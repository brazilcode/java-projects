package org.springframework.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.model.Alerta;

/**
 * Repository class for <code>Alerta</code>
 * 
 */
public interface AlertaRepository {

	/**
	 * Retrieve <code>Alerta</code>s from the data store by last name, returning
	 * all owners whose last name <i>starts</i> with the given name.
	 * 
	 * @param lastName
	 *            Value to search for
	 * @return a <code>Collection</code> of matching <code>Alerta</code>s (or an
	 *         empty <code>Collection</code> if none found)
	 */
	Collection<Alerta> findAll() throws DataAccessException;

	/**
	 * Retrieve an <code>Alerta</code> from the data store by id.
	 * 
	 * @param id
	 *            the id to search for
	 * @return the <code>Alerta</code> if found
	 * @throws org.springframework.dao.DataRetrievalFailureException
	 *             if not found
	 */
	Alerta findById(int id) throws DataAccessException;

	/**
	 * Save an <code>Alerta</code> to the data store, either inserting or
	 * updating it.
	 * 
	 * @param alerta
	 *            the <code>Alerta</code> to save
	 * @see BaseEntity#isNew
	 */
	void save(Alerta alerta) throws DataAccessException;

	/**
	 * Retrieve <code>Alerta</code>s from the data store by titulo, returning
	 * all alertas whose titulo <i>starts</i> with the given name.
	 * 
	 * @param titulo
	 *            Value to search for
	 * @return a <code>Collection</code> of matching <code>Alerta</code>s (or an
	 *         empty <code>Collection</code> if none found)
	 */
	Collection<Alerta> findByTitulo(String titulo);

	/**
	 * Remove an <code>Alerta</code> from the data store.
	 * 
	 * @param alerta
	 *            the <code>Alerta</code> to save
	 * @see BaseEntity#isNew
	 */
	void remove(Alerta alerta);

}
