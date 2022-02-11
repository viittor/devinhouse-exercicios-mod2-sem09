package br.com.viittor.cloudgames.model;

import javax.persistence.*;

@Entity
public class Plataforma {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "plataforma_seq")
    @SequenceGenerator(name = "plataforma_seq", sequenceName = "plataforma_seq")
    private Long id;

    private String nome;

}
