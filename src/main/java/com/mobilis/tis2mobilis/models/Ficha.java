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
@Table(name = Ficha.TABLE_NAME)
public class Ficha {

    public static final String TABLE_NAME = "ficha";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cpf", unique = true, length = 15, nullable = false)
    @NotNull
    @NotEmpty
    @Size(max = 15)
    private String cpf;

    @Column(name = "nome", length = 60, nullable = false, unique = true)
    @NotNull
    @NotEmpty
    private String nome;

    @Column(name = "datainicio", nullable = false, length = 50)
    @NotNull
    @NotEmpty
    private String datainicio;

    @Column(name = "datatermino", nullable = false, length = 50)
    @NotNull
    @NotEmpty
    @Size(min = 8, max = 50)
    private String datatermino;

    @Column(name = "descricao_ficha", length = 500, nullable = true)
    @NotNull
    @NotEmpty
    @Size(max = 500)
    private String descricaoFicha;

    @Column(name = "nota", nullable = false)
    private Integer nota = 0;

    @Column(name = "status", nullable = false)
    private boolean status = false;

    public Ficha() {
    }

    public Ficha(Long id, String cpf, String nome, String datainicio, String datatermino, String descricaoFicha, int nota, boolean status) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.datainicio = datainicio;
        this.datatermino = datatermino;
        this.descricaoFicha = descricaoFicha;
        this.nota = nota;
        this.status = status;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInicio() {
        return datainicio;
    }

    public void setInicio(String datainicio) {
        this.datainicio = datainicio;
    }

    public String getTermino() {
        return datatermino;
    }

    public void setTermino(String datatermino) {
        this.datatermino = datatermino;
    }

    public String getDescricaoFicha() {
        return descricaoFicha;
    }

    public void setDescricaoFicha(String descricaoFicha) {
        this.descricaoFicha = descricaoFicha;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ficha ficha = (Ficha) o;
        return id != null && id.equals(ficha.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
