package com.Account.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.AccountDTO.AccountDTO;

@Service
public interface RepositoryAccount extends CrudRepository<AccountDTO, Integer> {

}
