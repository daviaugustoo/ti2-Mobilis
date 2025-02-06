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
@Table(name = Paciente.TABLE_NAME)
public class Paciente{
    public static final String TABLE_NAME = "paciente";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cpf", unique = true, length = 15)
    @NotNull
    @NotEmpty
    @Size(max = 15)
    private String cpf;

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

    @Column(name = "cep", length = 8, nullable = false)
    @NotNull
    @NotEmpty
    @Size(max = 8)
    private String cep;

    @Column(name = "numero_residencia", nullable = false)
    @NotNull
    @NotEmpty
    @Size(max = 10)
    private String numeroResidencia;

    @Column(name = "descricaoDoPaciente", length = 500, nullable = false)
    @NotNull
    @NotEmpty
    @Size(max = 500)
    private String descricaoDoPaciente;

    public Paciente() {
    }

    public Paciente(Long id, String cpf, String nome, String email, String senha, String numeroTelefone, String cep, String numeroResidencia, String descricaoDoPaciente) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.numeroTelefone = numeroTelefone;
        this.cep = cep;
        this.numeroResidencia = numeroResidencia;
        this.descricaoDoPaciente = descricaoDoPaciente;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumeroResidencia() {
        return this.numeroResidencia;
    }

    public void setNumeroResidencia(String numeroResidencia) {
        this.numeroResidencia = numeroResidencia;
    }

    public String getDescricaoDoPaciente() {
        return this.descricaoDoPaciente;
    }

    public void setDescricaoDoPaciente(String descricaoDoPaciente) {
        this.descricaoDoPaciente = descricaoDoPaciente;
    }

    public Paciente id(Long id) {
        setId(id);
        return this;
    }

    public Paciente cpf(String cpf) {
        setCpf(cpf);
        return this;
    }

    public Paciente nome(String nome) {
        setNome(nome);
        return this;
    }

    public Paciente email(String email) {
        setEmail(email);
        return this;
    }

    public Paciente senha(String senha) {
        setSenha(senha);
        return this;
    }

    public Paciente numeroTelefone(String numeroTelefone) {
        setNumeroTelefone(numeroTelefone);
        return this;
    }

    public Paciente cep(String cep) {
        setCep(cep);
        return this;
    }

    public Paciente numeroResidencia(String numeroResidencia) {
        setNumeroResidencia(numeroResidencia);
        return this;
    }

    public Paciente descricaoDoPaciente(String descricaoDoPaciente) {
        setDescricaoDoPaciente(descricaoDoPaciente);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Paciente paciente = (Paciente) o;
        return id != null && id.equals(paciente.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
