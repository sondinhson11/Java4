<%--
  Created by IntelliJ IDEA.
  User: ThisPC
  Date: 3/9/2023
  Time: 5:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <center>
            <h1>Thêm Hóa Đơn Chi Tiết</h1>
        </center>
    </div>
    <div class="col-md-2"></div>
</div>
<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <form  method="POST"
               action="/DuAnMauJava4_war_exploded/hoadonct/store?ma=${sp.idHoaDon}">
            <div class="row mt-3">
                <div class="col-6">
                    <label>idHoaDon</label>
                    <input type="text" name="idHoaDon" class="form-control"/>
                </div>
                <div class="col-6">
                    <label>idChiTietSP</label>
                    <input type="text" name="idChiTietSP" class="form-control" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>soLuong</label>
                    <input type="text" name="soLuong" class="form-control"/>
                </div>
                <div class="col-6">
                    <label>donGia</label>
                    <input type="text" name="donGia" class="form-control" value="${sp.donGia}" />

                </div>
            </div>
            <br>
            <button type="submit" class="btn btn-primary">Thêm</button>
        </form>
    </div>
    <script src="/DuAnMauJava4_war_exploded/js/bootstrap.min.js"></script>
    <div class="col-md-2"></div>
</div>

