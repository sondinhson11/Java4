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
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Địa Chỉ</label>
                    <input type="text" name="dia_chi" class="form-control" value="${ch.dia_chi}"/>
                </div>
                <div class="col-6">
                    <label>Thành Phố</label>
                    <input type="text" name="thanh_pho" class="form-control" value="${ch.thanh_pho}"/>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-12">
                    <label>Quốc gia</label>
                    <select name="quoc_gia" class="form-select">
                        <option value="vi" ${ kh.quoc_gia == "vi" ? "selected" : "" }>Việt Nam</option>
                        <option value="us" ${ kh.quoc_gia == "us" ? "selected" : "" }>Mỹ</option>
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

