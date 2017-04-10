package br.com.alura.listavip.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity(name = "convidado")
public class Convidado {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message="O nome é obrigatório.")
    private String nome;
    
    @NotBlank(message="O email é obrigatório.")
    private String email;
    
    @NotBlank(message="O telefone é obrigatório.")
    private String telefone;

    public Convidado() {
	}
    
    public Convidado(String nome, String email, String telefone) {
    	this.nome = nome;
    	this.email = email;
    	this.telefone = telefone;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
	
}
