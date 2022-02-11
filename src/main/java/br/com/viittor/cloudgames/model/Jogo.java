package br.com.viittor.cloudgames.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jogo_seq")
    @SequenceGenerator(name = "jogo_seq", sequenceName = "jogo_seq")
    private Long id;

    private String nome;

    private Date dataLancamento;

    private String capa;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @OneToMany
    private List<Plataforma> plataformas;

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

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Plataforma> getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(List<Plataforma> plataformas) {
        this.plataformas = plataformas;
    }
}
