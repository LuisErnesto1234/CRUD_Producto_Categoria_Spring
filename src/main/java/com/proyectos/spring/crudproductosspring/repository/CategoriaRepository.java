package com.proyectos.spring.crudproductosspring.repository;

import com.proyectos.spring.crudproductosspring.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
