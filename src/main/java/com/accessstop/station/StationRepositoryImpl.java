package com.accessstop.station;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

@Repository
public class StationRepositoryImpl implements StationCustomRepository {
	
	private EntityManager em;
	
	public StationRepositoryImpl(EntityManager entityManager) {
        this.em = entityManager;
    }

	@Override
	public List<Station> search(StationFilter filter) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Station> criteria = builder.createQuery(Station.class);
        Root<Station> root = criteria.from(Station.class);
        List<Predicate> predicates = new LinkedList<>();
        if (filter.getName() != null) {
            predicates.add(builder.like(root.get("name"), filter.getName()));
        }
        if (filter.getAddress() != null) {
            predicates.add(builder.equal(root.get("address"), filter.getAddress()));
        }
        criteria.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
		return em.createQuery(criteria).getResultList();
	}	

}
