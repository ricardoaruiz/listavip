package br.com.alura.listavip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class ListaVipApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListaVipApplication.class, args);
	}
	
	
	@RequestMapping("/")
	@ResponseBody
	public String index() {
		return "Olá, bem vindo ao sistema Lista VIP";
	}
}
