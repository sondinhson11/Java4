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
    <title>Nhân Viên</title>
</head>
<body>
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
                    <th scope="col">Họ Và Tên</th>
                    <th scope="col">Giới Tính</th>
                    <th scope="col">Ngày Sinh</th>
                    <th scope="col">Địa Chỉ</th>
                    <th scope="col">Số Điện Thoại</th>
                    <th scope="col">Mật Khẩu</th>
                    <th scope="col">IDCH</th>
                    <th scope="col">IDCV</th>
                    <th scope="col">IDGuiBC</th>
                    <th colspan="2">Thao tác</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ DSNhanVien }" var="kh">
                <tr>
                    <th scope="row">${kh.ma}</th>
                    <td>${kh.ho} ${kh.ten_dem} ${kh.ten} </td>
                    <td>${kh.ngay_sinh}</td>
                    <td>${kh.dia_chi}</td>
                    <td>${kh.sdt}</td>
                    <td>${kh.mat_khau}</td>
                    <td>${kh.thanh_pho}</td>
                    <td>${kh.quoc_gia}</td>
                    <td>
                        <a href="../nhanvien/edit" class="btn btn-primary">Cập nhật</a>
                        <a href="#" class="btn btn-danger">Xóa</a>
                    </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
            </c:if>
        </div>
    </div>
    </script>
</body>
</html>
