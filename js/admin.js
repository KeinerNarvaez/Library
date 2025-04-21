async function getRolUser() {
    const url = `http://localhost:8085/api/v1/user_rol/`;

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

        const usuarios = await response.json();
        console.log(usuarios);

        const tbody = document.querySelector("#userList tbody");
        tbody.innerHTML = ""; // Limpiar antes de insertar

        usuarios.forEach(user => {
            const tr = document.createElement("tr");

            tr.innerHTML = `
                <td>${user.user._name}</td>
                <td>${user.user._number}</td>
                <td>${user._id_rol._name_rol}</td>
                <td>${user.user.email}</td>
                <td>
                    <button class="btn btn-sm btn-danger" onclick="eliminarUsuarioYRol(${user._id_user_rol}, ${user.user.id_user})">Eliminar</button>
                </td>
            `;

            tbody.appendChild(tr);
        });

    } catch (error) {
        console.error("Error al obtener el rol del usuario:", error);
    }
}

document.addEventListener("DOMContentLoaded", () => {
    getRolUser();
    document.getElementById("per").innerText = localStorage.getItem("userName");
    document.getElementById("peo").innerText = localStorage.getItem("userName");
    showUser();
    getCountry();
    getEditorial();
    document.getElementById("home").style.display = "block";
});
function deleteUserRol(id) {
    return new Promise(async (resolve) => {
        var url = "http://localhost:8085/api/v1/user_rol/"+id;
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
        console.log("Rol eliminado correctamente");
        resolve();
    });
}
function deleteUser(id) {
    return new Promise(async (resolve) => {
        var url = "http://localhost:8085/api/v1/user/"+id;
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
        console.log("Usuario eliminado correctamente");
        getRolUser();
        resolve();
    });
}
async function eliminarUsuarioYRol(idRol, idUser) {
    await deleteUserRol(idRol);
    await deleteUser(idUser);
}
let inicio = document.getElementById("inicio");
let editorial = document.getElementById("editorial");
let libros = document.getElementById("libros");
let usuarios = document.getElementById("usuarios");
function activo(activo) {
   inicio.classList.remove("active");
   editorial.classList.remove("active");
   libros.classList.remove("active");
   usuarios.classList.remove("active");
   activo.className="nav-link active";
   console.log("se desactivo");
}
function showUser() {
    document.getElementById("home").style.display = "none";
    document.getElementById("user").style.display = "none";
    document.getElementById("reservados").style.display = "none";
    document.getElementById("edi").style.display = "none";

}
inicio.addEventListener("click",function () {
    activo(inicio);
    showUser();
    document.getElementById("home").style.display = "block";
});
editorial.addEventListener("click",function () {
    activo(editorial);
    showUser();
    document.getElementById("edi").style.display = "block";
});
libros.addEventListener("click",function () {
    activo(libros);
    showUser();
    document.getElementById("reservados").style.display = "block";
});
usuarios.addEventListener("click",function () {
    activo(usuarios);
    showUser();
    document.getElementById("user").style.display = "block";

});
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

  
      countries.forEach(country => {
        const option = document.createElement("option");
        option.value = country["_id_country"];
        option.textContent = country['_country'];
        select.appendChild(option);
      });
  
    } catch (error) {
      console.error("Error al obtener el país:", error);
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
        console.error("Error al obtener el editorial:", response.status);
        return;
      }
  
      const edi = await response.json();
      console.log(edi);

      const tbody = document.querySelector("#editorialList tbody");
      tbody.innerHTML = ""; // Limpiar antes de insertar
  
      edi.forEach(editorial => {
        const tr = document.createElement("tr");

        tr.innerHTML = `
            <td>${editorial._editorial}</td>
            <td>${editorial._description}</td>
            <td>${editorial._id_country._country}</td>
            <td>
              <button class="btn btn-sm btn-warning me-1"  onclick="getEditorialModify(${editorial._id_editorial})">Modificar</button>
              <button class="btn btn-sm btn-danger" onclick="deleteEdi(${editorial._id_editorial})">Eliminar</button>
            </td>
        `;

        tbody.appendChild(tr);
      });
    } catch (error) {
      console.error("Error al obtener el país:", error);
    }
}
async function getEditorialModify(id) {
    const url = `http://localhost:8085/api/v1/editorial/${id}`;
   window.location.href = "#";
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
        console.error("Error al obtener el editorial modificable:", response.status);
        return;
      }
  
      const editar = await response.json();
      console.log(editar);
  
      document.getElementById("editorialCustomer").value = editar._editorial;
      document.getElementById("descriptionCustomer").value = editar._description;
      document.getElementById("selectCountry").value = editar._id_country._id_country;
      document.getElementById("idEditorial").value = editar._id_editorial;
      document.getElementById("modifyEditorial").style.display = "block";
    } catch (error) {
      console.error("Error al obtener el editorial modificable:", error);
    }
}
async function deleteEdi(id) {
    return new Promise(async (resolve) => {
        var url = "http://localhost:8085/api/v1/editorial/"+id;
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
            console.error("Error al eliminar el editorial:", response.status);
            return;
        }
        alert("Editorial eliminado correctamente");
        getEditorial();
        resolve();
    });
}
async function addEditorial() {
    const editorialName = document.getElementById("editorialCustomer").value;
    const editorialDescription = document.getElementById("descriptionCustomer").value;
    const editorialCountry = document.getElementById("selectCountry").value;


    let headersList = {
        "Accept": "*/*",
        "User-Agent": "web",
        "Content-Type": "application/json"
    }

    let bodyContent = JSON.stringify({
        "description": editorialDescription,
        "id_country": editorialCountry,
        "editorial": editorialName
    });
    try {
        const response = await fetch("http://localhost:8085/api/v1/editorial/", {
            method: "POST",
            body: bodyContent,
            headers: headersList
        });

        if (!response.ok) {
            console.error("Error al registrar el editorial:", response.status);
            return;
        }

        const data = await response.text();
        console.log(data);
        alert("Editorial creado correctamente");
        getEditorial();
        document.getElementById("modifyEditorial").style.display = "none";
        editorialName.value = "";
        editorialDescription.value = "";
        editorialCountry.value = "";
    } catch (error) {
        console.error("Error inesperado:", error);
    }
}
document.getElementById("addEditorial").addEventListener("click", async function() {
    await addEditorial();
});
function updateAuthor() {
    const editorialName = document.getElementById("editorialCustomer").value;
    const editorialDescription = document.getElementById("descriptionCustomer").value;
    const editorialCountry = document.getElementById("selectCountry").value;
    const idEditorial = document.getElementById("idEditorial").value;
    return new Promise(async (resolve) => {
        let headersList = {
            "Accept": "*/*",
            "User-Agent": "web",
            "Content-Type": "application/json"
        }

        let bodyContent = JSON.stringify({
            "description": editorialDescription,
            "id_country": editorialCountry,
            "editorial": editorialName,
        });

        let response = await fetch("http://localhost:8085/api/v1/editorial/"+idEditorial, {
            method: "PUT",
            body: bodyContent,
            headers: headersList
        });

        let data = await response.text();
        console.log(data);
        console.log('funciona');
        getEditorial();
        document.getElementById("modifyEditorial").style.display = "none";
        editorialName.value = "";
        editorialDescription.value = "";
        editorialCountry.value = "";
        alert("Editorial actualizado correctamente");
    });
}
document.getElementById("modifyEditorial").addEventListener("click", async function() {
    await updateAuthor();
});
function cerrarSesion() {
    localStorage.removeItem("userId");
    localStorage.removeItem("userName");
    window.location.href = "login.html";
}
document.getElementById("cerrarSesion").addEventListener("click", async function() {
    await cerrarSesion();
});