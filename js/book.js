
async function registerBook() {
    try {
        let headersList = {
            "Accept": "*/*",
            "User-Agent": "web",
            "Content-Type": "application/json"
        };

        let bodyContent = JSON.stringify({
            "id_book": 0,
            "name_book": document.getElementById("bookName").value,
            "id_author_book": document.getElementById("selectAuthor").value,
            "id_country": document.getElementById("selectCountry").value,
            "id_editorial": document.getElementById("selectEditorial").value,
            "image": document.getElementById("bookImage").value,
            "stars": document.getElementById("selectStars").value
        });

        const response = await fetch("http://localhost:8085/api/v1/book/", {
            method: "POST",
            body: bodyContent,
            headers: headersList
        });

        if (!response.ok) {
            console.error("Error al registrar el libro:", response.status);
            return;
        }

        const data = await response.text();
        console.log(data);
        console.log('Funciona');

        getBook();
        document.getElementById("addBookModal").style.display = "none";
    } catch (error) {
        console.error("Error inesperado:", error);
    }
}
async function registerBookGenre(id_genre, id_book) {
    try {
        let headersList = {
            "Accept": "*/*",
            "User-Agent": "web",
            "Content-Type": "application/json"
        };

        let bodyContent = JSON.stringify({
            "id_book_genre": 0,
            "id_genre": id_genre,
            "id_book": id_book
        });

        const response = await fetch("http://localhost:8085/api/v1/book_genre/", {
            method: "POST",
            body: bodyContent,
            headers: headersList
        });

        if (!response.ok) {
            console.error("Error al registrar el libro:", response.status);
            return;
        }

        const data = await response.text();
        console.log(data);
        console.log('Funciona');

        getBook();
        document.getElementById("addBookModal").style.display = "none";
    } catch (error) {
        console.error("Error inesperado:", error);
    }
}

window.onload = function () {
    getBook();
};

