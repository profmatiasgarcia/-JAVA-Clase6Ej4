-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 18-06-2018 a las 16:34:31
-- Versión del servidor: 10.1.31-MariaDB
-- Versión de PHP: 7.1.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `concesionario`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autos`
--

CREATE TABLE `autos` (
  `au_id` int(10) UNSIGNED NOT NULL,
  `au_marca` varchar(255) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `au_modelo` varchar(255) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `au_precio` float NOT NULL DEFAULT '0',
  `au_color` varchar(255) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `au_largo` int(10) UNSIGNED NOT NULL DEFAULT '0',
  `au_ancho` int(10) UNSIGNED NOT NULL DEFAULT '0',
  `au_altura` int(10) UNSIGNED NOT NULL DEFAULT '0',
  `au_equipamiento` varchar(255) COLLATE latin1_spanish_ci NOT NULL DEFAULT ''
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `autos`
--

INSERT INTO `autos` (`au_id`, `au_marca`, `au_modelo`, `au_precio`, `au_color`, `au_largo`, `au_ancho`, `au_altura`, `au_equipamiento`) VALUES
(1, 'Honda', '2010', 200000, 'Azul', 448, 178, 145, 'Honda Civic 1.8 Lxs Mt\r\nTipo: Sedán\r\nMotor: 1.8\r\nPotencia: 140hp\r\nTransmisión: Manual\r\nTipo de combustible: Nafta\r\nCilindrada: 1799 cc\r\nVálvulas por cilindro: 4\r\nDirección: Hidráulica\r\nControl de tracción: Delantera\r\nNro velocidades: 6'),
(2, 'Volkswagen', '2012', 180000, 'Negro', 423, 165, 146, 'Volkswagen Voyage 1.6 Comfortline 101cv \r\nTipo: Sedán\r\nMotor: 1.6\r\nPotencia: 101hp\r\nTransmisión: Manual\r\nTipo de combustible: Nafta\r\nCilindrada: 1599 cc\r\nVálvulas por cilindro: 2\r\nDirección: Hidráulica\r\nControl de tracción: Delantera\r\nNro velocidades: 5'),
(3, 'Chevrolet', '2014', 230000, 'Blanco', 427, 165, 148, 'Chevrolet Prisma 1.4 Ltz 98cv \r\nTipo: Sedán\r\nMotor: 1.4\r\nPotencia: 98hp\r\nTransmisión: Manual\r\nTipo de combustible: Nafta\r\nCilindrada: 1389 cc\r\nVálvulas por cilindro: 2\r\nDirección : Hidráulica\r\nControl de tracción : Delantera\r\nNro velocidades : 5'),
(4, 'Peugeot', '2012', 248000, 'Blanco', 428, 181, 151, 'Peugeot 308 2.0 Feline 143cv  \r\nTipo: Hatchback\r\nMotor: 2.0\r\nPotencia: 143hp\r\nTransmisión: Manual\r\nTipo de combustible: Nafta\r\nCilindrada: 1997 cc\r\nVálvulas por cilindro: 4\r\nDirección: Hidráulica\r\nControl de tracción: Delantera\r\nNro velocidades: 5'),
(5, 'Citroen', '2011', 218000, 'Azul', 426, 173, 147, 'Citroën C4 1.6 Sx Hdi Am73  \r\nTipo: Hatchback\r\nMotor: 1.6\r\nPotencia: 115hp\r\nTransmisión: Manual\r\nTipo de combustible: Diesel\r\nCilindrada: 1560 cc\r\nVálvulas por cilindro: 2\r\nDirección: Asistida\r\nControl de tracción: Delantera\r\nNro velocidades: 5'),
(6, 'Ford', '2013', 300000, 'Gris', 424, 176, 169, 'Ford Ecosport 1.6 Freestyle 110cv 4x2\r\nTipo: SUV\r\nMotor: 1.6\r\nPotencia: 110hp\r\nTransmisión: Manual\r\nTipo de combustible: Nafta\r\nCilindrada: 1596 cc\r\nVálvulas por cilindro: 4\r\nDirección: Eléctrica\r\nControl de tracción: 4x2\r\nNro velocidades: 5');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compradores`
--

CREATE TABLE `compradores` (
  `co_id` int(10) UNSIGNED NOT NULL,
  `co_nombre` varchar(255) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `co_apellido` varchar(255) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `co_documento` varchar(255) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `co_presupuesto` double NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `compradores`
--

INSERT INTO `compradores` (`co_id`, `co_nombre`, `co_apellido`, `co_documento`, `co_presupuesto`) VALUES
(1, 'Hernan', 'Minetti', '24985635', 200000),
(2, 'Matias', 'Garcia', '22698536', 350000),
(3, 'Angie', 'Lione', '24895965', 240000),
(4, 'Cecilia', 'Juliani', '27596585', 232000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendedores`
--

CREATE TABLE `vendedores` (
  `ve_id` int(10) UNSIGNED NOT NULL,
  `ve_nombre` varchar(225) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `ve_apellido` varchar(255) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `ve_documento` varchar(255) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `ve_cant_autos_vendidos` int(10) UNSIGNED NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `vendedores`
--

INSERT INTO `vendedores` (`ve_id`, `ve_nombre`, `ve_apellido`, `ve_documento`, `ve_cant_autos_vendidos`) VALUES
(1, 'Brianna', 'Garcia', '25896524', 5),
(2, 'Mariano', 'Perez', '26898741', 12),
(3, 'Leonardo', 'Lopez', '22365965', 15),
(4, 'Ernesto', 'Bioti', '18965352', 38);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `autos`
--
ALTER TABLE `autos`
  ADD PRIMARY KEY (`au_id`);

--
-- Indices de la tabla `compradores`
--
ALTER TABLE `compradores`
  ADD PRIMARY KEY (`co_id`);

--
-- Indices de la tabla `vendedores`
--
ALTER TABLE `vendedores`
  ADD PRIMARY KEY (`ve_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `autos`
--
ALTER TABLE `autos`
  MODIFY `au_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `compradores`
--
ALTER TABLE `compradores`
  MODIFY `co_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `vendedores`
--
ALTER TABLE `vendedores`
  MODIFY `ve_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
