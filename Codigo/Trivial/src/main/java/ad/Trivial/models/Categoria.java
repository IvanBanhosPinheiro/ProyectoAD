package ad.Trivial.models;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.List;

/**
 * Representa una categoría de preguntas.
 */

@Entity
@Table(name = "categoria")
public class Categoria {

    /**
     * Identificador único de la categoría.
     */
    @Schema(description = "Identificador único de la categoría.", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
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

    /**
     * Preguntas asociadas a esta categoría.
     */
    /*@Schema(description = "Lista de preguntas asociadas a esta categoría.", accessMode = Schema.AccessMode.READ_ONLY)
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pregunta> preguntas;*/

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

    /*public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }*/
}