function getBook() {
    return new Promise(async (resolve) => {
        var url = "http://localhost:8085/api/v1/book/";
        var dato
        var filtro = document.getElementById("nameFilter")?.value || "";
        var filtroStars = parseInt(document.getElementById("starFilter")?.value || "");
        if (filtro) {
            dato= 0;
        } else if(filtroStars){
            dato= 1;
        }
        switch (dato) {
            case 0:
                url += "filter/" + filtro;
                break;
            case 1:
                url += "Stars/" + filtroStars;
                break;
            default:
                break;
        }
        



        let headersList = {
            "Accept": "*/*",
            "User-Agent": "web",
            "Content-Type": "application/json"
        };

        let response = await fetch(url, {
            method: "GET",
            headers: headersList
        });

        if (!response.ok) {
            console.error("Error al obtener los libros:", response.status);
            return;
        }

        let data = await response.json();
        var container = document.getElementById("pao");
        container.innerHTML = ''; 


        var title = document.createElement("h2");
        title.className = "letest_text";
        title.innerText = "Descubre historias magicas que te transportan a otros mundos.";
        container.appendChild(title);


        // Crear contenedor principal
        var moviesMain = document.createElement("div");
        moviesMain.className = "movies_main";
        container.appendChild(moviesMain);


        var iamgeMoviesMain = document.createElement("div");
        iamgeMoviesMain.className = "iamge_movies_main";
        moviesMain.appendChild(iamgeMoviesMain);

        data.forEach(book => {
            var iamgeMovies = document.createElement("div");
            iamgeMovies.className = "iamge_movies";

            var image3 = document.createElement("div");
            image3.className = "image_3";

            var image = document.createElement("img");
            image.className = "image";
            image.src = book["_image"] || "default-book-image.jpg";
            image.style.width = "100%";
            image.style.height = "400px";

            var middle = document.createElement("div");
            middle.className = "middle";

            var playnow = document.createElement("div");
            playnow.className = "playnow_bt";
            playnow.style.cursor="pointer";
            playnow.innerText = "Modificar";
            var ids=book["_id_book"];
            playnow.onclick = function () {
                getModifiqueTarget(ids);
                openModifiqueBookModal();
            };

            middle.appendChild(playnow);
            image3.appendChild(image);
            image3.appendChild(middle);

            var codeText = document.createElement("h1");
            codeText.className = "code_text";
            codeText.innerText = book["_name_book"] || "Título no disponible";

            var thereText = document.createElement("p");
            thereText.className = "there_text";
            thereText.innerText = book["_id_author_book"]?._author_name || "Desconocido";

            var starIcon = document.createElement("div");
            starIcon.className = "star_icon";
            let stars = book["_stars"];

            var ul = document.createElement("ul");
            for (let i = 0; i < stars; i++) {
                var li = document.createElement("li");
                var a = document.createElement("a");
                var starImg = document.createElement("img");
                starImg.src = "images/star-icon.png";
                a.appendChild(starImg);
                li.appendChild(a);
                ul.appendChild(li);
            }
            starIcon.appendChild(ul);

            iamgeMovies.appendChild(image3);
            iamgeMovies.appendChild(codeText);
            iamgeMovies.appendChild(thereText);
            iamgeMovies.appendChild(starIcon);
            iamgeMoviesMain.appendChild(iamgeMovies);
        });

        console.log("Libros cargados correctamente");
    });
}
async function getCountry() {
    const url = `http://localhost:8085/api/v1/country/Listcountry`;
  
    let headersList = {
      "Accept": "*/*",
      "User-Agent": "web",
      "Content-Type": "application/json"
    };
  
    try {
      const response = await fetch(url, {
        method: "GET",
        headers: headersList
      });
  
      if (!response.ok) {
        console.error("Error al obtener el país:", response.status);
        return;
      }
  
      const countries = await response.json();
      console.log(countries);
      
      const select = document.getElementById("selectCountry");
      const selectModifique = document.getElementById("selectCountryModifique");
  
      countries.forEach(country => {
        const option = document.createElement("option");
        option.value = country["_id_country"];
        option.textContent = country['_country'];
        select.appendChild(option);
        selectModifique.appendChild(option);
      });
  
    } catch (error) {
      console.error("Error al obtener el país:", error);
    }
}
async function getGenre() {
    const url = `http://localhost:8085/api/v1/genre/Listgenre`;

    let headersList = {
        "Accept": "*/*",
        "User-Agent": "web",
        "Content-Type": "application/json"
    };

    try {
        const response = await fetch(url, {
            method: "GET",
            headers: headersList
        });

        if (!response.ok) {
            console.error("Error al obtener géneros:", response.status);
            return [];
        }

        const genres = await response.json();
        return genres;

    } catch (error) {
        console.error("Error al obtener géneros:", error);
        return [];
    }
}

  async function getEditorial() {
    const url = `http://localhost:8085/api/v1/editorial/`;
  
    let headersList = {
      "Accept": "*/*",
      "User-Agent": "web",
      "Content-Type": "application/json"
    };
  
    try {
      const response = await fetch(url, {
        method: "GET",
        headers: headersList
      });
  
      if (!response.ok) {
        console.error("Error al obtener el país:", response.status);
        return;
      }
  
      const countries = await response.json();
      console.log(countries);
      
      const select = document.getElementById("selectEditorial");
      const selectModifique = document.getElementById("selectEditorialModifique");
  
      countries.forEach(country => {
        const option = document.createElement("option");
        option.value = country["_id_editorial"];
        option.textContent = country['_editorial'];
        select.appendChild(option);
        selectModifique.appendChild(option);
      });
  
    } catch (error) {
      console.error("Error al obtener el país:", error);
    }
  }
  async function getAuthor() {
    const url = `http://localhost:8085/api/v1/author/`;
  
    let headersList = {
      "Accept": "*/*",
      "User-Agent": "web",
      "Content-Type": "application/json"
    };
  
    try {
      const response = await fetch(url, {
        method: "GET",
        headers: headersList
      });
  
      if (!response.ok) {
        console.error("Error al obtener el país:", response.status);
        return;
      }
  
      const countries = await response.json();
      console.log(countries);
      
      const select = document.getElementById("selectAuthor");
      const selectModifique = document.getElementById("selectAuthorModifique");
  
      countries.forEach(country => {
        const option = document.createElement("option");
        option.value = country["_id_author"];
        option.textContent = country['_author_name'];
        select.appendChild(option);
        selectModifique.appendChild(option);
      });
  
    } catch (error) {
      console.error("Error al obtener el país:", error);
    }
  }
  
  document.addEventListener("DOMContentLoaded", () => {
    getEditorial();
    getCountry();
    getAuthor();
    getBookGenreData();
    getGenre();

  });

  

