-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 15, 2017 at 12:15 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `CS102-PZ`
--

-- --------------------------------------------------------

--
-- Table structure for table `korisnici`
--

CREATE TABLE `korisnici` (
  `id` int(11) NOT NULL,
  `username` varchar(128) NOT NULL,
  `password` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `korisnici`
--

INSERT INTO `korisnici` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `tvtime`
--

CREATE TABLE `tvtime` (
  `id` int(11) NOT NULL,
  `naziv` varchar(255) NOT NULL,
  `zanr` varchar(255) NOT NULL,
  `godina` int(30) NOT NULL,
  `trajanje` varchar(255) NOT NULL,
  `opis` varchar(255) NOT NULL,
  `ocena` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tvtime`
--

INSERT INTO `tvtime` (`id`, `naziv`, `zanr`, `godina`, `trajanje`, `opis`, `ocena`) VALUES
(1, 'The Hangover', 'Komedija', 2009, '1:40', 'Three buddies wake up from a bachelor party in Las Vegas, with no memory of the previous night and the bachelor missing. They make their way around the city in order to find their friend before his wedding.', 10),
(2, 'Batman: The Dark Knight Returns, Part 1', 'Akcija', 2012, '1:16', 'Batman has not been seen for ten years. A new breed of criminal ravages Gotham City, forcing 55-year-old Bruce Wayne back into the cape and cowl. But, does he still have what it takes to fight crime in a new era?', 8),
(4, 'Spider-Man: Homecoming', 'Avantura', 2017, '2:13', 'Peter Parker, with the help of his mentor Tony Stark, tries to balance his life as an ordinary high school student in New York City while fighting crime as his superhero alter ego Spider-Man when a new threat emerges.', 8),
(5, 'Orphan', 'Horor', 2009, '2:03', 'A husband and wife who recently lost their baby adopt a 9 year-old girl who is not nearly as innocent as she claims to be.', 7),
(6, 'The Smurfs', 'Komedija', 2011, '1:43', 'When the evil wizard Gargamel chases the tiny blue Smurfs out of their village, they tumble from their magical world into New York City.', 5);

-- --------------------------------------------------------

--
-- Table structure for table `zanr`
--

CREATE TABLE `zanr` (
  `id` int(11) NOT NULL,
  `naziv` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `zanr`
--

INSERT INTO `zanr` (`id`, `naziv`) VALUES
(1, 'Akcija'),
(2, 'Avantura'),
(3, 'Komedija'),
(4, 'Drama'),
(5, 'Fantazija'),
(6, 'Horor'),
(7, 'Misterija'),
(8, 'Romantika'),
(9, 'Triler');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `korisnici`
--
ALTER TABLE `korisnici`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tvtime`
--
ALTER TABLE `tvtime`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `zanr`
--
ALTER TABLE `zanr`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `korisnici`
--
ALTER TABLE `korisnici`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tvtime`
--
ALTER TABLE `tvtime`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `zanr`
--
ALTER TABLE `zanr`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
