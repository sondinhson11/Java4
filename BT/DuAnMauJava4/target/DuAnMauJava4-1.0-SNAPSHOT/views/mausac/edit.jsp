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
            <h1>Sửa Thông Tin Màu Sắc</h1>
        </center>
    </div>
    <div class="col-md-2"></div>
</div>
<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <form  method="POST"
               action="/DuAnMauJava4_war_exploded/mausac/update?ma=${ms.ma}">

        <div class="row mt-3">
                <div class="col-6">
                    <label>Mã</label>
                    <input type="text" name="ma" class="form-control" value="${ms.ma}"disabled/>
                </div>
                <div class="col-6">
                    <label>Tên</label>
                    <input type="text" name="ten" class="form-control" value="${ms.ten}"/>
                </div>
            </div>
            <br>
            <button type="submit" class="btn btn-primary">Thêm</button>
        </form>
    </div>
    <script src="/DuAnMauJava4_war_exploded/js/bootstrap.min.js"></script>
    <div class="col-md-2"></div>
</div>

