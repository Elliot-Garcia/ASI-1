package com.Template.controller;

import com.TemplateDTO.TemplateDTO;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryTemplate extends CrudRepository<TemplateDTO, Integer> {

}
