-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 17, 2021 at 11:33 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bank`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `accountNo` varchar(30) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `contact` varchar(10) NOT NULL,
  `dob` date NOT NULL,
  `gender` varchar(20) NOT NULL,
  `panNo` varchar(30) NOT NULL,
  `aadharNo` varchar(30) NOT NULL,
  `city` varchar(50) NOT NULL,
  `area` varchar(50) NOT NULL,
  `state` varchar(50) NOT NULL,
  `pincode` varchar(20) NOT NULL,
  `cid` int(11) NOT NULL,
  `balance` double NOT NULL DEFAULT 1000
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`accountNo`, `name`, `email`, `contact`, `dob`, `gender`, `panNo`, `aadharNo`, `city`, `area`, `state`, `pincode`, `cid`, `balance`) VALUES
('DEL10191524', 'Fin', 'fin@gmail.com', '9887', '2001-11-05', 'F', '9887', '547', 'Delhi', 'Surat', 'Maha', '576799', 2, 1010.0219428749623),
('LUC30155404', 'Test', 't@gmail.com', '9876543210', '2006-03-29', 'Male', '9876543210', '987654321012', 'Luckh', 'Mand', 'Maha', '987654', 2, 1000),
('MUM1011068', 'Jay', 'jaythadeshwar007@gmail.com', '9699918900', '2001-11-22', 'Male', '1234', '12345', 'Mumbai', 'Borivali', 'Maharastra', '400092', 2, 41871.740834378325),
('MUM10151625', 'Test', 'test@gmail.com', '987654', '2001-11-22', 'M', '12345', 'ABC23', 'Mumbai', 'Bori', 'Maha', '567576', 2, 3016.495668256323),
('MUM10186122', 'Jenil', 'jenil@gamil.com', '1234567890', '2009-04-09', 'Male', '1234567890', '123456789012', 'Mumbai', 'Malad', 'Mahrashtra', '111111', 2, 12034.575515342973),
('MUM10199470', 'Karan', 'k@gmail.com', '12345', '2021-04-07', 'Male', '0098', '789', 'Mumbai', 'Borivali', 'Maharastra', '456756', 3, 3030.065828624888),
('MUM20179278', 'KN', 'kn@gmail.com', '9876543210', '2011-04-14', 'Male', '9876543210', '987654321012', 'Mumbai', 'Bori', 'Maharastra', '566579', 3, 1500),
('MUM30156364', 'Karan', 'k@gmail.com', '9876543210', '2001-04-24', 'M', '9876543210', '987654321012', 'Mumbai', 'Kandivali', 'Maharastra', '677794', 3, 1000),
('MUM30169808', 'Jay', 'jaythad@gmail.com', '9876543210', '2002-04-17', 'Male', '9876543210', '123456789011', 'Mumbai', 'Borivali', 'Maharastra', '400090', 2, 1000),
('MUM30189249', 'Jenil', 'j@gmail.com', '9876543210', '1995-04-06', 'Male', '9876543210', '987654321011', 'Mum', 'abc', 'Maha', '400067', 2, 1000);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `contact` varchar(10) NOT NULL,
  `dob` date NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `name`, `contact`, `dob`, `password`, `email`) VALUES
(2, 'Jay', '9699918900', '2001-11-22', 'password', 'jay@gmail.com'),
(3, 'Karan', '9876543219', '2001-05-28', 'karanpass', 'karannand@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `fixeddeposit`
--

CREATE TABLE `fixeddeposit` (
  `fdid` int(11) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `duration` int(11) NOT NULL,
  `acclinked` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `fixeddeposit`
--

INSERT INTO `fixeddeposit` (`fdid`, `amount`, `duration`, `acclinked`) VALUES
(3, '1000.00', 3, 'MUM10199470'),
(5, '1000.00', 4, 'MUM1011068'),
(6, '5000.00', 12, 'MUM30156364'),
(7, '1000.00', 3, 'MUM30156364'),
(8, '2000.00', 24, 'MUM30156364'),
(9, '50000.00', 36, 'MUM30189249'),
(10, '20000.00', 36, 'LUC30155404');

-- --------------------------------------------------------

--
-- Table structure for table `loan`
--

CREATE TABLE `loan` (
  `loanid` int(11) NOT NULL,
  `accno` varchar(30) DEFAULT NULL,
  `income` decimal(10,2) NOT NULL,
  `etype` varchar(100) DEFAULT NULL,
  `lamount` decimal(10,2) NOT NULL,
  `duration` int(11) DEFAULT NULL,
  `city` varchar(200) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `cmodel` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `loan`
--

INSERT INTO `loan` (`loanid`, `accno`, `income`, `etype`, `lamount`, `duration`, `city`, `type`, `cmodel`) VALUES
(3, 'MUM1011068', '15000.00', 'Pvt/MNC Job', '500000.00', 9, 'Mum', 'Car', 'Nano'),
(4, 'MUM10151625', '15000.00', 'Pvt/MNC Job', '150000.00', 9, 'Mum', 'Home', NULL),
(5, 'MUM10151625', '20000.00', 'Pvt/MNC Job', '1000000.00', 25, 'Delhi', 'Home', NULL),
(6, 'MUM1011068', '16000.00', 'Pvt/MNC Job', '500000.00', 12, 'Mum', 'Home', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `tranDate` date NOT NULL,
  `debit` double NOT NULL,
  `credit` double NOT NULL,
  `balance` double NOT NULL,
  `accNo` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`tranDate`, `debit`, `credit`, `balance`, `accNo`) VALUES
('2021-04-16', 0, 1000, 3000, 'MUM10199470'),
('2021-04-16', 1000, 0, 2000, 'MUM10199470'),
('2021-04-16', 500, 0, 1500, 'MUM10199470'),
('2021-04-16', 0, 1000, 2500, 'MUM10199470'),
('2021-04-16', 1499, 0, 1001, 'MUM10199470'),
('2021-04-16', 0, 9999, 11000, 'MUM10199470'),
('2021-04-16', 5000, 0, 6000, 'MUM10199470'),
('2021-04-16', 1000, 0, 5000, 'MUM10199470'),
('2021-04-17', 2000, 0, 3000, 'MUM10199470'),
('2021-04-17', 0, 1000, 2000, 'MUM20179278'),
('2021-04-17', 500, 0, 1500, 'MUM20179278'),
('2021-04-17', 0, 15000, 16000.87704866693, 'MUM1011068'),
('2021-04-17', 0, 100000, 116002.63056942185, 'MUM1011068'),
('2021-04-17', 0, 10000, 11000, 'MUM10186122'),
('2021-04-17', 2000, 0, 9000, 'MUM10186122'),
('2021-04-17', 50000, 0, 66703.89735903601, 'MUM1011068'),
('2021-04-17', 5000, 0, 61769.71635060941, 'MUM1011068'),
('2021-04-17', 0, 5000, 6008.252594125373, 'MUM10151625'),
('2021-04-17', 100, 0, 5910.228126507857, 'MUM10151625'),
('2021-04-17', 0, 100, 6010.228126507857, 'MUM10151625'),
('2021-04-17', 3000, 0, 3013.522124053625, 'MUM10151625'),
('2021-04-17', 0, 3000, 12022.712298487675, 'MUM10186122'),
('2021-04-17', 20000, 0, 41844.219288264656, 'MUM1011068');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`accountNo`),
  ADD KEY `fk_cid_CustID` (`cid`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `fixeddeposit`
--
ALTER TABLE `fixeddeposit`
  ADD PRIMARY KEY (`fdid`),
  ADD KEY `acclinked` (`acclinked`);

--
-- Indexes for table `loan`
--
ALTER TABLE `loan`
  ADD PRIMARY KEY (`loanid`),
  ADD KEY `accno` (`accno`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD KEY `fk_acNo_Account` (`accNo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `fixeddeposit`
--
ALTER TABLE `fixeddeposit`
  MODIFY `fdid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `loan`
--
ALTER TABLE `loan`
  MODIFY `loanid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `fk_cid_CustID` FOREIGN KEY (`cid`) REFERENCES `customer` (`id`);

--
-- Constraints for table `fixeddeposit`
--
ALTER TABLE `fixeddeposit`
  ADD CONSTRAINT `fixeddeposit_ibfk_1` FOREIGN KEY (`acclinked`) REFERENCES `account` (`accountNo`);

--
-- Constraints for table `loan`
--
ALTER TABLE `loan`
  ADD CONSTRAINT `loan_ibfk_1` FOREIGN KEY (`accno`) REFERENCES `account` (`accountNo`);

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `fk_acNo_Account` FOREIGN KEY (`accNo`) REFERENCES `account` (`accountNo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
