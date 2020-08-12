package com.pricing.pricingengine.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pricing.pricingengine.entity.Cycle;
import com.pricing.pricingengine.service.CalculatePriceService;

@RestController
public class CalculatePriceController {
	
	private CalculatePriceService calculatePriceService;
	
	@Autowired
	public CalculatePriceController(CalculatePriceService theCalculatePriceService) {
		calculatePriceService = theCalculatePriceService;
	}

	@PostMapping("/calculatePrice")
	public Map<String, Integer> calculatePrice(@RequestBody Cycle cycle) {
		return calculatePriceService.getPrice(cycle);
	}
}
