package com.proyectos.spring.crudproductosspring.service;

import com.proyectos.spring.crudproductosspring.exception.CategoriaException;
import com.proyectos.spring.crudproductosspring.model.Categoria;
import com.proyectos.spring.crudproductosspring.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> findAllCategoria(){
        return Collections.unmodifiableList(categoriaRepository.findAll());
    }

    public void deleteByIdCategoria(Long id){
        categoriaRepository.deleteById(id);
    }

    public void addCategoria(Categoria categoria){
        categoriaRepository.save(categoria);
    }

    public Categoria findByIdCategoria(Long id) throws CategoriaException{
        return categoriaRepository.findById(id).orElseThrow(() -> new CategoriaException("Error no fue encontrado la categoria con el ID: " + id));
    }
}
