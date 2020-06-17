-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 12 Des 2019 pada 14.31
-- Versi server: 10.4.6-MariaDB
-- Versi PHP: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_project2019`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `id_admn` int(11) NOT NULL,
  `usr_admn` varchar(20) NOT NULL,
  `pass_admn` varchar(32) NOT NULL,
  `nm_lngkp_admn` varchar(50) NOT NULL,
  `almt_admn` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`id_admn`, `usr_admn`, `pass_admn`, `nm_lngkp_admn`, `almt_admn`) VALUES
(1, 'mahendra', 'mahendra123', 'Dwi Mahendra Putra', 'Rt02/ Rw01 Ds. Parakan Kec. Trenggalek');

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `kode_barang` varchar(5) NOT NULL,
  `nama_barang` varchar(20) NOT NULL,
  `jumlah_barang` int(3) NOT NULL,
  `Harga` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`kode_barang`, `nama_barang`, `jumlah_barang`, `Harga`) VALUES
('B0001', 'Buku Tulis', 36, 4000),
('B0002', 'Buku Gambar', 36, 6000),
('B0003', 'Kertas Portofolio', 380, 250),
('B0004', 'Bolpoin Snowman', 90, 2500),
('B0005', 'Pensil 2B', 95, 2500),
('B0006', 'Tipe X', 40, 3000),
('B0007', 'Penghapus', 30, 1500),
('B0008', 'Bolpoin Pilot', 100, 2000),
('B0009', 'Pisang Goreng', 50, 500),
('B0010', 'Tempe Goreng', 100, 500);

-- --------------------------------------------------------

--
-- Struktur dari tabel `guru`
--

CREATE TABLE `guru` (
  `nip_guru` varchar(50) NOT NULL,
  `usrnm_guru` varchar(50) NOT NULL,
  `pass_guru` varchar(32) NOT NULL,
  `nm_lngkp_guru` varchar(50) NOT NULL,
  `almt_guru` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `guru`
--

INSERT INTO `guru` (`nip_guru`, `usrnm_guru`, `pass_guru`, `nm_lngkp_guru`, `almt_guru`) VALUES
('123456789', 'gilang', 'gilang123', 'Gilang Saputra', 'Jalan Seloputo No 69 Blitar'),
('727732736', 'aditya', 'aditya123', 'Aditya Kukila', 'Perumahan Permata Jingga'),
('987654321', 'jonathan', 'jonathan123', 'Jonathan Issac Dirgantara', 'Perumahan Hijau Mekar Sari');

-- --------------------------------------------------------

--
-- Struktur dari tabel `keuangan`
--

CREATE TABLE `keuangan` (
  `id` int(11) NOT NULL,
  `kas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `keuangan`
--

INSERT INTO `keuangan` (`id`, `kas`) VALUES
(1, 5250000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `murid`
--

CREATE TABLE `murid` (
  `usrnm_murid` varchar(20) NOT NULL,
  `pass_murid` varchar(50) NOT NULL,
  `nm_lngkp_murid` varchar(50) NOT NULL,
  `almt_murid` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `murid`
--

INSERT INTO `murid` (`usrnm_murid`, `pass_murid`, `nm_lngkp_murid`, `almt_murid`) VALUES
('agustinus', 'agustinus123', 'Agustinus Aditya', 'Jalan Raya Kediri - Surabaya No 45'),
('andiko', 'andiko123', 'Andiko Oktavianto', 'Perumahan Permata Jingga');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembelian`
--

CREATE TABLE `pembelian` (
  `kode_pembelian` varchar(6) NOT NULL,
  `kode_barang` varchar(11) NOT NULL,
  `nama_pembeli` varchar(50) NOT NULL,
  `jumlah` int(6) NOT NULL,
  `harga` int(6) NOT NULL,
  `uang` int(6) NOT NULL,
  `kembalian` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pembelian`
--

INSERT INTO `pembelian` (`kode_pembelian`, `kode_barang`, `nama_pembeli`, `jumlah`, `harga`, `uang`, `kembalian`) VALUES
('P0001', 'B0001', 'Dwi Mahendra Putra', 2, 8000, 10000, 2000),
('P0002', 'B0001', 'Dwi Mehendra Putra', 9, 36000, 40000, 4000),
('P0003', 'B0005', 'Dwi Mehendra Putra', 5, 12500, 15000, 2500),
('P0004', 'B0003', 'Gilang Saputra', 99, 24750, 25000, 250),
('P0005', 'B0003', '', 20, 5000, 5000, 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `peminjaman`
--

CREATE TABLE `peminjaman` (
  `kode_peminjaman` varchar(11) NOT NULL,
  `nip_guru` varchar(11) NOT NULL,
  `pinjaman` int(11) NOT NULL,
  `pengembalian` int(11) NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `peminjaman`
--

INSERT INTO `peminjaman` (`kode_peminjaman`, `nip_guru`, `pinjaman`, `pengembalian`, `total`) VALUES
('S0001', '123456789', 1000000, 1000000, 0),
('S0002', '987654321', 250000, 0, 250000),
('S0003', '727732736', 0, 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admn`);

--
-- Indeks untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`kode_barang`);

--
-- Indeks untuk tabel `guru`
--
ALTER TABLE `guru`
  ADD PRIMARY KEY (`nip_guru`),
  ADD UNIQUE KEY `usrnm_guru` (`usrnm_guru`);

--
-- Indeks untuk tabel `keuangan`
--
ALTER TABLE `keuangan`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `murid`
--
ALTER TABLE `murid`
  ADD UNIQUE KEY `usrnm_murid` (`usrnm_murid`);

--
-- Indeks untuk tabel `pembelian`
--
ALTER TABLE `pembelian`
  ADD UNIQUE KEY `kode_pembelian` (`kode_pembelian`);

--
-- Indeks untuk tabel `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`kode_peminjaman`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admn` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `keuangan`
--
ALTER TABLE `keuangan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
