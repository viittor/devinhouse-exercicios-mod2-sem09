package br.com.viittor.cloudgames.model;

import javax.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq")
    @SequenceGenerator(name = "usuario_seq", sequenceName = "usuario_seq")
    private Long id;

    private String nome;

    private String login;

    private String password;

    private String email;

    private String dataDeNascimento;

    private String cpf;

    private String rg;
}
