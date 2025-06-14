package entities;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity

@Table (name = "libri") // Nome della tabella nel database

public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_libro")
	private Long id;
	
	//@NotBlank(message = "Il titolo è obbligatorio")
	@Column(name = "titolo", nullable = false)
	private String titolo;
	
	//@NotBlank(message = "L'autore è obbligatorio")
    @Column(name = "autore", nullable = false)
    private String autore;
	
    //@NotNull(message = "Il prezzo è obbligatorio")
    @Column(name = "prezzo", precision = 10, scale = 2)// precision =10 numero totale di cifre prima della virgola, scale=2 cifre dopo la virgola
    private BigDecimal prezzo; //BigDecimal gestisce meglio i prezzi perchè non si rischia di avere troppe cifre inutili dopo la virgola
    
    //@NotNull (message = "L'ISBN è obbligatorio")
    @Column (name = "ISBN", nullable = false)
    private String isbn;

	public Libro(Long id, String titolo, String autore, BigDecimal prezzo, String isbn) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.autore = autore;
		this.prezzo = prezzo;
		this.isbn = isbn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Libro [id=");
		builder.append(id);
		builder.append(", titolo=");
		builder.append(titolo);
		builder.append(", autore=");
		builder.append(autore);
		builder.append(", prezzo=");
		builder.append(prezzo);
		builder.append(", isbn=");
		builder.append(isbn);
		builder.append("]");
		return builder.toString();
	}
    
    

}
// Nota: Per utilizzare le annotazioni come @NotBlank e @NotNull, è necessario importare le dipendenze di validazione (javax.validation.constraints) nel progetto.
// Queste annotazioni possono essere utilizzate per la validazione dei campi durante la creazione o l'aggiornamento di un libro.