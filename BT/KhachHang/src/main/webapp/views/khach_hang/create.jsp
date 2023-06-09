<%--
  Created by IntelliJ IDEA.
  User: thean
  Date: 14/03/2023
  Time: 8:55 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Khách Hàng</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<form method="POST" action="/KhachHang_war_exploded/khach-hang/store">
    <div class="container">
        <div class="card-body">
            <center><h1>Khách Hàng</h1></center>
            <br><br>
            <div class="col-md-12">
                <label>Mã:</label>
                <input type="text" name="ma" class="form-control" required> <br><br>
            </div>
            <div class="col-md-12">
                <label>Tên :</label>
                <input type="text" name="ten" class="form-control" required> <br><br>
            </div>
            <div class="col-md-12">
                <label>Tên đệm:</label>
                <input type="text" name="tenDem" class="form-control" required> <br><br>
            </div>
            <div class="col-md-12">
                <label>Họ:</label>
                <input type="text" name="ho" class="form-control" required> <br><br>
            </div>
            <div class="col-md-12">
                <label>Ngày sinh:</label>
                <input type="date" name="ngaySinh" class="form-control" required> <br><br>
            </div>

            <div class="col-md-12">
                <label>Số điện thoại:</label>
                <input type="text" name="sdt" class="form-control" required><br><br>
            </div>

            <div class="col-md-12">
                <label>Địa chỉ:</label>
                <input type="text" name="diaChi" class="form-control" required><br><br>
            </div>
            <div class="col-md-12">
                <label>Thành phố:</label>
                <select class="form-control" name="thanhPho">
                    <option >Hà Nội</option>
                    <option >HCM</option>
                </select>
            </div>

            <div class="col-md-12">
                <label>Quốc gia:</label>
                <select class="form-control" name="quocGia">
                    <option >Việt Nam</option>
                    <option >Nhật Bản</option>
                </select><br><br>
            </div>
            <div class="col-md-12">
                <label>Mật khẩu</label>
                <input type="text" class="form-control" name="matKhau" required> <br><br>
            </div>
            <div class="col-md-12">
                <center>
                    <button type="submit" style="color: white;background: greenyellow">Thêm khách hàng</button>
                </center>
            </div>

        </div>
    </div>


</form>

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
