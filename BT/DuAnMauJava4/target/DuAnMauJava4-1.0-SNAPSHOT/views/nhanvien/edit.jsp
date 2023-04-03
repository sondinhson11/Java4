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
            <h1>Sửa Thông Tin Nhân Viên</h1>
        </center>
    </div>
    <div class="col-md-2"></div>
</div>
<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <form method="POST" action="/DuAnMauJava4_war_exploded/nhanvien/update?ma=${nv.ma}">
            <div class="row">
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Mã</label>
                        <input type="text" class="form-control" name="ma" value="${ nv.ma }" disabled>
                    </div>
                </div>
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Họ</label>
                        <input type="text" class="form-control" name="ho" value="${ nv.ho }">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Tên Đệm</label>
                        <input type="text" class="form-control" name="tenDem" value="${ nv.tendem }">
                    </div>
                </div>
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Tên</label>
                        <input type="text" class="form-control" name="ten" value="${ nv.ten }">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label>Giới Tính </label>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="gioitinh"
                               value="Nam"${ nv.gioitinh == "Nam" ? "checked" : ""  }>
                        <label class="form-check-label" >
                            Nam
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="gioitinh"
                               value="Nữ"${ nv.gioitinh == "Nữ" ? "checked" : ""  } >
                        <label class="form-check-label" >
                            Nữ
                        </label>
                    </div>
                </div>
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Ngày Sinh</label>
                        <input type="date" class="form-control" name="ngaySinh" value="${ nv.ngaysinh }">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Địa chỉ</label>
                        <input type="text" class="form-control" name="diaChi" value="${ nv.diachi }">
                    </div>
                </div>
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Số điện thoại</label>
                        <input type="text" class="form-control" name="sdt" value="${ nv.sdt }"
                               id="exampleInputEmail145">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div>
                        <label for="inputPassword" class="form-label">Mật khẩu</label>
                        <input type="password" name="matKhau" value="${ nv.mk }" class="form-control" id="inputPassword">
                    </div>
                </div>
                <div class="col-md-6">
                    <div>
                        <label class="form-label">ID cửa hàng</label>
                        <select class="form-select" name="ch" aria-label="Default select example">
                            <c:forEach items="${ dsch }" var="ch">
                                <option value="${ch.ma}" ${ch.ma == nv.ch ? "selected" :"" }>${ch.ten}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div>
                        <label class="form-label">ID Chức Vụ</label>
                        <select class="form-select" name="cv" aria-label="Default select example">
                            <c:forEach items="${ dscv }" var="cv">
                                <option value="${cv.ma}" ${cv.ma == nv.cv ? "selected" :"" }>${cv.ten}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Trạng Thái</label>
                        <select class="form-select" name="trangThai" aria-label="Default select example">
                            <option selected></option>
                            <option value="Còn Làm" ${ nv.trangThai == "Còn Làm" ? "selected" : "" }>Còn Làm</option>
                            <option value="Nghỉ" ${ nv.trangThai == "Nghỉ" ? "selected" : "" }>Nghỉ</option>

                        </select>
                    </div>
                </div>
<%--                <div class="col-md-6">--%>
<%--                    <div>--%>
<%--                        <label class="form-label">IDGuiBC</label>--%>
<%--                        <input type="text" name="idGuiBC" value="${ nv.idGuiBC }" class="form-control" >--%>
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
