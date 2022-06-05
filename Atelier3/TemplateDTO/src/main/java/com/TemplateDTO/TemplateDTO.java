package com.TemplateDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TemplateDTO {
    @Id
    @GeneratedValue
    private Integer idTemplate;
    private String name;
    private Integer attack;
    private Integer BuyPrice;
    private Integer SellPrice;
    private String affinity;
    private String description;
    private int energy;
    private String famille;
    private int hp;

    public String getFamille() {
        return famille;
    }

    public void setFamille(String famille) {
        this.famille = famille;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getSmallImgUrl() {
        return smallImgUrl;
    }

    public void setSmallImgUrl(String smallImgUrl) {
        this.smallImgUrl = smallImgUrl;
    }

    public String getAffinity() {
        return affinity;
    }

    public void setAffinity(String affinity) {
        this.affinity = affinity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    private String imgUrl;
    private String smallImgUrl;

    public Integer getIdTemplate() {
        return idTemplate;
    }
    public void setIdTemplate(Integer idTemplate) {
        this.idTemplate = idTemplate;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAttack() {
        return attack;
    }
    public void setAttack(Integer attack) {
        this.attack = attack;
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
    public TemplateDTO(){}
}
