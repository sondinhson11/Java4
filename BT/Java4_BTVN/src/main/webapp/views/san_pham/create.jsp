<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/13/2023
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <title>Title</title>
    <link rel="stylesheet" href="/Java4_BTVN_war_exploded/css/bootstrap.min.css" />
<div class="col-8 offset-2 bg-light">
    <form method="POST"
          action="/Java4_BTVN_war_exploded/san-pham/store">
        <h1 style="text-align: center">Sản Phẩm</h1>
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" />
            </div>
            <div class="col-6">
                <label>ten</label>
                <input type="text" name="ten" class="form-control" />
            </div>
        </div>
        <div class="row mt-3">
        <div class="col-6">
            <button class="btn btn-primary">Thêm mới</button>
        </div>
        <div class="col-6"></div>
    </div>
    </form>
</div>

<script src="/Java4_BTVN_war_exploded/js/bootstrap.min.js"></script>

