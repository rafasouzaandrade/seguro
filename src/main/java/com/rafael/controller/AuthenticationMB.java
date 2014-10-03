package com.rafael.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@ViewScoped
@Model
@Named(value = "authentication")
public class AuthenticationMB implements Serializable {

	private static final long serialVersionUID = 5945068513281704289L;
	private String username;
	private String password;
	private String originalURL;

	@PostConstruct
	public void init() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		originalURL = (String) externalContext.getRequestMap().get(RequestDispatcher.FORWARD_REQUEST_URI);

		if (originalURL == null) {
			originalURL = externalContext.getRequestContextPath() + "/home.xhtml";
		} else {
			String originalQuery = (String) externalContext.getRequestMap().get(RequestDispatcher.FORWARD_QUERY_STRING);

			if (originalQuery != null) {
				originalURL += "?" + originalQuery;
			}
		}
	}

	public String login() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		try {
			if (request.getUserPrincipal() != null) {
				request.logout();
			}
			request.login(username, password);
			//			User user = userService.find(username, password);
			//			externalContext.getSessionMap().put("user", user);
			return "adminHome";
		} catch (ServletException e) {
			e.printStackTrace();
			context.addMessage(null, new FacesMessage("Unknown login"));
			return "loginError";
		}
	}

	public void logout() throws IOException {
		try {
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
			if (request.getUserPrincipal() != null) {
				request.logout();
			}
			externalContext.invalidateSession();
			externalContext.redirect(externalContext.getRequestContextPath() + "/login.xhtml");
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOriginalURL() {
		return originalURL;
	}

	public void setOriginalURL(String originalURL) {
		this.originalURL = originalURL;
	}
}
