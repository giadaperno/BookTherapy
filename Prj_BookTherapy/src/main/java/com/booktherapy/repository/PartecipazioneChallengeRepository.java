package com.booktherapy.repository;

import com.booktherapy.models.PartecipazioneChallenge;
import com.booktherapy.models.Challenge;
import com.booktherapy.models.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartecipazioneChallengeRepository extends JpaRepository<PartecipazioneChallenge, Long> {

    // Trova tutti i partecipanti a una certa challenge
    List<PartecipazioneChallenge> findByChallenge(Challenge challenge);

    // Trova la partecipazione di uno specifico utente a una specifica challenge
    PartecipazioneChallenge findByUtenteAndChallenge(Utente utente, Challenge challenge);
}
