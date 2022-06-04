package com.Transaction.controller.request;

import com.Transaction.controller.body.TemplateBody;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RequestToTemplate {
    final String uri = "localhost:8080/template";

    public TemplateBody getTemplate(int templateId) {
        String url = uri +"/"+Integer.toString(templateId);
        RestTemplate restTemplate = new RestTemplate();
        TemplateBody result = restTemplate.getForObject(uri, TemplateBody.class);
        return result;
    }
}
