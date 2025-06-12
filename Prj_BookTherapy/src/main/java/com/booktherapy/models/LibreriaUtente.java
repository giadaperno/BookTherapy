package com.booktherapy.models;

import jakarta.persistence.*; // Importiamo le classi JPA per la persistenza dei dati.

/**
 * Entità che rappresenta la relazione tra un utente e un libro nella sua libreria personale,
 * includendo lo stato di lettura del libro per quello specifico utente.
 * L'obiettivo è tracciare quali libri ogni utente ha nella sua libreria e se li ha "letti" o "da leggere".
 */
@Entity // Ho annotato questa classe come un'entità JPA, il che significa che verrà mappata a una tabella nel database.
@Table(name = "libreriautente") 
public class LibreriaUtente {

    @Id // Ho designato 'id' come la chiave primaria di questa tabella.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Ho configurato il database per generare automaticamente l'ID (auto-incremento) ogni volta che viene inserita una nuova riga.
    private Long id;

    /**
     * Ho stabilito una relazione "molti a uno" (`ManyToOne`) tra 'LibreriaUtente' e 'Utente'.
     * Ciò significa che molte voci nella tabella 'libreriautente' possono fare riferimento a un singolo utente.
     * Ho creato una colonna `utente_id` nella tabella `libreriautente` come chiave esterna per collegarmi all'utente,
     * e ho reso questo collegamento obbligatorio (`nullable = false`).
     */
    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;

    /**
     * Ho stabilito una relazione "molti a uno" tra 'LibreriaUtente' e 'Libro'.
     * Questo implica che molte voci nella tabella 'libreriautente' possono fare riferimento a un singolo libro.
     * Ho creato una colonna `libro_id` nella tabella `libreriautente` come chiave esterna per collegarmi al libro,
     * e ho reso anche questo collegamento obbligatorio (`nullable = false`).
     */
    @ManyToOne
    @JoinColumn(name = "libro_id", nullable = false)
    private Libro libro;

    /**
     * Ho aggiunto un campo `stato` per memorizzare se il libro è stato "letto" o è "da leggere" per un dato utente.
     * Ho reso questo campo obbligatorio (`nullable = false`) per garantire che ogni voce abbia uno stato definito.
     */
    @Column(nullable = false)
    private String stato;

    /**
     * Ho incluso il costruttore vuoto, che è un requisito di JPA per poter istanziare gli oggetti
     * quando vengono recuperati dal database.
     */
    public LibreriaUtente() {}

    /**
     * Ho definito un costruttore che permette di creare una nuova voce di 'LibreriaUtente'
     * specificando direttamente l'utente, il libro e lo stato iniziale.
     */
    public LibreriaUtente(Utente utente, Libro libro, String stato) {
        this.utente = utente;
        this.libro = libro;
        this.stato = stato;
    }

    // --- Metodi Getter e Setter ---
    // Ho implementato i metodi getter e setter standard per tutti i campi,
    // in modo da poter accedere e modificare i dati  in modo controllato.

    public Long getId() {
        return id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }
}