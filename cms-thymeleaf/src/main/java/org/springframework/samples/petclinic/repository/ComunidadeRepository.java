package org.springframework.samples.petclinic.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Comunidade;

import java.util.Collection;

/**
 * Repository class for <code>Comunidade</code>
 *
 */
public interface ComunidadeRepository {

    Collection<Comunidade> findAll() throws DataAccessException;

    Comunidade findById(int id) throws DataAccessException;

    Collection<Comunidade> findByNome(String nome) throws DataAccessException;

    void save(Comunidade comunidade) throws DataAccessException;

    void remove(Comunidade comunidade);
}
