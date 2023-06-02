-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-06-2023 a las 08:28:23
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
-- Base de datos: `elpalacio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `usuario` varchar(11) NOT NULL,
  `contraseña` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id`, `usuario`, `contraseña`) VALUES
(1, '999888777', 'manolo@hotm'),
(2, 'Marco', '587458856'),
(3, 'Mariano', '854632547'),
(4, '33', 'asdf@dfas'),
(6, '4477888', 'asdf@dfas'),
(10, '334', 'dasff@ef'),
(13, '3334', 'asdgf@hdhgf'),
(14, '877966587', 'marcosluna@'),
(15, '44455557778', 'manuelitobu'),
(16, '666888666', 'lucia@hotma'),
(17, '444777888', 'locuragonza'),
(18, '654521365', 'ñlutori@hñj'),
(19, '601122587', 'klñaufdi@ul'),
(20, '601122196', 'kljiusf@ñas'),
(21, '567987123', 'Tiara@hotma'),
(22, '333222555', '3658'),
(23, '88999877', 'noseque2@af'),
(24, '234589', '33'),
(25, '1', '1@1'),
(26, '25896544788', '2@23d'),
(28, '666999222', 'reww@try');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservas`
--

CREATE TABLE `reservas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(12) NOT NULL,
  `correo` varchar(25) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `turno` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `Estado` varchar(10) NOT NULL,
  `id_cliente` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reservas`
--

INSERT INTO `reservas` (`id`, `nombre`, `correo`, `telefono`, `turno`, `numero`, `fecha`, `Estado`, `id_cliente`) VALUES
(1, 'manolo', 'manolo@hotmail', '698563587', 2, 12, '2023-05-10', 'Espera', '999888777'),
(18, 'paco', 'paco@asd', '6663332252', 2, 2, '0000-00-00', 'Espera', '999888777'),
(19, 'jorge', 'jorge@jorge', '999888777', 2, 2, '0000-00-00', 'Espera', '999888777'),
(23, 'Query4', 'Query4@Query4', '999888777', 2, 2, '0000-00-00', 'Espera', '999888777'),
(24, 'Query4', 'Query4@Query4', '999888777', 2, 2, '0000-00-00', 'Espera', '999888777'),
(27, 'adsf3erb', 'adsf@asa', '999888777', 2, 4, '0000-00-00', 'Espera', '999888777'),
(32, 'mardsodf', 'asfd@agfds', '999888777', 2, 3, '0000-00-00', 'Espera', '999888777'),
(39, 'añjfdask', 'asdf@dfas', '33', 2, 1, '0000-00-00', 'Espera', '33'),
(40, 'locoplaya', 'asdf@dfas', '4477888', 2, 1, '0000-00-00', 'Espera', '4477888'),
(41, 'dasf', 'dasff@ef', '334', 2, 23, '0000-00-00', 'Espera', '334'),
(42, 'loco', 'asdgf@hdhgf', '33', 3, 3, '0000-00-00', 'Espera', '33'),
(43, 'loco', 'asdgf@hdhgf', '3334', 3, 3, '0000-00-00', 'Espera', '3334'),
(44, 'dasf', 'adsf@gfds', '22558899', 2, 12, '2023-05-06', 'Espera', '33'),
(45, 'dfasghgf', 'gfdghdf@ytd', '33', 21, 28, '0000-00-00', 'Espera', '33'),
(46, 'tryu', 'jhgfjgh@sdfg', '33', 1, 2, '2023-05-02', 'Espera', '33'),
(47, 'marcos', 'marcosluna@hotmail.com', '877966587', 1, 3, '2015-05-08', 'Espera', '877966587'),
(48, 'marcos', 'marcosluna@hotmail.com', '877966587', 1, 4, '0000-00-00', 'Espera', '877966587'),
(49, 'lucia', 'lucia@hotmail.com', '666888666', 1, 21, '0000-00-00', 'Espera', '666888666'),
(50, 'locura', 'locuragonzalez@hotmail.co', '444777888', 1, 2, '0000-00-00', 'Espera', '444777888'),
(51, 'lucatoni', 'ñlutori@hñjasfkj', '654521365', 1, 3, '0000-00-00', 'Espera', '654521365'),
(55, '3', '4', '2', 5, 8, '0000-00-00', 'Espera', '33'),
(56, '3', '4', '2', 5, 8, '1988-12-15', 'Espera', '33'),
(57, 'sdafer', 'klñaufdi@ulult', '601122587', 1, 3, '1970-01-01', 'Aceptada', '601122587'),
(58, 'sdafer', 'klñaufdi@ulult', '601122587', 1, 3, '0000-00-00', 'Espera', '601122587'),
(59, 'sdafer', 'klñaufdi@ulult', '601122587', 1, 3, '0000-00-00', 'Espera', '601122587'),
(60, 'dsafr', 'kljiusf@ñasd', '601122196', 1, 5, '1970-01-01', 'Espera', '601122196'),
(65, 'fasd', 'asd@gdfa', '33', 2, 2, '0000-00-00', 'Espera', '33'),
(66, 'fasd', 'asd@gdfa', '33', 2, 2, '0000-00-00', 'Espera', '33'),
(67, '33', '33', '234589', 2, 2, '0000-00-00', 'Espera', '234589'),
(68, 'dfsafr', '1@1', '1', 1, 1, '0000-00-00', 'Espera', '1'),
(69, 'ytuitru', 'reww@try', '666999222', 1, 23, '0000-00-00', 'Espera', '666999222'),
(70, 'ytuitru', 'reww@try', '666999222', 2, 1, '0000-00-00', 'Espera', '666999222'),
(71, 'manuos', 'manuos@hotmail.com', '321564879', 22, 4, '2023-05-30', 'Espera', '33'),
(73, 'adsf', 'vnbgdf@hjfg', '889999877', 2, 3, '2023-05-30', 'Espera', '88999877');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nombre` varchar(11) NOT NULL,
  `contraseña` varchar(11) NOT NULL
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
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `usuario` (`usuario`);

--
-- Indices de la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `rel` (`id_cliente`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT de la tabla `reservas`
--
ALTER TABLE `reservas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=74;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD CONSTRAINT `rel` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`usuario`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
