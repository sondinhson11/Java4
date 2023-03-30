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
          action="/Java4_BTVN_war_exploded/cua-hang/update?ma=${ch.ma}">
        <h1 style="text-align: center">Của Hàng</h1>
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control"  value="${ch.ma}" disabled/>
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" value="${ch.ten}"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Địa chỉ</label>
                <input type="text" name="diaChi" class="form-control"value="${ch.diaChi}" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Quốc gia</label>
                <select name="quocGia" class="form-select">
                    <option value="vn" ${ch.quocGia=="vn"?"selected":""}>Việt Nam</option>
                    <option value="en" ${ch.quocGia=="en"?"selected":""}>Anh</option>
                </select>
            </div>
            <div class="col-6">
                <label>Thành phố</label>
                <select name="thanhPho" class="form-select">
                    <option value="hanoi" ${ch.thanhPho=="hanoi"?"selected":""}>Hà Nội</option>
                    <option value="london" ${ch.thanhPho=="lodon"?"selected":""}>London</option>
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

