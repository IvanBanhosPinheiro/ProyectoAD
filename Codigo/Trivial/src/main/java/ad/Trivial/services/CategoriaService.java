package ad.Trivial.services;

import ad.Trivial.models.Categoria;
import ad.Trivial.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<Categoria> obtenerTodas(){
        return categoriaRepository.findAll();
    }

    public Categoria obtenerPorId(Long id){
        return categoriaRepository.findById(id).orElse(null);
    }

    public Categoria guardar(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public Categoria actualizar(Categoria categoria){
        if (categoria.getId() == null){
            return null;
        }else {
            return categoriaRepository.save(categoria);
        }
    }

    public void eliminar(Long id){
        categoriaRepository.deleteById(id);
    }

}
