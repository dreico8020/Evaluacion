package com.evaluador.david.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cuenta")
public class Cuenta {

	@Column(nullable = false)
	private Long clienteId;
	@Id
	@Column(unique = true, nullable = false)
	private String numeroCuenta;
	@Column(nullable = false)
	private String tipoCuenta;
	@Column(nullable = false)
	private Long saldoInicial;
	@Column(nullable = false)
	private boolean estado;

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public Long getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(Long saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
