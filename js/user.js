document.getElementById("sign-register").addEventListener("click", async function() {
    await registerUser();
});

async function registerUser() {
    let Username = document.getElementById("userName").value;
    let email = document.getElementById("userEmail").value;
    let password = document.getElementById("userPassword").value;
    let number = document.getElementById("userNumber").value;

    // Resetear estilos
    document.getElementById("userName").style.borderColor = "";
    document.getElementById("userEmail").style.borderColor = "";
    document.getElementById("userPassword").style.borderColor = "";
    document.getElementById("userNumber").style.borderColor = "";

    // Validaciones
    if (!Username || !email || !password || !number) {
        alert("Por favor, complete todos los campos obligatorios.");
        if (!Username) document.getElementById("userName").style.borderColor = "red";
        if (!email) document.getElementById("userEmail").style.borderColor = "red";
        if (!password) document.getElementById("userPassword").style.borderColor = "red";
        if (!number) document.getElementById("userNumber").style.borderColor = "red";
        return;
    }

    if (!/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)) {
        alert("Por favor ingrese un email válido");
        document.getElementById("userEmail").style.borderColor = "red";
        return;
    }

    if (!/(?=.*[!@#$%^&*])(?=.*[0-9])(?=.*[A-Za-z]).{6,}/.test(password)) {
        alert("Tu contraseña debe tener al menos 6 caracteres, un número y un carácter especial");
        document.getElementById("userPassword").style.borderColor = "red";
        return;
    }

    // Captcha
    const captchaToken = grecaptcha.getResponse();

    if (!captchaToken) {
        alert("Por favor, completa el reCAPTCHA.");
        return;
    }

    try {
        let headersList = {
            "Accept": "*/*",
            "User-Agent": "web",
            "Content-Type": "application/json"
        };

        let bodyContent = JSON.stringify({
            "name": Username,
            "email": email,
            "number": number,
            "password": password
        });

        let response = await fetch("http://localhost:8085/api/v1/user/?g-recaptcha-response=" + captchaToken, {
            method: "POST",
            body: bodyContent,
            headers: headersList
        });

        if (!response.ok) {
            if (response.status === 401) {
                alert("Validación reCAPTCHA fallida. Intenta de nuevo.");
                grecaptcha.reset();
                return;
            }
            throw new Error(`Error HTTP: ${response.status}`);
        }

        let data = await response.text();
        console.log("Usuario registrado:", data);

        // Esperar a que termine antes de continuar
        await registerUserRole(email);

        containerFormRegister.classList.add("hide");
        containerFormLogin.classList.remove("hide");

    } catch (error) {
        console.error("Error al registrar:", error);
        alert("Ocurrió un error al registrar. Por favor, intente nuevamente.");
    }
}

async function registerUserRole(email) {
    try {
        // Buscar al usuario por nombre
        let response = await fetch(`http://localhost:8085/api/v1/user/filter/${email}`, {
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
        console.log(data.id_user); // ¿Está obteniendo el id correctamente?
        console.log(document.getElementById("userRoles").value); 
        // Armar body para la asignación de rol
        let bodyContent = JSON.stringify({
            "user": parseInt(data.id_user),
            "id_rol": parseInt(document.getElementById("userRoles").value)
        });

        // Definir headers para el POST
        let headersList = {
            "Accept": "*/*",
            "User-Agent": "web",
            "Content-Type": "application/json"
        };

        // Hacer POST para asignar el rol
        let dato = await fetch("http://localhost:8085/api/v1/user_rol", {
            method: "POST",
            body: bodyContent,
            headers: headersList
        });

        if (!dato.ok) {
            throw new Error(`Error al asignar el rol: ${dato.status}`);
        }

        console.log("Rol asignado exitosamente.");

    } catch (error) {
        console.error("Error en el proceso de asignación de rol:", error);
    }
}

async function RegisterLogin(email, password) {
    try {
        let response = await fetch(`http://localhost:8085/api/v1/user/filter/${email}/${password}`, {
            method: "GET",
            headers: {
                "Accept": "*/*"
            }
        });

        if (!response.ok) {
            throw new Error("Error en login");
        }

        let data = await response.json();
        console.log(data);

        if (data.length === 0) {
            alert("Credenciales incorrectas.");
        } else {
            alert("¡Inicio de sesión exitoso!");
            window.location.href = "index.html";
        }
        data.forEach(user => {
            localStorage.setItem("userId", user["id_user"]); 
            localStorage.setItem("userName", user['_name']);  
        });

    } catch (error) {
        console.error("Error en login:", error);
        alert("No se pudo iniciar sesión. Intenta nuevamente.");
    }
}

document.getElementById("sign-login").addEventListener("click", async function () {
    let email = document.getElementById("userEmailLogin").value;
    let password = document.getElementById("userPasswordLogin").value;
    await RegisterLogin(email, password);
    window.location.href = "index.html";
});
async function getRoles() {
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
        console.error("Error al obtener los roles:", response.status);
        return;
      }
  
      const rol = await response.json();
      console.log(rol);
      
      const select = document.getElementById("userRoles");
  
      rol.forEach(roles => {
        const option = document.createElement("option");
        option.value = roles["_id_roles"];
        option.textContent = roles['_name_rol'];
        select.appendChild(option);
      });
  
    } catch (error) {
      console.error("Error al obtener el país:", error);
    }
  }
document.addEventListener("DOMContentLoaded", () => {
    getRoles();
});