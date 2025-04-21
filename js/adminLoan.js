async function adminLoan() {
    const url = `http://localhost:8085/api/v1/loan_detail/`;
  
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
        console.error("Error al obtener el detalle de la reserva:", response.status);
        return;
      }
  
      const loan = await response.json();
      console.log(loan);

      const tbody = document.querySelector("#reservadosList tbody");
      tbody.innerHTML = ""; // Limpiar antes de insertar
  
      loan.forEach(loan_detail => {
        const tr = document.createElement("tr");

        tr.innerHTML = `
            <td>${loan_detail._id_bill._name_customer}</td>
            <td>${loan_detail._state}</td>
            <td>${loan_detail._id_bill._code}</td>
            <td>${loan_detail._return_date}</td>
            <td>${loan_detail._id_bill._id_user._name}</td>
            <td>${loan_detail._id_book._name_book}</td>
            <td>
            <button class="btn btn-sm btn-warning me-1" onclick="tomarDatos('${loan_detail._id_loan_detail}','${loan_detail._id_bill._id_bill}','${loan_detail._id_bill._code}','${loan_detail._id_bill._id_user.id_user}','${loan_detail._id_bill._name_customer}','${loan_detail._state}','${loan_detail._id_book._id_book}')">Modificar</button>
            <button class="btn btn-sm btn-danger" onclick="deleteLoan('${loan_detail._id_loan_detail}','${loan_detail._id_bill._id_bill}','${loan_detail._id_bill._code}','${loan_detail._id_bill._id_user.id_user}','${loan_detail._id_bill._name_customer}')">Eliminar</button>
            </td>

        `;

        tbody.appendChild(tr);
      });
    } catch (error) {
      console.error("Error al obtener los detalles de la reserva:", error);
    }
}
document.addEventListener("DOMContentLoaded", () => {
    adminLoan();
});
function deleteLoan(idloan,idbill,code,idEncargado,nameUser) {
    return new Promise(async (resolve) => {
        var url = "http://localhost:8085/api/v1/loan_detail/"+idloan;
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
            console.error("Error Eliminar la reserva:", response.status);
            return;
        }
        alert("Reserva eliminada correctamente");
        reviewLoan(idloan,idbill,code,idEncargado,nameUser);
        adminLoan();
        resolve();
    });
}
async function reviewLoan(id,bill,code,iduser,_name_customer) {
    const url = `http://localhost:8085/api/v1/loan_detail/filter/${bill}`;
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
            console.error("Error al obtener el detalle de la reserva:", response.status);
            return;
        }

        const loan = await response.json();
        console.log(loan);
        if (loan.length === 0) {
            updateBill(bill,code,iduser,_name_customer);
          } else {
            return;
          }

    } catch (error) {
        console.error("Error al obtener los detalles de la reserva:", error);
    }
}
async function updateBill(id,code,iduser,_name_customer) {
    const url = `http://localhost:8085/api/v1/bill_loan/${id}`;
    let headersList = {
        "Accept": "*/*",
        "User-Agent": "web",
        "Content-Type": "application/json"
    };

    let bodyContent = JSON.stringify({
        "code": code,
        "id_user": iduser,
        "state":"Entregado",
        "name_customer": _name_customer
    });
    try {
        const response = await fetch(url, {
            method: "PUT",
            body: bodyContent,
            headers: headersList
        });

        if (!response.ok) {
            console.error("Error al actualizar la reserva:", response.status);
            return;
        }

        const data = await response.text();
        console.log(data);
        alert("Todos los datos de la reserva estan entregados");
        adminLoan();
    } catch (error) {
        console.error("Error inesperado:", error);
    }

}
function tomarDatos(idloan,idbill,code,idEncargado,nameUser,selectState,idbook) {
    document.getElementById("updateReservados").style.display = "block";
    document.getElementById("idLoanCustomer").value = idloan;
    document.getElementById("idBillCustomer").value = idbill;
    document.getElementById("codeCustomer").value = code
    document.getElementById("idEncargadoCustomer").value = idEncargado;
    document.getElementById("nameUserCustomer").value = nameUser;
    document.getElementById("selectState").value = selectState;
    document.getElementById("bookCustomer").value = idbook;
    window.location.href = "#";
}
async function updateReservados() {
    const idLoanCustomer = document.getElementById("idLoanCustomer").value;
    const idBillCustomer = document.getElementById("idBillCustomer").value;
    const codeCustomer = document.getElementById("codeCustomer").value;
    const idEncargadoCustomer = document.getElementById("idEncargadoCustomer").value;
    const nameUserCustomer = document.getElementById("nameUserCustomer").value;
    const selectState = document.getElementById("selectState").value;
    const bookCustomer = document.getElementById("bookCustomer").value;

    let headersList = {
        "Accept": "*/*",
        "User-Agent": "web",
        "Content-Type": "application/json"
    }

    let bodyContent = JSON.stringify({
        "id_bill": idBillCustomer,
        "state": selectState,
        "id_book": bookCustomer
    });
    try {
        const response = await fetch("http://localhost:8085/api/v1/loan_detail/"+idLoanCustomer, {
            method: "PUT",
            body: bodyContent,
            headers: headersList
        });

        if (!response.ok) {
            console.error("Error al actualizar la reserva:", response.status);
            return;
        }

        const data = await response.text();
        console.log(data);
        alert("Exitosamente actualizado loan_detail");
        reviewLoan(idLoanCustomer,idBillCustomer,codeCustomer,idEncargadoCustomer,nameUserCustomer);
        adminLoan();
    } catch (error) {
        console.error("Error inesperado:", error);
    }
}
document.getElementById("modifyReservados").addEventListener("click", async function() {
    await updateReservados();
    document.getElementById("updateReservados").style.display = "none";
});