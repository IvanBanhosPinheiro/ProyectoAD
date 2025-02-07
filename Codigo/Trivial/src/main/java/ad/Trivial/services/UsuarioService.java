package ad.Trivial.services;

import ad.Trivial.models.Usuario;
import ad.Trivial.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerTodas(){
        return usuarioRepository.findAll();
    }

    public Usuario guardar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizar(Usuario usuario){
        if (usuario.getId() == null){
            return null;
        }else {
            return usuarioRepository.save(usuario);
        }
    }
    public void eliminar(Long id){
        usuarioRepository.deleteById(id);
    }

}