async function getBookGenre(genreFilter = "") {
    return new Promise(async (resolve) => {
        var url = "http://localhost:8085/api/v1/book_genre/";

        let headersList = {
            "Accept": "*/*",
            "User-Agent": "web",
            "Content-Type": "application/json"
        };
        let response = await fetch(url, {
            method: "GET",
            headers: headersList
        });

        if (!response.ok) {
            console.error("Error al obtener los libros:", response.status);
            return;
        }

        let data = await response.json();
        var container = document.getElementById("pao");
        container.innerHTML = ''; 


        let filteredBooks = genreFilter
            ? data.filter(book => book["_id_genre"]?._genre === genreFilter)
            : data;

        if (filteredBooks.length === 0) {
            console.warn(`No se encontraron libros para el género: ${genreFilter}`);
            return;
        }

        var section = document.createElement("div");
        section.className = "genre_section";

        var title = document.createElement("h2");
        title.className = "letest_text";
        title.innerText = `Libros de ${genreFilter || "Todos"}`;
        section.appendChild(title);



        var moviesMain = document.createElement("div");
        moviesMain.className = "movies_main";
        section.appendChild(moviesMain);

        var iamgeMoviesMain = document.createElement("div");
        iamgeMoviesMain.className = "iamge_movies_main";
        moviesMain.appendChild(iamgeMoviesMain);

        filteredBooks.forEach(book => {
            var iamgeMovies = document.createElement("div");
            iamgeMovies.className = "iamge_movies";

            var image3 = document.createElement("div");
            image3.className = "image_3";

            var image = document.createElement("img");
            image.className = "image";
            image.src = book["_id_book"]._image || "default-book-image.jpg";
            image.style.width = "100%";
            image.style.height = "400px";

            var middle = document.createElement("div");
            middle.className = "middle";

            var playnow = document.createElement("div");
            playnow.className = "playnow_bt";
            playnow.innerText = "Modificar";
            var ids=book["_id_book"]._id_book;
            playnow.onclick = function () {
                getModifiqueTarget(ids);
                openModifiqueBookModal();
            };

            middle.appendChild(playnow);
            image3.appendChild(image);
            
            image3.appendChild(middle);
            var leerMas = document.createElement("div");
            leerMas.className = "playnow_bt";
            leerMas.innerText = "";
            // (Opcional) agregar funcionalidad
            leerMas.onclick = function () {
            console.log("Leer más de:", book["_id_book"]._name_book);
             // Aquí puedes abrir un modal o redirigir a más detalles
            };
            

            var codeText = document.createElement("h1");
            codeText.className = "code_text";
            codeText.innerText = book["_id_book"]._name_book || "Título no disponible";

            var thereText = document.createElement("p");
            thereText.className = "there_text";
            thereText.innerText = book["_id_book"]._id_author_book?._author_name || "Desconocido";

            var starIcon = document.createElement("div");
            starIcon.className = "star_icon";
            let stars = parseInt( book["_id_book"]._stars);
            var ul = document.createElement("ul");
            for (let i = 0; i < stars; i++) {
                var li = document.createElement("li");
                var a = document.createElement("a");
                var starImg = document.createElement("img");
                starImg.src = "images/star-icon.png";
                a.appendChild(starImg);
                li.appendChild(a);
                ul.appendChild(li);
            }
            starIcon.appendChild(ul);

            iamgeMovies.appendChild(image3);
            iamgeMovies.appendChild(codeText);
            iamgeMovies.appendChild(thereText);
            iamgeMovies.appendChild(starIcon);
            iamgeMoviesMain.appendChild(iamgeMovies);
        });

        container.appendChild(section);

        console.log(`Libros del género "${genreFilter}" cargados correctamente`);
    });
}

