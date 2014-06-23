package org.springframework.samples.petclinic.repository.jpa;

import org.springframework.samples.petclinic.model.Alerta;
import org.springframework.samples.petclinic.model.Comunidade;
import org.springframework.samples.petclinic.repository.AlertaRepository;
import org.springframework.samples.petclinic.repository.ComunidadeRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class JpaComunidadeRepositoryImpl implements ComunidadeRepository {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public Collection<Comunidade> findAll() {
		Query query = this.em.createQuery("SELECT comunidade FROM Comunidade comunidade");
		return query.getResultList();
	}

	@Override
	public Comunidade findById(int id) {
		Query query = this.em
				.createQuery("SELECT comunidade FROM Comunidade comunidade WHERE comunidade.id =:id");
		query.setParameter("id", id);
		return (Comunidade) query.getSingleResult();
	}

	@Override
	public void save(Comunidade comunidade) {
		this.em.merge(comunidade);

	}

    @SuppressWarnings("unchecked")
    @Override
    public Collection<Comunidade> findByNome(String nome) {
        Query query = this.em
                .createQuery("SELECT DISTINCT comunidade FROM Comunidade comunidade WHERE comunidade.nome LIKE :nome");
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }

    @Override
    public void remove(Comunidade comunidade) {
        this.em.remove(comunidade);
    }
}