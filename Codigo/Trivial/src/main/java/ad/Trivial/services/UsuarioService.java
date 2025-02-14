package ad.Trivial.services;

import ad.Trivial.models.Usuario;
import ad.Trivial.models.modelosDTO.UsuariODTO;
import ad.Trivial.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    ConversionModelos conversionModelos;

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

    //Parte DTOs
    public ResponseEntity<?> obtenerPorId(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null){
            UsuariODTO usuariODTO = conversionModelos.transformarUsuarioADTO(usuario);
            return ResponseEntity.ok(usuariODTO);
        }else{
            return ResponseEntity.status(404).body("No se ha encontrado el usuario");
        }
    }

    public ResponseEntity<?> guardarFront(Usuario usuario){
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        if (usuarioGuardado != null){
            UsuariODTO usuariODTO = conversionModelos.transformarUsuarioADTO(usuarioGuardado);
            return ResponseEntity.ok(usuariODTO);
        }else{
            return ResponseEntity.status(500).body("Error al guardar el usuario");
        }
    }

}
