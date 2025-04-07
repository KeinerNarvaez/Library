document.getElementById("sign-register").addEventListener("click", async function() {
    await registerUser();
});

async function registerUser() {
    // Obtener valores cuando se hace clic en el botón
    let Username = document.getElementById("userName").value;
    let email = document.getElementById("userEmail").value;
    let password = document.getElementById("userPassword").value;
    let number = document.getElementById("userNumber").value;

    // Resetear estilos de error
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
    

    try {
        let headersList = {
            "Accept": "*/*",
            "User-Agent": "web",
            "Content-Type": "application/json"
        };

        let bodyContent = JSON.stringify({
            "id_user": 0,
            "name": Username,
            "email": email,
            "number": number,
            "password": password
        });

        let response = await fetch("http://localhost:8085/api/v1/user/", {
            method: "POST",
            body: bodyContent,
            headers: headersList
        });

        if (!response.ok) {
            throw new Error(`Error HTTP: ${response.status}`);
        }

        let data = await response.text();
        console.log(data);
        console.log('funciona');
        alert("Registro exitoso!");
        containerFormRegister.classList.add("hide");
        containerFormLogin.classList.remove("hide")
    } catch (error) {
        console.error("Error al registrar:", error);
        alert("Ocurrió un error al registrar. Por favor, intente nuevamente.");

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

        if (data.length ===0) {
            alert("Credenciales incorrectas.");
        } else {
            alert("¡Inicio de sesión exitoso!");
            // Aquí podrías guardar al usuario o redireccionar
        }

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
