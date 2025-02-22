package ad.Trivial.services;

import ad.Trivial.models.Usuario;
import ad.Trivial.models.modelosDTO.UsuariODTO;
import ad.Trivial.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        usuario.setContraseña(new BCryptPasswordEncoder().encode(usuario.getContraseña()));
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizar(Usuario usuario){
        if (usuario.getId() == null){
            return null;
        }else {
            return guardar(usuario);
        }
    }
    public void eliminar(Long id){
        usuarioRepository.deleteById(id);
    }

    public Usuario obtenerPorIdAdmin(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario obtenerPorId(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        return usuario;
    }
    //Parte DTOs
    public ResponseEntity<?> obtenerPorIdDTO(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null){
            UsuariODTO usuariODTO = conversionModelos.transformarUsuarioADTO(usuario);
            return ResponseEntity.ok(usuariODTO);
        }else{
            return ResponseEntity.status(404).body("No se ha encontrado el usuario");
        }
    }

    public ResponseEntity<UsuariODTO> obtenerPorEmail(String email){
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario != null){
            UsuariODTO usuariODTO = conversionModelos.transformarUsuarioADTO(usuario);
            return ResponseEntity.ok(usuariODTO);
        }else{
            return ResponseEntity.status(404).body(null);
        }
    }

    public ResponseEntity<?> obtenerTodosSinAdministradoresDTO(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuariODTO> usuariODTOS = new ArrayList<>();
        for (Usuario usuario : usuarios){
            if (!usuario.getRol().equals("ADMIN")){
                usuariODTOS.add(conversionModelos.transformarUsuarioADTO(usuario));
            }
        }
        return ResponseEntity.ok(usuariODTOS);
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
