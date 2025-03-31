function registerExplorer() {
    return new Promise(async (resolve) => {
        let headersList = {
            "Accept": "*/*",
            "User-Agent": "web",
            "Content-Type": "application/json"
        }

        let bodyContent = JSON.stringify({
            "id": 0,
            "name": document.getElementById("nombre").value,
            "nationality": document.getElementById("nacionalidad").value,
            "age": document.getElementById("edad").value,
            "reputation": document.getElementById("reputacion").value,
            "image_explorer": document.getElementById("imagen").value
        });

        let response = await fetch("http://localhost:8085/api/v1/book/", {
            method: "POST",
            body: bodyContent,
            headers: headersList
        });

        let data = await response.text();
        console.log(data);

    });
}