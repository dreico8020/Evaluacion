package com.evaluador.david.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.evaluador.david.models.Cuenta;
import com.evaluador.david.repository.CuentaRepository;

@Service
public class CuentaService {

	@Autowired
	CuentaRepository cuentaRepository;

	public Cuenta insertaCuenta(Cuenta cuenta) {
		return cuentaRepository.save(cuenta);
	}

	public ArrayList<Cuenta> busquedaClienteId(Long clienteId) {
		return (ArrayList<Cuenta>) cuentaRepository.findAllByClienteId(clienteId);
	}

	public ArrayList<Cuenta> condicionBusqueda(Cuenta cuenta) {
		return (ArrayList<Cuenta>) cuentaRepository.findAllByClienteIdAndTipoCuenta(cuenta.getClienteId(),
				cuenta.getTipoCuenta());
	}
}
