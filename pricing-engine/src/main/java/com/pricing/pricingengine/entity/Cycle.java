package com.pricing.pricingengine.entity;

import java.util.Date;
import java.util.List;

public class Cycle {
	
	private List<PartOrdered> parts;
	private Date dateOfPricing;
	
	public Cycle(List<PartOrdered> parts, Date dateOfPricing) {
		this.parts = parts;
		this.dateOfPricing = dateOfPricing;
	}
	
	public List<PartOrdered> getParts() {
		return parts;
	}
	public void setParts(List<PartOrdered> parts) {
		this.parts = parts;
	}
	public Date getDateOfPricing() {
		return dateOfPricing;
	}
	public void setDateOfPricing(Date dateOfPricing) {
		this.dateOfPricing = dateOfPricing;
	}

}
