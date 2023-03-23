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
            <h1>Hóa Đơn Chi Tiết</h1>
        </center>
    </div>
    <div class="col-md-4"></div>
</div>
<br>

<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <a href="../hoadonct/create" class="btn btn-success">Thêm mới</a>
    </div>
    <div class="col-md-2"></div>
</div>
<div class="row">
    <div class="col-md-2"></div>

    <div class="col-md-8">
        <c:if test="${f:length(DSHoaDonCT)==0 }">
            <h3 class="alert-warning">Không có dữ liệu</h3>
        </c:if>
        <c:if test="${f:length(DSHoaDonCT)!=0 }">
            <table class="table table-striped mt-3">
                <thead class="table-primary">
                <tr>
                    <th scope="col">idHoaDon</th>
                    <th scope="col">idChiTietSP</th>
                    <th scope="col">soLuong</th>
                    <th scope="col">donGia</th>
                    <th colspan="2">Thao tác</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ DSHoaDonCT }" var="cv">
                    <tr>
                        <td>${cv.idHoaDon}</td>
                        <td>${cv.idChiTietSP}</td>
                        <td>${cv.soLuong}</td>
                        <td>${cv.donGia}</td>
                        <td>
                            <a class="btn btn-primary"
                               href="/DuAnMauJava4_war_exploded/hoadonct/edit?ma=${ cv.idHoaDon}">
                                Cập nhật
                            </a>
                        </td>
                        <td>
                            <a class="btn btn-danger"
                               href="/DuAnMauJava4_war_exploded/hoadonct/delete?ma=${ cv.idHoaDon}">
                                Xóa
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
    <div class="col-md-2"></div>
</div>

