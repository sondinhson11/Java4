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
            <h1>Thêm Nhân Viên</h1>
        </center>
    </div>
    <div class="col-md-2"></div>
</div>
<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <form  method="POST"
               action="/DuAnMauJava4_war_exploded/nhanvien/store">
            <div class="row">
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Mã</label>
                        <input type="text" class="form-control" name="ma">
                    </div>
                </div>
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Họ</label>
                        <input type="text" class="form-control" name="ho">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Tên Đệm</label>
                        <input type="text" class="form-control" name="tendem">
                    </div>
                </div>
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Tên</label>
                        <input type="text" class="form-control" name="ten">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label>Giới Tính </label>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="gioitinh">
                        <label class="form-check-label">
                            Nam
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="gioitinh">
                        <label class="form-check-label">
                            Nữ
                        </label>
                    </div>
                </div>
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Ngày Sinh</label>
                        <input type="date" class="form-control" name="ngaysinh">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Địa chỉ</label>
                        <input type="text" class="form-control" name="diachi">
                    </div>
                </div>
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Số điện thoại</label>
                        <input type="text" class="form-control" name="sdt">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Mật khẩu</label>
                        <input type="password" name="mk" class="form-control">
                    </div>
                </div>
                <div class="col-md-6">
                    <div>
                        <label class="form-label">ID cửa hàng</label>
                        <select class="form-select" name="idCH" aria-label="Default select example">
                            <option selected></option>
                            <option value="CH01">CH01</option>
                            <option value="CH02">CH02</option>
                            <option value="CH03">CH03</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div>
                        <label class="form-label">ID Chức Vụ</label>
                        <select class="form-select" name="idCV" aria-label="Default select example">
                            <option selected></option>
                            <option value="CV01">CV01</option>
                            <option value="CV02">CV02</option>
                            <option value="CV03">CV03</option>
                        </select>
                    </div>
                </div>
                <div class="col-md-6">
                    <div>
                        <label class="form-label">IDGuiBC</label>
                        <select class="form-select" name="idGuiBC" aria-label="Default select example">
                            <option selected></option>
                            <option value="GBC01">GBC01</option>
                            <option value="GBC02">GBC02</option>
                            <option value="GBC03">GBC03</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div>
                        <label class="form-label">Trạng Thái</label>
                        <select class="form-select" name="trangThai" aria-label="Default select example">
                            <option selected></option>
                            <option value="Còn Làm" >Còn Làm</option>
                            <option value="Nghỉ">Nghỉ</option>

                        </select>
                    </div>
                </div>
            </div>
            <br>
            <button type="submit" class="btn btn-primary">Thêm</button>
        </form>
    </div>
    <script src="/DuAnMauJava4_war_exploded/js/bootstrap.min.js"></script>
    <div class="col-md-2"></div>
</div>
