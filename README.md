# task-basic-siemo-multipolar

Repository ini digunakan untuk membuat kode untuk 7 task basic Divisi SIEMO di Multipolar dengan bahasa Java.

[![license](https://img.shields.io/github/license/mashape/apistatus.svg)]()

## 1 - Basic

Sebelum kode pada program ini dijalankan, perlu dilakukan pengaturan MySQL, pembuatan database, dan pembuatan tabel. Adapun kode yang perlu dimasukkan ke MySQL terlebih dahulu adalah:

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

Sebelum kode pada program ini dijalankan, perlu dilakukan pengaturan MySQL, pembuatan database, dan pembuatan tabel. Adapun kode yang perlu dimasukkan ke MySQL terlebih dahulu adalah:

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