let poesia=document.getElementById("poesia");
let narrativa=document.getElementById("narrativo");
let erotico=document.getElementById("erotico");
let comics=document.getElementById("comics");
let manga=document.getElementById("manga");
let mitologia=document.getElementById("mitologia");
let romantico=document.getElementById("romantico");
let cargar=document.getElementById("cargar-tarjetas");
function activo(activo) {
   narrativa.classList.remove("active");
   poesia.classList.remove("active");
   erotico.classList.remove("active");
   comics.classList.remove("active");
   manga.classList.remove("active");
   mitologia.classList.remove("active");
   romantico.classList.remove("active");
   activo.className="active";
   console.log("se desactivo");
}

poesia.addEventListener("click",function () {
    activo(poesia);
    getBookGenre("Poesia");
    
});
narrativa.addEventListener("click",function () {
   activo(narrativa);
   getBookGenre("Narrativa");
});
comics.addEventListener("click",function () {
   activo(comics);
   getBookGenre("Comics");
});
manga.addEventListener("click",function () {
   activo(manga);
   getBookGenre("Manga");
});
mitologia.addEventListener("click",function () {
   activo(mitologia);
   getBookGenre("Mitologia");
});
romantico.addEventListener("click",function () {
   activo(romantico);
   getBookGenre("Romantico");
});
erotico.addEventListener("click",function () {
   activo(erotico);
   getBookGenre("Infantil");
});


let verMas_Narrativa=document.getElementById("verMasNarrativa");
let verMas_Poesia=document.getElementById("verMas-Poesia");
let verMas_Comics=document.getElementById("verMas-Comics");
let verMas_Manga=document.getElementById("verMas-Manga");
let verMas_Mitologia=document.getElementById("verMas-Mitologia");
let verMas_Romantico=document.getElementById("verMas-Romantico");
let verMas_Erotico=document.getElementById("verMas-Erotico");

let searchBtn = document.getElementById("search-btn");
searchBtn.addEventListener("click", function() {
   getBook();
});
let searchBtnStar = document.getElementById("search-btn-stars");
searchBtnStar.addEventListener("click", function() {
   getBook();
});
function openAddBookModal() {
    console.log("Abrir formulario para nuevo libro");
 
    document.getElementById("addBookModal").style.display = "block";
}
function openAddBookModalGenre() {
    console.log("Abrir formulario para nuevo libro genero");
 
    document.getElementById("addBookModalGenre").style.display = "block";
}
function openModifiqueBookModal() {
    console.log("Abrir formulario editar autor");
    document.getElementById("modifiqueBookModal").style.display = "block";
}
document.getElementById("bookForm").onsubmit = function(e) {
    e.preventDefault();
    registerBook();
    document.getElementById("addBookModal").style.display = "none";
  };
document.getElementById("modifiqueBookForm").onsubmit = function(e) {
    e.preventDefault();
    registerBook();
    document.getElementById("modifiqueBookModal").style.display = "none";
  };
  document.getElementById("modifiqueBookFormGenre").onsubmit = function(e) {
    e.preventDefault();
    registerBook();
    document.getElementById("modifiqueBookModalGenre").style.display = "none";
  };
