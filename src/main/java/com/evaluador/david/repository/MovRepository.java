package com.evaluador.david.repository;

import java.util.ArrayList;
import java.util.Date;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.evaluador.david.models.Movimientos;

@Repository
public interface MovRepository extends CrudRepository<Movimientos, Long> {

	public abstract ArrayList<Movimientos> findAllByClienteIdAndFechaBetween(Long clienteId, Date fecha, Date fechaF);

}
