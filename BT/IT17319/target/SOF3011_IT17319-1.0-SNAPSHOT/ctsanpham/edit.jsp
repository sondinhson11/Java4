<%--
  Created by IntelliJ IDEA.
  User: sktfk
  Date: 12/03/2023
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/ctsanpham/update" method="post">
    <div class="container">
        <h1 class="mt-4 text-center mb-4">Thêm chi tiết sản phẩm</h1>
        <div class="row mb-4">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" class="form-control" name="id" value="${ctsp.id}"  />
            </div>
            <div class="col-6">
                <label>Sản phẩm</label>
                <select
                        class="form-select"
                        aria-label="Default select example"
                        name="tenSanPham"
                >
                    <option value="Sản Phẩm 1">Sản Phẩm 1</option>
                    <option value="Sản Phẩm 2">Sản Phẩm 2</option>
                </select>
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-6">
                <label>Dòng sản phẩm</label>
                <select
                        class="form-select"
                        aria-label="Default select example"
                        name="dongSanPham"
                >
                    <option value="Bánh">Bánh</option>
                    <option value="Kẹo">Kẹo</option>
                </select>
            </div>
            <div class="col-6">
                <label>Màu sắc</label>
                <select
                        class="form-select"
                        aria-label="Default select example"
                        name="mauSac"
                >
                    <option value="Red">Red</option>
                    <option value="Yellow">Yellow</option>
                </select>
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-6">
                <label>Nhà sản xuất</label>
                <select
                        class="form-select"
                        aria-label="Default select example"
                        name="NSX"
                >
                    <option value="Nhà Sản Xuất 1">Nhà Sản Xuất 1</option>
                    <option value="Nhà Sản Xuất 2">Nhà Sản Xuất 2</option>
                </select>
            </div>
            <div class="col-6">
                <label>Năm bán hàng:</label>
                <input type="text" class="form-control" name="namBH" value="${ctsp.namBH}"/>
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-6">
                <label>Số lượng :</label>
                <input type="number" class="form-control" name="soLuongTon" value="${ctsp.soLuongTon}"/>
            </div>
            <div class="col-6">
                <label>Giá nhập :</label>
                <input type="text" class="form-control" name="giaNhap" value="${ctsp.giaNhap}"/>
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-6">
                <label>Giá bán :</label>
                <input type="text" class="form-control" name="giaBan" value="${ctsp.giaBan}" />
            </div>
            <div class="col-6">
                <label>Mô tả :</label>
                <input type="text" class="form-control" name="moTa" value="${ctsp.moTa}"/>
            </div>
        </div>
        <!--  -->
        <div class="row">
            <div class="col-4"></div>
            <div class="col-2">
                <button type="submit" class="btn btn-success">Sửa</button>
            </div>
        </div>
    </div>
</form>

