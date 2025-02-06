package com.mobilis.tis2mobilis.models;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = Profissional.TABLE_NAME)
public class Profissional {
    public static final String TABLE_NAME = "profissional";

    @Id
    private Long codigoProfissional;

    @Column(name = "nome", length = 60, nullable = false, unique = true)
    @NotNull
    @NotEmpty
    private String nome;

    @Column(name = "email", nullable = false, unique = true, length = 50)
    @NotNull
    @NotEmpty
    private String email;

    @Column(name = "senha", nullable = false, length = 50)
    @NotNull
    @NotEmpty
    @Size(min = 8, max = 50)
    private String senha;

    @Column(name = "numero_telefone", length = 14, nullable = false, unique = true)
    @Size(max = 14)
    private String numeroTelefone;

    public Profissional() {
    }

    public Profissional(Long codigoProfissional, String nome, String email, String senha, String numeroTelefone) {
        this.codigoProfissional = codigoProfissional;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.numeroTelefone = numeroTelefone;
    }

    public Long getCodigoProfissional() {
        return this.codigoProfissional;
    }

    public void setCodigoProfissional(Long codigoProfissional) {
        this.codigoProfissional = codigoProfissional;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNumeroTelefone() {
        return this.numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public Profissional codigoProfissional(Long codigoProfissional) {
        setCodigoProfissional(codigoProfissional);
        return this;
    }

    public Profissional nome(String nome) {
        setNome(nome);
        return this;
    }

    public Profissional email(String email) {
        setEmail(email);
        return this;
    }

    public Profissional senha(String senha) {
        setSenha(senha);
        return this;
    }

    public Profissional numeroTelefone(String numeroTelefone) {
        setNumeroTelefone(numeroTelefone);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profissional that = (Profissional) o;
        return Objects.equals(codigoProfissional, that.codigoProfissional);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoProfissional);
    }
    
}
