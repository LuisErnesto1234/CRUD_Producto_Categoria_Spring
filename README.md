# CRUD de Productos con Categorías

Este es un proyecto de CRUD para la gestión de productos y categorías. Permite la creación, edición, eliminación y visualización de productos, además de la subida de imágenes para los mismos. Las categorías pueden ser asignadas a los productos.

## Tecnologías utilizadas

- **Spring Boot** - Framework principal del backend
- **Maven** - Gestión de dependencias mediante `pom.xml`
- **Thymeleaf** - Motor de plantillas para la vista
- **Tailwind CSS** - Estilización de la interfaz
- **MySQL** - Base de datos relacional
- **Hibernate** - ORM para la persistencia de datos
- **Lombok** - Reducción de código boilerplate en las entidades

## Características principales

- CRUD completo para productos y categorías
- Subida de imágenes para productos
- Asociación de productos con categorías
- Diseño responsivo con Tailwind CSS
- Persistencia de datos con MySQL y Hibernate

## Requisitos previos

Antes de ejecutar este proyecto, asegúrate de tener instalado lo siguiente:

- **Java 17** o superior
- **Maven**
- **MySQL**

## Configuración

1. **Clonar el repositorio**
   ```sh
   git clone https://github.com/LuisErnesto1234/CRUD_Producto_Categoria_Spring.git
   cd tu-repositorio
   ```

2. **Configurar la base de datos**
   Crea una base de datos en MySQL y actualiza `application.properties` con tus credenciales:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/tu_base_de_datos
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   ```

3. **Compilar y ejecutar el proyecto**
   ```sh
   mvn spring-boot:run
   ```

4. **Acceder a la aplicación**
   - La aplicación estará disponible en `http://localhost:8080`

## Uso

- **Productos**: Puedes crear, editar y eliminar productos. También puedes subir imágenes para cada producto.
- **Categorías**: Puedes gestionar las categorías y asignarlas a los productos.

## Capturas de pantalla
#### Pantalla Principal
![Pantalla Principal](https://github.com/LuisErnesto1234/CRUD_Producto_Categoria_Spring/blob/main/screenshot/principal.png)
#### Formulario Producto
![Formulario Producto](https://github.com/LuisErnesto1234/CRUD_Producto_Categoria_Spring/blob/main/screenshot/editar_producto.png)
#### Catalogo Productos
![Catalogo Productos](https://github.com/LuisErnesto1234/CRUD_Producto_Categoria_Spring/blob/main/screenshot/catalogo.png)
#### Producto Vista
![Producto Vista](https://github.com/LuisErnesto1234/CRUD_Producto_Categoria_Spring/blob/main/screenshot/ver_producto.png)
#### Categoria Tabla
![Categorias Tabla](https://github.com/LuisErnesto1234/CRUD_Producto_Categoria_Spring/blob/main/screenshot/categoria_tabla.png)
#### Categoria Formulario
![Categorias Formulario](https://github.com/LuisErnesto1234/CRUD_Producto_Categoria_Spring/blob/main/screenshot/formulario_categoria.png)

## Contribuciones

Si deseas contribuir a este proyecto:
1. Realiza un fork del repositorio
2. Crea una nueva rama (`git checkout -b feature/nueva-feature`)
3. Realiza tus cambios y haz commit (`git commit -m 'Descripción del cambio'`)
4. Sube los cambios (`git push origin feature/nueva-feature`)
5. Abre un Pull Request

## Licencia

Este proyecto está bajo la licencia MIT. Puedes ver más detalles en el archivo `LICENSE`.

## Autor

Desarrollado por [LuisErnesto1234](https://github.com/LuisErnesto1234).
