package com.proyectos.spring.crudproductosspring.service;

import com.proyectos.spring.crudproductosspring.model.Categoria;
import com.proyectos.spring.crudproductosspring.model.Producto;
import com.proyectos.spring.crudproductosspring.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> findAllProducto(){
        return Collections.unmodifiableList(productoRepository.findAll());
    }

    public void addProducto(Producto producto){
        productoRepository.save(producto);
    }

    public void deleteProducto(Long id){
        productoRepository.deleteById(id);
    }

    public Producto findByIdProducto(Long id){
        return productoRepository.findById(id).orElseThrow();
    }

    public List<Producto> findByCategoria(Categoria categoria){
        return productoRepository.findByCategoria(categoria);
    }

}
