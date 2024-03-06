-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3360
-- Generation Time: Mar 06, 2024 at 12:35 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `empleados`
--

-- --------------------------------------------------------

--
-- Table structure for table `empleado`
--

CREATE TABLE `empleado` (
  `ID` int(11) NOT NULL,
  `Apellido` varchar(255) DEFAULT NULL,
  `Borrado_logico` tinyint(1) DEFAULT 0,
  `Cargo` varchar(255) DEFAULT NULL,
  `Fecha_de_inicio` date DEFAULT NULL,
  `Nombre` varchar(255) DEFAULT NULL,
  `Salario` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `empleado`
--

INSERT INTO `empleado` (`ID`, `Apellido`, `Borrado_logico`, `Cargo`, `Fecha_de_inicio`, `Nombre`, `Salario`) VALUES
(1, 'López', 0, 'Marketing', '2010-03-20', 'Laura', 26000),
(2, 'García', 0, 'Frontend', '2023-05-15', 'Lucas', 18000),
(3, 'Pérez', 0, 'Marketing', '2020-08-06', 'Rocío', 23000),
(4, 'Ruiz', 0, 'Backend', '2008-01-23', 'Alejandro', 29000),
(5, 'Rodríguez', 0, 'Ciberseguridad', '2005-04-16', 'Carlos', 35000),
(6, 'Pérez', 0, 'Backend', '2018-10-10', 'Esmeralda', 20000),
(7, 'Martínez', 0, 'Ciberseguridad', '2020-06-10', 'Raquel', 25000),
(8, 'Herranz', 0, 'Administrativo', '2000-11-09', 'Daniel', 23000),
(9, 'Arrizabalaga', 0, 'Backend', '2023-12-10', 'Diego', 20000),
(10, 'Ibarra', 0, 'Frontend', '2016-07-10', 'Lorena', 30000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `empleado`
--
ALTER TABLE `empleado`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
