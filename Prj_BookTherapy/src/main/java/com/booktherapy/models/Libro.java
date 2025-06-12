package com.booktherapy.models;

import jakarta.persistence.*;

@Entity // Dice a Spring che questa classe rappresenta una tabella nel database
@Table(name = "libro") // Nome della tabella in MySQL
public class Libro {

    @Id // Indica che questo campo è la chiave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera ID automatici
    private Long id;

    @Column(nullable = false) // Campo obbligatorio
    private String titolo;

    @Column(nullable = false)
    private String autore;

    private String isbn;

    private double prezzo;

    // Costruttore vuoto richiesto da JPA
    public Libro() {}

    // Costruttore con parametri
    public Libro(String titolo, String autore, String isbn, double prezzo) {
        this.titolo = titolo;
        this.autore = autore;
        this.isbn = isbn;
        this.prezzo = prezzo;
    }

    // Getter e Setter (servono per accedere ai dati da altri file)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
}
