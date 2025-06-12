package controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entities.Libro;
import service.LibroService;

@RestController // Indica che questa classe gestirà richieste REST
@RequestMapping("/api/libri") // Tutte le chiamate a questo controller inizieranno con /api/libri
public class LibroController {

    private final LibroService libroService;

    @Autowired
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    // Endpoint: GET /api/libri/cerca/titolo?valore=...
    @GetMapping("/cerca/titolo")
    public List<Libro> cercaPerTitolo(@RequestParam String valore) {
        return libroService.cercaLibriPerTitolo(valore);
    }

    // Endpoint: GET /api/libri/cerca/autore?valore=...
    @GetMapping("/cerca/autore")
    public List<Libro> cercaPerAutore(@RequestParam String valore) {
        return libroService.cercaLibriPerAutore(valore);
    }

    // Endpoint: GET /api/libri/cerca/prezzo?max=...
    @GetMapping("/cerca/prezzo")
    public List<Libro> cercaPerPrezzo(@RequestParam BigDecimal max) {
        return libroService.cercaLibriPerPrezzoMassimo(max);
    }

    // Endpoint: GET /api/libri/cerca/isbn?valore=...
    @GetMapping("/cerca/isbn")
    public ResponseEntity<Libro> cercaPerIsbn(@RequestParam String valore) { 
        return libroService.cercaLibroPerIsbn(valore)
                .map(ResponseEntity::ok) // Se trovato, rispondi con 200 OK e il libro
                .orElse(ResponseEntity.notFound().build()); // Altrimenti, rispondi con 404 Not Found
    }

    // Endpoint: GET /api/libri/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Libro> cercaPerId(@PathVariable Long id) {
        return libroService.cercaLibroPerId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}