-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 31 Bulan Mei 2024 pada 04.38
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `apotekk`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `apoteker`
--

CREATE TABLE `apoteker` (
  `ID_Apoteker` char(10) NOT NULL,
  `Nama` varchar(30) NOT NULL,
  `Alamat` varchar(50) NOT NULL,
  `No_telpn` int(11) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `APOTEKER_ID_Apoteker` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `apoteker`
--

INSERT INTO `apoteker` (`ID_Apoteker`, `Nama`, `Alamat`, `No_telpn`, `Email`, `APOTEKER_ID_Apoteker`) VALUES
('123', '123', '123', 123, '123', NULL),
('9909', 'Muhammad Nabil', 'Jl. Dr. Sutomo', 123441243, 'mhnbl@gmail.com', NULL),
('9910', 'Faiz Abdul Rahman', 'Jl. Juanda', 9348324, 'Abdl@gmail.com', NULL),
('9911', 'Irfan Maulana', 'Jl. Suwandi', 23914824, 'irfnmln@gmail.com', NULL);

-- --------------------------------------------------------

--
-- Struktur dari tabel `cair`
--

CREATE TABLE `cair` (
  `ID_Obat` varchar(10) NOT NULL,
  `ml` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `cair`
--

INSERT INTO `cair` (`ID_Obat`, `ml`) VALUES
('2137', '60'),
('2138', '125');

-- --------------------------------------------------------

--
-- Struktur dari tabel `obat`
--

CREATE TABLE `obat` (
  `ID_Obat` varchar(10) NOT NULL,
  `Nama_obat` varchar(30) NOT NULL,
  `Stok` int(11) NOT NULL,
  `Tanggal_Kadaluarsa` date NOT NULL,
  `APOTEKER_ID_Apoteker` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `obat`
--

INSERT INTO `obat` (`ID_Obat`, `Nama_obat`, `Stok`, `Tanggal_Kadaluarsa`, `APOTEKER_ID_Apoteker`) VALUES
('2092', '111', 10, '2012-12-12', '9909'),
('2135', 'Acitretin', 100, '2027-12-02', '9909'),
('2136', 'Albendazole', 40, '2027-12-09', '9909'),
('2137', 'Antibiotik', 75, '2026-09-12', '9910'),
('2138', 'Antiaritmia', 60, '2026-10-09', '9911'),
('2139', 'Ibuprofen', 82, '2027-03-08', '9909');

-- --------------------------------------------------------

--
-- Struktur dari tabel `padat`
--

CREATE TABLE `padat` (
  `ID_Obat` varchar(10) NOT NULL,
  `Bentuk` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `padat`
--

INSERT INTO `padat` (`ID_Obat`, `Bentuk`) VALUES
('2092', 'Kapsul'),
('2135', 'Kapsul'),
('2136', 'Tablet'),
('2139', 'Serbuk');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pasien`
--

CREATE TABLE `pasien` (
  `ID_Pasien` varchar(10) NOT NULL,
  `Nama_Pasien` varchar(30) NOT NULL,
  `alamat` varchar(30) NOT NULL,
  `No_telpn` int(11) NOT NULL,
  `Email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pasien`
--

INSERT INTO `pasien` (`ID_Pasien`, `Nama_Pasien`, `alamat`, `No_telpn`, `Email`) VALUES
('123', 'Abdul Rahman', 'Jl.Suwandi', 91234214, 'rahman@gmail.com'),
('124', 'Dian Nurdian Murdian', 'Jl. Suwandi', 324852, 'dian@gmail.com'),
('125', 'Perdana Phang', 'Jl. Jakarta', 3854254, 'chnp@gmail.com'),
('126', 'Muhammad Yusuf', 'Jl. Anggi', 349013851, 'mhysf@gmail.com'),
('127', 'Harry Chandra', 'Jl. Juanda 3', 20883214, 'hrcn@gmail.com');

-- --------------------------------------------------------

--
-- Struktur dari tabel `resep`
--

CREATE TABLE `resep` (
  `ID_Resep` varchar(10) NOT NULL,
  `Tanggal_resep` date DEFAULT NULL,
  `Nama_pasien` varchar(30) NOT NULL,
  `PASIEN_ID_Pasien` varchar(10) NOT NULL,
  `APOTEKER_ID_Apoteker` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `resep`
--

INSERT INTO `resep` (`ID_Resep`, `Tanggal_resep`, `Nama_pasien`, `PASIEN_ID_Pasien`, `APOTEKER_ID_Apoteker`) VALUES
('4423', '2023-08-07', '', '125', '9910'),
('4424', '2023-07-11', '', '126', '9911'),
('4425', '2023-07-12', '', '127', '9909');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `apoteker`
--
ALTER TABLE `apoteker`
  ADD PRIMARY KEY (`ID_Apoteker`),
  ADD KEY `APOTEKER_APOTEKER_FK` (`APOTEKER_ID_Apoteker`);

--
-- Indeks untuk tabel `cair`
--
ALTER TABLE `cair`
  ADD PRIMARY KEY (`ID_Obat`);

--
-- Indeks untuk tabel `obat`
--
ALTER TABLE `obat`
  ADD PRIMARY KEY (`ID_Obat`),
  ADD KEY `OBAT_APOTEKER_FK` (`APOTEKER_ID_Apoteker`);

--
-- Indeks untuk tabel `padat`
--
ALTER TABLE `padat`
  ADD PRIMARY KEY (`ID_Obat`);

--
-- Indeks untuk tabel `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`ID_Pasien`);

--
-- Indeks untuk tabel `resep`
--
ALTER TABLE `resep`
  ADD PRIMARY KEY (`ID_Resep`),
  ADD KEY `RESEP_APOTEKER_FK` (`APOTEKER_ID_Apoteker`),
  ADD KEY `RESEP_PASIEN_FK` (`PASIEN_ID_Pasien`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `apoteker`
--
ALTER TABLE `apoteker`
  ADD CONSTRAINT `APOTEKER_APOTEKER_FK` FOREIGN KEY (`APOTEKER_ID_Apoteker`) REFERENCES `apoteker` (`ID_Apoteker`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ketidakleluasaan untuk tabel `cair`
--
ALTER TABLE `cair`
  ADD CONSTRAINT `CAIR_OBAT_FK` FOREIGN KEY (`ID_Obat`) REFERENCES `obat` (`ID_Obat`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Ketidakleluasaan untuk tabel `obat`
--
ALTER TABLE `obat`
  ADD CONSTRAINT `OBAT_APOTEKER_FK` FOREIGN KEY (`APOTEKER_ID_Apoteker`) REFERENCES `apoteker` (`ID_Apoteker`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ketidakleluasaan untuk tabel `padat`
--
ALTER TABLE `padat`
  ADD CONSTRAINT `PADAT_OBAT_FK` FOREIGN KEY (`ID_Obat`) REFERENCES `obat` (`ID_Obat`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Ketidakleluasaan untuk tabel `resep`
--
ALTER TABLE `resep`
  ADD CONSTRAINT `RESEP_APOTEKER_FK` FOREIGN KEY (`APOTEKER_ID_Apoteker`) REFERENCES `apoteker` (`ID_Apoteker`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `RESEP_PASIEN_FK` FOREIGN KEY (`PASIEN_ID_Pasien`) REFERENCES `pasien` (`ID_Pasien`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
