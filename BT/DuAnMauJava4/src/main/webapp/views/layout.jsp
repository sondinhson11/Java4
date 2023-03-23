<%--
  Created by IntelliJ IDEA.
  User: tiennh
  Date: 3/21/23
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/DuAnMauJava4_war_exploded/css/bootstrap.min.css"/>
</head>
<body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-dark " style="background-color: #192041;color: white">
                <div class="container">
                    <a class="navbar-brand" href="#!/">
                        <img style="height: 80px" src="../img/logo.png" alt=""/>
                    </a>
                    <button
                            class="navbar-toggler"
                            type="button"
                            data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent"
                            aria-controls="navbarSupportedContent"
                            aria-expanded="false"
                            aria-label="Toggle navigation"
                    >
                        <span class="bi bi-list"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" href="/DuAnMauJava4_war_exploded/khachhang/index">Khách hàng</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/DuAnMauJava4_war_exploded/sanpham/index">Sản phẩm</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/DuAnMauJava4_war_exploded/chucvu/index">Chức Vụ</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/DuAnMauJava4_war_exploded/cuahang/index">Cửa Hàng</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/DuAnMauJava4_war_exploded/nsx/index">Nhà Sản Xuất</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/DuAnMauJava4_war_exploded/mausac/index">Màu Sắc</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/DuAnMauJava4_war_exploded/dongSP/index">Dòng Sản Phẩm</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/DuAnMauJava4_war_exploded/nhanvien/index">Nhân Viên</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/DuAnMauJava4_war_exploded/ctsanpham/index">Chi Tiết Sản Phẩm</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
        <div class="row mt-10" style="min-height: 500px;">
            <div class="col-3">
                <img src="../img/siderbar.png" style="width: 105%;height: 100%">
            </div>
            <div class="col-9" style="background: white">
                <jsp:include page="${ view }"/>
            </div>
        </div>
        <footer class="text-center text-lg-start py-3 fp" style="background-color: #192041;color: white">
            <section class="">
                <div class="container text-center text-md-start mt-5">
                    <div class="row mt-3">
                        <div class="col-md-4 col-lg-4 col-xl-4 mx-auto mb-4">
                            <h6 class="text-uppercase fw-bold mb-4">
                                <img src="../img/logo2.png" height="80px"/>
                            </h6>
                        </div>

                        <div class="col-md-8 col-lg-8 col-xl-8 mx-auto mb-8">
                            <h6>THÔNG TIN LIÊN HỆ</h6>
                            <p>Văn Đình Sơn</p>
                            <p>Điện thoại: +84862521305</p>
                            <p>Email: sonvdph23054@fpt.edu.vn</p>
                        </div>

                    </div>
                </div>
            </section>

            <div
                    class="text-center py-4"
                    style="background-color: rgba(0, 0, 0, 0.05)"
            >
                © 2023 Copyright:
                <a class="text-reset fw-bold" href="https://mdbootstrap.com/"
                >sonvdph23054@fpt.edu.vn</a
                >
            </div>
        </footer>
<script src="/DuAnMauJava4_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
