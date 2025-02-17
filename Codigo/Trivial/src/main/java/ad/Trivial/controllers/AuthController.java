package ad.Trivial.controllers;


import ad.Trivial.config.securiti.JwtService;
import ad.Trivial.config.securiti.UserDetailsServiceImpl;
import ad.Trivial.models.Usuario;
import ad.Trivial.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtService jwtService;


    @PostMapping("/register")
    public String register(@RequestBody Usuario usuario) {
        // Encriptar la contraseña
        usuario.setContraseña(new BCryptPasswordEncoder().encode(usuario.getContraseña()));
        usuario.setId(null);
        if(usuarioService.guardar(usuario) == null){
            return "Error al guardar usuario";
        }

        return "Usuario registrado con éxito";
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        // Intentar autenticar al usuario
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getContraseña())
        );

        // Si la autenticación es exitosa, obtener los detalles del usuario
        UserDetails userDetails = userDetailsService.loadUserByUsername(usuario.getEmail());

        // Generar y devolver el token JWT
        return jwtService.generateToken(userDetails.getUsername());
    }

}
