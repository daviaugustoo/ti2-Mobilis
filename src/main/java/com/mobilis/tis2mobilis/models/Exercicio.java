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
@Table(name = Exercicio.TABLE_NAME)
public class Exercicio {

    public static final String TABLE_NAME = "exercicio";

    public Exercicio() {
        // Default constructor
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cpf", unique = false, length = 15, nullable = false)
    @NotNull
    @NotEmpty
    @Size(max = 15)
    private String cpf;

    @Column(name = "nome", length = 60, nullable = false, unique = false)
    @NotNull
    @NotEmpty
    private String nome;

    @Column(name = "descricao_exercicio", length = 500, nullable = true)
    @Size(max = 500)
    private String descricaoExercicio;

    @Column(name = "nota_exercicio", nullable = true)
    private Integer nota_exercicio;

    @Column(name = "segunda")
    private boolean segunda;

    @Column(name = "terca")
    private boolean terca;

    @Column(name = "quarta")
    private boolean quarta;

    @Column(name = "quinta")
    private boolean quinta;

    @Column(name = "sexta")
    private boolean sexta;

    @Column(name = "sabado")
    private boolean sabado;

    @Column(name = "domingo")
    private boolean domingo;

    @Column(name = "status_exercicio")
    private boolean status_exercicio;

    public Exercicio(Long id, String cpf, String nome, String descricaoExercicio, Integer nota_exercicio, boolean segunda, boolean terca, boolean quarta, boolean quinta, boolean sexta, boolean sabado, boolean domingo, boolean status_exercicio) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.descricaoExercicio = descricaoExercicio;
        this.nota_exercicio = 0;
        this.segunda = segunda;
        this.terca = terca;
        this.quarta = quarta;
        this.quinta = quinta;
        this.sexta = sexta;
        this.sabado = sabado;
        this.domingo = domingo;
        this.status_exercicio = status_exercicio;
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

    public String getDescricaoExercicio() {
        return descricaoExercicio;
    }

    public void setDescricaoExercicio(String descricaoExercicio) {
        this.descricaoExercicio = descricaoExercicio;
    }

    public Integer getNota() {
        return nota_exercicio;
    }

    public void setNota(Integer nota) {
        this.nota_exercicio = nota;
    }

    public boolean getSegunda() {
        return segunda;
    }

    public void setSegunda(boolean segunda) {
        this.segunda = segunda;
    }

    public boolean getTerca() {
        return terca;
    }

    public void setTerca(boolean terca) {
        this.terca = terca;
    }

    public boolean getQuarta() {
        return quarta;
    }

    public void setQuarta(boolean quarta) {
        this.quarta = quarta;
    }

    public boolean getQuinta() {
        return quinta;
    }

    public void setQuinta(boolean quinta) {
        this.quinta = quinta;
    }

    public boolean getSexta() {
        return sexta;
    }

    public void setSexta(boolean sexta) {
        this.sexta = sexta;
    }

    public boolean getSabado() {
        return sabado;
    }

    public void setSabado(boolean sabado) {
        this.sabado = sabado;
    }

    public boolean getDomingo() {
        return domingo;
    }

    public void setDomingo(boolean domingo) {
        this.domingo = domingo;
    }

    public boolean getStatus() {
        return status_exercicio;
    }

    public void setStatus(boolean status) {
        this.status_exercicio = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Exercicio exercicio = (Exercicio) o;
        return id != null && id.equals(exercicio.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
