package com.rafael.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.rafael.model.Member;

@Stateless
public class MemberDAO {

	@PersistenceContext()
	private EntityManager em;

	public void persist(Member entity) {
		em.persist(entity);
	}
}
