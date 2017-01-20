-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-11-2016 a las 13:20:40
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `amazon`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `blackfriday`
--

CREATE TABLE `blackfriday` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `unidades` int(11) DEFAULT NULL,
  `precio` decimal(5,2) DEFAULT NULL,
  `fecha` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `blackfriday`
--

INSERT INTO `blackfriday` (`id`, `nombre`, `unidades`, `precio`, `fecha`) VALUES
(1, 'camisa', 20, '9.99', '2016-11-25'),
(4, 'sada', 11, '9.99', NULL),
(7, 'pantalon', 14, '12.00', NULL),
(8, 'botas', 13, '33.00', '2017-11-25');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `unidades` int(11) DEFAULT NULL,
  `precio` decimal(5,2) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`id`, `nombre`, `unidades`, `precio`, `email`) VALUES
(1, 'sombrero', 12, '2.00', 'a@a.com'),
(2, 'sombrero', 1, '2.00', 'a@a.com'),
(3, 'camisa', 2, '2.00', 'a@a.com'),
(4, 'sombrero', 12, '12.00', 'a@a.com');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `blackfriday`
--
ALTER TABLE `blackfriday`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `blackfriday`
--
ALTER TABLE `blackfriday`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
