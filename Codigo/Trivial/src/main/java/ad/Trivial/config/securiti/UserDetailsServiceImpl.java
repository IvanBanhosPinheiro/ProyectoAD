package ad.Trivial.config.securiti;

import ad.Trivial.models.Usuario;
import ad.Trivial.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + email);
        }

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(usuario.getRol().toString());

        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getContraseña())
                .authorities(Collections.singletonList(authority))
                .build();
    }
}