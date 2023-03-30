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
            <a  class="btn btn-success" href="/Java4_BTVN_war_exploded/nhan-vien/create">Thêm mới</a>
        </div>
    </div>

    <c:if test="${ f:length(danhSach6) == 0 }">
        <h3>Không có dữ liệu</h3>
    </c:if>

    <c:if test="${ f:length(danhSach6) != 0 }">
        <table class="table table-striped mt-3">
            <thead class="table-primary">
            <tr>
                <th>Mã</th>
                <th>Họ</th>
                <th>Đệm</th>
                <th>Tên</th>
                <th>Ngày sinh</th>
                <th>Giới Tính</th>
                <th>Số Điện Thoại</th>
                <th>Địa Chỉ</th>
                <th>Mật Khẩu</th>
                <th>Trạng Thái</th>
                <th colspan="2">Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ danhSach6 }" var="nv">
                <tr>
                    <td>${ nv.ma }</td>
                    <td>${ nv.ho }</td>
                    <td>${ nv.ten_dem }</td>
                    <td>${ nv.ten }</td>
                    <td>${ nv.ngay_sinh  }</td>
                    <td>${ nv.gioi_tinh ? "Nam" : "Nữ"}</td>
                    <td>${ nv.sdt }</td>
                    <td>${ nv.dia_chi }</td>
                    <td>${ nv.mat_khau }</td>
                    <td>${ nv.trang_thai == 1 ? "Đang Làm" : "Đã Nghỉ"  }</td>

                    <td>
                        <a class="btn btn-primary" href="/Java4_BTVN_war_exploded/nhan-vien/edit?ma=${nv.ma}" >Cập nhật </a>
                    </td>
                    <td>
                        <a class="btn btn-primary" href="/Java4_BTVN_war_exploded/nhan-vien/delete?ma=${nv.ma}" >Xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>


</div>

<script src="/Java4_BTVN_war_exploded/js/bootstrap.min.js"></script>

