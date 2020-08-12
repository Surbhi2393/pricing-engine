package com.pricing.pricingengine.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pricing.pricingengine.entity.Cycle;
import com.pricing.pricingengine.entity.CyclePart;
import com.pricing.pricingengine.entity.PartOrdered;

@Repository
public class CalculatePriceDAO {
	
	private EntityManager entityManager;
		
	@Autowired
	public CalculatePriceDAO(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	public Map<String,Integer> getPrice(Cycle cycle){
	
		int price = 0;
		Map<String,Integer> map = new HashMap<>();
		Session session = entityManager.unwrap(Session.class);
		for(PartOrdered partOrdered : cycle.getParts()) {
			Query query = session.createQuery("from CyclePart where partName=:partOrderedName and validFrom<=:dateOfPricing and validTo>=:dateOfPricing");
			query.setParameter("partOrderedName", partOrdered.getName());
			query.setParameter("dateOfPricing", cycle.getDateOfPricing());
			List<CyclePart> list = query.getResultList();
			for (CyclePart cyclePartPrice : list) {
				int partPrice = cyclePartPrice.getPrice()*partOrdered.getCount();
				map.put(cyclePartPrice.getComponentName(), map.getOrDefault(cyclePartPrice.getComponentName(), 0)+partPrice);
				price+=partPrice;			
			}
		}
		
		map.put("Cycle", price);
		return map;
	}

}
