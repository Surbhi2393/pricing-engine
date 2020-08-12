package com.pricing.pricingengine.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pricing.pricingengine.dao.CalculatePriceDAO;
import com.pricing.pricingengine.entity.Cycle;

@Service
public class CalculatePriceService {
	
	private CalculatePriceDAO calculatePriceDAO;
	
	@Autowired
	public CalculatePriceService(CalculatePriceDAO theCalculatePriceDAO) {
		calculatePriceDAO = theCalculatePriceDAO;
	}
	
	public Map<String,Integer> getPrice(Cycle cycle) {
		return calculatePriceDAO.getPrice(cycle);
	}

}
