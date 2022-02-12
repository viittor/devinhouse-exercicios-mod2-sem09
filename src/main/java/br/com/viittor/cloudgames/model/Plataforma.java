package br.com.viittor.cloudgames.model;

import javax.persistence.*;

@Entity
public class Plataforma {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "plataforma_seq")
    @SequenceGenerator(name = "plataforma_seq", sequenceName = "plataforma_seq")
    private Long id;

    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
