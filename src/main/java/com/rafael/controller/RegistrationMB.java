package com.rafael.controller;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.rafael.model.Corretora;
import com.rafael.model.Usuario;

@Model
@Named(value = "registration")
public class RegistrationMB {

	private Corretora corretora;
	
	@Inject
	private Logger log;

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

	public void cadastrar() {
		log.info(corretora.toString());
	}
}
