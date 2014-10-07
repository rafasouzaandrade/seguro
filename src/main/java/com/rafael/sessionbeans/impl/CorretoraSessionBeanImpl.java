package com.rafael.sessionbeans.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.rafael.dao.CorretoraDAO;
import com.rafael.model.Corretora;
import com.rafael.model.Perfil;
import com.rafael.model.Usuario;
import com.rafael.sessionbeans.CorretoraSessionBean;

@Stateless
public class CorretoraSessionBeanImpl implements CorretoraSessionBean {
 
	@Inject
	private CorretoraDAO dao;

	@Override
	public void registarCorretora(Corretora corretora) {
		Usuario corretor = corretora.getCorretor();
		List<Perfil> perfis = new ArrayList<Perfil>();
		perfis.add(new Perfil(2l));
		corretor.setPerfis(perfis);
		corretor.setCorretora(corretora);
		dao.persist(corretora);
	}

}
