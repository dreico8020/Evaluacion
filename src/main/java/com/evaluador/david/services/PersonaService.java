package com.evaluador.david.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.evaluador.david.repository.ClienteRepository;
import com.evaluador.david.repository.PersonaRepository;
import com.evaluador.david.models.Cliente;
import com.evaluador.david.models.Persona;
import com.evaluador.david.models.RequestClientes;

@Service
public class PersonaService {

	@Autowired
	PersonaRepository personaRepository;

	@Autowired
	ClienteRepository clienteRepository;

	public ArrayList<Persona> obtenerUsuarios() {
		return (ArrayList<Persona>) personaRepository.findAll();
	}

	public boolean guardaPersona(RequestClientes persona) {
		ArrayList<Persona> buscarPer = personaRepository.findByNombre(persona.getNombreCompleto());
		if (buscarPer.size() == 1) {
			System.out.print("La persona ya existe");
			return false;
		} else {
			Persona personaNew = new Persona();
			personaNew.setNombre(persona.getNombreCompleto());
			personaNew.setGenero(persona.getGenero());
			personaNew.setEdad(persona.getEdad());
			personaNew.setIdentificacion(persona.getIdentificacion());
			personaNew.setDireccion(persona.getDireccion());
			personaNew.setTelefono(persona.getTelefono());
			Persona personaReg = personaRepository.save(personaNew);

			Cliente cliente = new Cliente();
			cliente.setClienteid(personaReg.getId());
			cliente.setContrasena(persona.getContrasena());
			cliente.setEstado(true);
			clienteRepository.save(cliente);
		}
		return true;
	}

	public Persona actualizaPersona(Persona persona) {
		return personaRepository.save(persona);

	}

	public void borrarPersona(Persona persona) {
		personaRepository.delete(persona);
	}

}
