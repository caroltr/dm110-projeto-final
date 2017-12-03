package br.inatel.dm110.ipstatus.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.inatel.dm110.ipstatus.entities.IPStatus;

@Stateless
public class IPStatusDAO {
	
	@PersistenceContext(unitName = "ipstatus")
	private EntityManager em;

	public List<IPStatus> listAll() {
		return em.createQuery("from IPStatus ip", IPStatus.class).getResultList();
	}

	public void insert(IPStatus ipStatus) {
		em.persist(ipStatus);
	}

}
