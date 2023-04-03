<%--
  Created by IntelliJ IDEA.
  User: ThisPC
  Date: 3/9/2023
  Time: 5:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <center>
            <h1>Nhân Viên</h1>
        </center>
    </div>
    <div class="col-md-4"></div>
</div>
<br>
<a href="../nhanvien/create" class="btn btn-success">Thêm mới</a>
<div class="row">
    <div class="col-md-12">
        <c:if test="${f:length(DSNhanVien)==0 }">
            <h3 class="alert-warning">Không có dữ liệu</h3>
        </c:if>
        <c:if test="${f:length(DSNhanVien)!=0 }">
            <table class="table table-striped mt-3">
                <thead class="table-primary">
                <tr>
                    <th scope="col">Mã</th>
                    <th scope="col">Họ Tên</th>
                    <th scope="col">Giới tính</th>
                    <th scope="col">Ngày Sinh</th>
                    <th scope="col">Địa Chỉ</th>
                    <th scope="col">Số Điện Thoại</th>
                    <th scope="col">Mật Khẩu</th>
                    <th scope="col">IdCH</th>
                    <th scope="col">IdCV</th>
<%--                    <th scope="col">IdGuiBC</th>--%>
                    <th scope="col">TrangThai</th>
                    <th colspan="2">Thao tác</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ DSNhanVien }" var="nv">
                    <tr>
                        <td>${ nv.ma }</td>
                        <td>${ nv.ho } ${ nv.tenDem } ${ nv.ten }</td>
                        <td>${ nv.gioiTinh }</td>
                        <td>${ nv.ngaySinh }</td>
                        <td>${ nv.diaChi }</td>
                        <td>${ nv.sdt }</td>
                        <td>${ nv.matKhau }</td>
                        <td>${ nv.ch }</td>
<%--                        <td>${ nv.cv }</td>--%>
<%--                        <td>${ nv.idGuiBC }</td>--%>
                        <td>${ nv.trangThai }</td>
                        <td>
                            <a href="../nhanvien/edit?ma=${nv.ma}" class="btn btn-primary">Cập nhật</a>
                            <a href="../nhanvien/delete?ma=${nv.ma}" class="btn btn-danger">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
</div>
