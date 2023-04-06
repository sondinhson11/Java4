<%--
  Created by IntelliJ IDEA.
  User: tiennh
  Date: 3/11/23
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-8 offset-2">
    <form method="POST"
          action="/DuAnMauJava4_war_exploded/khachhang/update?ma=${kh.ma}">
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" value="${ kh.ma }" disabled />
            </div>
            <div class="col-6">
                <label>Họ</label>
                <input type="text" name="ho" class="form-control" value="${ kh.ho }" />
                <div class="error mt-2" style="color: red"><p>${errorHo}</p></div>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Tên đệm</label>
                <input type="text" name="tenDem" class="form-control" value="${ kh.tenDem }" />
                <div class="error mt-2" style="color: red"><p>${errorTenDem}</p></div>
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" value="${ kh.ten }" />
                <div class="error mt-2" style="color: red"><p>${errorTen}</p></div>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Ngày sinh</label>
                <input type="date" name="ngaySinh" class="form-control" value="${ kh.ngaySinh }"/>
                <div class="error mt-2" style="color: red"><p>${errorNgaySinh}</p></div>
            </div>
            <div class="col-6">
                <label>SDT</label>
                <input type="tel" name="sdt" class="form-control" value="${ kh.sdt }"/>
                <div class="error mt-2" style="color: red"><p>${errorSDT}</p></div>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Địa chỉ</label>
                <input type="text" name="diaChi" class="form-control" value="${ kh.diaChi }"/>
                <div class="error mt-2" style="color: red"><p>${errorDiaChi}</p></div>
            </div>
            <div class="col-6">
                <label>Mật khẩu</label>
                <input type="password" name="matKhau" class="form-control" value="${ kh.matKhau }"/>
                <div class="error mt-2" style="color: red"><p>${errorMK}</p></div>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Thành phố</label>
                <select name="thanhPho" class="form-select">
                    <option value="Hà Nội"${ kh.thanhPho == "Hà Nội" ? "selected" : "" }>Hà Nội</option>
                    <option value="Thanh Hóa"${ kh.thanhPho == "Thanh Hóa" ? "selected" : "" }>Thanh Hóa</option>
                </select>
            </div>
            <div class="col-6">
                <label>Quốc gia</label>
                <select name="quocGia" class="form-select">
                    <option value="Việt Nam" ${ kh.quocGia == "Việt Nam" ? "selected" : "" }>Việt Nam</option>
                    <option value="Mỹ" ${ kh.quocGia == "Mỹ" ? "selected" : "" }>Mỹ</option>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary">Sửa</button>
            </div>
            <div class="col-6"></div>
        </div>
    </form>
</div>
<script src="/DuAnMauJava4_war_exploded/js/bootstrap.min.js"></script>
