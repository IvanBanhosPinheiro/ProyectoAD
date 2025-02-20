package ad.Trivial.controllers;

import ad.Trivial.config.securiti.JwtService;
import ad.Trivial.config.securiti.UserDetailsServiceImpl;
import ad.Trivial.models.Usuario;
import ad.Trivial.services.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador de autenticación para manejar el registro y login de usuarios.
 */
@RestController
@RequestMapping("/auth")
@Tag(name = "Auth", description = "Operaciones de autenticación")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtService jwtService;

    /**
     * Registra un nuevo usuario.
     *
     * @param usuario los datos del usuario a registrar
     * @return mensaje de éxito o error
     */
    @Operation(summary = "Registrar un nuevo usuario", description = "Registra un nuevo usuario en el sistema")
    @ApiResponse(responseCode = "200", description = "Usuario registrado con éxito",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            {
                                "nombre": "Nuevo Usuario",
                                "email": "nuevo@ejemplo.com",
                                "contraseña": "contraseña_segura"
                            }
                            """)))
    @PostMapping("/register")
    public String register(
            @Parameter(description = "Datos del usuario a registrar", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class),
                            examples = @ExampleObject(value = """
                                    {
                                        "nombre": "Nuevo Usuario",
                                        "email": "nuevo@ejemplo.com",
                                        "contraseña": "contraseña_segura"
                                    }
                                    """))) @RequestBody Usuario usuario) {
        try {
            usuario.setId(null);
            usuario.setRol(Usuario.Rol.usuario);
            if (usuarioService.guardar(usuario) == null) {
                return "Error al guardar usuario";
            }
            return "Usuario registrado con éxito";
        } catch (Exception e) {
            return "Error al registrar: " + e.getMessage();
        }
    }

    /**
     * Autentica un usuario y genera un token JWT.
     *
     * @param usuario los datos del usuario para autenticación
     * @return token JWT si la autenticación es exitosa
     */
    @Operation(summary = "Login de usuario", description = "Autentica un usuario y genera un token JWT")
    @ApiResponse(responseCode = "200", description = "Autenticación exitosa",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            {
                                "email": "usuario@ejemplo.com",
                                "contraseña": "contraseña_segura"
                            }
                            """)))
    @PostMapping("/login")
    public String login(
            @Parameter(description = "Datos del usuario para autenticación", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class),
                            examples = @ExampleObject(value = """
                                    {
                                        "email": "usuario@ejemplo.com",
                                        "contraseña": "contraseña_segura"
                                    }
                                    """))) @RequestBody Usuario usuario) {
        try {
            System.out.println("Intentando login para: " + usuario.getEmail());

            // Intentar autenticar al usuario
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getContraseña())
            );
            System.out.println("Autenticación exitosa");

            // Si la autenticación es exitosa, obtener los detalles del usuario
            UserDetails userDetails = userDetailsService.loadUserByUsername(usuario.getEmail());

            // Generar y devolver el token JWT
            return jwtService.generateToken(userDetails.getUsername());
        } catch (Exception e) {
            System.out.println("Error en login: " + e.getMessage());
            throw new RuntimeException("Error en la autenticación: " + e.getMessage());
        }
    }
}