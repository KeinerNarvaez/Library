# 📚 Library — Sistema de Gestión de Libros

<p align="center">
![Logo de pagina](images/b650f9cb-a484-424a-984d-117c6dd42023.webp "Logo de pagina")
</p>

> Proyecto desarrollado como parte de una petición del instructor Carlos Cadena. Utiliza lenguajes de programación y demas cosas como Java, JavaScript, HTML, CSS y MySQL para construir un sistema completo con backend y frontend integrados.

---

## 📑 Tabla de contenido

- [📚 Library — Sistema de Gestión de Libros](#-library--sistema-de-gestión-de-libros)
- [⚙️ Tecnologías utilizadas](#️-tecnologías-utilizadas)
- [🧪 Funcionalidades principales](#-funcionalidades-principales)
- [🚀 Instalación y ejecución](#-instalación-y-ejecución)
- [🗄️ Modelo de Base de Datos](#-Modelo-de-Base-de-Datos)

---

## ⚙️ Tecnologías utilizadas

- ☕ Java (Spring Boot o Java puro para APIs)
- 🖥️ JavaScript (funcionalidad del frontend)
- 🎨 HTML5 y CSS3
- 🐬 MySQL (estructura relacional)


---

## 🧪 Funcionalidades principales

- Registro e inicio de sesión de usuarios.
- Listado de libros con filtros por nombre.
- CRUD completo de libros, autores, géneros.
- Visualización detallada de cada libro.
- Sistema de puntuación y valoración.

---

## 🚀 Instalación y ejecución


1. Clona este repositorio:
```bash
git clone https://github.com/KeinerNarvaez/Library.git
```
> Asegúrate de tener XAMPP en ejecución (MySQL activado) y apache  
> Crea una base de datos llamada librarydb.

3. Ejecuta el backend (Java):
- Abre el proyecto backend en tu IDE favorito (Eclipse, IntelliJ, VS Code, etc.)
- Ejecuta el proyecto. La API estará disponible en http://localhost:8085/api/v1/

4. Visualiza el frontend:
- Abre el archivo index.html.
- También puedes usar Live Server si estás en VS Code

5. Demas cosas:
- La tabla genre debe tener:  Narrativa, Manga, Mitologia, Romantico, Infantil, Poesia, Comics, todo sin tildes.

---

## 🗄️ Modelo de Base de Datos

A continuación se describe la estructura de las tablas que conforman la base de datos del sistema. Cada tabla corresponde a una entidad del modelo de datos del proyecto.

### 📍 Tabla: country

| Campo       | Tipo       | Restricciones        |
|-------------|------------|-----------------------|
| id_country  | int        | PK, auto-incremental |
| country     | varchar(20)| NOT NULL             |

---

### 📍 Tabla: editorial

| Campo        | Tipo       | Restricciones                                   |
|--------------|------------|--------------------------------------------------|
| id_editorial | int        | PK, auto-incremental                            |
| editorial    | varchar(20)| NOT NULL                                        |
| id_country   | int        | FK → country(id_country), NOT NULL             |
| description  | TEXT       | NOT NULL                                        |

---

### 📍 Tabla: genre

| Campo     | Tipo       | Restricciones        |
|-----------|------------|-----------------------|
| id_genre  | int        | PK, auto-incremental |
| genre     | varchar(20)| NOT NULL             |

---

### 📍 Tabla: user

| Campo             | Tipo          | Restricciones                      |
|-------------------|---------------|-------------------------------------|
| id_user           | int           | PK, auto-incremental               |
| name              | varchar(50)   | NOT NULL                           |
| email             | varchar(150)  | NOT NULL                           |
| password          | varchar(150)  | NOT NULL                           |
| number            | varchar(150)  | NOT NULL                           |
| registration_date | datetime      | NOT NULL                           |
| status            | boolean       | NOT NULL, default true             |

---

### 📍 Tabla: roles

| Campo     | Tipo         | Restricciones        |
|-----------|--------------|-----------------------|
| id_roles  | int          | PK, auto-incremental |
| name_rol  | varchar(50)  | NOT NULL             |

---

### 📍 Tabla: user_rol

| Campo        | Tipo       | Restricciones                                |
|--------------|------------|-----------------------------------------------|
| id_user_rol  | int        | PK, auto-incremental                         |
| id_user      | int        | FK → user(id_user), NOT NULL                |
| id_rol       | int        | FK → roles(id_roles), NOT NULL              |

---

### 📍 Tabla: loan_detail

| Campo          | Tipo        | Restricciones                                |
|----------------|-------------|-----------------------------------------------|
| id_loan_detail | int         | PK, auto-incremental                         |
| id_bill        | int         | FK → bill_loan(id_bill), NOT NULL           |
| state          | varchar(20) | NOT NULL                                     |
| return_date    | date        | NOT NULL                                     |
| id_book        | int         | FK → book(id_book), NOT NULL                |


### 🧑‍💼 Tabla: author

Representa a los autores de los libros.

| Campo       | Tipo        | Restricciones                              |
|-------------|-------------|--------------------------------------------|
| id_author   | int         | PRIMARY KEY, auto-incremental              |
| author      | varchar(50) | NOT NULL                                   |
| id_country  | int         | FOREIGN KEY → country(id_country), NOT NULL |

---

### 📕 Tabla: book

Contiene la información principal sobre los libros disponibles.

| Campo            | Tipo          | Restricciones                                               |
|------------------|---------------|-------------------------------------------------------------|
| id_book          | int           | PRIMARY KEY, auto-incremental                              |
| title            | varchar(100)  | NOT NULL                                                    |
| id_author        | int           | FOREIGN KEY → author(id_author), NOT NULL                  |
| id_genre         | int           | FOREIGN KEY → genre(id_genre), NOT NULL                    |
| id_editorial     | int           | FOREIGN KEY → editorial(id_editorial), NOT NULL            |
| publication_year | int           | NOT NULL                                                    |
| pages            | int           | NOT NULL                                                    |
| image            | TEXT          | Puede ser una URL o base64 (representación de imagen)       |

---

### 🧾 Tabla: bill_loan

Representa el registro general de préstamos realizados por los usuarios.

| Campo     | Tipo     | Restricciones                         |
|-----------|----------|---------------------------------------|
| id_bill   | int      | PRIMARY KEY, auto-incremental        |
| id_user   | int      | FOREIGN KEY → user(id_user), NOT NULL |
| date      | date     | NOT NULL                              |
---

### 📚 Tabla: book_genre

Esta tabla representa la relación entre libros y géneros, permitiendo que un libro tenga múltiples géneros asociados.

| Campo          | Tipo       | Restricciones                                 |
|----------------|------------|-----------------------------------------------|
| id_book_genre  | int        | PRIMARY KEY, auto-incremental                |
| id_genre       | int        | FOREIGN KEY → genre(id_genre), NOT NULL     |
| id_book        | int        | FOREIGN KEY → book(id_book), NOT NULL       |
