-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 27, 2022 at 12:43 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tp1dpbo2022`
--

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `id` int(11) NOT NULL,
  `img` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `jumlah_buku` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `author`
--

INSERT INTO `author` (`id`, `img`, `nama`, `jumlah_buku`) VALUES
(26, 'profil.jpeg', 'Iqbal', '20'),
(27, '20161215-ridwal-kamil-walikota-bandung.jpeg', 'Ridwan Kamil', '20'),
(28, 'Penulis-Best-Seller-November-2018.jpeg', 'Latisa Shafa Naraswari', '1'),
(29, 'BLK_SMK2020714882.jpeg', 'sdas', 'sadsa');

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `id` int(11) NOT NULL,
  `img` varchar(255) NOT NULL,
  `penerbit` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `desc` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`id`, `img`, `penerbit`, `author`, `desc`) VALUES
(18, '6786675_fb460502-4077-4da3-bdf0-19af9e7d724a_720_720.jpeg', 'Latisa', 'Latisa Shafa Naraswari', 'Nanti Kita Cerita Tentang Hari Ini'),
(19, 'ridwan-kamil-pemimpin-kreatif-era-milenial.jpeg', 'Anom Whani Wicaksan', 'Ridwan Kamil', 'Pemimpin Kreatif Era Milenial'),
(21, 'Gedungsate.jpeg', 'SS', 'Iqbal', 'SS');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `author`
--
ALTER TABLE `author`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `buku`
--
ALTER TABLE `buku`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
