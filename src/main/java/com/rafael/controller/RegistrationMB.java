package com.rafael.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.rafael.model.Corretora;

@Model
@Named(value = "registration")
public class RegistrationMB {

	private Corretora corretora;

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
	}

}
