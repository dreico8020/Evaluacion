package com.evaluador.david.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.evaluador.david.models.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	public abstract Optional<Cliente> findByclienteId(Long id);

}
