package com.booktherapy.repository;

import com.booktherapy.models.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
    // Qui possiamo aggiungere metodi personalizzati se ci serviranno più avanti
}
