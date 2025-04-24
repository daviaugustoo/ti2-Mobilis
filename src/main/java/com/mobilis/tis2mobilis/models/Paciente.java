package com.mobilis.tis2mobilis.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

/*
Sugestão de melhoria 15:
Utilizar a anotação @Data do Lombok para gerar automaticamente os
métodos getters, setters, equals, hashCode e toString é uma excelente prática
já que diminui drasticamente a quantidade de código desneccessário. O @NoArgsConstructor
e o @AllArgsConstructor também servem para esse fim.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = Paciente.TABLE_NAME)
public class Paciente{
    /*
    O padrão de projeto Builder facilita a criação de objetos com muitos atributos,
    evitando construtores longos e melhorando a legibilidade do código.
    Classe muito grandes como essa de paciente podem ser melhoradas usando o padrão builder.
     */

    public static class Builder {
        private Long id;
        private String cpf;
        private String nome;
        private String email;
        private String senha;
        private String numeroTelefone;
        private String cep;
        private String numeroResidencia;
        private String descricaoDoPaciente;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder senha(String senha) {
            this.senha = senha;
            return this;
        }

        public Builder numeroTelefone(String numeroTelefone) {
            this.numeroTelefone = numeroTelefone;
            return this;
        }

        public Builder cep(String cep) {
            this.cep = cep;
            return this;
        }

        public Builder numeroResidencia(String numeroResidencia) {
            this.numeroResidencia = numeroResidencia;
            return this;
        }

        public Builder descricaoDoPaciente(String descricaoDoPaciente) {
            this.descricaoDoPaciente = descricaoDoPaciente;
            return this;
        }

        public Paciente build() {
            return new Paciente(this);
        }
    }


    private Paciente(Builder builder) {
        this.id = builder.id;
        this.cpf = builder.cpf;
        this.nome = builder.nome;
        this.email = builder.email;
        this.senha = builder.senha;
        this.numeroTelefone = builder.numeroTelefone;
        this.cep = builder.cep;
        this.numeroResidencia = builder.numeroResidencia;
        this.descricaoDoPaciente = builder.descricaoDoPaciente;
    }

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

    /*
    Sugestão de melhoria 20
    Ao anotar um atributo de entidade com @Email podemos realizar a validação se o atributo
    está nos padrões esperados para um email, e caso não esteja, não permitir que a instância
    seja salva ou alterada e lançar uma mensagem informando sobre essa inconsistência.
    Isso facilita a coesão e garante que a variável irá receber um valor válido.
     */
    @Column(name = "email", unique = true, length = 50)
    @Email(message = "Formato de email inválido")
    @NotBlank
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
