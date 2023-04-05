<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/13/2023
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <link rel="stylesheet" href="/Java4_BTVN_war_exploded/css/bootstrap.min.css" />

<div class="col-8 offset-2 bg-light">
    <form method="POST"
          action="/Java4_BTVN_war_exploded/nhan-vien/update?ma=${nv.ma}">
        <h1 style="text-align: center">Nhân Viên</h1>
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control"  value="${nv.ma}" disabled/>
            </div>
            <div class="col-6">
                <label>Họ</label>
                <input type="text" name="ho" class="form-control" value="${nv.ho}"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Tên đệm</label>
                <input type="text" name="tenDem" class="form-control"value="${nv.tenDem}" />
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" value="${nv.ten}" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Ngày sinh</label>
                <input type="date" name="ngaySinh" class="form-control" value="${nv.ngaySinh}"/>
            </div>
            <div class="col-6" style="margin-top: 30px">
                <label>Giới Tính</label>
                <input type="radio" name="gioiTinh"  id="nam" value="Nam" ${nv.gioiTinh=="Nam"?"checked":"" }>Nam
                <input type="radio" name="gioiTinh" id="nu" value="Nữ" ${nv.gioiTinh=="Nữ"?"checked":""}>Nữ
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Địa chỉ</label>
                <input type="text" name="diaChi" class="form-control" value="${nv.diaChi}"/>
            </div>
            <div class="col-6">
            <label>Trạng thái</label>
            <select name="trangThai" class="form-select">
                <option value="0" ${nv.trangThai==0?"selected":""}>Đang làm</option>
                <option value="1" ${nv.trangThai==1?"selected":""}  >Đã nghỉ</option>
            </select>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <label>Số Điện Thoại</label>
                <input type="text" name="sdt" class="form-control" value="${nv.sdt}"/>
                </select>
            </div>
            <div class="col-6">
                <label>Mật Khẩu</label>
                <input type="text" name="matKhau" class="form-control" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label> Cửa Hàng</label>
                <select name="cuaHang" class="form-select" >
                    <c:forEach items="${dsch}" var="chs">
                        <option ${nv.ch.id == ch.id ? "selected" : "" } value="${chs.id}">${ch.ten} </option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>Chức Vụ</label>
                <select name="chucVu" class="form-select"  >
                    <c:forEach items="${dscv}" var="cvs">
                        <option ${nv.cv.id == cv.id ? "selected" : "" } value="${cvs.id}">${cvs.ten} </option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="col-6">
            <button class="btn btn-primary">Cập Nhật</button>
        </div>
        <div class="col-6"></div>
    </form>
</div>

<script src="/Java4_BTVN_war_exploded/js/bootstrap.min.js"></script>

