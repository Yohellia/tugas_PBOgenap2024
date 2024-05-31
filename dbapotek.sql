-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 31 Bulan Mei 2024 pada 04.11
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
-- Database: `apotek`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `data`
--

CREATE TABLE `data` (
  `id_data` char(8) NOT NULL,
  `id_pegawai` char(8) NOT NULL,
  `id_obat` char(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `data`
--

INSERT INTO `data` (`id_data`, `id_pegawai`, `id_obat`) VALUES
('23101505', '20020505', '23010101'),
('23102504', '20020504', '23010102'),
('23103503', '20020503', '23010103'),
('23104503', '20020503', '23010104'),
('23105503', '20020503', '23010105'),
('23106503', '20020503', '23010106'),
('23107503', '20020503', '23010107'),
('23108502', '20020502', '23010108'),
('23109502', '20020502', '23010109'),
('23110502', '20020502', '23010110'),
('23111505', '20020505', '23010111'),
('23112504', '20020504', '23010112'),
('23113504', '20020504', '23010113'),
('23114505', '20020505', '23010114'),
('23115505', '20020505', '23010115'),
('23116505', '20020505', '23010116'),
('23117505', '20020505', '23010117'),
('23118505', '20020505', '23010118'),
('23119505', '20020505', '23010119'),
('23120504', '20020504', '23010120'),
('23121504', '20020504', '23010121'),
('23201504', '20020504', '23010201'),
('23301502', '20020502', '23010301'),
('23302501', '20020501', '23010302'),
('23401501', '20020501', '23010401');

-- --------------------------------------------------------

--
-- Struktur dari tabel `miliki`
--

CREATE TABLE `miliki` (
  `id_miliki` char(8) NOT NULL,
  `id_obat` char(8) NOT NULL,
  `id_pesanan` char(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `miliki`
--

INSERT INTO `miliki` (`id_miliki`, `id_obat`, `id_pesanan`) VALUES
('23701106', '23010106', '23040701'),
('23702102', '23010102', '23040702'),
('23703701', '23010701', '23040703'),
('23704901', '23010901', '23040704'),
('23705109', '23010109', '23040705'),
('23706105', '23010105', '23040706'),
('23707401', '23010401', '23040707'),
('23708302', '23010302', '23040708'),
('23709101', '23010101', '23040709'),
('23710102', '23010102', '23040710'),
('23711601', '23010601', '23040711'),
('23801110', '23010110', '23040801'),
('23802402', '23010402', '23040802'),
('23803106', '23010106', '23040803'),
('23804102', '23010102', '23040804'),
('23805104', '23010104', '23040805'),
('23806501', '23010501', '23040806'),
('23807103', '23010103', '23040807'),
('23808102', '23010102', '23040808'),
('23809110', '23010110', '23040809');

-- --------------------------------------------------------

--
-- Struktur dari tabel `obat`
--

CREATE TABLE `obat` (
  `id_obat` char(8) NOT NULL,
  `nama_obat` varchar(24) NOT NULL,
  `jenis_obat` varchar(10) NOT NULL,
  `stok_obat` int(3) NOT NULL,
  `harga_obat` varchar(7) NOT NULL,
  `id_pegawai` char(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `obat`
--

INSERT INTO `obat` (`id_obat`, `nama_obat`, `jenis_obat`, `stok_obat`, `harga_obat`, `id_pegawai`) VALUES
('23010101', 'antasida', 'tablet', 62, '8000', '20020505'),
('23010102', 'ambroxol', 'tablet', 45, '5000', '20020504'),
('23010103', 'amoxillin', 'tablet', 53, '8000', '20020503'),
('23010104', 'dulcolax', 'tablet', 34, '18000', '20020503'),
('23010105', 'mylanta', 'tablet', 30, '18000', '20020503'),
('23010106', 'paracetamol', 'tablet', 45, '7000', '20020503'),
('23010107', 'quetiapine', 'tablet', 5, '330000', '20020503'),
('23010108', 'salbutamol', 'tablet', 36, '3000', '20020502'),
('23010109', 'strepsils', 'tablet', 20, '18000', '20020502'),
('23010110', 'vitacimin', 'tablet', 28, '2000', '20020502'),
('23010111', 'tramadol', 'tablet', 5, '150000', '20020505'),
('23010112', 'promag', 'tablet', 30, '10000', '20020504'),
('23010113', 'panadol', 'tablet', 15, '15000', '20020504'),
('23010114', 'polysilane', 'tablet', 20, '9000', '20020505'),
('23010115', 'paramex', 'tablet', 40, '3000', '20020505'),
('23010116', 'oskadon', 'tablet', 29, '4000', '20020505'),
('23010117', 'ibuprofen', 'tablet', 15, '5000', '20020505'),
('23010118', 'entrostop', 'tablet', 34, '10000', '20020505'),
('23010119', 'enervon c', 'tablet', 40, '6000', '20020505'),
('23010120', 'decolgen', 'tablet', 10, '2500', '20020504'),
('23010121', 'combatrin', 'tablet', 20, '20000', '20020504'),
('23010201', 'sangobion', 'kapsul', 25, '20000', '20020504'),
('23010301', 'tempra', 'sirup', 54, '25000', '20020502'),
('23010302', 'komix', 'sirup', 35, '40000', '20020501'),
('23010401', 'adem sari', 'bubuk', 34, '15000', '20020501'),
('23010402', 'vidoran xmart', 'bubuk', 18, '55000', '20020503'),
('23010403', 'vegeta herbal', 'bubuk', 35, '19000', '20020503'),
('23010404', 'oralit', 'bubuk', 50, '2000', '20020502'),
('23010405', 'lacto b', 'bubuk', 20, '71000', '20020502'),
('23010501', 'kejibeling', 'pil', 10, '6000', '20020502'),
('23010502', 'stimuno forte', 'pil', 12, '27000', '20020502'),
('23010503', 'pil kb', 'pil', 20, '22000', '20020501'),
('23010504', 'natur E', 'pil', 35, '30000', '20020501'),
('23010601', 'betadin', 'cairan', 74, '25000', '20020501'),
('23010605', 'nuvo handsinitizer', 'cairan', 60, '12000', '20020503'),
('23010701', 'salonpas', 'obat luar', 45, '8000', '20020503'),
('23010801', 'gliserol', 'emulsi', 9, '6000', '20020504'),
('23010901', 'counterpain', 'salep', 65, '27000', '20020501'),
('23020608', 'insto', 'cairan', 30, '18000', '20020505'),
('23020802', 'scott\'s emultion', 'emulsi', 40, '50000', '20020505'),
('23020902', 'kalpanax', 'salep', 20, '20000', '20020505'),
('23030603', 'ofloxacin tetes mata', 'cairan', 30, '31000', '20020505'),
('23030604', 'ofloxacin tetes telinga', 'cairan', 60, '12000', '20020505'),
('23030607', 'insulin suntik', 'cairan', 20, '250000', '20020504'),
('23050602', 'telon lang', 'cairan', 40, '15000', '20020504'),
('23060603', 'tolak angin', 'cairan', 30, '31000', '20020504'),
('23060606', 'kiranti', 'cairan', 25, '12000', '20020501');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pegawai`
--

CREATE TABLE `pegawai` (
  `id_pegawai` char(8) NOT NULL,
  `nama_pegawai` varchar(24) NOT NULL,
  `jenis_kelamin` char(1) NOT NULL,
  `jabatan` varchar(20) NOT NULL,
  `alamat` varchar(24) DEFAULT NULL,
  `no_telp` char(13) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pegawai`
--

INSERT INTO `pegawai` (`id_pegawai`, `nama_pegawai`, `jenis_kelamin`, `jabatan`, `alamat`, `no_telp`) VALUES
('20020101', 'Tia', 'P', 'kepala apoteker', 'msaid', '0881026814105'),
('20020102', 'Fiskiya', 'P', 'Wakil apoteker', '', '08963478912'),
('20020201', 'Amalia', 'P', 'apoteker', 'sempaja', '0856723415673'),
('20020202', 'Rizani', 'P', 'apoteker', 'pramuka', '088263290134'),
('20020203', 'Adzimah', 'P', 'apoteker', NULL, NULL),
('20020204', 'Trisna', 'P', 'apoteker', 'pramuka', NULL),
('20020205', 'Aldi', 'L', 'apoteker', 'Sempaja', '087453289065'),
('20020206', 'Andy', 'L', 'apoteker', 'Sempaja', NULL),
('20020301', 'Adinda', 'P', 'asisten apoteker', 'anggur', '0814256901347'),
('20020302', 'Stephanie', 'P', 'asisten apoteker', 'perjuangan', '087234590134'),
('20020303', 'Lidia', 'P', 'asisten apoteker', 'makroman', NULL),
('20020304', 'Arya', 'L', 'asisten apoteker', 'bengkuring', NULL),
('20020305', 'Farrera', 'P', 'asisten apoteker', NULL, '085478921567'),
('20020401', 'Sandrina', 'P', 'kasir', 'msaid', '085234891345'),
('20020402', 'Mita', 'P', 'kasir', NULL, '089126780235'),
('20020501', 'Gilang', 'L', 'petugas gudang', 'myamin', '082478012563'),
('20020502', 'Jonathan', 'L', 'petugas gudang', 'vorvo', '081902356781'),
('20020503', 'Fauzan', 'L', 'petugas gudang', 'juanda', '087346801456'),
('20020504', 'Ali', 'L', 'petugas gudang', 'sempaja', '084239543179'),
('20020505', 'Devano', 'L', 'petugas gudang', 'Pahlawan', '083278904321');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pelanggan` char(8) NOT NULL,
  `nama_pelanggan` varchar(24) NOT NULL,
  `jenis_kelamin` char(1) NOT NULL,
  `usia` int(2) NOT NULL,
  `alamat` varchar(24) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pelanggan`
--

INSERT INTO `pelanggan` (`id_pelanggan`, `nama_pelanggan`, `jenis_kelamin`, `usia`, `alamat`) VALUES
('23000201', 'Alisya', 'P', 23, 'Sempaja'),
('23030201', 'Novianti', 'P', 20, 'Makroman'),
('23060201', 'Yusuf', 'L', 17, 'Bangris'),
('23080201', 'Muti', 'P', 15, NULL),
('23090201', 'Dinnu', 'L', 18, NULL),
('23110201', 'Kayla', 'P', 21, NULL),
('23110202', 'Silva', 'P', 25, 'Myamin'),
('23130101', 'Sandrina', 'P', 19, 'Msaid'),
('23130201', 'Haiqal', 'L', 30, 'Anggur'),
('23170201', 'Joviana', 'P', 24, 'Kelua'),
('23180201', 'Haykal', 'L', 34, 'Antasari'),
('23190201', 'Helen', 'P', 31, 'Juanda'),
('23780201', 'Nita', 'P', 22, 'Makroman'),
('23880201', 'Harry', 'L', 45, 'Pramuka'),
('23910101', 'Ayu', 'P', 27, 'Pahlawan'),
('23930201', 'Uswa', 'P', 23, 'Perjuangan'),
('23940201', 'Imelda', 'P', 33, 'Tenggarong'),
('23960201', 'Amal', 'P', 20, 'Biawan'),
('23970201', 'Angel', 'P', 45, 'Kelua'),
('23980201', 'Haidar', 'L', 18, NULL);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pesanan_obat`
--

CREATE TABLE `pesanan_obat` (
  `id_pesanan` char(8) NOT NULL,
  `no_pesanan` int(2) NOT NULL,
  `jumlah_pesanan` int(3) NOT NULL,
  `tanggal_pesanan` date NOT NULL,
  `id_obat` char(8) NOT NULL,
  `id_pelanggan` char(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pesanan_obat`
--

INSERT INTO `pesanan_obat` (`id_pesanan`, `no_pesanan`, `jumlah_pesanan`, `tanggal_pesanan`, `id_obat`, `id_pelanggan`) VALUES
('23040701', 1, 1, '2023-04-07', '23010106', '23170201'),
('23040702', 1, 1, '2023-04-07', '23010102', '23170201'),
('23040703', 2, 2, '2023-04-07', '23010701', '23110201'),
('23040704', 2, 1, '2023-04-07', '23010901', '23110201'),
('23040705', 2, 2, '2023-04-07', '23010109', '23110201'),
('23040706', 3, 1, '2023-04-07', '23010105', '23910101'),
('23040707', 4, 1, '2023-04-07', '23010401', '23130101'),
('23040708', 4, 1, '2023-04-07', '23010302', '23130101'),
('23040709', 5, 1, '2023-04-07', '23010101', '23060201'),
('23040710', 5, 1, '2023-04-07', '23010102', '23060201'),
('23040711', 6, 1, '2023-04-07', '23010601', '23110201'),
('23040801', 7, 3, '2023-04-08', '23010110', '23780201'),
('23040802', 7, 2, '2023-04-08', '23010402', '23780201'),
('23040803', 8, 1, '2023-04-08', '23010106', '23940201'),
('23040804', 8, 1, '2023-04-08', '23010102', '23940201'),
('23040805', 9, 1, '2023-04-08', '23010104', '23970201'),
('23040806', 10, 1, '2023-04-08', '23010103', '23080201'),
('23040807', 10, 1, '2023-04-08', '23010103', '23080201'),
('23040808', 10, 1, '2023-04-08', '23010102', '23080201'),
('23040809', 11, 3, '2023-04-08', '23010110', '23930201');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` char(8) NOT NULL,
  `tanggal_transaksi` date NOT NULL,
  `total_bayar` int(5) NOT NULL,
  `id_pesanan` char(8) NOT NULL,
  `id_pegawai` char(8) NOT NULL,
  `id_pelanggan` char(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `tanggal_transaksi`, `total_bayar`, `id_pesanan`, `id_pegawai`, `id_pelanggan`) VALUES
('23001101', '2023-04-07', 15000, '23040701', '20020401', '23170201'),
('23001102', '2023-04-07', 15000, '23040702', '20020401', '23170201'),
('23002201', '2023-04-07', 79000, '23040703', '20020402', '23110201'),
('23002202', '2023-04-07', 79000, '23040704', '20020402', '23110201'),
('23002203', '2023-04-07', 79000, '23040705', '20020402', '23110201'),
('23003101', '2023-04-07', 18000, '23040706', '20020402', '23910101'),
('23004201', '2023-04-07', 115000, '23040707', '20020402', '23130101'),
('23004202', '2023-04-07', 115000, '23040708', '20020402', '23130101'),
('23005101', '2023-04-07', 13000, '23040709', '20020401', '23060201'),
('23005102', '2023-04-07', 13000, '23040710', '20020401', '23060201'),
('23006201', '2023-04-07', 25000, '23040711', '20020402', '23100101'),
('23007101', '2023-04-08', 116000, '23040801', '20020401', '23780201'),
('23007102', '2023-04-08', 116000, '23040802', '20020401', '23780201'),
('23008201', '2023-04-08', 15000, '23040803', '20020401', '23940201'),
('23008202', '2023-04-08', 15000, '23040804', '20020402', '23940201'),
('23009101', '2023-04-08', 18000, '23080405', '20020401', '23970201'),
('23010201', '2023-04-08', 6000, '23040806', '20020402', '23970201'),
('23011101', '2023-04-08', 13000, '23040807', '20020401', '23080101'),
('23011102', '2023-04-08', 13000, '23040808', '20020401', '23080101'),
('23012201', '2023-04-08', 6000, '23040809', '20020402', '23930201');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `data`
--
ALTER TABLE `data`
  ADD PRIMARY KEY (`id_data`),
  ADD KEY `id_pegawai` (`id_pegawai`),
  ADD KEY `id_obat` (`id_obat`);

--
-- Indeks untuk tabel `miliki`
--
ALTER TABLE `miliki`
  ADD PRIMARY KEY (`id_miliki`),
  ADD KEY `id_obat` (`id_obat`),
  ADD KEY `id_pesanan` (`id_pesanan`);

--
-- Indeks untuk tabel `obat`
--
ALTER TABLE `obat`
  ADD PRIMARY KEY (`id_obat`),
  ADD KEY `id_pegawai` (`id_pegawai`);

--
-- Indeks untuk tabel `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`id_pegawai`);

--
-- Indeks untuk tabel `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indeks untuk tabel `pesanan_obat`
--
ALTER TABLE `pesanan_obat`
  ADD PRIMARY KEY (`id_pesanan`),
  ADD KEY `id_obat` (`id_obat`),
  ADD KEY `id_pelanggan` (`id_pelanggan`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_pesanan` (`id_pesanan`),
  ADD KEY `id_pegawai` (`id_pegawai`),
  ADD KEY `id_pelanggan` (`id_pelanggan`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `data`
--
ALTER TABLE `data`
  ADD CONSTRAINT `data_ibfk_1` FOREIGN KEY (`id_pegawai`) REFERENCES `pegawai` (`id_pegawai`),
  ADD CONSTRAINT `data_ibfk_2` FOREIGN KEY (`id_obat`) REFERENCES `obat` (`id_obat`);

--
-- Ketidakleluasaan untuk tabel `miliki`
--
ALTER TABLE `miliki`
  ADD CONSTRAINT `miliki_ibfk_1` FOREIGN KEY (`id_obat`) REFERENCES `obat` (`id_obat`),
  ADD CONSTRAINT `miliki_ibfk_2` FOREIGN KEY (`id_pesanan`) REFERENCES `pesanan_obat` (`id_pesanan`);

--
-- Ketidakleluasaan untuk tabel `obat`
--
ALTER TABLE `obat`
  ADD CONSTRAINT `obat_ibfk_1` FOREIGN KEY (`id_pegawai`) REFERENCES `pegawai` (`id_pegawai`);

--
-- Ketidakleluasaan untuk tabel `pesanan_obat`
--
ALTER TABLE `pesanan_obat`
  ADD CONSTRAINT `pesanan_obat_ibfk_1` FOREIGN KEY (`id_obat`) REFERENCES `obat` (`id_obat`),
  ADD CONSTRAINT `pesanan_obat_ibfk_2` FOREIGN KEY (`id_pelanggan`) REFERENCES `pelanggan` (`id_pelanggan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
