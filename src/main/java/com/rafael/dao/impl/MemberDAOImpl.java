package com.rafael.dao.impl;

import javax.ejb.Stateless;

import com.rafael.dao.MemberDAO;
import com.rafael.model.Member;

@Stateless
public class MemberDAOImpl extends GenericDAOImpl<Member, Long> implements MemberDAO {

}
