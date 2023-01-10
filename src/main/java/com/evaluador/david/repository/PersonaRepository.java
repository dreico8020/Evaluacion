package com.evaluador.david.repository;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.evaluador.david.models.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long> {

	public abstract ArrayList<Persona> findByNombre(String nombreCOmpleto);
}
