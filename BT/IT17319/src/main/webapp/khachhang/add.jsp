<%--
  Created by IntelliJ IDEA.
  User: sktfk
  Date: 09/03/2023
  Time: 9:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm khách hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <form method="POST" action="/khach-hang/store" >
    <div class="row mt-3">
        <div class="col-lg-6">
            <label>Mã KH:</label>
            <input type="text" class="form-control" name="ma"/>
        </div>

        <div class="col-lg-6">
            <label>Họ:</label>
            <input type="text" class="form-control" name="ho"/>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-lg-6">
            <label>Tên Đệm:</label>
            <input type="text" class="form-control" name="tenDem"/>
        </div>
        <div class="col-lg-6">
            <label>Tên:</label>
            <input type="text" class="form-control" name="ten"/>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-lg-6">
            <label>Ngày Sinh:</label>
            <input type="text" class="form-control" name="ngaySinh"/>
        </div>
        <div class="col-lg-6">
            <label>SĐT:</label>
            <input type="text" class="form-control" name="sdt"/>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-lg-6">
            <label>Địa Chỉ:</label>
            <input type="text" class="form-control" name="diaChi"/>
        </div>
        <div class="col-lg-6">
            <label>Mật Khẩu:</label>
            <input type="password" class="form-control" name="matKhau"/>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-lg-6">
            <label>Thành Phố:</label>
            <select class="form-select" aria-label="Default select example" name="thanhPho">
                <option value="Hà Nội">Hà Nội</option>
                <option value="Hải Phòng">Hải Phòng</option>
                <option value="Hà Nam">Hà Nam</option>
            </select>
        </div>
        <div class="col-lg-6 pb-3 mt-3 mb-3">
            <label>Quốc Gia:</label>
            <select class="form-select" aria-label="Default select example" name="quocGia">
                <option value="Việt Nam">Việt Nam</option>
                <option value="Hà Lan">Hà Lan</option>
                <option value="USA">USA</option>
            </select>
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Thêm</button>
    <%--        <button type="button" class="btn btn-primary">Sửa</button>--%>
    <%--        <button type="button" class="btn btn-primary">Xóa</button>--%>
</form>
</div>
</body>
</html>
