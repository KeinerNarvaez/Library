const userRol=document.getElementById("idUserRol").value;
async function getRol() {
    const url = `http://localhost:8085/api/v1/roles/Listroles`;
  
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
        console.error("Error al obtener roles:", response.status);
        return;
      }
  
      const boo = await response.json();
      console.log(boo);
      
      const select = document.getElementById("rolesSelect");
  
      boo.forEach(roles => {
        const option = document.createElement("option");
        option.value = roles["id_roles"];
        option.textContent = roles['_name_rol'];
        select.appendChild(option);
      });

  
    } catch (error) {
      console.error("Error al obtener los roles:", error);
    }finally {
        getRolUser(); 
      }
}
const userId = localStorage.getItem("userId");
document.addEventListener("DOMContentLoaded", () => {
    getRol();
    registerUserRole();
});
async function registerUserRole() {
    try {
        // Buscar al usuario por nombre
        let response = await fetch(`http://localhost:8085/api/v1/user/${userId}`, {
            method: "GET",
            headers: {
                "Accept": "*/*",
                "User-Agent": "web",
                "Content-Type": "application/json"
            }
        });

        if (!response.ok) {
            throw new Error(`Error al buscar el usuario: ${response.status}`);
        }

        let data = await response.json();
        console.log(data);
        document.getElementById("nameCustomer").value = data["_name"];
        document.getElementById("numberCustomer").value = data["_number"];
        document.getElementById("emailCustomer").value = data["email"];
        document.getElementById("passwordCustomer").value = data["_password"];
        

    } catch (error) {
        console.error("Error en el proceso de asignación de rol:", error);
    }
}
async function getRolUser() {
    const url = `http://localhost:8085/api/v1/user_rol/filter/${userId}`;
  
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
        console.error("Error al obtener rol especifico:", response.status);
        return;
      }
  
      const rol = await response.json();
      console.log(rol);
      rol.forEach(roles => {
        document.getElementById("rolesSelect").value = roles._id_rol.id_roles;
        document.getElementById("idUserRol").value = roles._id_user_rol;
      });

  
    } catch (error) {
      console.error("Error al obtener el rol del usuario:", error);
    }
}

async function updateUser() {
  const Username = document.getElementById("nameCustomer").value;
  const number = document.getElementById("numberCustomer").value;
  const email = document.getElementById("emailCustomer").value;
  const password = document.getElementById("passwordCustomer").value;
  
  let headersList = {
      "Accept": "*/*",
      "User-Agent": "web",
      "Content-Type": "application/json"
  }

  let bodyContent = JSON.stringify({
    "name": Username,
    "number": number,
    "email": email,
    "password": password
  });

  try {
    let response = await fetch(`http://localhost:8085/api/v1/user/${userId}`, {
        method: "PUT",
        body: bodyContent,
        headers: headersList
    });

    let data = await response.text();
    console.log(data);
    localStorage.setItem("userName", Username); 
    alert("Datos de usuario actualizados correctamente");
  } catch (error) {
    console.error("Error al actualizar el usuario:", error);
  }
}
async function updateUser_rol() {
  let url = `http://localhost:8085/api/v1/user_rol/`;
  let method = "POST";

  if (document.getElementById("idUserRol").value !== "") {
      url += document.getElementById("idUserRol").value;
      method = "PUT";
  }

  const headersList = {
      "Accept": "*/*",
      "User-Agent": "web",
      "Content-Type": "application/json"
  };

  const bodyContent = JSON.stringify({ 
      "id_rol": document.getElementById("rolesSelect").value,
      "user": userId
  });

  try {
      const response = await fetch(url, {
          method: method,
          body: bodyContent,
          headers: headersList
      });

      if (!response.ok) {
          console.error("Error al actualizar o crear el rol del usuario:", response.status);
          return;
      }

      const data = await response.text();
      console.log(data);
      alert("Rol actualizado correctamente");
  } catch (error) {
      console.error("Error en la petición:", error);
  }
}
const boton = document.getElementById("createLoanBtn");
boton.addEventListener("click", async function() {
    await updateUser();
    await updateUser_rol(); 
    const modalElement = document.getElementById('exampleModal');
    const modalInstance = bootstrap.Modal.getInstance(modalElement);
    modalInstance.hide();

    document.querySelector('.modal-backdrop')?.remove();
});

