<%--
  Created by IntelliJ IDEA.
  User: tiennh
  Date: 3/14/23
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <center>
            <h1>Khách Hàng</h1>
        </center>
    </div>
    <div class="col-md-4"></div>
</div>
<br>
<div>
    <div class="row">
        <div class="col-6">
            <a href="/DuAnMauJava4_war_exploded/khachhang/create" class="btn btn-success">Thêm mới</a>
        </div>
    </div>
    <c:if test="${ f:length(danhSachKH) == 0 }">
        <h3 class="alert alert-warning">Không có dữ liệu</h3>
    </c:if>
    <c:if test="${ f:length(danhSachKH) != 0 }">
        <table class="table table-striped mt-3">
            <thead class="table-primary">
            <tr>
                <th>Mã</th>
                <th>Họ Và Tên</th>
                <th>Ngày sinh</th>
                <th>SDT</th>
                <th>Địa chỉ</th>
                <th>Mật Khẩu</th>
                <th>Thành phố</th>
                <th>Quốc gia</th>
                <th colspan="2">Thao tác</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${ danhSachKH }" var="kh">
                <tr>
                    <td>${ kh.ma }</td>
                    <td>${ kh.ho } ${ kh.tenDem } ${ kh.ten }</td>
                    <td>${ kh.ngaySinh }</td>
                    <td>${ kh.sdt }</td>
                    <td>${ kh.diaChi }</td>
                    <td>${ kh.matKhau }</td>
                    <td>${ kh.thanhPho }</td>
                    <td>${ kh.quocGia }</td>
                    <td>
                        <a class="btn btn-primary"
                           href="/DuAnMauJava4_war_exploded/khachhang/edit?ma=${ kh.ma }">
                            Cập nhật
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-danger"
                           href="/DuAnMauJava4_war_exploded/khachhang/delete?ma=${ kh.ma }">
                            Xóa
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
