# task-basic-siemo-multipolar

Repository ini digunakan untuk membuat kode untuk 7 task basic Divisi SIEMO di Multipolar dengan bahasa Java.

[![license](https://img.shields.io/github/license/mashape/apistatus.svg)]()

## 1 - Basic

Sebelum kode pada program ini dijalankan, perlu dilakukan pengaturan MySQL, pembuatan database, dan pembuatan tabel. Adapun kode yang bisa dimasukkan ke MySQL adalah:
```
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+07:00";

CREATE DATABASE `basic1string`;

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

Setelah itu, kode bisa dijalankan pada kelas InputStringServlet. Aplikasi servlet akan muncul pada URL http://localhost:8080/.

![Peek recording itself](https://github.com/cyberboyz/task-basic-siemo-multipolar/blob/master/asset/1-basic.gif)

Pada project ini, cloud yang digunakan adalah Heroku. Untuk unggah aplikasi ke heroku, daftar terlebih dahulu ke heroku lewat https://signup.heroku.com/. Kemudian install Heroku CLI melalui https://devcenter.heroku.com/articles/heroku-cli. Setelah Heroku CLI terinstall, ketikkan perintah berikut ini di command line untuk membuat aplikasi Heroku:
```
heroku create
```

Kemudian lakukan login:
```
heroku login
```

Setelah itu buat database postgresql di Heroku:
```
heroku addons:create heroku-postgresql
```

Database yang digunakan akan terdeteksi secara otomatis karena digunakan kode ```os.Getenv($DATABASE_URL)``` pada variabel ```db_url``` untuk mendeteksi URL database default yang digunakan pada Heroku.
Kemudian masukkan perintah ini untuk deploy repository ke Heroku:
```
git add . -A
git commit -m "Deploy Heroku"
git push heroku master
```

Setelah berhasil di-deploy ke Heroku, jalankan perintah ```heroku open``` untuk membuka URL tempat deploy aplikasi atau lakukan tes melalui Postman dengan menggunakan URL yang digunakan. 

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
