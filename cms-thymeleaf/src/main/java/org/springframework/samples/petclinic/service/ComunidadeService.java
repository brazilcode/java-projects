package org.springframework.samples.petclinic.service;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Comunidade;

import java.util.Collection;

/**
 * Created by henrique.nascimento on 16/06/2014.
 */
public interface ComunidadeService {

    Collection<Comunidade> findAllComunidades() throws DataAccessException;

    public void saveComunidade(Comunidade comunidade) throws DataAccessException;

    public Comunidade findComunidadeById(int comunidadeId) throws DataAccessException;

    Collection<Comunidade> findComunidadeByNome(String nome) throws DataAccessException;

    public void removeComunidadeById(int comunidadeId) throws DataAccessException;
}
