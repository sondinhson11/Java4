<%--
  Created by IntelliJ IDEA.
  User: ThisPC
  Date: 3/9/2023
  Time: 5:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <center>
            <h1>Sửa Thông Tin Cửa Hàng</h1>
        </center>
    </div>
    <div class="col-md-2"></div>
</div>
<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <form method="POST"
              action="/DuAnMauJava4_war_exploded/cuahang/update?ma=${ch.ma}">
            <div class="row mt-3">
                <div class="col-6">
                    <label>Mã</label>
                    <input type="text" name="ma" class="form-control" value="${ch.ma}" disabled/>
                </div>
                <div class="col-6">
                    <label>Tên</label>
                    <input type="text" name="ten" class="form-control" value="${ch.ten}"/>
                    <div class="error mt-2" style="color: red"><p>${errorDiaChi}</p></div>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Địa Chỉ</label>
                    <input type="text" name="diaChi" class="form-control" value="${ch.diaChi}"/>
                    <div class="error mt-2" style="color: red"><p>${errorDiaChi}</p></div>
                </div>
                <div class="col-6">
                    <label>Thành phố</label>
                    <select name="thanhPho" class="form-select">
                        <option value="Hà Nội"${ kh.thanhPho == "Hà Nội" ? "selected" : "" }>Hà Nội</option>
                        <option value="Thanh Hóa"${ kh.thanhPho == "Thanh Hóa" ? "selected" : "" }>Thanh Hóa</option>
                    </select>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-12">
                    <label>Quốc gia</label>
                    <select name="quocGia" class="form-select">
                        <option value="Việt Nam" ${ kh.quocGia == "Việt Nam" ? "selected" : "" }>Việt Nam</option>
                        <option value="Mỹ" ${ kh.quocGia == "Mỹ" ? "selected" : "" }>Mỹ</option>
                    </select>
                </div>
            </div>
            <br>
            <button type="submit" class="btn btn-primary">Sửa</button>
        </form>
    </div>
    <script src="/DuAnMauJava4_war_exploded/js/bootstrap.min.js"></script>
    <div class="col-md-2"></div>
</div>