document.getElementById("botton").addEventListener("click", function() {
    registerBook();
    document.getElementById("addBookModal").style.display = "none";
});
async function getModifiqueTarget(id) {
    const url = "http://localhost:8085/api/v1/book/" + id;

    let headersList = {
        "Accept": "*/*",
        "User-Agent": "web",
        "Content-Type": "application/json"
    };

    const response = await fetch(url, {
        method: "GET",
        headers: headersList
    });

    if (!response.ok) {
        console.error("Error al obtener el libro:", response.status);
        return;
    }

    const book = await response.json();

    document.getElementById("bookIdModifique").value = book["_id_book"];
    document.getElementById("bookNameModifique").value = book["_name_book"];
    document.getElementById("bookImageModifique").value = book["_image"];
    document.getElementById("selectStarsModifique").value = book["_stars"];
    document.getElementById("selectAuthorModifique").value = book["_id_author_book"]._id_author;
    document.getElementById("selectCountryModifique").value = book["_id_country"]._id_country;
    document.getElementById("selectEditorialModifique").value = book["_id_editorial"]._id_editorial;
    document.getElementById("imageModifique").src = book["_image"] || "default-book-image.jpg";
    document.getElementById("modifiqueBookModal").style.display = "block";
}

function deleteBook(id) {
    return new Promise(async (resolve) => {
        var url = "http://localhost:8085/api/v1/book/"+id;
        let headersList = {
            "Accept": "*/*",
            "User-Agent": "web",
            "Content-Type": "application/json"
        };
        let response = await fetch(url, {
            method: "DELETE",
            headers: headersList
        });
        if (!response.ok) {
            console.error("Error al obtener los autores:", response.status);
            return;
        }
        console.log("Autor eliminado correctamente");
        getBook();
        document.getElementById("modifiqueBookModal").style.display = "none";
    });
}

function updateBook(id) {
    return new Promise(async (resolve) => {
        let headersList = {
            "Accept": "*/*",
            "User-Agent": "web",
            "Content-Type": "application/json"
        }

        let bodyContent = JSON.stringify({
            "id_book": 0,
            "name_book": document.getElementById("bookNameModifique").value,
            "id_author_book": document.getElementById("selectAuthorModifique").value,
            "id_country": document.getElementById("selectCountryModifique").value,
            "id_editorial": document.getElementById("selectEditorialModifique").value,
            "image": document.getElementById("bookImageModifique").value,
            "stars": document.getElementById("selectStarsModifique").value
        });

        let response = await fetch("http://localhost:8085/api/v1/book/"+id, {
            method: "PUT",
            body: bodyContent,
            headers: headersList
        });

        let data = await response.text();
        console.log(data);
        console.log('funciona');
        getBook();
        document.getElementById("modifiqueBookModal").style.display = "none";
    });
}
function openModifiqueBookModal() {
    console.log("Abrir formulario editar autor");
    document.getElementById("modifiqueBookModal").style.display = "block";
}

