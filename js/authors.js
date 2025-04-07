function registerAuthor() {
    return new Promise(async (resolve) => {
        let headersList = {
            "Accept": "*/*",
            "User-Agent": "web",
            "Content-Type": "application/json"
        }

        let bodyContent = JSON.stringify({
            "id_author": 0,
            "author_name": document.getElementById("AuthorName").value,
            "biography": document.getElementById("AuthorBiography").value,
            "image": document.getElementById("AuthorImage").value,
            "stars": document.getElementById("AuthorStars").value,
            "number_of_titles": document.getElementById("AuthorTitle").value
        });

        let response = await fetch("http://localhost:8085/api/v1/author/", {
            method: "POST",
            body: bodyContent,
            headers: headersList
        });

        let data = await response.text();
        console.log(data);
        console.log('funciona');
        getAuthor();
        document.getElementById("addBookModal").style.display = "none";
    });
}
window.onload = function () {
    getAuthor();
};
function getAuthor() {
    return new Promise(async (resolve) => {
        var url = "http://localhost:8085/api/v1/author/";
        var filtro = document.getElementById("nameFilter").value || "";
        if (filtro !== "") {
            url += "filter/" + filtro;
        }
        console.log(filtro);
        
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
            console.error("Error al obtener los autores:", response.status);
            return;
        }

        let data = await response.json();
        var container = document.getElementById("pao");
        container.innerHTML = '';


        data.forEach(author => {
            var row = document.createElement("div");
            row.className = "row";
            var ids=author["_id_author"];

            // Imagen del autor
            var colImage = document.createElement("div");
            colImage.className = "col-sm-6 col-lg-4";

            var imageDiv = document.createElement("div");
            imageDiv.className = "image_1";

            var image = document.createElement("img");
            image.className = "image";
            image.src = author["_image"] || "default-author-image.jpg";
            image.style.width = "100%";
            image.style.height = "500px";

            imageDiv.appendChild(image);
            colImage.appendChild(imageDiv);
            row.appendChild(colImage);

            // Información del autor
            var colInfo = document.createElement("div");
            colInfo.className = "col-sm-8 col-lg-4";

            var name = document.createElement("h1");
            name.className = "arrival_text";
            name.innerText = author["_author_name"] || "Nombre no disponible";

            var movieMain = document.createElement("div");
            movieMain.className = "movie_main";

            var titlesCount = document.createElement("div");
            titlesCount.className = "mins_text_1";
            titlesCount.innerText = `${author["_number_of_titles"] || 0} títulos`;

            movieMain.appendChild(titlesCount);

            var biography = document.createElement("p");
            biography.className = "long_text";
            biography.innerText = author["_biography"] || "Biografía no disponible.";

            var ratingMain = document.createElement("div");
            ratingMain.className = "rating_main";

            var ratingRow = document.createElement("div");
            ratingRow.className = "row";

            var ratingCol = document.createElement("div");
            ratingCol.className = "col-sm-6 col-lg-6";

            var iconDiv = document.createElement("div");
            iconDiv.className = "icon_2";

            var iconImg = document.createElement("img");
            iconImg.src = "images/icon-2.png";

            var ratingText = document.createElement("span");
            ratingText.className = "padding_10";
            ratingText.innerText = `${author["_stars"] || "0"} Calificación`;

            iconDiv.appendChild(iconImg);
            iconDiv.appendChild(ratingText);
            ratingCol.appendChild(iconDiv);
            ratingRow.appendChild(ratingCol);
            ratingMain.appendChild(ratingRow);

            var categoryButton = document.createElement("div");
            categoryButton.className = "paly_bt";
            categoryButton.setAttribute("id",ids+" modifique");
            categoryButton.onclick = function () {
                getModifiqueTarget(ids);
                openModifiqueBookModal();
            };
            

            var categoryLink = document.createElement("a");
            categoryLink.href = "#";
            categoryLink.innerText = "Modificar";
            categoryLink.addEventListener("click", (e) => {
                e.preventDefault();
                getModifiqueTarget(ids);
            });
            


            

            categoryButton.appendChild(categoryLink);

            colInfo.appendChild(name);
            colInfo.appendChild(movieMain);
            colInfo.appendChild(biography);
            colInfo.appendChild(ratingMain);
            colInfo.appendChild(categoryButton);

            row.appendChild(colInfo);
            container.appendChild(row);
        });

        console.log("Autores cargados correctamente");
    });
}
function getModifiqueTarget(id) {
    return new Promise(async (resolve) => {
        var url = "http://localhost:8085/api/v1/author/" + id;
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
            console.error("Error al obtener los autores:", response.status);
            return;
        }

        let author = await response.json();
        console.log(author);
        document.getElementById("AuthorIdModifique").value = author["_id_author"];
        document.getElementById("AuthorNameModifique").value = author["_author_name"];
        document.getElementById("AuthorBiographyModifique").value = author["_biography"];
        document.getElementById("AuthorImageModifique").value = author["_image"];
        document.getElementById("AuthorTitleModifique").value = author["_number_of_titles"];
        document.getElementById("AuthorStarsModifique").value = author["_stars"];
        document.getElementById("imageModifique").src = author["_image"];
        document.getElementById("modifiqueBookModal").style.display = "block";
        });
}

function deleteAuthor(id) {
    return new Promise(async (resolve) => {
        var url = "http://localhost:8085/api/v1/author/"+id;
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
        getAuthor();
        document.getElementById("modifiqueBookModal").style.display = "none";
    });
}
function updateAuthor(id) {
    return new Promise(async (resolve) => {
        let headersList = {
            "Accept": "*/*",
            "User-Agent": "web",
            "Content-Type": "application/json"
        }

        let bodyContent = JSON.stringify({
            "id_author": 0,
            "author_name": document.getElementById("AuthorNameModifique").value,
            "biography": document.getElementById("AuthorBiographyModifique").value,
            "image": document.getElementById("AuthorImageModifique").value,
            "stars": document.getElementById("AuthorStarsModifique").value,
            "number_of_titles": document.getElementById("AuthorTitleModifique").value
        });

        let response = await fetch("http://localhost:8085/api/v1/author/"+id, {
            method: "PUT",
            body: bodyContent,
            headers: headersList
        });

        let data = await response.text();
        console.log(data);
        console.log('funciona');
        getAuthor();
        document.getElementById("modifiqueBookModal").style.display = "none";
    });
}


var modifique=document.getElementById("modifique")
modifique.addEventListener("click",function () {
    var id=this.id;
    console.log(id);
    getModifiqueTarget(id);
    openModifiqueBookModal();
});
var dele=document.getElementById("dele");
dele.addEventListener("click",function () {
    document.getElementById("modifiqueBookModal").style.display = "none";
});


let searchBtn = document.getElementById("search-btn");
searchBtn.addEventListener("click", function() {
   getAuthor();
});
function openAddBookModal() {
    console.log("Abrir formulario para nuevo libro");
 
    document.getElementById("addBookModal").style.display = "block";
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
document.getElementById("botton").addEventListener("click", function() {
    registerAuthor();
    document.getElementById("addBookModal").style.display = "none";
  });