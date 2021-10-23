-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-05-2021 a las 15:52:39
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `voyagearrive`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estancia`
--

CREATE TABLE `estancia` (
  `Id` int(10) NOT NULL,
  `destino` varchar(10) COLLATE utf8_spanish2_ci NOT NULL,
  `pais` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `tipo_viaje` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `categoria_hotel` varchar(10) COLLATE utf8_spanish2_ci NOT NULL,
  `precio` varchar(10) COLLATE utf8_spanish2_ci NOT NULL,
  `fin_oferta` varchar(10) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `estancia`
--

INSERT INTO `estancia` (`Id`, `destino`, `pais`, `tipo_viaje`, `categoria_hotel`, `precio`, `fin_oferta`) VALUES
(1, 'Europa', 'Grecia', 'Sol y Playa', '5', '1250', '2021-07-24'),
(2, 'Europa', 'Chequia', 'Cultural', '3', '750', '2021-08-18'),
(4, 'Europa', 'Holanda', 'Cultural', '3', '560', '2021-08-10'),
(5, 'Europa', 'Italia', 'Cultural', '5', '1375', '2021-07-29'),
(6, 'África', 'Túnez', 'Sol y Playa', '4', '890', '2021-07-29'),
(8, 'África', 'Kenia', 'Naturaleza', '5', '1765', '2021-08-10'),
(9, 'África', 'Egipto', 'Cultural', '5', '1635', '2021-07-28'),
(10, 'África', 'Marruecos', 'Naturaleza', '3', '740', '2021-07-18'),
(11, 'América', 'México', 'Sol y Playa', '4', '1675', '2021-07-23'),
(12, 'América', 'Argentina', 'Naturaleza', '5', '2460', '2021-08-07'),
(13, 'América', 'EEUU', 'Cultural', '5', '2180', '2021-08-03'),
(14, 'América', 'Perú', 'Naturaleza', '4', '1720', '2021-07-22'),
(16, 'Asia', 'Tailandia', 'Naturaleza', '5', '2610', '2021-07-30'),
(18, 'Asia', 'Japón', 'Cultural', '5', '3425', '2021-08-16'),
(19, 'Asia', 'China', 'Cultural', '4', '2770', '2021-07-29'),
(20, 'Oceanía', 'Australia', 'Naturaleza', '5', '3160', '2021-08-13');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `ID_USUARIO` int(4) NOT NULL,
  `EMAIL` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `PASS` varchar(8) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`ID_USUARIO`, `EMAIL`, `PASS`) VALUES
(1, 'one@mail.com', '1234\0\0\0\0'),
(2, 'two@mail.com', 'admin\0\0\0'),
(3, 'three@mail.com', '3333'),
(4, 'four@mail.com', '4321\0\0\0\0'),
(5, 'five@mail.com', 'user\0\0\0\0'),
(6, 'six@mail.com', '6666');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `estancia`
--
ALTER TABLE `estancia`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`ID_USUARIO`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `estancia`
--
ALTER TABLE `estancia`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `ID_USUARIO` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
