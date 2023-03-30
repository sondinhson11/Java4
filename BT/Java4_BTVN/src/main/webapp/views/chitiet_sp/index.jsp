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

<div class="col-10 offset-1 mt-5 table-responsive">
    <div class="row">
        <div class="col-6">
            <a class="btn btn-success" href="/Java4_BTVN_war_exploded/chitiet-sp/create">Thêm mới</a>
        </div>
    </div>

    <c:if test="${ f:length(danhSach1) == 0 }">
        <h3>Không có dữ liệu</h3>
    </c:if>

    <c:if test="${ f:length(danhSach1) != 0 }">
        <table class="table table-striped mt-3">
            <thead class="table-primary">
            <tr>
                <th>Tên SP</th>
                <th>Năm bảo Hành</th>
                <th>Mô tả</th>
                <th>Số lượng tồn</th>
                <th>Giá Nhập</th>
                <th>Giá Bán</th>
                <th colspan="2">Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ danhSach1 }" var="ctsp">
                <tr>
                    <td>${ ctsp.ten_sp }</td>
                    <td>${ ctsp.nam_bh }</td>
                    <td>${ ctsp.mo_ta }</td>
                    <td>${ ctsp.slt }</td>
                    <td>${ ctsp.gia_nhap }</td>
                    <td>${ ctsp.gia_ban }</td>

                    <td>
                        <a href="/Java4_BTVN_war_exploded/chitiet-sp/edit?ten_sp=${ctsp.ten_sp}" class="btn btn-primary">Cập nhật</a>
                    </td>
                    <td>
                        <a href="/Java4_BTVN_war_exploded/chitiet-sp/delete?ten_sp=${ctsp.ten_sp}" class="btn btn-danger">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>


</div>

<script src="/Java4_BTVN_war_exploded/js/bootstrap.min.js"></script>

