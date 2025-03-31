package com.proyectos.spring.crudproductosspring.controller;

import com.proyectos.spring.crudproductosspring.model.Producto;
import com.proyectos.spring.crudproductosspring.service.CategoriaService;
import com.proyectos.spring.crudproductosspring.service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Controller
@RequestMapping({"/", "/app", "/app/producto"})
public class ProductoController {

    private final ProductoService productoService;
    private final CategoriaService categoriaService;

    public ProductoController(ProductoService productoService, CategoriaService categoriaService) {
        this.productoService = productoService;
        this.categoriaService = categoriaService;
    }

    @GetMapping()
    public String mostrarProductos(Model model) {
        model.addAttribute("productos", productoService.findAllProducto());
        return "producto";
    }

    @GetMapping("/nuevo")
    public String agregarProducto(Model model){
        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", categoriaService.findAllCategoria());
        return "formulario";
    }

    //TODO metodo mas dificil el postMapping ;V ☠️
    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute Producto producto, @RequestParam(name = "imagen") MultipartFile file) throws IOException{

        // Si es una edición y no se sube una nueva imagen, conservar la imagen anterior
        if (producto.getId() != null) {
            Producto productoEncontrado = productoService.findByIdProducto(producto.getId());
            if (productoEncontrado != null && productoEncontrado.getImagenUrl() != null && file.isEmpty()) {
                producto.setImagenUrl(productoEncontrado.getImagenUrl());
            }
        } else if (!file.isEmpty()) {
            //Capturamos la ruta base del proyecto para guardar imagenes
            String rutaBase = System.getProperty("user.dir");

            //Ahora la ruta donde se guardara la imagen
            String rutaSubida = rutaBase + File.separator + "uploads" + File.separator + "producto";

            //Creamos la carpeta donde se guardara la imagen
            File carpetaGuardado = new File(rutaSubida);
            if (!carpetaGuardado.exists()){
                boolean crearCarpeta = carpetaGuardado.mkdirs();
                if (!crearCarpeta){
                    throw new IOException("No se pudo crear el directorio: " + rutaSubida);
                }
            }

            // Generamos un nombre seguro
            String nombreImagen = System.currentTimeMillis() + "_" + Objects.requireNonNull(file.getOriginalFilename()).replaceAll("\\s+", "_");
            Path archivoPath = Paths.get(rutaSubida, nombreImagen);

            //Guardamos la imagen en la carpeta
            file.transferTo(archivoPath.toFile());

            //Modificamos la ruta de la imagen
            producto.setImagenUrl("/uploads/producto/" + nombreImagen);
        }
        // Si no hay imagen y es un nuevo producto, asignamos una imagen por defecto
        if (file.isEmpty() && producto.getImagenUrl() == null) {
            producto.setImagenUrl("/uploads/producto/default.png");
        }

        productoService.addProducto(producto);
        return "redirect:/app";
    }


    @GetMapping("/editar/{id}")
    public String editarProducto(Model model, @PathVariable Long id) {
        model.addAttribute("producto", productoService.findByIdProducto(id));
        model.addAttribute("categorias", categoriaService.findAllCategoria());
        return "formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        Producto productoEncontrado = productoService.findByIdProducto(id);

        if (productoEncontrado != null) {
            if (productoEncontrado.getImagenUrl() != null) {
                //Capturamos la ruta base del proyecto
                String rutaBase = System.getProperty("user.dir");
                //Creamos la ruta con Path para poder eliminar el archivo asociado al producto :v
                Path rutaAbsoluta = Paths.get(rutaBase, productoEncontrado.getImagenUrl());
                File file = rutaAbsoluta.toFile();

                if (file.exists()) {
                    file.delete();
                }
            }

            productoService.deleteProducto(id);
        }

        return "redirect:/app";
    }

    @GetMapping("/catalogo")
    public String catalogo(Model model){
        model.addAttribute("productos", productoService.findAllProducto());
        return "catalogo";
    }

    @GetMapping("/ver/{id}")
    public String verProducto(@PathVariable Long id, Model model){
        model.addAttribute("producto", productoService.findByIdProducto(id));
        return "ver_producto";
    }
}

