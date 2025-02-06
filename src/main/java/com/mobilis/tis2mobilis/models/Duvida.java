package com.mobilis.tis2mobilis.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = Duvida.TABLE_NAME)
public class Duvida {

    public static final String TABLE_NAME = "duvida";

    public Duvida() {
        // Default constructor
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 60, nullable = false)
    @NotNull
    @NotEmpty
    private String nome;

    @Column(name = "titulo", length = 150, nullable = false)
    @NotNull
    @NotEmpty
    @Size(max = 15)
    private String titulo;

    @Column(name = "duvida", length = 500, nullable = true)
    @NotNull
    @NotEmpty
    @Size(max = 500)
    private String duvida;

    @Column(name = "resposta", length = 500, nullable = true)
    @NotNull
    @NotEmpty
    @Size(max = 500)
    private String resposta;

    @Column(name = "nota", nullable = false)
    private Integer nota = 0;



    public Duvida(Long id, String nome, String titulo, String duvida, String resposta) {
        this.id = id;
        this.nome = nome;
        this.titulo = titulo;
        this.duvida = duvida;
        this.resposta = resposta;
        this.nota = 0;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNome() {
        return nome;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDuvida() {
        return duvida;
    }

    public void setDuvida(String duvida) {
        this.duvida = duvida;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Duvida d = (Duvida) o;
        return id != null && id.equals(d.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
