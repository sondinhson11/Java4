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
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="/DuAnMauJava4_war_exploded/css/bootstrap.min.css">
        <title>Cửa Hàng</title>
    </head>
    <body>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <center>
                <h1>Cửa Hàng</h1>
                </center>
            </div>
            <div class="col-md-4"></div>
        </div>
        <br>
        <a href="../cuahang/create" class="btn btn-success">Thêm mới</a>
        <div class="row">
            <div class="col-md-12">
                <c:if test="${f:length(DSCuaHang)==0 }">
                    <h3 class="alert-warning">Không có dữ liệu</h3>
                </c:if>
                <c:if test="${f:length(DSCuaHang)!=0 }">
                    <table class="table table-striped mt-3">
                        <thead class="table-primary">
                            <tr>
                                <th scope="col">Mã</th>
                                <th scope="col">Tên Cửa Hàng</th>
                                <th scope="col">Địa Chỉ</th>
                                <th scope="col">Thành Phố</th>
                                <th scope="col">Quốc Gia</th>
                                <th colspan="2">Thao tác</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${ DSCuaHang }" var="ch">
                            <tr>
                                <th scope="row">${ch.ma}</th>
                                <td>${ch.ten}</td>
                                <td>${ch.dia_chi}</td>
                                <td>${ch.thanh_pho}</td>
                                <td>${ch.quoc_gia}</td>
                                <td>
                                    <a href="../cuahang/edit" class="btn btn-primary">Cập nhật</a>
                                    <a href="#" class="btn btn-danger">Xóa</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                    </table>
                </c:if>
            </div>
        </div>
    </body>
</html>
