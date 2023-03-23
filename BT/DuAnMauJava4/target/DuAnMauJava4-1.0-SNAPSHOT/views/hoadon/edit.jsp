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
            <h1>Sửa Hóa Đơn</h1>
        </center>
    </div>
    <div class="col-md-2"></div>
</div>
<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <form  method="POST"
               action="/DuAnMauJava4_war_exploded/hoadon/update?ma=${sp.ma}">
            <div class="row mt-3">
                <div class="col-6">
                    <label>idKH</label>
                    <input type="text" name="idKH" class="form-control" value="${sp.idKH}"/>
                </div>
                <div class="col-6">
                    <label>idNV</label>
                    <input type="text" name="idNV" class="form-control" value="${sp.idNV}" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Mã</label>
                    <input type="text" name="ma" class="form-control" value="${sp.ma}"disabled/>
                </div>
                <div class="col-6">
                    <label>ngayTao</label>
                    <input type="date" name="ngayTao" class="form-control" value="${sp.ngayTao}" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>ngayThanhToan</label>
                    <input type="date" name="ngayThanhToan" class="form-control" value="${sp.ngayThanhToan}"/>
                </div>
                <div class="col-6">
                    <label>ngayShip</label>
                    <input type="date" name="ngayShip" class="form-control" value="${sp.ngayShip}" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>ngayNhan</label>
                    <input type="date" name="ngayNhan" class="form-control" value="${sp.ngayNhan}"/>
                </div>
                <div class="col-6">
                    <label>tenNguoiNhan</label>
                    <input type="text" name="tenNguoiNhan" class="form-control" value="${sp.tenNguoiNhan}" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>diaChi</label>
                    <input type="text" name="diaChi" class="form-control" value="${sp.diaChi}"/>
                </div>
                <div class="col-6">
                    <label>SDT</label>
                    <input type="tel" name="sdt" class="form-control" value="${sp.sdt}" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-12">
                    <label class="form-label">Trạng Thái</label>
                    <select class="form-select" name="trangThai" aria-label="Default select example">
                        <option selected></option>
                        <option value="1" ${ nv.trangThai == "Còn Làm" ? "selected" : "" }>Còn Làm</option>
                        <option value="2" ${ nv.trangThai == "Nghỉ" ? "selected" : "" }>Nghỉ</option>

                    </select>
                </div>
            </div>
            <br>
            <button type="submit" class="btn btn-primary">Thêm</button>
        </form>
    </div>
    <script src="/DuAnMauJava4_war_exploded/js/bootstrap.min.js"></script>
    <div class="col-md-2"></div>
</div>
