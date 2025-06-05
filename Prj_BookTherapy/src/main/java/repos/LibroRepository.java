package repos;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entities.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {
	
	   // Trova libro per ISBN
    Optional<Libro> findByIsbn(String isbn);
    
    // Ricerca per titolo (case insensitive)
    @Query("SELECT l FROM Libro l WHERE LOWER(l.titolo) LIKE LOWER(CONCAT('%', :titolo, '%'))")
    List<Libro> findByTitoloContainingIgnoreCase(@Param("titolo") String titolo);
    
    // Ricerca per autore (case insensitive)
    @Query("SELECT l FROM Libro l WHERE LOWER(l.autore) LIKE LOWER(CONCAT('%', :autore, '%'))")
    List<Libro> findByAutoreContainingIgnoreCase(@Param("autore") String autore);
    
    // Ricerca per prezzo massimo
    List<Libro> findByPrezzoLessThanEqual(BigDecimal prezzoMax);
    
    // Ricerca per prezzo tra due valori
    List<Libro> findByPrezzoBetween(BigDecimal prezzoMin, BigDecimal prezzoMax);
    
    // Ricerca combinata con filtri
    @Query("SELECT l FROM Libro l WHERE " +
           "(:titolo IS NULL OR LOWER(l.titolo) LIKE LOWER(CONCAT('%', :titolo, '%'))) AND " +
           "(:autore IS NULL OR LOWER(l.autore) LIKE LOWER(CONCAT('%', :autore, '%'))) AND " +
           "(:prezzoMin IS NULL OR l.prezzo >= :prezzoMin) AND " +
           "(:prezzoMax IS NULL OR l.prezzo <= :prezzoMax)")
    List<Libro> findLibriConFiltri(@Param("titolo") String titolo,
                                   @Param("autore") String autore,
                                   @Param("prezzoMin") BigDecimal prezzoMin,
                                   @Param("prezzoMax") BigDecimal prezzoMax);
}

