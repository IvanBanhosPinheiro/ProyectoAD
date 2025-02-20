# Trivial API

## Descripción del proyecto
Este proyecto consiste en una API REST desarrollada con Spring Boot para un juego de trivial. Permite gestionar categorías, preguntas, respuestas y partidas de usuarios, ofreciendo una plataforma organizada y accesible para jugar al trivial.

## 1. Modelo de datos
El modelo de datos de la API se basa en las siguientes entidades principales:
- Usuario: Almacena información sobre los usuarios del sistema (nombre, email, contraseña, rol).
- Categoría: Representa las categorías a las que pertenecen las preguntas (nombre, descripción).
- Pregunta: Contiene las preguntas del juego (texto, categoría_id).
- Respuesta: Almacena las posibles respuestas a cada pregunta (texto, es_correcta, pregunta_id).
- Partida: Registra las partidas jugadas por los usuarios (fecha_inicio, fecha_fin, puntuacion, usuario_id).
- Usuario_Pregunta_Partida: Relaciona qué preguntas ha respondido cada usuario en cada partida (usuario_id, pregunta_id, partida_id, acertada).

## 2. Tecnologías utilizadas
- Java 17
- Spring Boot 3
- H2 (base de datos embebida)
- Spring Data JPA
- Spring Security + JWT (autenticación)
- Thymeleaf + Bootstrap (frontend para administradores)
- Swagger, Postman (documentación)
- Maven (gestión de dependencias)

## 3. Instalación
1. Clona el repositorio: `git clone https://github.com/IvanBanhosPinheiro/ProyectoAD.git`
2. Abre el proyecto en tu IDE (IntelliJ recomendado).
3. Asegúrate de tener Java 17 y Maven instalados.
4. Descarga las dependencias del proyecto con Maven.
5. Configura las variables de entorno si es necesario (especialmente las de la base de datos).

## 4. Ejecución de la API

Tienes dos opciones para ejecutar la API:

**Opción 1: Ejecutar desde el proyecto**

1. Abre una terminal y navega a la carpeta del proyecto.
2. Ejecuta el siguiente comando para compilar y empaquetar la aplicación:
   ```bash
   mvn clean package
   ```
3. El archivo JAR ejecutable se encontrará en la carpeta `target/`.
4. Ejecuta la API con el siguiente comando:
   ```bash
   java -jar target/Trivial-0.0.1-SNAPSHOT.jar 
   ```
5. La API estará disponible en http://localhost:8080.

**Opción 2: Ejecutar desde el JAR precompilado**

1. Navega a la carpeta `distribucion/Ejecutable`.
2. Ejecuta el siguiente comando:
   ```bash
   java -jar Trivial-0.0.1-SNAPSHOT.jar
   ```
3. La API estará disponible en http://localhost:8080.

## 5. Importar la colección de Postman

1. Abre Postman.
2. Haz clic en "Import" y selecciona el archivo `Trivial.postman_collection.json` que se encuentra en la carpeta `distribucion/`.
3. La colección se importará y podrás comenzar a probar los endpoints de la API.

## 6. Estructura del proyecto (backend)

```
ad.Trivial
├── config
│   ├── security
│   └── swagger
├── controllers
│   ├── backend
│   ├── crudCompleto
│   ├── frontend
│   └── AuthController
├── models
│   └── modelosDTO
├── repositories
└── services
```

## 7. Endpoints de la API

La API de Trivial ofrece los siguientes endpoints:

- **Autenticación**:
  - `/auth/login`: Inicia sesión y genera un token JWT.
  - `/auth/register`: Registra un nuevo usuario.
  - Usuario administrador de prueba:
  ```
	{
		"email": "usuario@test.com",
		"contraseña": "usuario"
	}
  ```
- **CRUD de entidades**:
  - `/crud/categorias`: Gestiona categorías (GET, POST, PUT, DELETE).
  - `/crud/preguntas`: Gestiona preguntas (GET, POST, PUT, DELETE).
  - `/crud/usuarios`: Gestiona usuarios (GET, POST, PUT, DELETE).
  - `/crud/partidas`: Gestiona partidas (GET, POST, PUT, DELETE).
- **Operaciones de frontend**:
  - `/api/partidas/mejores`: Obtiene las mejores partidas.
  - Otros endpoints para obtener datos específicos para el frontend.

## 8. Documentación

La documentación detallada de la API se encuentra en Swagger, accesible en http://localhost:8080/swagger-ui.html.

## 9. Acceso a la base de datos

La base de datos H2 tendras acceso en http://localhost:8080/h2-console con usuario: usuario y contraseña: usuario

## 10. Despliegue

Para desplegar la aplicación en un servidor, se recomienda seguir estos pasos:

1. Configurar las variables de entorno (base de datos, JWT).
2. Generar el archivo JAR: `mvn clean package`
3. Ejecutar la aplicación en el servidor: `java -jar target/nombre-del-proyecto.jar`
4. Configurar el acceso externo si es necesario.
5. Implementar un sistema de logs y monitoreo (se recomienda Spring Boot Actuator).

## 11. Créditos

Desarrollado por Iván Baños Piñeiro.

