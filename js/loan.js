function Codigo(numero) {
    const caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    const num = caracteres.length;
    let result = "";
    for (let i = 0; i < numero; i++) {
        result += caracteres.charAt(Math.floor(Math.random() * num));
    }
    return result;  
}
codigo=Codigo(6);
document.getElementById("codigo-text").innerText=codigo;
async function registerLoan() {
    try {
        let headersList = {
            "Accept": "*/*",
            "User-Agent": "web",
            "Content-Type": "application/json"
        };

        let bodyContent = JSON.stringify({
            "id_user": localStorage.getItem("userId"),
            "code":codigo,
            "state":"Pendiente" 
            
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

        const data = await response.text();
        console.log(data);
        console.log('Funciona');

    } catch (error) {
        console.error("Error inesperado:", error);
    }
}
async function registerLoan_detail() {
    try {
        let headersList = {
            "Accept": "*/*",
            "User-Agent": "web",
            "Content-Type": "application/json"
        };

        let bodyContent = JSON.stringify({
            "id_user": localStorage.getItem("userId"),
            "id_bill": 0,
            "state":"Pendiente",
            "id_book": document.getElementById("bookSelect").value,
            
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

        const data = await response.text();
        console.log(data);
        console.log('Funciona');

    } catch (error) {
        console.error("Error inesperado:", error);
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
const clientNameInput = document.getElementById('clientName');
const loanDateInput = document.getElementById('loanDate');

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
    if (!clientNameInput.value || !loanDateInput.value || selectedBooks.length === 0) {
        alert('Por favor, complete todos los campos.');
        return;
    }

    const loanDetails = selectedBooks.map(book => ({
        id_book: book.id,
        state: 'active',
        return_date: loanDateInput.value
    }));

    const loanData = {
        clientName: clientNameInput.value,
        state: loanDateInput.value,
        loanDetails: loanDetails
    };

    try {
        const response = await fetch('http://localhost:8085/api/v1/loan_detail/', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(loanData)
        });

        const result = await response.json();
        if (response.ok) {
            alert('Préstamo creado exitosamente.');
        } else {
            alert('Error al crear el préstamo: ' + result.message);
        }
    } catch (error) {
        console.error('Error al crear el préstamo:', error);
        alert('Hubo un problema al realizar la solicitud.');
    }
});