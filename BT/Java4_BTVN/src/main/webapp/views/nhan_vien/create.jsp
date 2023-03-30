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
          action="/Java4_BTVN_war_exploded/nhan-vien/store">
        <h1 style="text-align: center">Nhân Viên</h1>
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" />
            </div>
            <div class="col-6">
                <label>Họ</label>
                <input type="text" name="ho" class="form-control" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Tên đệm</label>
                <input type="text" name="ten_dem" class="form-control" />
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Ngày sinh</label>
                <input type="date" name="ngay_sinh" class="form-control" />
            </div>
            <div class="col-6" style="margin-top: 30px">
                <label>Giới Tính</label>
                <input type="radio" name="gioi_tinh"id="nam" value="true">Nam
                <input type="radio" name="gioi_tinh"id="nu" value="false">Nữ
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Địa chỉ</label>
                <input type="text" name="dia_chi" class="form-control" />
            </div>
            <div class="col-6">
            <label>Trạng thái</label>
            <select name="trang_thai" class="form-select">
                <option value="1">Đang làm</option>
                <option value="2">Đã nghỉ</option>
            </select>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <label>Số Điện Thoại</label>
                <input type="text" name="sdt" class="form-control" />
                </select>
            </div>
            <div class="col-6">
                <label>Mật Khẩu</label>
                <input type="text" name="mat_khau" class="form-control" />
            </div>
        </div><div class="row mt-3">
        <div class="col-6">
            <button class="btn btn-primary">Thêm mới</button>
        </div>
        <div class="col-6"></div>
    </div>
    </form>
</div>

<script src="/Java4_BTVN_war_exploded/js/bootstrap.min.js"></script>

