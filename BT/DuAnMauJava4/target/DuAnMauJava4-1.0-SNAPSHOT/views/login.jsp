<%--
  Created by IntelliJ IDEA.
  User: sondi
  Date: 04/04/2023
  Time: 7:50 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap');

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: "Poppins", sans-serif;
        }

        body {
            background: #dfe9f5;
        }

        .wrapper {
            width: 330px;
            padding: 2rem 0 1rem 0;
            margin: 50px auto;
            background: #fff;
            border-radius: 10px;
            text-align: center;
            box-shadow: 0 20px 35px rgba(0, 0, 0, 0.1);
        }

        h1 {
            font-size: 2rem;
            color: #07001f;
        }

        p {
            margin-bottom: 1.7rem;
        }

        form input {
            width: 85%;
            outline: none;
            border: none;
            background: #dfe9f5;
            padding: 12px 14px;
            margin-bottom: 10px;
            border-radius: 10px;
        }

        .recover {
            text-align: right;
            font-size: 0.8rem;
            margin: 0.2rem 1.7rem 0 0;
        }

        .recover a {
            text-decoration: none;
            color: #07001f;
        }

        button {
            font-size: 1.1rem;
            margin-top: 1rem;
            padding: 8px 0;
            border-radius: 5px;
            outline: none;
            border: none;
            width: 85%;
            background: tomato;
            color: #fff;
            cursor: pointer;
        }

        button:hover {
            background: rgba(122, 30, 30, 0.767);
        }

        .or {
            font-size: 0.8rem;
            margin-top: 1.5rem;
        }

        .icons i {
            color: #07001f;
            padding: 00.8rem 1.5rem;
            border-radius: 10px;
            margin-left: .9rem;
            font-size: 1.5rem;
            cursor: pointer;
            border: 2px solid #dfe9f5;
        }

        .icons i:hover {
            color: #fff !important;
            background: #07001f;
            transition: 1s;
        }

        .icons i:first-child {
            color: green;
        }

        .icons i:last-child {
            color: blue;
        }

        .not-member {
            font-size: 0.8rem;
            margin-top: 1.4rem;
        }

        .not-member a {
            color: tomato;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        .abc {
            margin-top: 15px;
            margin-bottom: -10px;
            color: red;
        }
    </style>
</head>

<form method="post" action="/DuAnMauJava4_war_exploded/login">
    <br>
    <center>
        <h1>Đăng Nhập</h1>
        <br>
        <div class="row">
            <div class="col-4">
            </div>
            <div class="col-4">
                <center>

                    <form action="/login/submitnv" method="post">
                        <input type="text" placeholder="Nhập mã nhân viên của bạn" name="ma">

                        <input type="password" placeholder="Mật Khẩu" name="matKhau">
                        <p class="recover">
                            <a href="#">Quên Mật Khẩu</a>
                        </p>
                        <p class="abc">${errorMessage}</p>
                        <button type="submit">Đăng Nhập</button>
                    </form>
                    <p class="or">
                        ----- hoặc có thể tiếp tục bằng -----
                    </p>
                    <div class="icons">
                        <i class="fab fa-google"></i>
                        <i class="fab fa-github"></i>
                        <i class="fab fa-facebook"></i>
                    </div>
                </center>

            </div>
            <div class="col-4">
            </div>
        </div>
        <br>
</form>