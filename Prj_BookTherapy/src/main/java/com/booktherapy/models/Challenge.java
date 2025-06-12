package com.booktherapy.models; // Dichiara il pacchetto a cui appartiene questa classe.
                               

import jakarta.persistence.*; 
import java.time.LocalDate; 

@Entity // Questa annotazione (@Entity) dice a JPA che questa classe è un'entità,
        // e che quindi deve essere mappata a una tabella del database.
@Table(name = "challenge") // Questa annotazione (@Table) specifica il nome della tabella nel database
                           // a cui questa entità sarà mappata. In questo caso, la tabella si chiamerà "challenge".
public class Challenge {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; // Dichiarazione del campo 'id'. Sarà di tipo Long (un numero intero grande)
                     // per supportare molti record. È 'private' per incapsulamento (accessibile solo tramite getter/setter).

    private String nome; 

    private LocalDate dataInizio; 

    private LocalDate dataFine; 

    /**
     * Costruttore vuoto (default constructor).
     * È necessario per JPA (e per molti framework come Spring) per poter creare istanze della classe
     * quando recupera dati dal database.
     */
    public Challenge() {}

    /**
     * Costruttore con parametri.
     * Questo costruttore permette di creare un oggetto Challenge inizializzando direttamente
     * i campi 'nome', 'dataInizio' e 'dataFine' al momento della creazione.
     * L'ID non viene passato qui perché è generato automaticamente dal database.
     *
     * @param nome Il nome della sfida.
     * @param dataInizio La data di inizio della sfida.
     * @param dataFine La data di fine della sfida.
     */
    public Challenge(String nome, LocalDate dataInizio, LocalDate dataFine) {
        this.nome = nome; 
        this.dataInizio = dataInizio; 
        this.dataFine = dataFine;     
    }

    /**
     * Getter per l'ID della sfida.
     * @return L'ID della sfida.
     */
    public Long getId() {
        return id;
    }

    /**
     * Getter per il nome della sfida.
     * @return Il nome della sfida.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter per il nome della sfida.
     * Permette di modificare il nome di una sfida esistente.
     * @param nome Il nuovo nome da impostare.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Getter per la data di inizio della sfida.
     * @return La data di inizio della sfida.
     */
    public LocalDate getDataInizio() {
        return dataInizio;
    }

    /**
     * Setter per la data di inizio della sfida.
     * @param dataInizio La nuova data di inizio da impostare.
     */
    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    /**
     * Getter per la data di fine della sfida.
     * @return La data di fine della sfida.
     */
    public LocalDate getDataFine() {
        return dataFine;
    }

    /**
     * Setter per la data di fine della sfida.
     * @param dataFine La nuova data di fine da impostare.
     */
    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }
}