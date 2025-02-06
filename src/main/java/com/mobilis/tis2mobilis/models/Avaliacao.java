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
@Table(name = Avaliacao.TABLE_NAME)
public class Avaliacao {

    public static final String TABLE_NAME = "avaliacao";

    public Avaliacao() {
        // Default constructor
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "cpf", length = 500, nullable = true)
    @NotNull
    @NotEmpty
    @Size(max = 500)
    private String cpf;

    @Column(name = "nome", length = 60, nullable = false)
    @NotNull
    @NotEmpty
    private String nome;

    @Column(name = "datatermino", nullable = false, length = 50)
    @NotNull
    @NotEmpty
    @Size(min = 8, max = 50)
    private String datatermino;

 

    @Column(name = "avaliacao", length = 5000, nullable = true)
    @NotNull
    @NotEmpty
    @Size(max = 5000)
    private String avaliacao;

    @Column(name = "titulo", length = 200, nullable = true)
    @NotNull
    @NotEmpty
    @Size(max = 200)
    private String titulo;


    public Avaliacao(Long id, String nome,  String datatermino,String titulo, String avaliacao ) {
        this.id = id;
        this.nome = nome;
        this.datatermino = datatermino;
        this.titulo = titulo;
        this.avaliacao = avaliacao;
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

  public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    
      public String getAvaliacao() {
        return avaliacao;
    }


    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getTermino() {
        return datatermino;
    }

    public void setTermino(String datatermino) {
        this.datatermino = datatermino;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Avaliacao d = (Avaliacao) o;
        return id != null && id.equals(d.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