async function getBookGenreData() {
    var url = "http://localhost:8085/api/v1/book/";
    document.getElementById("buttonrevert").style.display="none"
    document.getElementById("cards").style.display="block"
    document.getElementById("buttonModify").style.display="block"
    document.getElementById("filterCards").style.display="block"
    const filtro = document.getElementById("filterCards").value;
    if (filtro) {
        url += "filter/" + filtro;
    }

    let headersList = {
        "Accept": "*/*",
        "User-Agent": "web",
        "Content-Type": "application/json"
    };

    let response = await fetch(url, {
        method: "GET",
        headers: headersList
    });

    if (!response.ok) {
        console.error("Error al obtener los libros:", response.status);
        return;
    }

    const data = await response.json();
    const genres = await getGenre(); // Obtén los géneros antes de iterar libros

    const contenedor = document.getElementById("contenedorFrom");
    contenedor.innerHTML = ''; // Limpia el contenedor

    data.forEach((book) => {
        const container = document.createElement("div");
        container.className = "select-container";

        const innerDiv = document.createElement("div");

        const titulo = document.createElement("h3");
        titulo.innerText = book["_name_book"] || "Sin título";
        innerDiv.appendChild(titulo);

        const inputId = document.createElement("input");
        inputId.type = "hidden";
        inputId.value = book["_id_book"];
        innerDiv.appendChild(inputId);

        const imagenDiv = document.createElement("div");
        imagenDiv.align = "center";
        const imagen = document.createElement("img");
        imagen.src = book["_image"] || "https://via.placeholder.com/300x100?text=Sin+imagen+de+libro";
        imagen.style.width = "70%";
        imagen.style.height = "300px";
        imagenDiv.appendChild(imagen);
        innerDiv.appendChild(imagenDiv);

        const generoLabel = document.createElement("h5");
        generoLabel.innerText = "Género";
        generoLabel.style.marginTop = "20px";
        innerDiv.appendChild(generoLabel);

        const selectGenero = document.createElement("select");
        selectGenero.className = "selectGenreModifique";
        selectGenero.setAttribute("id","selectGenreModifique"+book["_id_book"]);

        const opcionDefault = document.createElement("option");
        opcionDefault.value = "";
        opcionDefault.innerText = "-- Selecciona una opción --";
        selectGenero.appendChild(opcionDefault);

        // Agrega los géneros al select
        genres.forEach((genre) => {
            const option = document.createElement("option");
            option.setAttribute("id","dato"+book["_id_book"]);
            option.value = genre["_id_genre"];
            option.innerText = genre["_genre"];
            selectGenero.appendChild(option);
        });

        innerDiv.appendChild(selectGenero);

        const inputExtra = document.createElement("input");
        inputExtra.type = "hidden";
        inputExtra.value = book["_id_book"];
        innerDiv.appendChild(inputExtra);

        container.appendChild(innerDiv);

        const botonesDiv = document.createElement("div");
        botonesDiv.style.marginTop = "20px";

        const botonAgregar = document.createElement("button");
        botonAgregar.type = "button";
        botonAgregar.className = "guardar";
        botonAgregar.innerText = "Agregar";
        botonAgregar.onclick = function () {
            registerBookGenre(document.getElementById("selectGenreModifique"+book["_id_book"]).value,book["_id_book"]);
            document.getElementById("addBookModalGenre").style.display = "none";
        };
        botonesDiv.appendChild(botonAgregar);

        container.appendChild(botonesDiv);
        contenedor.appendChild(container);
    });

    console.log("Todos los formularios de libros cargados correctamente.");
}

