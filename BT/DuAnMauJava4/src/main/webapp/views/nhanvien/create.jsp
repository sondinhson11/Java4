<%--
  Created by IntelliJ IDEA.
  User: ThisPC
  Date: 3/9/2023
  Time: 5:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

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
                        <div class="error mt-2" style="color: red"><p>${trungMa}</p></div>
                        <div class="error mt-2" style="color: red"><p>${errorMa}</p></div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Họ</label>
                        <input type="text" class="form-control" name="ho">
                        <div class="error mt-2" style="color: red"><p>${errorHo}</p></div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Tên Đệm</label>
                        <input type="text" class="form-control" name="tenDem">
                        <div class="error mt-2" style="color: red"><p>${errorTenDem}</p></div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Tên</label>
                        <input type="text" class="form-control" name="ten">
                        <div class="error mt-2" style="color: red"><p>${errorTen}</p></div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label>Giới Tính </label>
                    <div class="form-check">
                        <input class="form-check-input" value="Nam" type="radio" name="gioiTinh" checked>
                        <label class="form-check-label">
                            Nam
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" value="Nữ" name="gioiTinh">
                        <label class="form-check-label">
                            Nữ
                        </label>
                    </div>
                </div>
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Ngày Sinh</label>
                        <input type="date" class="form-control" value="2023-01-01" name="ngaySinh">
                        <div class="error mt-2" style="color: red"><p>${errorNgaySinh}</p></div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Địa chỉ</label>
                        <input type="text" class="form-control" name="diaChi">
                        <div class="error mt-2" style="color: red"><p>${errorDiaChi}</p></div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Số điện thoại</label>
                        <input type="text" class="form-control" name="sdt">
                        <div class="error mt-2" style="color: red"><p>${errorSDT}</p></div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Mật khẩu</label>
                        <input type="password" name="matKhau" class="form-control">
                        <div class="error mt-2" style="color: red"><p>${errorMK}</p></div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div>
                        <label class="form-label">ID cửa hàng</label>
                        <select class="form-select" name="idCH" aria-label="Default select example">
                            <c:forEach items="${ dsch }" var="ch">
                                <option value="${ch.id}">${ch.ten}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div>
                        <label class="form-label">ID Chức Vụ</label>
                        <select name="idCV" class="form-select">
                            <c:forEach items="${ dscv }" var="cv">
                                <option value="${cv.id}">${cv.ten}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Trạng Thái</label>
                        <select class="form-select" name="trangThai" aria-label="Default select example">
                            <option value="0"selected >Còn Làm</option>
                            <option value="1">Nghỉ</option>
                        </select>
                    </div>
                </div>
<%--                <div class="col-md-6">--%>
<%--                    <div>--%>
<%--                        <label class="form-label">IDGuiBC</label>--%>
<%--                        <input type="text" name="idGuiBC" class="form-control">--%>
<%--                    </div>--%>
<%--                </div>--%>
            </div>
            <br>
            <button type="submit" class="btn btn-primary">Thêm</button>
        </form>
    </div>
    <script src="/DuAnMauJava4_war_exploded/js/bootstrap.min.js"></script>
    <div class="col-md-2"></div>
</div>
