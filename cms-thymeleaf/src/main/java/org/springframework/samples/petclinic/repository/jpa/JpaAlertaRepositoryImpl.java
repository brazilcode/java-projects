package org.springframework.samples.petclinic.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.samples.petclinic.model.Alerta;
import org.springframework.samples.petclinic.repository.AlertaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA implementation of the {@link AlertaRepository} interface.
 * 
 */
@Repository
public class JpaAlertaRepositoryImpl implements AlertaRepository {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public Collection<Alerta> findAll() {
		Query query = this.em.createQuery("SELECT alerta FROM Alerta alerta");
		return query.getResultList();
	}

	@Override
	public Alerta findById(int id) {
		Query query = this.em
				.createQuery("SELECT alerta FROM Alerta alerta WHERE alerta.id =:id");
		query.setParameter("id", id);
		return (Alerta) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
    @Override
    public Collection<Alerta> findByTitulo(String titulo) {
        Query query = this.em
                .createQuery("SELECT DISTINCT alerta FROM Alerta alerta WHERE alerta.titulo LIKE :titulo");
        query.setParameter("titulo", "%" + titulo + "%");
        return query.getResultList();
    }

	@Override
	public void save(Alerta alerta) {
		this.em.merge(alerta);
	}

	@Override
	public void remove(Alerta alerta) {
		this.em.remove(alerta);
	}

}