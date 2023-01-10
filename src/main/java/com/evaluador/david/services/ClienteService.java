package com.evaluador.david.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.evaluador.david.models.Cliente;
import com.evaluador.david.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public ArrayList<Cliente> obtenerClientes() {
		return (ArrayList<Cliente>) clienteRepository.findAll();
	}

}
