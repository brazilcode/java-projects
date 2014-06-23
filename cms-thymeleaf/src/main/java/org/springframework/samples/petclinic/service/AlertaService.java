package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Alerta;

/**
 * Service used for AlertaController
 * 
 */
public interface AlertaService {

	Collection<Alerta> findAllAlertas() throws DataAccessException;

	public void saveAlerta(Alerta alerta) throws DataAccessException;

	public Alerta findAlertaById(int alertaId) throws DataAccessException;

	public Collection<Alerta> findAlertaByTitulo(String titulo)
			throws DataAccessException;

	public void removeAlertaById(int alertaId) throws DataAccessException;

}
