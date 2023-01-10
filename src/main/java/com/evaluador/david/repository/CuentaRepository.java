package com.evaluador.david.repository;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.evaluador.david.models.Cuenta;

@Repository
public interface CuentaRepository extends CrudRepository<Cuenta, Long> {

	public abstract ArrayList<Cuenta> findAllByClienteIdAndTipoCuenta(long clienteId, String tipoCuenta);

	public abstract ArrayList<Cuenta> findAllByClienteId(long clienteId);

}