async function getBookGenreModify() {
    var url = "http://localhost:8085/api/v1/book_genre/";

    let headersList = {
        "Accept": "*/*",
        "User-Agent": "web",
        "Content-Type": "application/json"
    };
    document.getElementById("buttonModify").style.display="none"
    document.getElementById("filterCards").style.display="none"
    document.getElementById("cards").style.display="none"
    document.getElementById("buttonrevert").style.display="block"
    let response = await fetch(url, {
        method: "GET",
        headers: headersList
    });

    if (!response.ok) {
        console.error("Error al obtener los libros:", response.status);
        return;
    }

    const data = await response.json();
    console.log(data);
    const genres = await getGenre(); // Obtén los géneros antes de iterar libros

    const contenedor = document.getElementById("contenedorFrom");
    contenedor.innerHTML = ''; // Limpia el contenedor

    data.forEach((book) => {
        const container = document.createElement("div");
        container.className = "select-container";

        const innerDiv = document.createElement("div");

        const titulo = document.createElement("h3");
        titulo.innerText = book._id_book._name_book || "Sin título";
        innerDiv.appendChild(titulo);

        const inputId = document.createElement("input");
        inputId.type = "hidden";
        inputId.value = book._id_book._id_book;
        innerDiv.appendChild(inputId);

        const imagenDiv = document.createElement("div");
        imagenDiv.align = "center";
        const imagen = document.createElement("img");
        imagen.src = book._id_book._image || "https://via.placeholder.com/300x100?text=Sin+imagen+de+libro";
        imagen.style.width = "70%";
        imagen.style.height = "300px";
        imagenDiv.appendChild(imagen);
        innerDiv.appendChild(imagenDiv);

        const generoLabel = document.createElement("h5");
        generoLabel.innerText = "Género";
        generoLabel.style.marginTop = "20px";
        innerDiv.appendChild(generoLabel);

        const selectGenero = document.createElement("select");
        selectGenero.className = "selectGenreModifique";
        selectGenero.setAttribute("id","selectGenreModifique"+book._id_book._id_book);

        const opcionDefault = document.createElement("option");
        opcionDefault.value = "";
        opcionDefault.innerText = "-- Selecciona una opción --";
        
        selectGenero.appendChild(opcionDefault);

        // Agrega los géneros al select
        genres.forEach((genre) => {
            const option = document.createElement("option");
            option.setAttribute("id", "dato" + book._id_book._id_book);
            option.value = genre["_id_genre"];
            option.innerText = genre["_genre"];
            selectGenero.appendChild(option);
        });
        
        // Selecciona el valor actual del género
        selectGenero.value = String(book._id_genre._id_genre);
        

        innerDiv.appendChild(selectGenero);

        const inputExtra = document.createElement("input");
        inputExtra.type = "hidden";
        inputExtra.value = book["_id_book"];
        innerDiv.appendChild(inputExtra);

        container.appendChild(innerDiv);

        const botonesDiv = document.createElement("div");
        botonesDiv.style.marginTop = "20px";
        botonesDiv.className="row";;

        const botonAgregar = document.createElement("button");
        botonAgregar.type = "button";
        botonAgregar.className = "guardar";
        botonAgregar.innerText = "Actualizar";
        botonAgregar.style.margin="5px";
        botonAgregar.onclick = function () {
            const select = document.getElementById("selectGenreModifique" + book._id_book._id_book);
            const selectedGenreId = select.value;
            updateBookGenre(book._id_book_genre, selectedGenreId, book._id_book._id_book);
            console.log(selectedGenreId, book._id_book._id_book);
            document.getElementById("addBookModalGenre").style.display = "none";
        };
        const botonEliminar = document.createElement("button");
        botonEliminar.type = "button";
        botonEliminar.className = "guardar";
        botonEliminar.innerText = "Eliminar";
        botonEliminar.style.margin="5px";
        botonEliminar.onclick = function () {
            deleteBookGenre(book["_id_book_genre"]);
            document.getElementById("addBookModalGenre").style.display = "none";
        };
        botonesDiv.appendChild(botonAgregar);
        botonesDiv.appendChild(botonEliminar);
        container.appendChild(botonesDiv);
        contenedor.appendChild(container);
    });

    console.log("Todos los formularios de libros cargados correctamente.");
}

document.getElementById("cards").addEventListener("click", function() {
    console.log("Click detectado, ejecutando filtro...");
    getGenre();
    getBookGenreData();

});
document.getElementById("filterCards").addEventListener("keypress", function(e) {
    if (e.key === "Enter") {
        e.preventDefault(); // Previene comportamiento por defecto
        getBookGenreData();
    }
});
function deleteBookGenre(id) {
    return new Promise(async (resolve) => {
        var url = "http://localhost:8085/api/v1/book_genre/"+id;
        let headersList = {
            "Accept": "*/*",
            "User-Agent": "web",
            "Content-Type": "application/json"
        };
        let response = await fetch(url, {
            method: "DELETE",
            headers: headersList
        });
        if (!response.ok) {
            console.error("Error al obtener los autores:", response.status);
            return;
        }
        console.log("Autor eliminado correctamente");
        getBook();
        document.getElementById("addBookModalGenre").style.display = "none";
    });
}
function updateBookGenre(id,genre,book) {
    return new Promise(async (resolve) => {
        let headersList = {
            "Accept": "*/*",
            "User-Agent": "web",
            "Content-Type": "application/json"
        }

        let bodyContent = JSON.stringify({
            "id_book_genre": 0,
            "id_genre": genre,
            "id_book": book
        });
        let response = await fetch("http://localhost:8085/api/v1/book_genre/"+id, {
            method: "PUT",
            body: bodyContent,
            headers: headersList
        });

        let data = await response.text();
        console.log(data);
        console.log('funciona');
        getBook();
        document.getElementById("addBookModalGenre").style.display = "none";
    });
}