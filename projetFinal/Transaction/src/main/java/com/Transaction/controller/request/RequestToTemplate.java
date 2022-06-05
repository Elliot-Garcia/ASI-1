package com.Transaction.controller.request;

import com.TemplateDTO.TemplateDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RequestToTemplate {
    final String uri = "localhost:8080/template";

    public TemplateDTO getTemplate(int templateId) {
        String url = uri +"/"+Integer.toString(templateId);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, TemplateDTO.class);
    }
}
