package ad.Trivial.models;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * Representa una categoría de preguntas.
 */
@Schema(description = "Entidad que representa una categoría de preguntas")
@Entity
@Table(name = "categoria")
public class Categoria {

    /**
     * Identificador único de la categoría.
     */
    @Schema(description = "Identificador único de la categoría.", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre de la categoría.
     */
    @Schema(description = "Nombre de la categoría.", example = "Historia", maxLength = 50)
    @Column(nullable = false, unique = true, length = 50)
    private String nombre;

    /**
     * Descripción de la categoría.
     */
    @Schema(description = "Descripción de la categoría.", example = "Preguntas relacionadas con eventos históricos.")
    @Column(length = 255)
    private String descripcion;


    public Categoria() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
