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
}
