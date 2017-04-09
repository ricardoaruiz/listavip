package br.com.alura.listavip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.alura.listavip.model.Convidado;
import br.com.alura.listavip.repository.ConvidadoRepository;

@Controller
public class ConvidadoController {

	@Autowired
	private ConvidadoRepository convidadoRepository;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/listaconvidados")
	public String listaConvidados(Model model) {
		
		Iterable<Convidado> convidados = convidadoRepository.findAll();
		model.addAttribute("convidados", convidados);
		
		return "listaconvidados";
	}
	
	@RequestMapping(value="salvar", method=RequestMethod.POST)
//	public String salvar(@RequestParam("nome") String nome, 
//			@RequestParam("email") String email,
//			@RequestParam("telefone") String telefone,
//			Model model) {
	public String salvar(@ModelAttribute Convidado convidado, Model model) {	
		
		//Convidado convidado = new Convidado(nome, email, telefone);
		convidadoRepository.save(convidado);
		
				
		return listaConvidados(model);
	}
	
}
