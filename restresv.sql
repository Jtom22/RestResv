-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-05-2023 a las 22:26:09
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `restresv`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservas`
--

CREATE TABLE `reservas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(10) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `turno` int(1) NOT NULL,
  `numero` int(15) NOT NULL,
  `fecha` date NOT NULL,
  `Estado` varchar(20) NOT NULL,
  `cliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reservas`
--

INSERT INTO `reservas` (`id`, `nombre`, `telefono`, `correo`, `turno`, `numero`, `fecha`, `Estado`, `cliente`) VALUES
(1, 'eugenio', '675847598', 'eugeniovalencia@hotmail.com', 1, 4, '2023-08-16', 'Espera', 0),
(3, 'Mariano', '678987523', 'eugeniovalencia@hotmail.com', 1, 5, '2023-08-16', 'Aceptada', 0),
(5, 'Lobo', '678987523', 'LoboCarrasco@hotmail.com', 2, 9, '2023-08-11', 'Rechazada', 0),
(6, 'María', '568795447', 'LoboCarrasco@hotmail.com', 1, 3, '2023-09-08', 'Lleno', 0),
(10, 'Lucas', '587965325', 'LucasTorres@hotmail.com', 1, 10, '0000-00-00', 'Espera', 0),
(11, 'Marco', '547896521', 'LucasTorro@hotmail.com', 2, 32, '0000-00-00', 'Espera', 0),
(12, 'Julian', '687985685', 'JulianTorres@outook.com', 2, 8, '0000-00-00', 'Espera', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nombre` varchar(10) NOT NULL,
  `contraseña` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `contraseña`) VALUES
(1, 'jorge', 'split');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD UNIQUE KEY `id` (`id`),
  ADD KEY `fk_cliente` (`cliente`) USING BTREE;

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `reservas`
--
ALTER TABLE `reservas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
