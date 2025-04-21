function Codigo(numero) {
    const caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    const num = caracteres.length;
    let result = "";
    for (let i = 0; i < numero; i++) {
        result += caracteres.charAt(Math.floor(Math.random() * num));
    }
    return result;  
}
codigo = Codigo(6);
document.getElementById("codigo-text").innerText = codigo;

async function registerLoan() {
    try {
        let headersList = {
            "Accept": "*/*",
            "User-Agent": "web",
            "Content-Type": "application/json"
        };

        let bodyContent = JSON.stringify({
            "id_user": localStorage.getItem("userId"),
            "code": codigo,
            "state": "Reservado",
            "name_customer": document.getElementById("nameCustomer").value
        });

        const response = await fetch("http://localhost:8085/api/v1/bill_loan/", {
            method: "POST",
            body: bodyContent,
            headers: headersList
        });

        if (!response.ok) {
            console.error("Error al registrar bill_loan:", response.status);
            return;
        }

        const data = await response.json();
        const idGenerado = data.object._id_bill;
        console.log("ID generado:", idGenerado);

        await registerLoan_detail(idGenerado);
        const modalElement = document.getElementById('exampleModal');
        const modalInstance = bootstrap.Modal.getInstance(modalElement);
        modalInstance.hide();
        document.body.classList.remove('modal-open');
        document.querySelector('.modal-backdrop')?.remove();
        setTimeout(() => {
            alert("Préstamo creado correctamente.");
        }, 1000);


    } catch (error) {
        alert("Error inesperado en bill_loan:", error);
        console.error("Error inesperado:", error);
    }
}

async function registerLoan_detail(idGenerado) {
    try {
        const id_user = localStorage.getItem("userId");

        for (const book of selectedBooks) {
            const body = JSON.stringify({
                id_user: id_user,
                id_bill: idGenerado,
                id_book: book.id,
                state: "Reservado"
            });

            const response = await fetch("http://localhost:8085/api/v1/loan_detail/", {
                method: "POST",
                headers: {
                    "Accept": "*/*",
                    "User-Agent": "web",
                    "Content-Type": "application/json"
                },
                body: body
            });

            if (!response.ok) {
                console.error("Error al registrar loan_detail:", response.status);
            } else {
                const data = await response.text();
                console.log("Loan detail creado:", data);
            }
        }

    } catch (error) {
        console.error("Error al registrar loan_detail:", error);
    }
}

async function getBook() {
    const url = `http://localhost:8085/api/v1/book/`;
  
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
        console.error("Error al obtener el libros:", response.status);
        return;
      }
  
      const boo = await response.json();
      console.log(boo);
      
      const select = document.getElementById("bookSelect");
  
      boo.forEach(book => {
        const option = document.createElement("option");
        option.value = book["_id_book"];
        option.textContent = book['_name_book'];
        select.appendChild(option);
      });
  
    } catch (error) {
      console.error("Error al obtener el país:", error);
    }
}

document.addEventListener("DOMContentLoaded", () => {
    getBook();

});

const addBookBtn = document.getElementById('addBookBtn');
const createLoanBtn = document.getElementById('createLoanBtn');
const bookSelect = document.getElementById('bookSelect');
const booksList = document.getElementById('books-list');
const nameCustomer = document.getElementById('nameCustomer');
let selectedBooks = [];

addBookBtn.addEventListener('click', () => {
    const bookId = bookSelect.value;
    const bookName = bookSelect.options[bookSelect.selectedIndex].text;

    if (selectedBooks.some(book => book.id === bookId)) {
        alert('Este libro ya ha sido agregado.');
        return;
    }

    selectedBooks.push({ id: bookId, name: bookName });
    updateBooksList();
});

function updateBooksList() {
    booksList.innerHTML = '';

    selectedBooks.forEach(book => {
        const li = document.createElement('li');
        li.classList.add('book-item');
        li.innerHTML = `${book.name} <button style="width: 100px;" onclick="removeBook('${book.id}')">Eliminar</button>`;
        booksList.appendChild(li);
    });
}

function removeBook(bookId) {
    selectedBooks = selectedBooks.filter(book => book.id !== bookId);
    updateBooksList();
}

createLoanBtn.addEventListener('click', async () => {
    if (selectedBooks.length === 0|| nameCustomer.value === "") {
        alert('Por favor, complete todos los campos.');
        return;
    }
    registerLoan();

});