package ad.Trivial.models;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

/**
 * Representa una pregunta en el sistema.
 */
@Schema(description = "Entidad que representa una pregunta del trivial")
@Entity
@Table(name = "pregunta")
public class Pregunta {

    /**
     * Identificador único de la pregunta.
     */
    @Schema(description = "Identificador único de la pregunta.", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Texto de la pregunta.
     */
    @Schema(description = "Texto de la pregunta.", example = "¿Cuál es el río más largo del mundo?", maxLength = 250)
    @Column(name = "texto", nullable = false, length = 250)
    private String texto;

    /**
     * Categoría a la que pertenece la pregunta.
     */
    @Schema(description = "Categoría a la que pertenece la pregunta.")
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;


    public Pregunta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}