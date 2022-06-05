package com.Cards.controller;

import com.CardsDTO.CardsDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface RepositoryCards extends CrudRepository<CardsDTO, Integer> {

    @Query("SELECT c FROM CardsDTO c WHERE c.id_User = ?1")
    Iterable<CardsDTO> selectCardsByUserId(int userId);
}