if (localStorage.getItem("userId")) {
    document.getElementById("iniciar").style.display = "none";
    document.getElementById("navbarSupportedContent").appendChild(document.createElement("div")).innerHTML = '<div class="search_icon" id="admin" ><a href="admin.html"><img src="images/user-icon.png"><span class="padding_left_15">Administración</span></a></div>';
    document.getElementById("footer").appendChild(document.createElement("li")).innerHTML = "<a href='admin.html'>Administración</a>";
 }