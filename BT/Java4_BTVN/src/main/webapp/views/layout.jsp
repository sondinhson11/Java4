<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/17/2023
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/Java4_BTVN_war_exploded/css/bootstrap.min.css" />

</head>
<body>
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
<%--                <a class="nav-link active" aria-current="page" href="#">Home</a>--%>
<%--                <a class="nav-link" href="/Java4_BTVN_war_exploded/khach-hang/index">Khách Hàng</a>--%>
<%--                <a class="nav-link" href="/Java4_BTVN_war_exploded/nhan-vien/index">Nhân Viên</a>--%>
<%--                <a class="nav-link" href="/Java4_BTVN_war_exploded/chitiet-sp/index">Chi Tiết Sản Phẩm</a>--%>
<%--                <a class="nav-link" href="/Java4_BTVN_war_exploded/san-pham/index">Sản Phẩm </a>--%>
<%--                <a class="nav-link" href="/Java4_BTVN_war_exploded/dong-sp/index">Dòng Sản Phẩm </a>--%>
<%--                <a class="nav-link" href="/Java4_BTVN_war_exploded/nsx/index">Nhà Sản Xuất </a>--%>
<%--                <a class="nav-link" href="/Java4_BTVN_war_exploded/mau-sac/index">Màu Sắc </a>--%>
<%--                <a class="nav-link" href="/Java4_BTVN_war_exploded/chuc-vu/index">Chức Vụ </a>--%>
<%--                <a class="nav-link" href="/Java4_BTVN_war_exploded/cua-hang/index">Cửa Hàng </a>--%>
            </div>
        </div>
    </div>
</nav>

<div class="row mt-3" style="min-height: 600px;">
    <div class="text-bg-secondary col-3">
        <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
            <a class="nav-link" id="settings-tab" data-toggle="tab"  href="/Java4_BTVN_war_exploded/khach-hang/index" role="tab" aria-controls="settings" aria-selected="true">Khách Hàng</a>
            <a class="nav-link" href="/Java4_BTVN_war_exploded/nhan-vien/index">Nhân Viên</a>
            <a class="nav-link" href="/Java4_BTVN_war_exploded/chitiet-sp/index">Chi Tiết Sản Phẩm</a>
            <a class="nav-link" href="/Java4_BTVN_war_exploded/san-pham/index">Sản Phẩm </a>
            <a class="nav-link" href="/Java4_BTVN_war_exploded/dong-sp/index">Dòng Sản Phẩm </a>
            <a class="nav-link" href="/Java4_BTVN_war_exploded/nsx/index">Nhà Sản Xuất </a>
            <a class="nav-link" href="/Java4_BTVN_war_exploded/mau-sac/index">Màu Sắc </a>
            <a class="nav-link" href="/Java4_BTVN_war_exploded/chuc-vu/index">Chức Vụ </a>
            <a class="nav-link" href="/Java4_BTVN_war_exploded/cua-hang/index">Cửa Hàng </a>
        </div>
    </div>
    <div class="bg-light col-9">
        <jsp:include page="${ view }" />
    </div>
</div>
<div class="row mt-3 bg-dark ms-0">Footer</div>

<script src="/Java4_BTVN_war_exploded/js/bootstrap.min.js"></script>

</body>
</html>
