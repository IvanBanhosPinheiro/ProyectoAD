package ad.Trivial.models;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * Representa a un usuario en el sistema.
 */
@Schema(description = "Entidad que representa a un usuario en el sistema")
@Entity
@Table(name = "usuario")
public class Usuario {

    /**
     * Identificador único del usuario.
     */
    @Schema(description = "Identificador único del usuario.", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del usuario.
     */
    @Schema(description = "Nombre del usuario.", example = "Juan Pérez", maxLength = 50)
    @Column(nullable = false, length = 50)
    private String nombre;

    /**
     * Email del usuario (único).
     */
    @Schema(description = "Email único del usuario.", example = "juan.perez@example.com", maxLength = 50)
    @Column(nullable = false, unique = true, length = 50)
    private String email;

    /**
     * Contraseña del usuario (debería estar cifrada).
     */
    @Schema(description = "Contraseña del usuario.", example = "password123", minLength = 6)
    @Column(nullable = false)
    private String contraseña;

    /**
     * Rol del usuario (admin o usuario).
     */
    @Schema(description = "Rol del usuario.", example = "usuario", allowableValues = {"admin", "usuario"})
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Rol rol;


    /**
     * Enumeración para los roles de usuario.
     */
    public enum Rol {
        admin, usuario
    }

    public Usuario() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }


}


