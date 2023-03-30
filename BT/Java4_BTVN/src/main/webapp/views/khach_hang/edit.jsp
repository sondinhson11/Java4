<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/13/2023
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <link rel="stylesheet" href="/Java4_BTVN_war_exploded/css/bootstrap.min.css" />

<div class="col-8 offset-2 bg-light">
    <form method="POST"
          action="/Java4_BTVN_war_exploded/khach-hang/update?ma=${kh.ma}">
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" value="${kh.ma}" disabled/>
            </div>
            <div class="col-6">
                <label>Họ</label>
                <input type="text" name="ho" class="form-control"value="${kh.ho}" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Tên đệm</label>
                <input type="text" name="tenDem" class="form-control"value="${kh.tenDem}" />
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" value="${kh.ten}" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Ngày sinh</label>
                <input type="date" name="ngaySinh" class="form-control" value="${kh.ngaySinh}"/>
            </div>
            <div class="col-6">
                <label>Số điện thoại</label>
                <input type="tel" name="sdt" class="form-control" value="${kh.sdt}"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Địa chỉ</label>
                <input type="text" name="diaChi" class="form-control" value="${kh.diaChi}"/>
            </div>
            <div class="col-6">
                <label>Mật khẩu</label>
                <input type="password" name="matKhau" class="form-control" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Quốc gia</label>
                <select name="quocGia" class="form-select">
                    <option value="vn" ${kh.quocGia=="vn"?"selected":""}>Việt Nam</option>
                    <option value="en" ${kh.quocGia=="en"?"selected":""}>Anh </option>
                </select>
            </div>
            <div class="col-6">
                <label>Thành phố</label>
                <select name="thanhPho" class="form-select">
                    <option value="hanoi" ${kh.thanhPho=="hanoi"?"selected":""}>Hà Nội</option>
                    <option value="london" ${kh.thanhPho=="london"?"selected":""}>London</option>
                </select>
            </div>
        </div><div class="row mt-3">
        <div class="col-6">
            <button class="btn btn-primary">Cập Nhật</button>
        </div>
        <div class="col-6"></div>
    </div>
    </form>
</div>

<script src="/Java4_BTVN_war_exploded/js/bootstrap.min.js"></script>
