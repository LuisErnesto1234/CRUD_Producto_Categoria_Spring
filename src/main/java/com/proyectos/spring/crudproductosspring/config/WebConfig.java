package com.proyectos.spring.crudproductosspring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Obtener la ruta real donde se almacenan las imágenes
        Path uploadDir = Paths.get(System.getProperty("user.dir"), "uploads", "producto");
        String uploadPath = uploadDir.toFile().getAbsolutePath();

        // Configurar el acceso a las imágenes
        registry.addResourceHandler("/uploads/producto/**")
                .addResourceLocations("file:///" + uploadPath + "/");
    }
}
