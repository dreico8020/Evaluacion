package com.evaluador.david.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.evaluador.david.models.Cuenta;
import com.evaluador.david.models.Movimientos;
import com.evaluador.david.repository.CuentaRepository;
import com.evaluador.david.repository.MovRepository;

@Service
public class MovService {

	@Autowired
	MovRepository movRepository;

	@Autowired
	CuentaRepository cuentaRepository;

	public Optional<Movimientos> consultaMov(Movimientos movimientos) {
		return movRepository.findById(movimientos.getClienteId());
	}

	public String guardaMov(Movimientos movimientos) {

		ArrayList<Cuenta> cuenta = cuentaRepository.findAllByClienteIdAndTipoCuenta(movimientos.getClienteId(),
				movimientos.getTipoCuenta());

		if (cuenta != null) {
			if (movimientos.getTipoMovimiento().equals("Deposito")) {
				Long operacion = cuenta.get(0).getSaldoInicial() + movimientos.getValor();
				movRepository.save(movimientos);
				cuenta.get(0).setSaldoInicial(operacion);
				cuentaRepository.save(cuenta.get(0));
				return "Transaccion exitosa!";
			} else if (movimientos.getTipoMovimiento().equals("Retiro")) {
				Long operacion = cuenta.get(0).getSaldoInicial() - movimientos.getValor();
				if (operacion > 0) {
					movRepository.save(movimientos);
					cuenta.get(0).setSaldoInicial(operacion);
					cuentaRepository.save(cuenta.get(0));
					return "Transaccion exitosa!";
				} else {
					return "Tipo de movimiento no valido, solo disponible Deposito y Retiro";
				}
			}
		}
		return "No se encontro el tipo de ceunta del cliente";
	}

	public ArrayList<Movimientos> reporte(Long cliente, String fecha, String fechaF) {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha1;
		Date fecha2;
		try {
			fecha1 = formato.parse(fecha);
			fecha2 = formato.parse(fechaF);
			return (ArrayList<Movimientos>) movRepository.findAllByClienteIdAndFechaBetween(cliente, fecha1, fecha2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
