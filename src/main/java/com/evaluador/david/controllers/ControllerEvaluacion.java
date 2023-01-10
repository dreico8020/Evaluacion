package com.evaluador.david.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.evaluador.david.models.Cuenta;
import com.evaluador.david.models.Movimientos;
import com.evaluador.david.models.Persona;
import com.evaluador.david.models.RequestClientes;
import com.evaluador.david.models.ResponseClientes;
import com.evaluador.david.services.CuentaService;
import com.evaluador.david.services.MovService;
import com.evaluador.david.services.PersonaService;

@RestController
@RequestMapping("/entidades")
public class ControllerEvaluacion {

	@Autowired()
	PersonaService personaService;

	@Autowired()
	CuentaService cuentaService;

	@Autowired
	MovService movService;

	@GetMapping(path = "/clientes")
	public ArrayList<Persona> obtenerUsuarios() {
		return personaService.obtenerUsuarios();
	}

	@RequestMapping(value = "/reportes/{fecha}/{fechaF}/{clienteId}", method = RequestMethod.GET)
	public ArrayList<Movimientos> consultaCuentas(@PathVariable("fecha") String fecha,
			@PathVariable("fechaF") String fechaF, @PathVariable("clienteId") Long clienteId) {
		return movService.reporte(clienteId, fecha, fechaF);
	}

	@RequestMapping(value = "/cuentas/{clienteId}", method = RequestMethod.GET)
	public ArrayList<Cuenta> consultaCuentas(@PathVariable("clienteId") Long clienteId) {
		return cuentaService.busquedaClienteId(clienteId);
	}

	@DeleteMapping(path = "/clientes")
	public String borrarPersona(@RequestBody Persona persona) {
		personaService.borrarPersona(persona);
		return "Se borro el registro";
	}

	@PutMapping()
	@RequestMapping(value = "/clientes")
	public Persona actualizaPersona(@RequestBody Persona persona) {
		return personaService.actualizaPersona(persona);
	}

	@ResponseBody
	@RequestMapping(value = "/clientes", method = RequestMethod.POST)
	public ResponseClientes altaPersonaCliente(@RequestBody RequestClientes req) {
		ResponseClientes resp = new ResponseClientes();
		if (personaService.guardaPersona(req)) {
			resp.setCodigo(1);
			resp.setDescripcion("Alta exitosa");
			return resp;
		}
		resp.setCodigo(0);
		resp.setDescripcion("Ocurrio un error");
		return resp;
	}

	@ResponseBody
	@RequestMapping(value = "/cuentas", method = RequestMethod.POST)
	public Cuenta altaCuentas(@RequestBody Cuenta cuenta) {
		return cuentaService.insertaCuenta(cuenta);
	}

	@ResponseBody
	@RequestMapping(value = "/movimientos", method = RequestMethod.POST)
	public String movimientos(@RequestBody Movimientos movimientos) {
		return movService.guardaMov(movimientos);
	}
}
