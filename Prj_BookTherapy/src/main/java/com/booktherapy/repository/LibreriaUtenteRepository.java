package com.booktherapy.repository;

import com.booktherapy.models.LibreriaUtente;
import com.booktherapy.models.Libro;
import com.booktherapy.models.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibreriaUtenteRepository extends JpaRepository<LibreriaUtente, Long> {

    // Restituisce tutti i libri associati a un certo utente
    List<LibreriaUtente> findByUtente(Utente utente);

    // Restituisce tutti i libri associati a un utente con un certo stato (es: "letto" o "da leggere")
    List<LibreriaUtente> findByUtenteAndStato(Utente utente, String stato);

    // Trova l'associazione tra un libro e un utente specifico
    LibreriaUtente findByUtenteAndLibro(Utente utente, Libro libro);
}
