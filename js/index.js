document.addEventListener('DOMContentLoaded', function () {
let poesia=document.getElementById("poesia");
let narrativa=document.getElementById("narrativo");
let erotico=document.getElementById("erotico");
let comics=document.getElementById("comics");
let manga=document.getElementById("manga");
let mitologia=document.getElementById("mitologia");
let romantico=document.getElementById("romantico");
let cargar=document.getElementById("cargar-tarjetas");
function activo(activo) {
   narrativa.classList.remove("active");
   poesia.classList.remove("active");
   erotico.classList.remove("active");
   comics.classList.remove("active");
   manga.classList.remove("active");
   mitologia.classList.remove("active");
   romantico.classList.remove("active");
   activo.className="active";
   console.log("se desactivo");
}
let textNarrativa=`
<div class="movies_section_2 layout_padding" id="pao">
<h2 class="letest_text">narrativa.</h2>
<div class="seemore_bt" id="verMasNarrativa"><a href="#">ver más</a></div>
<div class="movies_main">
  <div class="iamge_movies_main">
     <div class="iamge_movies">
        <div class="image_3">
           <img src="https://planetadelibrosco0.cdnstatics.com/usuaris/libros/fotos/415/tam_1/414417_portada_el-manuscrito-carmesi_antonio-gala_202310181309.jpg" class="image" style="width:100%">
           <div class="middle">
              <div class="playnow_bt">Leer más</div>
           </div>
        </div>
        <h1 class="code_text">El manuscrito carmesír</h1>
        <p class="there_text">Antonio Gala</p>
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
           <img src="https://planetadelibrosco0.cdnstatics.com/usuaris/libros/fotos/411/tam_1/410158_portada_mi-reino-por-un-caballo-antologia-de-citas-de-william-shakespeare_william-shakespeare_202211041207.jpg" class="image" style="width:100%">
           <div class="middle">
              <div class="playnow_bt">Leer más</div>
           </div>
        </div>
        <h1 class="code_text">¡Mi reino por un caballo!</h1>
        <p class="there_text">William Shakespeare </p>
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
           <img src="https://planetadelibrosco0.cdnstatics.com/usuaris/libros/fotos/410/m_libros/409066_portada_1984_george-orwell_202202241653.jpg" class="image" style="width:100%">
           <div class="middle">
              <div class="playnow_bt">Leer más</div>
           </div>
        </div>
        <h1 class="code_text">1984</h1>
        <p class="there_text">George Orwell</p>
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
           <img src="https://planetadelibrosco0.cdnstatics.com/usuaris/libros/fotos/392/m_libros/portada_el-arrebato-de-lol-v-stein_ana-maria-moix_202311171753.jpg" class="image" style="width:100%">
           <div class="middle">
              <div class="playnow_bt">Leer más</div>
           </div>
        </div>
        <h1 class="code_text">El arrebato de Lol V. Stein</h1>
        <p class="there_text">Marguerite Duras </p>
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
           <img src="https://planetadelibrosco0.cdnstatics.com/usuaris/libros/fotos/374/m_libros/373917_portada_cuentos-de-franz-kafka_franz-kafka_202207152209.jpg" class="image" style="width:100%">
           <div class="middle">
              <div class="playnow_bt">Leer más</div>
           </div>
        </div>
        <h1 class="code_text">Cuentos de Franz Kafka  </h1>
        <p class="there_text">Franz Kafka </p>
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
</div>`;
let textPoesia=`<div class="movies_section_2 layout_padding" id="pao">
   <h2 class="letest_text">Poesía</h2>
   <div class="seemore_bt" id="verMas-Poesia"><a href="#">Ver más</a></div>
   <div class="movies_main">
      <div class="iamge_movies_main">

         <div class="iamge_movies">
            <div class="image_3">
               <img src="https://edicioneshispanicas.com/wp-content/uploads/9788418395796-scaled.jpeg" class="image" style="width:100%">
               <div class="middle">
                  <div class="playnow_bt">Leer más</div>
               </div>
            </div>
            <h1 class="code_text">Veinte poemas de amor y una canción desesperada</h1>
            <p class="there_text">Pablo Neruda</p>
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
               <img src="https://www.loqueleo.es/uploads/2016/10/resized/800_9788491221708-rimas-y-leyendas.jpg" class="image" style="width:100%">
               <div class="middle">
                  <div class="playnow_bt">Leer más</div>
               </div>
            </div>
            <h1 class="code_text">Rimas y leyendas</h1>
            <p class="there_text">Gustavo Adolfo Bécquer</p>
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
               <img src="https://images.cdn2.buscalibre.com/fit-in/360x360/40/dc/40dcdb944c94ce86fb00eb1ead7bf7ab.jpg" class="image" style="width:100%">
               <div class="middle">
                  <div class="playnow_bt">Leer más</div>
               </div>
            </div>
            <h1 class="code_text">El poeta en Nueva York</h1>
            <p class="there_text">Federico García Lorca</p>
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
               <img src="https://www.penguinlibros.com/co/5254119/residencia-en-la-tierra.jpg" class="image" style="width:100%">
               <div class="middle">
                  <div class="playnow_bt">Leer más</div>
               </div>
            </div>
            <h1 class="code_text">Residencia en la Tierra</h1>
            <p class="there_text">Pablo Neruda</p>
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
               <img src="https://www.penguinlibros.com/co/1666842/antologia-poetica.jpg" class="image" style="width:100%">
               <div class="middle">
                  <div class="playnow_bt">Leer más</div>
               </div>
            </div>
            <h1 class="code_text">Antología poética</h1>
            <p class="there_text">Mario Benedetti</p>
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
</div>
`;
let textComics=`<div class="movies_section_2 layout_padding" id="comics">
   <h2 class="letest_text">Cómics</h2>
   <div class="seemore_bt" id="verMas-Comics"><a href="#">Ver más</a></div>
   <div class="movies_main">
      <div class="iamge_movies_main">

         <div class="iamge_movies">
            <div class="image_3">
               <img src="https://www.tornamesa.co/imagenes/9781401/978140129405.GIF" class="image" style="width:100%">
               <div class="middle">
                  <div class="playnow_bt">Leer Ahora</div>
               </div>
            </div>
            <h1 class="code_text">Batman: The Killing Joke</h1>
            <p class="there_text">Alan Moore & Brian Bolland</p>
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
               <img src="https://images.cdn2.buscalibre.com/fit-in/360x360/d3/b2/d3b2d5cfb04c705b9ecaec87bdd67b5d.jpg" class="image" style="width:100%">
               <div class="middle">
                  <div class="playnow_bt">Leer Ahora</div>
               </div>
            </div>
            <h1 class="code_text">Spider-Man: Blue</h1>
            <p class="there_text">Jeph Loeb & Tim Sale</p>
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
               <img src="https://images.cdn3.buscalibre.com/fit-in/360x360/63/d0/63d01c3ee3a609a4720378cbeaf5e9dd.jpg" class="image" style="width:100%">
               <div class="middle">
                  <div class="playnow_bt">Leer Ahora</div>
               </div>
            </div>
            <h1 class="code_text">Watchmen</h1>
            <p class="there_text">Alan Moore & Dave Gibbons</p>
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
               <img src="https://images.cdn1.buscalibre.com/fit-in/360x360/1b/4b/1b4bbd2e3f13df99f8dddd5a038d25dc.jpg" class="image" style="width:100%">
               <div class="middle">
                  <div class="playnow_bt">Leer Ahora</div>
               </div>
            </div>
            <h1 class="code_text">The Sandman: Preludes & Nocturnes</h1>
            <p class="there_text">Neil Gaiman</p>
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
               <img src="https://images.cdn2.buscalibre.com/fit-in/360x360/42/bb/42bb269afd93c5be0287fc717772e931.jpg" class="image" style="width:100%">
               <div class="middle">
                  <div class="playnow_bt">Leer Ahora</div>
               </div>
            </div>
            <h1 class="code_text">Daredevil: Born Again</h1>
            <p class="there_text">Frank Miller & David Mazzucchelli</p>
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
</div>
`;
let textManga=`<div class="movies_section_2 layout_padding" id="manga">
   <h2 class="letest_text">Mangas Famosos</h2>
   <div class="seemore_bt" id="verMas-Manga"><a href="#">Ver más</a></div>
   <div class="movies_main">
      <div class="iamge_movies_main">

         <div class="iamge_movies">
            <div class="image_3">
               <img src="https://images.cdn1.buscalibre.com/fit-in/360x360/71/55/71553b3c259caf6cbb510b7eb001e632.jpg" class="image" style="width:100%">
               <div class="middle">
                  <div class="playnow_bt">Leer Ahora</div>
               </div>
            </div>
            <h1 class="code_text">One Piece</h1>
            <p class="there_text">Eiichiro Oda - La épica aventura de los Piratas del Sombrero de Paja.</p>
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
               <img src="https://http2.mlstatic.com/D_NQ_NP_905839-MLU78126482691_082024-O.webp" class="image" style="width:100%">
               <div class="middle">
                  <div class="playnow_bt">Leer Ahora</div>
               </div>
            </div>
            <h1 class="code_text">Naruto</h1>
            <p class="there_text">Masashi Kishimoto - La historia de un ninja que sueña con ser Hokage.</p>
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
               <img src="https://images.cdn1.buscalibre.com/fit-in/360x360/6b/f8/6bf8a5218db76936dc4e98b8d71e83a8.jpg" class="image" style="width:100%">
               <div class="middle">
                  <div class="playnow_bt">Leer Ahora</div>
               </div>
            </div>
            <h1 class="code_text">Dragon ball</h1>
            <p class="there_text">El inicio de la leyenda: Goku en su infancia y la búsqueda de las Esferas del Dragón.</p>
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
               <img src="https://www.comicquestcol.com/wp-content/uploads/2018/06/1.-DEATH-NOTE.jpg" class="image" style="width:100%">
               <div class="middle">
                  <div class="playnow_bt">Leer Ahora</div>
               </div>
            </div>
            <h1 class="code_text">Death Note</h1>
            <p class="there_text">Tsugumi Ohba y Takeshi Obata - Un cuaderno que da el poder de decidir quién vive y quién muere.</p>
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
               <img src="https://www.comicquestcol.com/wp-content/uploads/2020/09/1.-DEMON-SLAYER.jpg" class="image" style="width:100%">
               <div class="middle">
                  <div class="playnow_bt">Leer Ahora</div>
               </div>
            </div>
            <h1 class="code_text">Demon Slayer</h1>
            <p class="there_text">Koyoharu Gotouge - La historia de Tanjiro Kamado en su lucha contra los demonios.</p>
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
</div>
`;
let textMitologia=`<div class="movies_section_2 layout_padding" id="mitologia">
   <h2 class="letest_text">Mitología</h2>
   <div class="seemore_bt" id="verMas-Mitologia"><a href="#">Ver más</a></div>
   <div class="movies_main">
      <div class="iamge_movies_main">

         <div class="iamge_movies">
            <div class="image_3">
               <img src="https://images.cdn2.buscalibre.com/fit-in/360x360/38/e2/38e27d114be84ed4d62b6990e81b7e4e.jpg" class="image" style="width:100%">
               <div class="middle">
                  <div class="playnow_bt">Leer más</div>
               </div>
            </div>
            <h1 class="code_text">Zeus</h1>
            <p class="there_text">Dios del trueno y soberano del Olimpo.</p>
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
               <img src="https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1523061841i/39746234.jpg" class="image" style="width:100%">
               <div class="middle">
                  <div class="playnow_bt">Leer más</div>
               </div>
            </div>
            <h1 class="code_text">Atenea</h1>
            <p class="there_text">Diosa de la sabiduría y la estrategia.</p>
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
               <img src="https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1508801145i/36465807.jpg" class="image" style="width:100%">
               <div class="middle">
                  <div class="playnow_bt">Leer más</div>
               </div>
            </div>
            <h1 class="code_text">Hades</h1>
            <p class="there_text">Dios del inframundo y guardián de las almas.</p>
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
               <img src="https://libreriatemis.com/wp-content/uploads/2024/09/18-11420-0004.jpg" class="image" style="width:100%">
               <div class="middle">
                  <div class="playnow_bt">Leer más</div>
               </div>
            </div>
            <h1 class="code_text">Thor</h1>
            <p class="there_text">Dios nórdico del trueno y la guerra.</p>
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
               <img src="https://images.librotea.com/uploads/media/2015/10/01/mito-leyenda-e-historia-de-quetzalcoatl-la-misteriosa-serpiente-emplumada.jpeg" class="image" style="width:100%">
               <div class="middle">
                  <div class="playnow_bt">Leer más</div>
               </div>
            </div>
            <h1 class="code_text">Quetzalcóatl</h1>
            <p class="there_text">Serpiente emplumada, dios del viento y la sabiduría.</p>
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
</div>
`;
let textRomantico=`<div class="movies_section_2 layout_padding" id="romance">
   <h2 class="letest_text">Libros Románticos Famosos</h2>
   <div class="seemore_bt" id="verMas-Romantico"><a href="#">Ver más</a></div>
   <div class="movies_main">
      <div class="iamge_movies_main">

         <div class="iamge_movies">
            <div class="image_3">
               <img src="https://www.penguinlibros.com/co/2492523/orgullo-y-prejuicio.jpg" class="image" style="width:100%">
               <div class="middle">
                  <div class="playnow_bt">Leer Ahora</div>
               </div>
            </div>
            <h1 class="code_text">Orgullo y Prejuicio</h1>
            <p class="there_text">Jane Austen - Un amor que desafía las normas sociales.</p>
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
               <img src="https://images.cdn3.buscalibre.com/fit-in/360x360/30/e3/30e34f1584bebf69098cac22b4442de1.jpg" class="image" style="width:100%">
               <div class="middle">
                  <div class="playnow_bt">Leer Ahora</div>
               </div>
            </div>
            <h1 class="code_text">Cumbres Borrascosas</h1>
            <p class="there_text">Emily Brontë - Una historia de amor y venganza en los páramos.</p>
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
               <img src="https://images.cdn3.buscalibre.com/fit-in/360x360/10/01/10011f45e0c390723e47b3e1a7b3e5ba.jpg" class="image" style="width:100%">
               <div class="middle">
                  <div class="playnow_bt">Leer Ahora</div>
               </div>
            </div>
            <h1 class="code_text">Romeo y Julieta</h1>
            <p class="there_text">William Shakespeare - El romance trágico más icónico de la literatura.</p>
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
               <img src="https://images.cdn1.buscalibre.com/fit-in/360x360/2a/33/2a33e7c0064a41e226d228a0a88fffb3.jpg" class="image" style="width:100%">
               <div class="middle">
                  <div class="playnow_bt">Leer Ahora</div>
               </div>
            </div>
            <h1 class="code_text">Posdata: Te Amo</h1>
            <p class="there_text">Cecelia Ahern - Un amor que trasciende la muerte a través de cartas.</p>
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
               <img src="https://pics.filmaffinity.com/Bajo_la_misma_estrella-457483777-large.jpg" class="image" style="width:100%">
               <div class="middle">
                  <div class="playnow_bt">Leer Ahora</div>
               </div>
            </div>
            <h1 class="code_text">Bajo la Misma Estrella</h1>
            <p class="there_text">John Green - Un romance que florece en la adversidad.</p>
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
</div>
`;
let textErotico=`<div class="movies_section_2 layout_padding" id="infantil">
   <h2 class="letest_text">Libros Infantiles Famosos</h2>
   <div class="seemore_bt" id="verMas-Erotico"><a href="#">Ver más</a></div>
   <div class="movies_main">
      <div class="iamge_movies_main">

         <div class="iamge_movies">
            <div class="image_3">
               <img src="https://images.cdn3.buscalibre.com/fit-in/520x520/1b/be/1bbe4e73ab3b5da0c508f19c51472916.jpg" class="image" style="width:100%">
               <div class="middle">
                  <div class="playnow_bt">Leer Ahora</div>
               </div>
            </div>
            <h1 class="code_text">El Principito</h1>
            <p class="there_text">Antoine de Saint-Exupéry - Un viaje a través de la imaginación y el corazón.</p>
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
               <img src="https://www.tornamesa.co/imagenes/9788420/978842061018.GIF" class="image" style="width:100%">
               <div class="middle">
                  <div class="playnow_bt">Leer Ahora</div>
               </div>
            </div>
            <h1 class="code_text">Alicia en el País de las Maravillas</h1>
            <p class="there_text">Lewis Carroll - Una aventura llena de magia y personajes fantásticos.</p>
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
               <img src="https://www.tarambana.net/upload/espectaculos/foto_poster-995.jpg?id=67511" class="image" style="width:100%">
               <div class="middle">
                  <div class="playnow_bt">Leer Ahora</div>
               </div>
            </div>
            <h1 class="code_text">Donde Viven los Monstruos</h1>
            <p class="there_text">Maurice Sendak - Un cuento sobre la imaginación y la aventura.</p>
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
               <img src="https://www.elejandria.com/covers/Caperucita_roja-Charles_Perrault-lg.png" class="image" style="width:100%">
               <div class="middle">
                  <div class="playnow_bt">Leer Ahora</div>
               </div>
            </div>
            <h1 class="code_text">Caperucita Roja</h1>
            <p class="there_text">Charles Perrault - Un cuento clásico sobre la astucia y la precaución.</p>
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
               <img src="https://images.cdn3.buscalibre.com/fit-in/360x360/9e/b8/9eb8b892c57b96f05056a37a1ec7768f.jpg" class="image" style="width:100%">
               <div class="middle">
                  <div class="playnow_bt">Leer Ahora</div>
               </div>
            </div>
            <h1 class="code_text">Peter Pan</h1>
            <p class="there_text">J.M. Barrie - La historia del niño que nunca quiso crecer.</p>
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
</div>
`;
let verMas=`<div class="movies_main">
  <div class="iamge_movies_main">
    
    <div class="iamge_movies">
      <div class="image_3">
        <img src="https://www.exlibris.com.co/imagenes/9786287/978628775012.JPG" class="image" style="width:100%">
        <div class="middle">
          <div class="playnow_bt">Leer más</div>
        </div>
      </div>
      <h1 class="code_text">Los juegos del hambre</h1>
      <p class="there_text">Suzanne Collins</p>
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
        <img src="https://m.media-amazon.com/images/I/81af+MCATTL._SL1500_.jpg" class="image" style="width:100%">
        <div class="middle">
          <div class="playnow_bt">Leer más</div>
        </div>
      </div>
      <h1 class="code_text">El gran Gatsby</h1>
      <p class="there_text">F. Scott Fitzgerald</p>
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
        <img src="https://images.cdn1.buscalibre.com/fit-in/360x360/fe/58/fe581c3ec5f295989816825413d462a4.jpg" class="image" style="width:100%">
        <div class="middle">
          <div class="playnow_bt">Leer más</div>
        </div>
      </div>
      <h1 class="code_text">Harry Potter y la piedra filosofal</h1>
      <p class="there_text">J.K. Rowling</p>
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
        <img src="https://www.alpiedelaletralibreria.com/imagenes/9788410/978841006700.JPG" class="image" style="width:100%">
        <div class="middle">
          <div class="playnow_bt">Leer más</div>
        </div>
      </div>
      <h1 class="code_text">Orgullo y prejuicio</h1>
      <p class="there_text">Jane Austen</p>
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
        <img src="https://auladefilosofia.net/wp-content/uploads/2008/10/dostoievski-crimen-y-castigo.jpg" class="image" style="width:100%">
        <div class="middle">
          <div class="playnow_bt">Leer más</div>
        </div>
      </div>
      <h1 class="code_text">Crimen y castigo</h1>
      <p class="there_text">Fiódor Dostoyevski</p>
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
`;
poesia.addEventListener("click",function () {
    activo(poesia);
    cargar.innerHTML=textPoesia;
});
narrativa.addEventListener("click",function () {
   activo(narrativa);
   cargar.innerHTML=textNarrativa;
});
comics.addEventListener("click",function () {
   activo(comics);
   cargar.innerHTML=textComics;
});
manga.addEventListener("click",function () {
   activo(manga);
   cargar.innerHTML=textManga;
});
mitologia.addEventListener("click",function () {
   activo(mitologia);
   cargar.innerHTML=textMitologia;
});
romantico.addEventListener("click",function () {
   activo(romantico);
   cargar.innerHTML=textRomantico;
});
erotico.addEventListener("click",function () {
   activo(erotico);
   cargar.innerHTML=textErotico;
});
if(poesia.classList.contains("active")){
   cargar.innerHTML=textPoesia;
}
else if(narrativa.classList.contains("active")){
   cargar.innerHTML=textNarrativa;
      cargar.innerHTML=`<h1 style="text-align: center;color:white; padding-top: 20px;">Seleccione una categoría</h1><br>
      <div class="movies_menu">
      <div align="center">
      <img src="https://static.vecteezy.com/system/resources/previews/023/221/041/non_2x/open-book-school-supply-icon-free-png.png" class="image" style="width:80%; height:auto;">
      </div>
      </div>`;
}
else if(comics.classList.contains("active")){
   cargar.innerHTML=textComics;
}
else if(manga.classList.contains("active")){
   cargar.innerHTML=textManga;
}
else if(mitologia.classList.contains("active")){
   cargar.innerHTML=textMitologia;
}
else if(romantico.classList.contains("active")){
   cargar.innerHTML=textRomantico;
}
else if(erotico.classList.contains("active")){
   cargar.innerHTML=textErotico;
} else{
    
}

let verMas_Narrativa=document.getElementById("verMasNarrativa");
let verMas_Poesia=document.getElementById("verMas-Poesia");
let verMas_Comics=document.getElementById("verMas-Comics");
let verMas_Manga=document.getElementById("verMas-Manga");
let verMas_Mitologia=document.getElementById("verMas-Mitologia");
let verMas_Romantico=document.getElementById("verMas-Romantico");
let verMas_Erotico=document.getElementById("verMas-Erotico");

document.addEventListener("click", function (event) {
   let target = event.target;
   if (target.id === "verMasNarrativa" || target.closest("#verMasNarrativa")) {
       event.preventDefault(); 
       cargar.innerHTML+=verMas;
   }
});
document.addEventListener("click", function (event) {
   let target = event.target;
   if (target.id === "verMas-Poesia" || target.closest("#verMas-Poesia")) {
       event.preventDefault();
       cargar.innerHTML+=verMas;
   }
});
document.addEventListener("click", function (event) {
   let target = event.target;


   if (target.id === "verMas-Comics" || target.closest("#verMas-Comics")) {
       event.preventDefault(); 
       cargar.innerHTML+=verMas;
   }
});
document.addEventListener("click", function (event) {
   let target = event.target;


   if (target.id === "verMas-Manga" || target.closest("#verMas-Manga")) {
       event.preventDefault(); 
       cargar.innerHTML+=verMas;
   }
});
document.addEventListener("click", function (event) {
   let target = event.target;


   if (target.id === "verMas-Mitologia" || target.closest("#verMas-Mitologia")) {
       event.preventDefault(); 
       cargar.innerHTML+=verMas;
   }
});
document.addEventListener("click", function (event) {
   let target = event.target;


   if (target.id === "verMas-Romantico" || target.closest("#verMas-Romantico")) {
       event.preventDefault(); 
       cargar.innerHTML+=verMas;
   }
});
document.addEventListener("click", function (event) {
   let target = event.target;


   if (target.id === "verMas-Erotico" || target.closest("#verMas-Erotico")) {
       event.preventDefault(); 
       cargar.innerHTML+=verMas;
   }
});


    
});