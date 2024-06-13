-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 12 Jun 2024 pada 18.47
-- Versi server: 10.4.27-MariaDB
-- Versi PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hpvivo`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `datahp`
--

CREATE TABLE `datahp` (
  `idhp` int(10) NOT NULL,
  `namhp` varchar(25) NOT NULL,
  `harga` int(15) NOT NULL,
  `stok` int(3) NOT NULL,
  `penyimpanan` varchar(7) NOT NULL,
  `keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `datahp`
--

INSERT INTO `datahp` (`idhp`, `namhp`, `harga`, `stok`, `penyimpanan`, `keterangan`) VALUES
(1, 'VIVO Y22', 3000000, 0, '6/128', 'Prosessor : Mediatek Helio G85(gaming prosesor)\r\nRam :6/128 \r\nCamera :50MP+2MP/depan:8MP\r\nBaterai:5000 mAh'),
(2, 'VIVO Y35', 2899000, 6, '8/128', 'Prosessor : Snapdrgon 680\r\nRam: 8/128\r\nCamera: 50MP+2MP/depan:16MP\r\nBaterai: 5000mAh\r\n'),
(3, 'VIVO Y02', 1299000, 10, '3/32', 'Prosessor : Mediatek Helio p22\r\nRam: 3/32\r\nCamera: 8MP/depan:5MP\r\nBaterai: 5000mAh'),
(4, 'VIVO Y16', 1550000, 15, '3/32', 'Prosessor : Mediatek Helio p35\r\nRam: 8/128\r\nCamera: 13MP+2MP/depan:5MP\r\nBaterai: 5000mAh'),
(5, 'VIVO Y75', 3199000, 8, '8/128', 'Prosessor : Mediatek Dimensity 700(7nm)\r\nRam: 8/128\r\nCamera: 50MP+2MP/depan:16MP\r\nBaterai: 5000mAh'),
(6, 'VIVO Y21', 1890000, 7, '4/64', 'Prosessor Mediatek Helio p35(12nm)\r\nRam: 4/64\r\nCamera: 13MP+2MP/depan:8MP\r\nBaterai: 5000mAh'),
(11, 'VIVO X80', 9200000, 8, '12/256', 'Prosessor : Mediatek Dimensity \nRam : 12/256\nCamera : 50+12MP/depan : 32MP\nBaterai : 4500mAh'),
(12, 'VIVO X80 pro', 15999000, 4, '12/256', 'Prosessor : Snapdragon 8 gen 1\nRam :12/256\nCamera :50+8MP/depan :32 MP\nBaterai :4700 mAh'),
(13, 'VIVO X50', 6500000, 6, '8/128', 'Snapdragon 730\n8/128\nbatre 4200 mAh\ncamera 32MP/48 MP\n'),
(21, 'VIVO V27', 5399000, 15, '8/256', 'Prosessor:  Mediatek Dimensity 7200(nm)\nRam: 8/256\nCamera: 50MP/depan:50MP\nBaterai:4600mAh'),
(22, 'VIVO V25e', 3475000, 10, '8/128', 'Prosessor:  Mediatek Helio G99\nRam: 8/256\nCamera:64MP+2MP/depan:32MP\nBaterai:4500mAh'),
(23, 'VIVO V25pro', 7200000, 6, '12/256', 'Prosessor:  MediaTek Dimensity 1300(6nm)\nRam: 12/256\nCamera:64MP+12MP/depan:32MP\nBaterai:4830mAh'),
(40, 'OPPO A16', 1199000, 4, '3/32', 'Prosessor :MediaTek Helio G35\nAI Triple Camera 8MP Front + 13+2+2 MP rea\nBaterai 500mAh'),
(41, 'OPPO Reno7 Z5G', 3599000, 9, '8/128', 'Prosessor : Qualcomm Snapdragon 695\nKamera depan 16MP\nKamera belakang 64MP\nBaterai 4385 mAh'),
(42, 'OPPO Reno7 5G', 4499000, 7, '8/256', 'MediaTek Dimensity 900\n64MP\n32MP\nsudut lebar : f/ 25 FOV 118,9\n2 x 2200 mah'),
(43, 'OPPO Find N2 Flip', 1499900, 5, '8/56', 'Prosessor : Dimensity 9000+(DX-1Pro)\nKamera belakang  50MP\nKamera depan 33 MP\nBaterai 3040 mAh'),
(44, 'OPPO A18', 14999000, 10, '4/128', 'Prosessor :MediaTek Helio G85\nKamera Depan 5MP\nLKamera Belakang 8MP\nBaterai 5000mAh'),
(45, 'OPPO A98 5G', 4299000, 10, '8/256', 'Prosessor : Qualcomm Snapdragon 695\nKamera Depan 32MP\nKamera Belakang 64 MP\nBaterai 5000mAh'),
(46, 'OPPO Reno10 Pro 5G', 7999000, 12, '12/256', 'Prosessor : Qualcomm Snapdragon 778G\nKamera Depan 32MP\nKamera Belakang 64MP\nBaterai 4460 mAh(Rated) 4600(Typical)\npengisian cepat 80W'),
(47, 'OPPO Find N3 Flip', 15999000, 5, '12/256', 'Prosessor : Qualcomm Kryo 880 8 inti\nKamera Utama Belakang 48MP\nKamera Depan 32MP\nBaterai 4805mAh\n'),
(48, 'OPPO A78', 3399000, 7, '8/256', 'Prosessor : Qualcomm Snapdragon 680\nKamera Depan 8MP\nKamera Belakang 50MP\nBaterai 5000mAh\n'),
(49, 'OPPO Find X5 Pro 5G', 13999000, 4, '12/256', 'Prosessor :Qualcomm Snapdragon 8 Gen \nKamera Depan 32MP\nKamera Belakang50MP\nBaterai 5000mAh'),
(50, 'OPPO A54', 2148000, 8, '6/128', 'Prosessor : MediaTek Helio P35\nKamera Depan 16MP\nKamera Belakang 13MP\nBaterai 5000mAh'),
(51, 'OPPO A88', 2589000, 8, '8/128', 'Prosessor :Qualcomm Snapdragon 680\nKamera Depan 8MP\nKamera Belakang 50MP\nBaterai 4880mAh'),
(87468, 'VIVO Y21', 50000, 5, '6/128', 'Mediatek');

