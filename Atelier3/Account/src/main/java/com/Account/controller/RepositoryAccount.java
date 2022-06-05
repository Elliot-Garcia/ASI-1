package com.Account.controller;

import com.Account.model.AccountBody;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface RepositoryAccount extends CrudRepository<AccountBody, Integer> {

}
