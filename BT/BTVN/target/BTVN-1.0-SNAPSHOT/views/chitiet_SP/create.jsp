<%--
  Created by IntelliJ IDEA.
  User: tt
  Date: 3/9/2023
  Time: 9:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous" />
</head>
<body>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <label style="color: red;text-align: center"><h1>Chi tiết sản phẩm</h1></label>
    </div>
    <div class="col-md-4"></div>
</div>
<div class="row">
    <div class="col-md-4"><label>ID</label>
        <label>...</label></div>
    <div class="col-md-4"></div>

    <div class="col-md-4"></div>
</div>
<br>
<form method="POST" action="/BTVN_war_exploded/chitietSP/store">
    <div class="row">
        <div class="col-md-6">
            <div>
                <label for="exampleInputEmail1" class="form-label">Mã</label>
                <input type="text" class="form-control" name="ma"  id="exampleInputEmail19">
            </div>
            <div>
                <label  class="form-label">ID Sản Phẩm</label>
                <select class="form-select" name="idSP" aria-label="Default select example">
                    <option selected></option>
                    <option value="SP01">SP01</option>
                    <option value="SP02">SP02</option>
                    <option value="SP03">SP03</option>
                </select>
            </div>
            <div>
                <label class="form-label">ID Nhà Sản Xuất</label>
                <select class="form-select" name="idNsx" aria-label="Default select example">
                    <option selected></option>
                    <option value="NSX01">NSX01</option>
                    <option value="NSX02">NSX02</option>
                    <option value="NSX03">NSX03</option>
                </select>
            </div>
            <div>
                <label  class="form-label">ID Màu Sắc</label>
                <select class="form-select" name="idMauSac" aria-label="Default select example">
                    <option selected></option>
                    <option value="MS01">MS01</option>
                    <option value="MS02">MS02</option>
                    <option value="MS03">MS03</option>
                </select>
            </div>
            <div>
                <label  class="form-label">ID Dòng Sản Phẩm</label>
                <select class="form-select" name="idDongSP" aria-label="Default select example">
                    <option selected></option>
                    <option value="DSP01">DSP01</option>
                    <option value="DSP02">DSP02</option>
                    <option value="DSP03">DSP03</option>
                </select>
            </div>




        </div>
        <div class="col-md-6">
            <div>
                <label for="exampleInputEmail1" class="form-label">Năm bán hàng</label>
                <input type="text" class="form-control" name="namBH" id="exampleInputEmail1">
            </div>
            <div>
                <label for="exampleInputEmail1" class="form-label">Mô tả</label>
                <input type="text" class="form-control" name="moTa" id="exampleInputEmail12">
            </div>
            <div>
                <label for="exampleInputEmail1" class="form-label">Số lượng tồn</label>
                <input type="text" class="form-control" name="soLuongTon" id="exampleInputEmail13">
            </div>
            <div>
                <label for="exampleInputEmail1" class="form-label">Giá nhập</label>
                <input type="text" class="form-control" name="giaNhap" id="exampleInputEmail124">
            </div>
            <div>
                <label for="exampleInputEmail1" class="form-label">Giá bán</label>
                <input type="text" class="form-control" name="giaBan" id="exampleInputEmail134">
            </div>

        </div>
    </div>
    <button type="submit" class="btn btn-danger">Thêm</button>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>
