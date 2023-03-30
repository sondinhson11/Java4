<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/13/2023
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
    <link rel="stylesheet" href="/Java4_BTVN_war_exploded/css/bootstrap.min.css" />

<div class="col-12  mt-5 table-responsive">
    <div class="row">
        <div class="col-6">
            <a  class="btn btn-success" href="/Java4_BTVN_war_exploded/khach-hang/create">Thêm mới</a>
        </div>
    </div>

    <c:if test="${ f:length(danhSach) == 0 }">
        <h3>Không có dữ liệu</h3>
    </c:if>

    <c:if test="${ f:length(danhSach) != 0 }">
        <table class="table table-striped mt-3">
            <thead class="table-primary">
            <tr>
                <th>Mã</th>
                <th>Tên</th>
                <th>Đệm</th>
                <th>Tên</th>
                <th>Ngày sinh</th>
                <th>SDT</th>
                <th>Địa chỉ</th>
                <th>Thành phố</th>
                <th>Quốc gia</th>

                <th colspan="2">Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ danhSach }" var="kh">
                <tr>
                    <td>${ kh.ma }</td>
                    <td>${ kh.ho }</td>
                    <td>${ kh.tenDem }</td>
                    <td>${ kh.ten }</td>
                    <td>${ kh.ngaySinh }</td>
                    <td>${ kh.sdt }</td>
                    <td>${ kh.diaChi }</td>
                    <td>${ kh.thanhPho }</td>
                    <td>${ kh.quocGia }</td>

                    <td>
                        <a href="/Java4_BTVN_war_exploded/khach-hang/edit?ma=${kh.ma}" class="btn btn-primary">Cập nhật</a>
                    </td>
                    <td>
                        <a href="/Java4_BTVN_war_exploded/khach-hang/delete?ma=${kh.ma}" class="btn btn-danger">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>


</div>

<script src="/Java4_BTVN_war_exploded/js/bootstrap.min.js"></script>

