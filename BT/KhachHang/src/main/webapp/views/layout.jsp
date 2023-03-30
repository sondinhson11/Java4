<%--
  Created by IntelliJ IDEA.
  User: thean
  Date: 21/03/2023
  Time: 2:40 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#" style="font-size: 30px ; font-weight: bold">IT17311</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarNav" aria-controls="navbarNav"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

    </div>
</nav>

<div class="row mt-10" style="min-height: 500px;">
    <div class="col-3 bg-warning" >
        <ul class="navbar-nav" style="margin-left: 40px">
        <li class="nav-item" >
            <a class="nav-link active" aria-current="page" href="#" style="font-weight: bold">Trang chủ</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/KhachHang_war_exploded/khach-hang/index"  style="font-weight: bold">Khách hàng</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/KhachHang_war_exploded/san-pham/index"  style="font-weight: bold">Sản phẩm</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/KhachHang_war_exploded/chuc-vu/index"  style="font-weight: bold">Chức Vụ</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/KhachHang_war_exploded/cua-hang/index"  style="font-weight: bold">Cửa Hàng</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/KhachHang_war_exploded/mau-sac/index"  style="font-weight: bold">Màu Sắc</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/KhachHang_war_exploded/nhan-vien/index"  style="font-weight: bold">Nhân Viên</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/KhachHang_war_exploded/nsx/index"  style="font-weight: bold">NSX</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/KhachHang_war_exploded/chitiet-sp/index"  style="font-weight: bold">Chi Tiết Sản Phẩm</a>
        </li>
       </ul>
    </div>
    <div class="col-9" style="border: 5px solid #808080;">
        <div style="margin-top: 20px"><jsp:include page="${ view }"  /></div>
    </div>
</div>

<div class="row m-0 mt-10 bg-dark text-white">Footer</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
