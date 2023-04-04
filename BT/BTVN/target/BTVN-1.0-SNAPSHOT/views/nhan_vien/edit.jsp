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
        <label style="color: red;text-align: center"><h1>Nhân viên</h1></label>
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
<form method="POST" action="/BTVN_war_exploded/nhan-vien/update?ma=${nv.ma}">
    <div class="row">
        <div class="col-md-6">
            <div>
                <label for="exampleInputEmail1" class="form-label">Mã</label>
                <input type="text" class="form-control" name="ma" value="${ nv.ma }" disabled id="exampleInputEmail1">
            </div>
            <div>
                <label for="exampleInputEmail12" class="form-label">Tên</label>
                <input type="text" class="form-control" name="ten" value="${ nv.ten }" id="exampleInputEmail12">
            </div>
            <div>
                <label for="exampleInputEmail13" class="form-label">Tên Đệm</label>
                <input type="text" class="form-control" name="tendem" value="${ nv.tendem }" id="exampleInputEmail13">
            </div>
            <div>
                <label for="exampleInputEmail14" class="form-label">Họ</label>
                <input type="text" class="form-control" name="ho" value="${ nv.ho }" id="exampleInputEmail14">
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio"  name="gioitinh" id="flexRadioDefault1"  value="Nam"${ nv.gioitinh == "Nam" ? "checked" : ""  }>
                <label class="form-check-label" for="flexRadioDefault1">
                    Nam
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio"  name="gioitinh" id="flexRadioDefault2" value="Nữ"${ nv.gioitinh == "Nữ" ? "checked" : ""  } >
                <label class="form-check-label" for="flexRadioDefault2">
                    Nữ
                </label>
            </div>
            <div>
                <label for="exampleInputEmail16" class="form-label">Ngày Sinh</label>
                <input type="date" class="form-control" name="ngaysinh" value="${ nv.ngaysinh }" id="exampleInputEmail16">
            </div>
            <div>
                <label for="exampleInputEmail1456" class="form-label">Địa chỉ</label>
                <input type="text" class="form-control" name="diachi" value="${ nv.diachi }" id="exampleInputEmail1456">
            </div>
        </div>
        <div class="col-md-6">

            <div>
                <label for="exampleInputEmail145" class="form-label">Số điện thoại</label>
                <input type="text" class="form-control" name="sdt" value="${ nv.sdt }" id="exampleInputEmail145">
            </div>
            <div>
                <label for="inputPassword" class="col-sm-2 col-form-label">Mật khẩu</label>
                <div class="col-sm-10">
                    <input type="password" name="mk" value="${ nv.mk }" class="form-control" id="inputPassword">
                </div>
            </div>
            <div>
                <label for="exampleInputEmail1456" class="form-label">ID cửa hàng</label>
                <select class="form-select" name="idCH" aria-label="Default select example">
                    <option selected></option>
                    <option value="CH01"  ${ nv.idCH == "CH01" ? "selected" : "" }>CH01</option>
                    <option value="CH02" ${ nv.idCH == "CH02" ? "selected" : "" }>CH02</option>
                    <option value="CH03" ${ nv.idCH == "CH03" ? "selected" : "" }>CH03</option>
                </select>
            </div>
            <div>
                <label for="exampleInputEmail1456" class="form-label">ID Chức Vụ</label>
                <select class="form-select" name="idCV" aria-label="Default select example">
                    <option selected></option>
                    <option value="CV01" ${ nv.idCV == "CV01" ? "selected" : "" }>CV01</option>
                    <option value="CV02" ${ nv.idCV == "CV02" ? "selected" : "" }>CV02</option>
                    <option value="CV03" ${ nv.idCV == "CV03" ? "selected" : "" }>CV03</option>
                </select>
            </div>
            <div>
                <label for="exampleInputEmail1456" class="form-label">IDGuiBC</label>
                <select class="form-select" name="idGuiBC" aria-label="Default select example">
                    <option selected></option>
                    <option value="GBC01" ${ nv.idGuiBC == "GBC01" ? "selected" : "" }>GBC01</option>
                    <option value="GBC02" ${ nv.idGuiBC == "GBC02" ? "selected" : "" }>GBC02</option>
                    <option value="GBC03" ${ nv.idGuiBC == "GBC03" ? "selected" : "" }>GBC03</option>
                </select>
            </div>
            <div>
                <label for="exampleInputEmail1456" class="form-label">Trạng Thái</label>
                <select class="form-select" name="trangThai" aria-label="Default select example">
                    <option selected></option>
                    <option value="Còn Làm" ${ nv.trangThai == "Còn Làm" ? "selected" : "" }>Còn Làm</option>
                    <option value="Nghỉ" ${ nv.trangThai == "Nghỉ" ? "selected" : "" }>Nghỉ</option>

                </select>
            </div>
        </div>
    </div>
    <button type="submit" class="btn btn-danger">Thêm</button>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>
