-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 18, 2016 at 10:02 AM
-- Server version: 5.6.21
-- PHP Version: 5.5.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `inventaris`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `username` varchar(15) NOT NULL,
  `password` varchar(8) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `idAdmin` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE IF NOT EXISTS `barang` (
  `idBarang` int(10) NOT NULL,
  `namabarang` varchar(25) NOT NULL,
  `hargabarang` double NOT NULL,
  `kategori` varchar(15) NOT NULL,
  `lokasi` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`idBarang`, `namabarang`, `hargabarang`, `kategori`, `lokasi`) VALUES
(1, 'KURSI SEKOLAH', 200000, 'kursi', 'Gudang A');

-- --------------------------------------------------------

--
-- Table structure for table `datapemeliharaan`
--

CREATE TABLE IF NOT EXISTS `datapemeliharaan` (
  `idbarang` int(10) NOT NULL,
  `nama` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `datapemeliharaan`
--

INSERT INTO `datapemeliharaan` (`idbarang`, `nama`) VALUES
(1, 'Rusak');

-- --------------------------------------------------------

--
-- Table structure for table `departemeninventaris`
--

CREATE TABLE IF NOT EXISTS `departemeninventaris` (
  `username` varchar(15) NOT NULL,
  `password` varchar(8) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `idDI` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `departemeninventaris`
--

INSERT INTO `departemeninventaris` (`username`, `password`, `nama`, `idDI`) VALUES
('rmk', 'rmk', 'rmk', 1);

-- --------------------------------------------------------

--
-- Table structure for table `departemenkeuangan`
--

CREATE TABLE IF NOT EXISTS `departemenkeuangan` (
  `username` varchar(15) NOT NULL,
  `password` varchar(8) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `idDK` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `kategoribarang`
--

CREATE TABLE IF NOT EXISTS `kategoribarang` (
  `namaKategori` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kategoribarang`
--

INSERT INTO `kategoribarang` (`namaKategori`) VALUES
('kursi');

-- --------------------------------------------------------

--
-- Table structure for table `kategoritanah`
--

CREATE TABLE IF NOT EXISTS `kategoritanah` (
  `nama` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pemeliharaan`
--

CREATE TABLE IF NOT EXISTS `pemeliharaan` (
  `namaPemeliharaan` varchar(15) NOT NULL,
  `biaya` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pemeliharaan`
--

INSERT INTO `pemeliharaan` (`namaPemeliharaan`, `biaya`) VALUES
('Rusak', 500000);

-- --------------------------------------------------------

--
-- Table structure for table `tanah`
--

CREATE TABLE IF NOT EXISTS `tanah` (
  `idTanah` int(10) NOT NULL,
  `lokasi` text NOT NULL,
  `luas` double NOT NULL,
  `kategori` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tempat`
--

CREATE TABLE IF NOT EXISTS `tempat` (
  `namaTempat` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tempat`
--

INSERT INTO `tempat` (`namaTempat`) VALUES
('Gudang A');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
 ADD PRIMARY KEY (`username`);

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
 ADD PRIMARY KEY (`idBarang`);

--
-- Indexes for table `datapemeliharaan`
--
ALTER TABLE `datapemeliharaan`
 ADD PRIMARY KEY (`idbarang`,`nama`), ADD KEY `nama` (`nama`);

--
-- Indexes for table `departemeninventaris`
--
ALTER TABLE `departemeninventaris`
 ADD PRIMARY KEY (`username`);

--
-- Indexes for table `departemenkeuangan`
--
ALTER TABLE `departemenkeuangan`
 ADD PRIMARY KEY (`username`);

--
-- Indexes for table `kategoribarang`
--
ALTER TABLE `kategoribarang`
 ADD PRIMARY KEY (`namaKategori`);

--
-- Indexes for table `kategoritanah`
--
ALTER TABLE `kategoritanah`
 ADD PRIMARY KEY (`nama`);

--
-- Indexes for table `pemeliharaan`
--
ALTER TABLE `pemeliharaan`
 ADD PRIMARY KEY (`namaPemeliharaan`);

--
-- Indexes for table `tanah`
--
ALTER TABLE `tanah`
 ADD PRIMARY KEY (`idTanah`), ADD KEY `kategori` (`kategori`);

--
-- Indexes for table `tempat`
--
ALTER TABLE `tempat`
 ADD PRIMARY KEY (`namaTempat`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `datapemeliharaan`
--
ALTER TABLE `datapemeliharaan`
ADD CONSTRAINT `datapemeliharaan_ibfk_1` FOREIGN KEY (`idbarang`) REFERENCES `barang` (`idBarang`),
ADD CONSTRAINT `datapemeliharaan_ibfk_2` FOREIGN KEY (`nama`) REFERENCES `pemeliharaan` (`namaPemeliharaan`);

--
-- Constraints for table `tanah`
--
ALTER TABLE `tanah`
ADD CONSTRAINT `Foreign_key` FOREIGN KEY (`kategori`) REFERENCES `kategoritanah` (`nama`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
