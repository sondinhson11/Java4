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
          action="/Java4_BTVN_war_exploded/chitiet-sp/update?ten_sp=${ctsp.ten_sp}">
        <h1 style="text-align: center">Chi Tiết Sản Phẩm</h1>
        <div class="row mt-3">
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten_sp" class="form-control" value="${ctsp.ten_sp}" disabled/>
            </div>
            <div class="col-6">
                <label>Năm Bảo Hành</label>
                <input type="text" name="nam_bh" class="form-control" value="${ctsp.nam_bh}"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Mô Tả</label>
                <input type="text" name="mo_ta" class="form-control" value="${ctsp.mo_ta}" />
            </div>
            <div class="col-6">
                <label>Số Lượng Tồn</label>
                <input type="text" name="slt" class="form-control" value="${ctsp.slt}"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Giá Nhập</label>
                <input type="text" name="gia_nhap" class="form-control" value="${ctsp.gia_nhap}"/>
            </div>
            <div class="col-6">
                <label>Giá Bán</label>
                <input type="tel" name="gia_ban" class="form-control" value="${ctsp.gia_ban}"/>
            </div>
        </div>
        <div class="row mt-3">
        <div class="col-6">
            <button class="btn btn-primary">Cập Nhật</button>
        </div>
        <div class="col-6"></div>
    </div>
    </form>
</div>

<script src="/Java4_BTVN_war_exploded/js/bootstrap.min.js"></script>

