document.addEventListener('DOMContentLoaded', function () {
let poesia=document.getElementById("poesia");
let narrativa=document.getElementById("narrativa");
let erotico=document.getElementById("erotico");
let comics=document.getElementById("comics");
let manga=document.getElementById("manga");
let mitologia=document.getElementById("mitologia");
let romantico=document.getElementById("romantico");
let cargar=document.getElementById("cargar-tarjetas");
function activo(activo) {
    activacion.classList.remove("active");
    /*poesia.classList.remove("active");
    narrativa.classList.remove("active");
    erotico.classList.remove("active");
    comics.classList.remove("active");
    manga.classList.remove("active");
    mitologia.classList.remove("active");
    romantico.classList.remove("active");
*/
    activo.classList.add("active");
}
poesia.addEventListener("click",function () {

    activo(poesia);
    cargar.innerHTML=`<div class="movies_section_2 layout_padding">
<h2 class="letest_text">poesia.</h2>
<div class="seemore_bt"><a href="#">See More</a></div>
<div class="movies_main">
   <div class="iamge_movies_main">
      <div class="iamge_movies">
         <div class="image_3">
            <img src="images/img-13.png" class="image" style="width:100%">
            <div class="middle">
               <div class="playnow_bt">Play Now</div>
            </div>
         </div>
         <h1 class="code_text">CADE Prlor</h1>
         <p class="there_text">There are many variations </p>
         <div class="star_icon">
            <ul>
               <li><a href="#"><img src="images/star-icon.png"></a></li>
               <li><a href="#"><img src="images/star-icon.png"></a></li>
               <li><a href="#"><img src="images/star-icon.png"></a></li>
               <li><a href="#"><img src="images/star-icon.png"></a></li>
               <li><a href="#"><img src="images/star-icon.png"></a></li>
            </ul>
         </div>
      </div>
      <div class="iamge_movies">
         <div class="image_3">
            <img src="images/img-14.png" class="image" style="width:100%">
            <div class="middle">
               <div class="playnow_bt">Play Now</div>
            </div>
         </div>
         <h1 class="code_text">Bradon</h1>
         <p class="there_text">There are many variations </p>
         <div class="star_icon">
            <ul>
               <li><a href="#"><img src="images/star-icon.png"></a></li>
               <li><a href="#"><img src="images/star-icon.png"></a></li>
               <li><a href="#"><img src="images/star-icon.png"></a></li>
               <li><a href="#"><img src="images/star-icon.png"></a></li>
               <li><a href="#"><img src="images/star-icon.png"></a></li>
            </ul>
         </div>
      </div>
      <div class="iamge_movies">
         <div class="image_3">
            <img src="images/img-15.png" class="image" style="width:100%">
            <div class="middle">
               <div class="playnow_bt">Play Now</div>
            </div>
         </div>
         <h1 class="code_text">Anton Levin</h1>
         <p class="there_text">There are many variations </p>
         <div class="star_icon">
            <ul>
               <li><a href="#"><img src="images/star-icon.png"></a></li>
               <li><a href="#"><img src="images/star-icon.png"></a></li>
               <li><a href="#"><img src="images/star-icon.png"></a></li>
               <li><a href="#"><img src="images/star-icon.png"></a></li>
               <li><a href="#"><img src="images/star-icon.png"></a></li>
            </ul>
         </div>
      </div>
      <div class="iamge_movies">
         <div class="image_3">
            <img src="images/img-16.png" class="image" style="width:100%">
            <div class="middle">
               <div class="playnow_bt">Play Now</div>
            </div>
         </div>
         <h1 class="code_text">Sacha Styles</h1>
         <p class="there_text">There are many variations </p>
         <div class="star_icon">
            <ul>
               <li><a href="#"><img src="images/star-icon.png"></a></li>
               <li><a href="#"><img src="images/star-icon.png"></a></li>
               <li><a href="#"><img src="images/star-icon.png"></a></li>
               <li><a href="#"><img src="images/star-icon.png"></a></li>
               <li><a href="#"><img src="images/star-icon.png"></a></li>
            </ul>
         </div>
      </div>
      <div class="iamge_movies">
         <div class="image_3">
            <img src="images/img-7.png" class="image" style="width:100%">
            <div class="middle">
               <div class="playnow_bt">Play Now</div>
            </div>
         </div>
         <h1 class="code_text">Katledrazdu</h1>
         <p class="there_text">There are many variations </p>
         <div class="star_icon">
            <ul>
               <li><a href="#"><img src="images/star-icon.png"></a></li>
               <li><a href="#"><img src="images/star-icon.png"></a></li>
               <li><a href="#"><img src="images/star-icon.png"></a></li>
               <li><a href="#"><img src="images/star-icon.png"></a></li>
               <li><a href="#"><img src="images/star-icon.png"></a></li>
            </ul>
         </div>
      </div>
   </div>
</div>
</div>`
});
    
});