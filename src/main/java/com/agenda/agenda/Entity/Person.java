package com.agenda.agenda.Entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "agenda")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    @org.hibernate.annotations.Type(type="uuid-char")
    private UUID id;
    @Column(name="nome")
    private String nome;
    @Column(name="cognome")
    private String cognome;
    @Column(name="numero")
    private String numero;
    @Column(name = "email")
    private String email;

    public Person(UUID id, String nome, String cognome, String numero, String email) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.numero = numero;
        this.email = email;
    }

    public Person() {
        this.id = null;
        this.nome = null;
        this.cognome = null;
        this.numero = null;
        this.email = null;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
