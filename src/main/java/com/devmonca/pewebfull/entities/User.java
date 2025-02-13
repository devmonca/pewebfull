package com.devmonca.pewebfull.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Data
@Getter
@Setter

@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email", columnDefinition = "TEXT", nullable = false)
    private String email;

    @Column(name = "senha",length = 200, nullable = false)
    private String senha;

    @Column(name = "nome",length = 200, nullable = false)
    private String nome;

    @Column(name = "data_de_nascimento", nullable = false)
    private Date nascimento;

    @Column(name = "telefone",length = 200, nullable = false)
    private String telefone;

    public User(){

    }

    public User(Integer id, String email, String senha, String nome, Date nascimento, String telefone) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.nascimento = nascimento;
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
