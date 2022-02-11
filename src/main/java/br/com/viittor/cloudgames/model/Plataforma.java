package br.com.viittor.cloudgames.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Plataforma {

    @Id
    private Long id;

    private String nome;

}