-- --------------------------------------------------------

--
-- Struktur dari tabel `login`
--

CREATE TABLE `login` (
  `username` varchar(25) NOT NULL,
  `password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('aman', 'aman123'),
('AMAN', '321'),
('aman', '321'),
('aman', '456'),
('aman', '90'),
('nama', '89'),
('nama', '22'),
('aman', '1234'),
('aman', '12345'),
('aman', '123456'),
('aman', '321'),
('aman', '123'),
('aman', '4567'),
('aman', '789'),
('aman', '890'),
('admin', '123');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembeli`
--

CREATE TABLE `pembeli` (
  `idpembeli` int(11) NOT NULL,
  `namapembeli` varchar(25) NOT NULL,
  `alamatpembeli` text NOT NULL,
  `nohp` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pembeli`
--

INSERT INTO `pembeli` (`idpembeli`, `namapembeli`, `alamatpembeli`, `nohp`) VALUES
(1, 'Aman Hutabrata', 'Tarutung', '082226762789'),
(2, 'amann', 'Tarutung', '94857'),
(3, 'eben', 'blabala', '95985'),
(6, 'Aman Hutabarat', 'Prosessor : Mediatek Helio G85(gaming prosesor)\r\nRam :6/128 \r\nCamera :50MP+2MP/depan:8MP\r\nBaterai:5000 mAh', '0823'),
(65, 'sunita', 'Rantau', '08737'),
(78, 'romeo', 'Kaban Jahe', '03884978'),
(89, 'aman', 'Tarutung', '0812757158'),
(523, 'Frans', 'MuaraTakus', '087796162323'),
(765, 'aman Hutabarat', 'Tarutung,Taput', '2876174'),
(767, 'ddd', 'trr', '0878'),
(788, 'aman', 'tarutung', '09774'),
(847, 'amnn', 'tarutung', '09767'),
(874, 'aman', 'trt', '09867'),
(876, 'hutabarat', 'Tarutung', '08823123'),
(877, 'aman', 'Tarutung', '09858'),
(901, 'aman', 'Tarutung\nkab taput', '7426651'),
(972, 'aman', 'tarutung', '0777'),
(4947, 'amn', 'medan', '086663'),
(8888, 'aman', 'Tarutung', '08362'),
(9784, 'aman', 'Tarutung', '082375448129'),
(9864, 'aman', 'trt', '903'),
(9974, 'aman', 'trtt', '04886'),
(77765, 'aman', 'tarutung', '948638'),
(847875, 'ah', 'Taryt', '08873'),
(876086726, 'amann', 'Tarutung', '');

-- --------------------------------------------------------

--
-- Struktur dari tabel `penjualan`
--

CREATE TABLE `penjualan` (
  `nofak` int(11) NOT NULL,
  `idpembeli` int(11) NOT NULL,
  `idhp` int(10) NOT NULL,
  `jumlahbeli` int(10) NOT NULL,
  `tanggal` varchar(35) NOT NULL,
  `total` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `penjualan`
--

INSERT INTO `penjualan` (`nofak`, `idpembeli`, `idhp`, `jumlahbeli`, `tanggal`, `total`) VALUES
(1, 1, 1, 1, '', 3000000),
(3, 65, 1, 2, '', 6000000),
(18, 765, 6, 2, '', 3780000),
(19, 876086726, 5, 1, 'dd MMM yy', 3199000),
(20, 4947, 47, 1, 'dd MMM yy', 15999000),
(21, 767, 40, 1, 'dd MMM yy', 1199000),
(22, 847875, 40, 1, 'dd MMM yy', 1199000),
(23, 9974, 1, 1, 'dd MMM yy', 3000000),
(24, 972, 1, 1, 'dd MMM yy', 3000000),
(25, 9784, 40, 1, 'dd MMM yy', 1199000),
(26, 77765, 51, 1, 'dd MMM yy', 2589000),
(27, 874, 1, 1, 'Tue Jan 23 16:31:13 ICT 2024', 3000000),
(28, 847, 1, 2, 'Wed Jan 24 00:15:35 ICT 2024', 6000000),
(29, 788, 41, 1, 'Wed Jan 24 12:21:45 ICT 2024', 3599000);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `datahp`
--
ALTER TABLE `datahp`
  ADD PRIMARY KEY (`idhp`);

--
-- Indeks untuk tabel `pembeli`
--
ALTER TABLE `pembeli`
  ADD PRIMARY KEY (`idpembeli`);

--
-- Indeks untuk tabel `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`nofak`),
  ADD KEY `idpembeli` (`idpembeli`),
  ADD KEY `idhp` (`idhp`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `penjualan`
--
ALTER TABLE `penjualan`
  MODIFY `nofak` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `penjualan`
--
ALTER TABLE `penjualan`
  ADD CONSTRAINT `penjualan_ibfk_1` FOREIGN KEY (`idpembeli`) REFERENCES `pembeli` (`idpembeli`),
  ADD CONSTRAINT `penjualan_ibfk_2` FOREIGN KEY (`idhp`) REFERENCES `datahp` (`idhp`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
