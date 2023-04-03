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
            <h1>Sản Phẩm</h1>
        </center>
    </div>
    <div class="col-md-4"></div>
</div>
<br>

<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <a href="../sanpham/create" class="btn btn-success">Thêm mới</a>
    </div>
    <div class="col-md-2"></div>
</div>
<div class="row">
    <div class="col-md-2"></div>

    <div class="col-md-8">
        <c:if test="${f:length(DSSanPham)==0 }">
            <h3 class="alert-warning">Không có dữ liệu</h3>
        </c:if>
        <c:if test="${f:length(DSSanPham)!=0 }">
            <table class="table table-striped mt-3">
                <thead class="table-primary">
                <tr>
                    <th scope="col">Mã</th>
                    <th scope="col">Tên</th>
                    <th colspan="2">Thao tác</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ DSSanPham }" var="cv">
                    <tr>
                        <td>${cv.ma}</td>
                        <td>${cv.ten}</td>
                        <td>
                            <a class="btn btn-primary"
                               href="/DuAnMauJava4_war_exploded/sanpham/edit?ma=${ cv.ma }">
                                Cập nhật
                            </a>
                        </td>
                        <td>
                            <a class="btn btn-danger"
                               href="/DuAnMauJava4_war_exploded/sanpham/delete?ma=${ cv.ma }">
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

