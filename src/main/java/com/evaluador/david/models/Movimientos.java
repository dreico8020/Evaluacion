package com.evaluador.david.models;

import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "movimientos")
public class Movimientos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(nullable = false)
	private Long clienteId;

	@Column(nullable = false)
	private Date fecha;

	@Column(nullable = false)
	private String tipoMovimiento;

	@Column(nullable = false)
	private String tipoCuenta;

	@Column(nullable = false)
	private Long valor;

	@Column(nullable = false)
	private Long saldo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	public Long getSaldo() {
		return saldo;
	}

	public void setSaldo(Long saldo) {
		this.saldo = saldo;
	}

}
