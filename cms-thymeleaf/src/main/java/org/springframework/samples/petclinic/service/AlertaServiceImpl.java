package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Alerta;
import org.springframework.samples.petclinic.repository.AlertaRepository;
import org.springframework.samples.petclinic.web.AlertaController;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service used for {@link AlertaController}. Also a placeholder for @Transactional
 * and @Cacheable annotations
 * 
 */
@Service
public class AlertaServiceImpl implements AlertaService {

	private AlertaRepository alertaRepository;

	@Autowired
	public AlertaServiceImpl(AlertaRepository alertaRepository) {
		this.alertaRepository = alertaRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Alerta> findAllAlertas() throws DataAccessException {
		return alertaRepository.findAll();
	}

	@Override
	@Transactional
	public void saveAlerta(Alerta alerta) throws DataAccessException {
		alertaRepository.save(alerta);
	}

	@Override
	@Transactional(readOnly = true)
	public Alerta findAlertaById(int id) throws DataAccessException {
		return alertaRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Alerta> findAlertaByTitulo(String titulo)
			throws DataAccessException {
		return alertaRepository.findByTitulo(titulo);
	}

	@Override
	@Transactional
	public void removeAlertaById(int alertaId) throws DataAccessException {
		Alerta alertaToRemove = findAlertaById(alertaId);
		alertaRepository.remove(alertaToRemove);
	}
}
