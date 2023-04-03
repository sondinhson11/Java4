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
            <h1>Chi Tiết Sản Phẩm</h1>
        </center>
    </div>
    <div class="col-md-4"></div>
</div>
<br>
<div>
    <div class="row">
        <div class="col-6">
            <a href="/DuAnMauJava4_war_exploded/ctsanpham/create" class="btn btn-success">Thêm mới</a>
        </div>
    </div>
    <c:if test="${ f:length(DSCTSP) == 0 }">
        <h3 class="alert-warning">Không có dữ liệu</h3>
    </c:if>
    <c:if test="${ f:length(DSCTSP) != 0 }">
        <table class="table table-striped mt-3">
            <thead class="table-primary">
            <tr>
                <th>Ma</th>
                <th>IdSP</th>
                <th>IdNsx</th>
                <th>IdMauSac</th>
                <th>IdDongSP</th>
                <th>NamBH</th>
                <th>MoTa</th>
                <th>SoLuongTon</th>
                <th>GiaNhap</th>
                <th>GiaBan</th>
                <th colspan="2">Thao tác</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${ DSCTSP }" var="ct">
                <tr>
                    <td>${ ct.ma }</td>
                    <td>${ ct.idSP }</td>
                    <td>${ ct.idNsx }</td>
                    <td>${ ct.idMauSac }</td>
                    <td>${ ct.idDongSP }</td>
                    <td>${ ct.namBH }</td>
                    <td>${ ct.moTa }</td>
                    <td>${ ct.soLuongTon }</td>
                    <td>${ ct.giaNhap }</td>
                    <td>${ ct.giaBan }</td>
                    <td>
                        <a class="btn btn-primary"
                           href="/DuAnMauJava4_war_exploded/ctsanpham/edit?ma=${ ct.ma }">
                            Cập nhật
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-danger"
                           href="/DuAnMauJava4_war_exploded/ctsanpham/delete?ma=${ ct.ma }">
                            Xóa
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
