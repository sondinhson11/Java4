<%--
  Created by IntelliJ IDEA.
  User: sktfk
  Date: 12/03/2023
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="/nhanvien/update" method="post">
    <div class="container">
        <h1 class="mt-4 text-center mb-4">Sửa nhân viên</h1>
        <div class="row mb-4">
            <div class="col-lg-6">
                <label>Mã:</label>
                <input type="text" class="form-control" name="ma" value="${nv.ma}"  />
            </div>
            <div class="col-lg-6">
                <label>Họ:</label>
                <input type="text" class="form-control" name="ho" value="${nv.ho}"/>
            </div>
        </div>
        <div class="row mb-3">
            <div class="col-lg-6">
                <label>Tên Đệm:</label>
                <input type="text" class="form-control" name="tenDem" value="${nv.tenDem}"/>
            </div>
            <div class="col-lg-6">
                <label>Tên:</label>
                <input type="text" class="form-control" name="ten" value="${nv.ten}"/>
            </div>
        </div>
        <div class="row mb-3">
            <div class="col-lg-6">
                <label>Giới tính:</label>
                <div class="row">
                    <div class="col-3">
                        <div class="form-check">
                            <input
                                    class="form-check-input"
                                    type="radio"
                                    name="gioiTinh"
                                    value="Nam"
                                    ${nv.gioiTinh=="Nam"?"checked":""}
                            />
                            <label class="form-check-label">
                                Nam
                            </label>
                        </div>
                    </div>
                    <div class="col-3">
                        <div class="form-check">
                            <input
                                    class="form-check-input"
                                    type="radio"
                                    name="gioiTinh"
                                    value="Nữ"
                            ${nv.gioiTinh=="Nữ"?"checked":""}
                            />
                            <label class="form-check-label" >
                                Nữ
                            </label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <label>Ngày sinh:</label>
                <input type="text" class="form-control" name="ngaySinh" value="${nv.ngaySinh}"/>
            </div>
        </div>
        <div class="row mb-3">
            <div class="col-lg-6">
                <label>Địa Chỉ:</label>
                <input type="text" class="form-control" name="diaChi" value="${nv.diaChi}" />
            </div>
            <div class="col-lg-6">
                <label>Số điện thoại:</label>
                <input type="text" class="form-control" name="sdt" value="${nv.sdt}"/>
            </div>
        </div>
        <div class="row mb-3">
            <div class="col-lg-6">
                <label>Mật khẩu:</label>
                <input type="password" class="form-control" name="matKhau"/>
            </div>
            <div class="col-lg-6 pb-3">
                <label>Trạng thái:</label>
                <div class="row">
                    <div class="col-3">
                        <div class="form-check">
                            <input
                                    class="form-check-input"
                                    type="radio"
                                    name="trangThai"
                                    value="0"
                                    ${nv.trangThai==0?"checked":""}
                            />
                            <label class="form-check-label" >
                                Đang làm
                            </label>
                        </div>
                    </div>
                    <div class="col-3">
                        <div class="form-check">
                            <input
                                    class="form-check-input"
                                    type="radio"
                                    name="trangThai"
                                    value="1"
                            ${nv.trangThai==1?"checked":""}
                            />
                            <label class="form-check-label" >
                                Nghỉ làm
                            </label>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Sửa</button>
        <!--  -->
    </div>
</form>


