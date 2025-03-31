package com.proyectos.spring.crudproductosspring.controller;

import com.proyectos.spring.crudproductosspring.exception.CategoriaException;
import com.proyectos.spring.crudproductosspring.model.Categoria;
import com.proyectos.spring.crudproductosspring.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"/app/categoria", "/categoria"})
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping()
    public String mostrarCategorias(Model model){
        model.addAttribute("categorias", categoriaService.findAllCategoria());
        return "categoria";
    }

    @GetMapping("/delete/{id}")
    public String eliminarCategoria(@PathVariable Long id){
        categoriaService.deleteByIdCategoria(id);
        return "redirect:/categoria";
    }

    @GetMapping("/editar/{id}")
    public String editarCategoria(@PathVariable Long id, Model model) throws CategoriaException {
        model.addAttribute("categoria", categoriaService.findByIdCategoria(id));
        return "categoria_formulario";
    }

    @GetMapping("/nuevo")
    public String agregarCategoria(Model model){
        model.addAttribute("categoria", new Categoria());
        return "categoria_formulario";
    }

    @PostMapping("/guardar")
    public String guardarCategoria(@ModelAttribute Categoria categoria){
        categoriaService.addCategoria(categoria);
        return "redirect:/app/categoria";
    }
}
