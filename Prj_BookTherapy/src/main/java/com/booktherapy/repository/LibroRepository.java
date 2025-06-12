package com.booktherapy.repository;

import com.booktherapy.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    // Cerca libri che contengono il titolo indicato, ignorando maiuscole/minuscole
    List<Libro> findByTitoloContainingIgnoreCase(String titolo);

    // Cerca libri che contengono l'autore indicato, ignorando maiuscole/minuscole
    List<Libro> findByAutoreContainingIgnoreCase(String autore);

    // Cerca libri con prezzo minore o uguale a quello indicato
    List<Libro> findByPrezzoLessThanEqual(double prezzo);

    // Cerca libri tramite ISBN (potrebbero esserci più libri con stesso ISBN)
    List<Libro> findByIsbn(String isbn);
}
