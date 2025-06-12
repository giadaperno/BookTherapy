package com.booktherapy.repository;

import com.booktherapy.models.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

    // Cerca un utente tramite l'email (utile per login e registrazione)
    Utente findByEmail(String email);
}
