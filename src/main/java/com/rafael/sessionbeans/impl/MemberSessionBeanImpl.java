package com.rafael.sessionbeans.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.rafael.dao.MemberDAO;
import com.rafael.model.Member;
import com.rafael.sessionbeans.MemberSessionBean;

@Stateless
public class MemberSessionBeanImpl implements MemberSessionBean {

	@Inject
	private MemberDAO dao;

	@Override
	public void salvar(Member member) {
		dao.persist(member);
	}

}
