-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-04-2025 a las 04:29:28
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `librarydb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `author`
--

CREATE TABLE `author` (
  `id_author` int(11) NOT NULL,
  `author_name` varchar(50) NOT NULL,
  `biography` text NOT NULL,
  `image` tinytext NOT NULL,
  `number_of_titles` varchar(255) NOT NULL,
  `stars` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `author`
--

INSERT INTO `author` (`id_author`, `author_name`, `biography`, `image`, `number_of_titles`, `stars`) VALUES
(1, 'Gabriel garcia marquez', 'asasasas', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGumJlfTjtOuaZ0pq0L3T3dHSqjoNs4wWHQA&s', '700', '3.0'),
(2, 'Karen Sofia Ortiz Morea ', 'Autora ', 'https://cloudfront-us-east-1.images.arcpublishing.com/infobae/A3BZFFVCANGEBAQCWJL3TJV73U.jpg', '100', '4.7');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bill_loan`
--

CREATE TABLE `bill_loan` (
  `id_bill` int(11) NOT NULL,
  `code` varchar(20) NOT NULL,
  `date` datetime(6) NOT NULL,
  `state` varchar(20) NOT NULL,
  `id_user` int(11) DEFAULT NULL,
  `name_customer` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `bill_loan`
--

INSERT INTO `bill_loan` (`id_bill`, `code`, `date`, `state`, `id_user`, `name_customer`) VALUES
(6, 'TAX064', '2025-04-16 21:10:48.000000', 'Entregado', 6, ''),
(7, 'BP3EVX', '2025-04-16 21:13:29.000000', 'Entregado', 6, ''),
(8, 'K4DJ5A', '2025-04-16 21:14:54.000000', 'Entregado', 6, ''),
(9, 'IRBCF4', '2025-04-16 21:15:57.000000', 'Pendiente', 6, ''),
(10, '01HHEY', '2025-04-16 21:16:51.000000', 'Pendiente', 6, ''),
(11, 'T04G2N', '2025-04-16 21:18:55.000000', 'Pendiente', 6, ''),
(12, 'BL5THQ', '2025-04-16 21:20:11.000000', 'Pendiente', 6, ''),
(13, 'SILRWA', '2025-04-16 21:25:01.000000', 'Pendiente', 6, ''),
(14, 'N6D51U', '2025-04-16 21:40:04.000000', 'Entregado', 6, 'Juan Carlos'),
(15, 'H31Y7K', '2025-04-18 16:11:50.000000', 'Entregado', 6, 'pepito');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `book`
--

CREATE TABLE `book` (
  `id_book` int(11) NOT NULL,
  `image` tinytext NOT NULL,
  `name_book` varchar(100) NOT NULL,
  `stars` int(11) NOT NULL,
  `id_author_book` int(11) DEFAULT NULL,
  `id_country` int(11) DEFAULT NULL,
  `id_editorial` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `book`
--

INSERT INTO `book` (`id_book`, `image`, `name_book`, `stars`, `id_author_book`, `id_country`, `id_editorial`) VALUES
(1, 'https://edicioneshispanicas.com/wp-content/uploads/9788418395796-scaled.jpeg', 'Veinte poemas de amor y una canción desesperada', 5, 1, 2, 1),
(2, 'https://www.llibres.cat/media/products/517677/517677-0-big.jpg', 'Poeta en Nueva York – Federico García Lorca', 5, 1, 2, 1),
(4, 'https://images.cdn3.buscalibre.com/fit-in/360x360/61/8d/618d227e8967274cd9589a549adff52d.jpg', 'Cien años de soledad', 5, 1, 8, 3),
(5, 'https://www.planetadelibros.com/usuaris/libros/fotos/330/original/portada_la-sombra-del-viento-20-aniversario_carlos-ruiz-zafon_202103111500.jpg', 'La sombra del viento', 4, 1, 4, 1),
(6, 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1456792756i/29369726.jpg', 'Crónica de una muerte anunciada', 5, 2, 1, 3),
(7, 'https://images.cdn3.buscalibre.com/fit-in/360x360/90/53/905322d10841b36aa311dbd5c90d92ed.jpg', 'Rayuela', 4, 2, 9, 1),
(8, 'https://librerialaberintopr.com/cdn/shop/files/81tcNit8CML._SL1500.jpg?v=1726317591', 'El amor, las mujeres y la vida', 4, 2, 7, 1),
(10, 'https://images.cdn2.buscalibre.com/fit-in/360x360/b6/a1/b6a1759f2ac08644dfaf12d8a101f496.jpg', 'Antología poética ', 4, 2, 7, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `book_genre`
--

CREATE TABLE `book_genre` (
  `id_book_genre` int(11) NOT NULL,
  `id_genre` int(11) DEFAULT NULL,
  `id_book` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `book_genre`
--

INSERT INTO `book_genre` (`id_book_genre`, `id_genre`, `id_book`) VALUES
(1, 1, 4),
(2, 1, 5),
(3, 1, 6),
(4, 1, 7),
(5, 6, 1),
(6, 6, 8),
(7, 6, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `country`
--

CREATE TABLE `country` (
  `id_country` int(11) NOT NULL,
  `country` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `country`
--

INSERT INTO `country` (`id_country`, `country`) VALUES
(1, 'Colombia'),
(2, 'Venezuela'),
(3, 'Rusia'),
(4, 'Estados Unidos'),
(5, 'Japon'),
(6, 'China'),
(7, 'Turquía'),
(8, 'Argentina'),
(9, 'Paraguay '),
(10, 'Ecuador ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `editorial`
--

CREATE TABLE `editorial` (
  `id_editorial` int(11) NOT NULL,
  `description` tinytext NOT NULL,
  `editorial` varchar(20) NOT NULL,
  `id_country` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `editorial`
--

INSERT INTO `editorial` (`id_editorial`, `description`, `editorial`, `id_country`) VALUES
(1, 'Esto es una prueba', 'Libros y libros', 1),
(3, 'adasadhggfgghhhh', 'Panamericana', 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genre`
--

CREATE TABLE `genre` (
  `id_genre` int(11) NOT NULL,
  `genre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `genre`
--

INSERT INTO `genre` (`id_genre`, `genre`) VALUES
(1, 'Narrativa'),
(2, 'Manga'),
(3, 'Mitologia'),
(4, 'Romantico'),
(5, 'Infantil'),
(6, 'Poesia'),
(7, 'Comics');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `loan_detail`
--

CREATE TABLE `loan_detail` (
  `id_loan_detail` int(11) NOT NULL,
  `return_date` datetime(6) NOT NULL,
  `state` varchar(20) NOT NULL,
  `id_bill` int(11) DEFAULT NULL,
  `id_book` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `loan_detail`
--

INSERT INTO `loan_detail` (`id_loan_detail`, `return_date`, `state`, `id_bill`, `id_book`) VALUES
(15, '2025-04-18 18:10:52.000000', 'Entregado', 14, 1),
(16, '2025-04-18 17:45:01.000000', 'Reservado', 15, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id_roles` int(11) NOT NULL,
  `name_rol` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id_roles`, `name_rol`) VALUES
(1, 'Encargado'),
(2, 'Lector');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `email` varchar(150) NOT NULL,
  `name` varchar(50) NOT NULL,
  `number` varchar(150) NOT NULL,
  `password` varchar(150) NOT NULL,
  `registration_date` datetime(6) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id_user`, `email`, `name`, `number`, `password`, `registration_date`, `status`) VALUES
(1, 'ckeinercano@gmail.com', 'asdasdadsas', '3183512139', '1075791926K*', '2025-04-15 11:59:53.000000', 1),
(2, 'sandra@gmail.com', 'Sandra milena', '3183512139', '1075791926K*', '2025-04-15 13:59:40.000000', 1),
(3, 'ckeinercano@gmail.com', 'Sandra camp', '3183512139', '1075791926K*', '2025-04-15 14:15:07.000000', 1),
(4, 'ckeinercano@gmail.com', 'asd', '3183512139', '12345678*K', '2025-04-15 14:33:50.000000', 1),
(5, 'asdasdasd@gmail.com', 'asdasd', '3183512139', '1075791926K*', '2025-04-15 14:45:26.000000', 1),
(6, 'xdxd@gmail.com', 'Keiner Andrés Cano Narváez', '3183512139', '1075791926K*', '2025-04-15 14:47:06.000000', 1),
(7, 'xdxad@gmail.com', 'keiner cano', '3183512139', 'asdasd123123*', '2025-04-15 14:55:29.000000', 1),
(8, 'hola@gmail.com', 'keiner cano', '3183512139', '1075791926K*', '2025-04-15 15:03:27.000000', 1),
(9, 'zdzd@gmail.com', 'keiner cano', '3183512139', '10757929193*K', '2025-04-15 15:17:00.000000', 1),
(10, 'cola@gmail.com', 'keiner cano', '3183512139', '107234234K*', '2025-04-15 15:20:28.000000', 0),
(11, 'we@gmail.com', 'keiner cano', '3183512139', '12312312123*D', '2025-04-15 15:21:38.000000', 1),
(12, 'qo@gmail.com', 'keiner cano', '3183512139', '123123*A', '2025-04-15 15:23:30.000000', 1),
(13, 'kl@gmail.com', 'keiner cano', '3183512139', 'C123123*', '2025-04-15 15:28:52.000000', 1),
(14, 'ghj@gmail.com', 'keiner cano', '3183512139', '123123*D', '2025-04-15 15:37:34.000000', 1),
(15, 'rt@gmail.com', 'keiner cano', '3183512139', '123123@A', '2025-04-15 15:38:48.000000', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user_rol`
--

CREATE TABLE `user_rol` (
  `id_user_rol` int(11) NOT NULL,
  `id_rol` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `user_rol`
--

INSERT INTO `user_rol` (`id_user_rol`, `id_rol`, `id_user`) VALUES
(6, 2, 6);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`id_author`);

--
-- Indices de la tabla `bill_loan`
--
ALTER TABLE `bill_loan`
  ADD PRIMARY KEY (`id_bill`),
  ADD KEY `FKsymrvlfyfkmv9u94x199semdv` (`id_user`);

--
-- Indices de la tabla `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id_book`),
  ADD KEY `FKp79fb2oo3wn504ypekknfw638` (`id_author_book`),
  ADD KEY `FKb0l98egcgo2967s1w6xkv2u73` (`id_country`),
  ADD KEY `FKtm65bhl60ejunf5b8u73teqp` (`id_editorial`);

--
-- Indices de la tabla `book_genre`
--
ALTER TABLE `book_genre`
  ADD PRIMARY KEY (`id_book_genre`),
  ADD KEY `FK7ckoxtsinmmkro0n2kywfk91f` (`id_genre`),
  ADD KEY `FKccexx241jlwh3220h1vmk3876` (`id_book`);

--
-- Indices de la tabla `country`
--
ALTER TABLE `country`
  ADD PRIMARY KEY (`id_country`);

--
-- Indices de la tabla `editorial`
--
ALTER TABLE `editorial`
  ADD PRIMARY KEY (`id_editorial`),
  ADD KEY `FKd61er4os7k6lqcp5s6tsid8ko` (`id_country`);

--
-- Indices de la tabla `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`id_genre`);

--
-- Indices de la tabla `loan_detail`
--
ALTER TABLE `loan_detail`
  ADD PRIMARY KEY (`id_loan_detail`),
  ADD KEY `FKs4if1mw1m7som39fs5tmupf01` (`id_bill`),
  ADD KEY `FKao6j8vsds7exgoeqwappt4hsq` (`id_book`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id_roles`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- Indices de la tabla `user_rol`
--
ALTER TABLE `user_rol`
  ADD PRIMARY KEY (`id_user_rol`),
  ADD KEY `FKcm17xb5ydlfbjchm26yxyrff0` (`id_rol`),
  ADD KEY `FKinug80h9oblk9av2nqvw0ckoo` (`id_user`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `author`
--
ALTER TABLE `author`
  MODIFY `id_author` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `bill_loan`
--
ALTER TABLE `bill_loan`
  MODIFY `id_bill` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `book`
--
ALTER TABLE `book`
  MODIFY `id_book` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `book_genre`
--
ALTER TABLE `book_genre`
  MODIFY `id_book_genre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `country`
--
ALTER TABLE `country`
  MODIFY `id_country` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `editorial`
--
ALTER TABLE `editorial`
  MODIFY `id_editorial` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `genre`
--
ALTER TABLE `genre`
  MODIFY `id_genre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `loan_detail`
--
ALTER TABLE `loan_detail`
  MODIFY `id_loan_detail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `id_roles` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `user_rol`
--
ALTER TABLE `user_rol`
  MODIFY `id_user_rol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bill_loan`
--
ALTER TABLE `bill_loan`
  ADD CONSTRAINT `FKsymrvlfyfkmv9u94x199semdv` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Filtros para la tabla `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `FKb0l98egcgo2967s1w6xkv2u73` FOREIGN KEY (`id_country`) REFERENCES `country` (`id_country`),
  ADD CONSTRAINT `FKp79fb2oo3wn504ypekknfw638` FOREIGN KEY (`id_author_book`) REFERENCES `author` (`id_author`),
  ADD CONSTRAINT `FKtm65bhl60ejunf5b8u73teqp` FOREIGN KEY (`id_editorial`) REFERENCES `editorial` (`id_editorial`);

--
-- Filtros para la tabla `book_genre`
--
ALTER TABLE `book_genre`
  ADD CONSTRAINT `FK7ckoxtsinmmkro0n2kywfk91f` FOREIGN KEY (`id_genre`) REFERENCES `genre` (`id_genre`),
  ADD CONSTRAINT `FKccexx241jlwh3220h1vmk3876` FOREIGN KEY (`id_book`) REFERENCES `book` (`id_book`);

--
-- Filtros para la tabla `editorial`
--
ALTER TABLE `editorial`
  ADD CONSTRAINT `FKd61er4os7k6lqcp5s6tsid8ko` FOREIGN KEY (`id_country`) REFERENCES `country` (`id_country`);

--
-- Filtros para la tabla `loan_detail`
--
ALTER TABLE `loan_detail`
  ADD CONSTRAINT `FKao6j8vsds7exgoeqwappt4hsq` FOREIGN KEY (`id_book`) REFERENCES `book` (`id_book`),
  ADD CONSTRAINT `FKs4if1mw1m7som39fs5tmupf01` FOREIGN KEY (`id_bill`) REFERENCES `bill_loan` (`id_bill`);

--
-- Filtros para la tabla `user_rol`
--
ALTER TABLE `user_rol`
  ADD CONSTRAINT `FKcm17xb5ydlfbjchm26yxyrff0` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id_roles`),
  ADD CONSTRAINT `FKinug80h9oblk9av2nqvw0ckoo` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
