-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 24 Lip 2020, 00:27
-- Wersja serwera: 10.1.38-MariaDB
-- Wersja PHP: 7.1.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `emp`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `emp1`
--

CREATE TABLE `emp1` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `surname` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `money` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `emp1`
--

INSERT INTO `emp1` (`id`, `name`, `surname`, `email`, `money`) VALUES
(2, 'Adam', 'Nikolas', 'adam@wp.pl', 390),
(3, 'Nikola', 'Nikolas', 'nikola@wp.pl', 4530),
(12, 'Pablo', 'Wyklad', 'wy@wp.pl', 1271),
(15, 'alek', 'waflowy', 'fajny@wp.pl', 0),
(17, 'Monika', 'Kadlubek', 'kad@wp.pl', 1270),
(18, 'Monika', 'Alfa', 'kad23@wp.pl', 0),
(19, 'Ada', 'Rada', '23', 1270);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `emp1`
--
ALTER TABLE `emp1`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `emp1`
--
ALTER TABLE `emp1`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
