<%--
  Created by IntelliJ IDEA.
  User: sondi
  Date: 04/04/2023
  Time: 7:50 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>


<form method="post" action="/DuAnMauJava4_war_exploded/login">
    <br>
    <center>
        <h1>Đăng Nhập</h1>
    </center>
    <br>
    <div class="row">
        <div class="col-3">
        </div>
        <div class="col-3">
            <label>Mã</label>
            <input type="text" name="ma" class="form-control" />
        </div>
        <div class="col-3">
            <label>Mật khẩu</label>
            <input type="password" name="matKhau" class="form-control" />
        </div>
        <div class="col-3">
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-3">
        </div>
        <div class="col-6">
            <c:if test="${f:contains(errorMessage,'Sai tài khoản hoặc mật khẩu') == true }">
                <div class="alert alert-danger">${ errorMessage }</div>
            </c:if>
        </div>
        <div class="col-3">
        </div>
    </div>
    <div class="row">
        <div class="col-3">
        </div>
        <div class="col-6">
            <button class="btn btn-primary">Đăng nhập</button>

        </div>
        <div class="col-3">
        </div>
    </div>

</form>