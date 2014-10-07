package com.rafael.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "corretora")
public class Corretora {

	@SequenceGenerator(name = "corretora_seq", sequenceName = "corretora_seq", initialValue = 1, allocationSize = 1)
	@Id
	@GeneratedValue(generator = "corretora_seq")
	private Long id;

	@NotNull
	private String nome;

	@NotNull
	private String email;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "corretor")
	private Usuario corretor;

	@OneToMany(mappedBy = "corretora", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Usuario> usuarios;

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

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getCorretor() {
		return corretor;
	}

	public void setCorretor(Usuario corretor) {
		this.corretor = corretor;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
