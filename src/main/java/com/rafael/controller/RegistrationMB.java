package com.rafael.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.rafael.model.Corretora;
import com.rafael.model.Usuario;
import com.rafael.sessionbeans.CorretoraSessionBean;

@Model
@Named(value = "registration")
public class RegistrationMB {

	private Corretora corretora;
	
	@Inject
	private CorretoraSessionBean corretoraSessionBean;

	@Produces
	public Corretora getCorretora() {
		return corretora;
	}

	public void setCorretora(Corretora corretora) {
		this.corretora = corretora;
	}

	@PostConstruct
	public void init() {
		corretora = new Corretora();
		corretora.setCorretor(new Usuario());
	}

	public String cadastrar() {
		corretoraSessionBean.registarCorretora(corretora);
		return "adminHome";
	}
}
