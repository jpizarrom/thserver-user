-- phpMyAdmin SQL Dump
-- version 3.3.9.2deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 03-07-2011 a las 20:33:46
-- Versión del servidor: 5.1.49
-- Versión de PHP: 5.3.3-7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `memoria2-user`
--

--
-- Volcar la base de datos para la tabla `User`
--

INSERT INTO `User` (`userId`, `country`, `email`, `latitude`, `longitude`, `name`, `password`, `phone`, `role`, `showPersonalInfo`, `surname`, `username`) VALUES
(1, NULL, 'qwe', -34634576, -71358695, NULL, 'qwe', NULL, 'ROLE_USER', b'0', NULL, 'qwe'),
(2, NULL, 'jpizarrom@gmail.com', -35410681, -71644689, NULL, 'asd', NULL, 'ROLE_USER', b'0', NULL, 'asd'),
(3, NULL, 'jpizarrom@gmail.com', 0, 0, NULL, 'yxc', NULL, 'ROLE_USER', b'0', NULL, 'yxc');
