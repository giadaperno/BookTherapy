package com.booktherapy.models;

import jakarta.persistence.*;

@Entity
@Table(name = "partecipazione_challenge")
public class PartecipazioneChallenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "challenge_id", nullable = false)
    private Challenge challenge;

    private int punteggio; // 1 libro letto = 1 punto

    public PartecipazioneChallenge() {}

    public PartecipazioneChallenge(Utente utente, Challenge challenge, int punteggio) {
        this.utente = utente;
        this.challenge = challenge;
        this.punteggio = punteggio;
    }

    public Long getId() {
        return id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }
}

