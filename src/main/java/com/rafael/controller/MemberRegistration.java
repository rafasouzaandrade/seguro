package com.rafael.controller;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.rafael.model.Member;
import com.rafael.sessionbeans.MemberSessionBean;

@Model
@Named(value = "memberRegistration")
public class MemberRegistration {

   @Inject
   private Logger log;

   @Inject
   private MemberSessionBean memberSessionBean;

   @Inject
   private Event<Member> memberEventSrc;

   private Member newMember;

   @Produces
   public Member getNewMember() {
      return newMember;
   }

   public void register() throws Exception {
      log.info("Registering " + newMember.getName());
      memberSessionBean.salvar(newMember);
      memberEventSrc.fire(newMember);
      initNewMember();
   }

   @PostConstruct
   public void initNewMember() {
      newMember = new Member();
   }
}
