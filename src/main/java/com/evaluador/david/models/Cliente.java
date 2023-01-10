package com.evaluador.david.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@Column(unique = true, nullable = false)
	private Long clienteId;
	@Column(nullable = false)
	private String contrasena;
	@Column(nullable = false)
	private boolean estado;

	public Long getClienteid() {
		return clienteId;
	}

	public void setClienteid(Long clienteid) {
		this.clienteId = clienteid;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
