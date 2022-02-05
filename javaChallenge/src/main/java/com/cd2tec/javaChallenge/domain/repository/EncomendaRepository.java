package com.cd2tec.javaChallenge.domain.repository;

import com.cd2tec.javaChallenge.domain.model.Encomenda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncomendaRepository extends JpaRepository <Encomenda,Long> {
    
}
