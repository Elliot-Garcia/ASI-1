package com.Template.controller;

import com.TemplateDTO.TemplateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.Optional;

@Service
public class ServiceTemplate {

    @Autowired
    private final RepositoryTemplate rTemplate;

    public ServiceTemplate(RepositoryTemplate rTemplate){
        this.rTemplate = rTemplate;
    }
    public Iterable<TemplateDTO> listAllTemplates() {
        return rTemplate.findAll();
    }

    public TemplateDTO templateById(String stringTemplateId) {
        int templateId = Integer.parseInt(stringTemplateId);
        Optional<TemplateDTO> oTplDto = rTemplate.findById(templateId);
        if(oTplDto.isPresent()){
            return oTplDto.get();
        }else{
            throw new HttpServerErrorException(HttpStatus.NOT_FOUND);
        }
    }

    public void createTemplate(TemplateDTO templateDTO) {
        int defaultBuyPrice = 50;
        int defaultSellPrice = 50;
        if (templateDTO.getBuyPrice() == null){
            templateDTO.setBuyPrice(defaultBuyPrice);
        }
        if (templateDTO.getSellPrice() == null){
            templateDTO.setSellPrice(defaultSellPrice);
        }
        rTemplate.save(templateDTO);
    }
}
