package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Comunidade;
import org.springframework.samples.petclinic.repository.ComunidadeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Mostly used as a facade for all controllers Also a placeholder for @Transactional
 * and @Cacheable annotations
 * 
 */
@Service
public class ComunidadeServiceImpl implements ComunidadeService {

	private ComunidadeRepository comunidadeRepository;

	@Autowired
	public ComunidadeServiceImpl(ComunidadeRepository comunidadeRepository) {
		this.comunidadeRepository = comunidadeRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Comunidade> findAllComunidades() throws DataAccessException {
		return comunidadeRepository.findAll();
	}

	@Override
	@Transactional
	public void saveComunidade(Comunidade comunidade) throws DataAccessException {
		comunidadeRepository.save(comunidade);
	}

	@Override
	@Transactional(readOnly = true)
	public Comunidade findComunidadeById(int id) throws DataAccessException {
		return comunidadeRepository.findById(id);
	}

	@Override
         @Transactional(readOnly = true)
         public Collection<Comunidade> findComunidadeByNome(String nome)
            throws DataAccessException {
        return comunidadeRepository.findByNome(nome);
    }

	@Override
	@Transactional
	public void removeComunidadeById(int comunidadeId) throws DataAccessException {
		Comunidade comunidadeToRemove = findComunidadeById(comunidadeId);
		comunidadeRepository.remove(comunidadeToRemove);
	}
}
