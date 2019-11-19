# Task Basic SIEMO Multipolar

Repository ini digunakan untuk membuat kode untuk 7 task basic Divisi SIEMO di Multipolar dengan bahasa Java.

[![license](https://img.shields.io/github/license/mashape/apistatus.svg)]()

## 1 - Basic

Aplikasi yang dibuat pada task basic berfungsi untuk melakukan filter kata berulang yang tersusun secara berurutan selain kata ulang. Selain itu, jumlah perulangan tiap kata dan indeks pertama munculnya kata yang diulang juga diperlihatkan pada kolom `Kata Berulang`.

Sebelum kode pada program ini dijalankan, perlu dilakukan pengaturan MySQL, pembuatan database, dan pembuatan tabel. Adapun sintaks yang perlu dimasukkan ke MySQL terlebih dahulu adalah:

```
CREATE DATABASE `multipolar_basic`;

USE `multipolar_basic`;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+07:00";

CREATE TABLE `basic` (
  `id` int(10) NOT NULL,
  `input` varchar(250) NOT NULL,
  `output` varchar(250) NOT NULL,
  `processing_date` date NOT NULL DEFAULT current_timestamp(),
  `repeated_words` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `repetition` (
  `sentence_id` int(10) NOT NULL,
  `word` varchar(250) NOT NULL,
  `num_repetitions` int(10) NOT NULL,
  `first_index` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE `basic`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `basic`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;
COMMIT;
```

Setelah itu, kode bisa dijalankan pada kelas InputStringServlet. Aplikasi servlet akan muncul pada URL http://localhost:8080/. Demonstrasi dari aplikasi ini dapat dilihat pada animasi di bawah ini.

![Peek recording itself](https://github.com/cyberboyz/task-basic-siemo-multipolar/blob/master/asset/1-basic.gif)

## 2 - Intermediate

Aplikasi yang dibuat pada task intermediate berfungsi untuk mencatat informasi karyawan (`nama`, `id`, `tanggal_masuk`, `golongan`, `gaji_per_bulan`). Fitur yang terdapat pada aplikasi ini adalah:
- Input golongan dan gaji masing-masing golongan
- Input data karyawan
- Tampilan data karyawan urut sesuai gaji / tanggal masuk

Sebelum kode pada program ini dijalankan, perlu dilakukan pengaturan MySQL, pembuatan database, dan pembuatan tabel. Adapun sintaks yang perlu dimasukkan ke MySQL terlebih dahulu adalah:

```
CREATE DATABASE `multipolar_intermediate`;

USE `multipolar_intermediate`;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+07:00";

CREATE TABLE `employee` (
  `id` int(50) NOT NULL,
  `name` varchar(250) NOT NULL,
  `entry_date` date NOT NULL,
  `employee_group` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `employee_group` (
  `employee_group` varchar(50) NOT NULL,
  `monthly_salary` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE `employee`
  ADD KEY `employee_group` (`employee_group`);

ALTER TABLE `employee_group`
  ADD PRIMARY KEY (`employee_group`);

ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`employee_group`) REFERENCES `employee_group` (`employee_group`);
COMMIT;
```

Setelah itu, kode bisa dijalankan pada kelas EmployeeServlet. Aplikasi servlet akan muncul pada URL http://localhost:8080/. Demonstrasi dari aplikasi ini dapat dilihat pada animasi di bawah ini.

![Peek recording itself](https://github.com/cyberboyz/task-basic-siemo-multipolar/blob/master/asset/2-intermediate.gif)

## 3 - Advanced

Aplikasi yang dibuat pada task advanced adalah aplikasi servlet karyawan yang memanggil aplikasi servlet insentif untuk melakukan perhitungan insentif. 

Sebelum kode pada program ini dijalankan, perlu dilakukan pengaturan MySQL, pembuatan database, dan pembuatan tabel. Adapun sintaks yang perlu dimasukkan ke MySQL terlebih dahulu adalah:

```
CREATE DATABASE `multipolar_advanced`;

USE `multipolar_advanced`;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+07:00";

CREATE TABLE `employee` (
  `id` int(50) NOT NULL,
  `name` varchar(250) NOT NULL,
  `entry_date` date NOT NULL,
  `employee_group` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `employee_group` (
  `employee_group` varchar(50) NOT NULL,
  `monthly_salary` int(50) NOT NULL,
  `incentive_percentage` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE `employee`
  ADD KEY `employee_group` (`employee_group`);

ALTER TABLE `employee_group`
  ADD PRIMARY KEY (`employee_group`);

ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`employee_group`) REFERENCES `employee_group` (`employee_group`);
COMMIT;
```

Kode bisa dijalankan pada kelas EmployeeServlet di aplikasi pertama dan kelas IncentiveServlet di aplikasi kedua. Setelah itu, aplikasi bisa diakses melalui URL http://localhost:8080/. Demonstrasi dari aplikasi ini dapat dilihat pada animasi di bawah ini.

![Peek recording itself](https://github.com/cyberboyz/task-basic-siemo-multipolar/blob/master/asset/3-advanced.gif)

## 4 - Socket

Aplikasi socket yang dibuat ada 3 macam, yaitu:
- Client mengirim string ke server kemudian server menulis ke file
- Client mengirim file text ke server yang berisi 10 baris data (`nama`, `golongan`, `gaji`). Selanjutnya data tersebut disimpan server ke database
- Aplikasi multithread di mana client mengirim data string random dari 4 thread ke server

### Task 1 

Pada task 1, server bisa dijalankan pada kelas SocketServer sedangkan client bisa dijalankan pada kelas ClientServer. Setelah itu, masukkan string tertentu pada command line saat menjalankan ClientServer. Hasil yang didapatkan adalah string tersebut dikirimkan ke server dan disimpan ke dalam file text `message_from_client.txt`.

### Task 2

Sebelum menjalankan task 2, kita perlu membuat database untuk menyimpan data yang dikirim oleh client. Adapun sintaks SQL untuk pengaturan database, pembuatan database, dan pembuatan tabel adalah:

```
CREATE DATABASE `multipolar_socket`;

USE `multipolar_socket`;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

CREATE TABLE `employee` (
  `name` varchar(250) NOT NULL,
  `emp_group` varchar(50) NOT NULL,
  `monthly_salary` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```

Server bisa dijalankan pada kelas FileServer sedangkan client bisa dijalankan pada kelas FileClient. Setelah itu, file text yang dikirimkan client ke server akan disimpan di database.

### Task 3

Aplikasi ini bisa dijalankan dengan menjalankan server pada kelas MultithreadedSocketServer dan client pada kelas DemoMultithreadedSocketClient. Hasil yang didapatkan adalah client menerima berbagai string random dari 4 buah thread client secara tidak berurutan.

## Pengujian dengan Postman

Untuk pengujian melalui Postman dilakukan dengan menggunakan <your_url>/v1/<nama_resource>. Adapun list dari resource yang dapat diakses adalah :

| Name                  | URL                                | HTTP Method  |
| ----------------------|:----------------------------------:|:------------:|
| Register User         | `<your_url>/v1/register`           |   **POST**   |
| Login User            | `<your_url>/v1/login`              |   **POST**   |
| Logout User           | `<your_url>/v1/logout`             |   **GET**    |
| Get All Post          | `<your_url>/v1/posts`              |   **GET**    |
| Get Post Detail       | `<your_url>/v1/posts/<id_post>`    |   **GET**    |
| Update Post           | `<your_url>/v1/posts/<id_post>`    |   **PUT**    |
| Delete Post           | `<your_url>/v1/posts/<id_post>`    |   **DELETE** |
| Show All Users        | `<your_url>/v1/profile`            |   **GET**    |
| Show Profile Detail   | `<your_url>/v1/profile/<id_user>`  |   **GET**    |
| Update Profile Detail | `<your_url>/v1/profile/<id_user>`  |   **PUT**    |
| Delete Profile        | `<your_url>/v1/profile/<id_user>`  |   **DELETE** |
| Add Category          | `<your_url>/v1/categories`         |   **POST**   |
| Show All Categories   | `<your_url>/v1/categories`         |   **GET**    |
| Show All Posts Based on Categories | `<your_url>/v1/categories`         |   **GET**    |
| Show All Posts Based on Several Categories| `<your_url>/v1/3categoriesposts` |   **POST** |
| Add Bookmark          | `<your_url>/v1/bookmarks`          |   **POST**   |
| Delete Bookmark       | `<your_url>/v1/bookmarks/<id_post>`|   **DELETE** |
| Show Own Bookmarks    | `<your_url>/v1/bookmarks`          |   **GET**    |
| Show Own Profile      | `<your_url>/v1/ownprofile`         |   **GET**    |
| Show Own Posts        | `<your_url>/v1/ownposts`           |   **GET**    |
| Add Categories by User| `<your_url>/v1/owncategory`        |   **POST**   |
| Update Categories by User| `<your_url>/v1/owncategory`     |   **PUT**    |
| Delete Categories by User| `<your_url>/v1/owncategory`     |   **DELETE** |
| Get All Posts Based on User| `<your_url>/v1/profile/<id_user>/posts` |   **GET** |

## Tools

- Java
- MySQL
- IDE (IntelliJ IDEA)
