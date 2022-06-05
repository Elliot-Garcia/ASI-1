package com.Template.controller;

import com.TemplateDTO.TemplateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class RestTemplate {

    @Autowired
    private final ServiceTemplate serviceTemplate;

    public RestTemplate(ServiceTemplate serviceTemplate){
        this.serviceTemplate = serviceTemplate;
    }

    @GetMapping(value = "/")
    public Iterable<TemplateDTO>  listTemplate(){
        return serviceTemplate.listAllTemplates();
    }

    @GetMapping(value = "/{id}")
    public TemplateDTO getTemplate(@PathVariable String id){
        return serviceTemplate.templateById(id);
    }

    @PostMapping(value = "/")
    public void createTemplate(@RequestBody TemplateDTO templateDTO){
        serviceTemplate.createTemplate(templateDTO);
    }
}
