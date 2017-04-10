package br.com.alura.listavip.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.alura.listavip.model.Convidado;
import br.com.alura.listavip.service.ConvidadoService;
import br.com.alura.listavip.service.EmailService;

@Controller
public class ConvidadoController {

	@Autowired
	private ConvidadoService convidadoService;
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/listaconvidados")
	public ModelAndView listaConvidados(Convidado convidado) {
		
		Iterable<Convidado> convidados = convidadoService.obterTodos();
		
		ModelAndView model = new ModelAndView("listaconvidados");
		model.addObject("convidados", convidados);
		
		return model;
	}
	
	@RequestMapping(value="salvar", method=RequestMethod.POST)
	public ModelAndView salvar(@Valid Convidado convidado, BindingResult result, RedirectAttributes attributes) {	
		
		if(result.hasErrors()) {
			return listaConvidados(convidado);
		}
		
		convidadoService.salvar(convidado);
		emailService.enviar(convidado.getNome(), convidado.getEmail());
		
		ModelAndView mav = new ModelAndView("redirect:/listaconvidados");
		attributes.addFlashAttribute("mensagem","Cliente salvo com sucesso");
				
		return mav;
	}
	
}
