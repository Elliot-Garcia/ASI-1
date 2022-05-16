package com.asi.projet.cards.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Templates {
	
	@Id
	@GeneratedValue
	private Integer idTemplate;
	private String Name;
	private Integer Stat1;
	private Integer BuyPrice;
	private Integer SellPrice;
	
	public Integer getIdTemplate() {
		return idTemplate;
	}
	public void setIdTemplate(Integer idTemplate) {
		this.idTemplate = idTemplate;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Integer getStat1() {
		return Stat1;
	}
	public void setStat1(Integer stat1) {
		Stat1 = stat1;
	}
	public Integer getBuyPrice() {
		return BuyPrice;
	}
	public void setBuyPrice(Integer buyPrice) {
		BuyPrice = buyPrice;
	}
	public Integer getSellPrice() {
		return SellPrice;
	}
	public void setSellPrice(Integer sellPrice) {
		SellPrice = sellPrice;
	}
	
}
