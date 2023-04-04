<%--
  Created by IntelliJ IDEA.
  User: tt
  Date: 3/14/2023
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous" />
</head>
<body>
<div class="col-6">
    <a href="/BTVN_war_exploded/khach-hang/create" class="btn btn-success">Thêm mới</a>
</div>
<c:if test="${f:length(danhsachKH)==0}">
    <h3 class="alert alert-warning">Không có dữ liệu</h3>
</c:if>
<c:if test="${f:length(danhsachKH)!=0}">
    <table class="table">
        <thead>
        <tr>
<%--            <th scope="col">ID</th>--%>
            <th scope="col">Mã</th>
            <th scope="col">Tên</th>
            <th scope="col">Tên Đệm</th>
            <th scope="col">Họ</th>
            <th scope="col">Ngày Sinh</th>
            <th scope="col">Số Điện Thoại</th>
            <th scope="col">Địa Chỉ</th>
            <th scope="col">Thành Phố</th>
            <th scope="col">Quốc Gia</th>
            <th scope="col">Mật Khẩu</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ danhsachKH }" var="kh">
            <tr>
                <td>${ kh.ma }</td>
                <td>${ kh.ten }</td>
                <td>${ kh.tenDem }</td>
                <td>${ kh.ho }</td>
                <td>${ kh.ngaySinh }</td>
                <td>${ kh.sdt }</td>
                <td>${ kh.diaChi }</td>
                <td>${ kh.thanhPho }</td>
                <td>${ kh.quocGia }</td>
                <td>${ kh.matKhau }</td>
                <td>
                    <a href="/BTVN_war_exploded/khach-hang/edit?ma=${ kh.ma }" class="btn btn-primary">Cập nhật</a>
                </td>
                <td>
                    <a href="/BTVN_war_exploded/khach-hang/delete?ma=${ kh.ma }" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>
