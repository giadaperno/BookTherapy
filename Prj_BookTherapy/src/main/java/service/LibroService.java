package service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Libro;
import repos.LibroRepository;

@Service // Indica a Spring che questa è una classe di servizio
public class LibroService {

    private final LibroRepository libroRepository;

    @Autowired // Inietta automaticamente un'istanza di LibroRepository nel costruttore
    // per poter utilizzare i metodi di accesso ai dati
    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    // Cerca libri per titolo
    public List<Libro> cercaLibriPerTitolo(String titolo) {
        return libroRepository.findByTitoloContainingIgnoreCase(titolo);
    }

    // Cerca libri per autore
    public List<Libro> cercaLibriPerAutore(String autore) {
        return libroRepository.findByAutoreContainingIgnoreCase(autore);
    }

    // Cerca libri con un prezzo massimo
    public List<Libro> cercaLibriPerPrezzoMassimo(BigDecimal prezzoMax) {
        return libroRepository.findByPrezzoLessThanEqual(prezzoMax);
    }

    // Cerca un libro per ISBN
    public Optional<Libro> cercaLibroPerIsbn(String isbn) {
        return libroRepository.findByIsbn(isbn);
    }

    // Cerca un libro per il suo ID univoco
    public Optional<Libro> cercaLibroPerId(Long id) {
        return libroRepository.findById(id);
 
    }
}