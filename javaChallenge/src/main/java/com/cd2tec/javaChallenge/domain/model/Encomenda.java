package com.cd2tec.javaChallenge.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "encomenda_log")
@Data
public class Encomenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 8)
    private String cepOrigem;

    @Column(nullable = false,length = 8)
    private String cepDestino;

    @Column(nullable = false,length = 60)
    private String nomeDestinatario;

    @Column(nullable = false)
    private float peso;

    @Column(nullable = false)
    private float vlTotalFrete;

    @Column(nullable = false)
    private String dataPrevistaEntrega;


    
}
