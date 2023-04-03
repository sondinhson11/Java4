S<%--
  Created by IntelliJ IDEA.
  User: ThisPC
  Date: 3/9/2023
  Time: 5:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <center>
            <h1>Thêm Chi Tiết Sản Phẩm</h1>
        </center>
    </div>
    <div class="col-md-2"></div>
</div>
<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <form  method="POST"
               action="/DuAnMauJava4_war_exploded/ctsanpham/store">
            <div class="row mt-3">
                <div class="col-6">
                    <label>Mã</label>
                    <input type="text" name="ma" class="form-control" />
                </div>
                <div class="col-6">
                    <label>idSP</label>
                    <select name="idSP" class="form-select">
                        <c:forEach items="${ dssp }" var="sp">
                            <option value="${sp.ma}">${sp.ten}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>idNsx</label>
                    <select name="idNsx" class="form-select">
                        <c:forEach items="${ dsnxs }" var="nxs">
                            <option value="${nxs.ma}">${nxs.ten}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-6">
                    <label>idMauSac</label>
                    <select name="idMauSac" class="form-select">
                        <c:forEach items="${ dsms }" var="ms">
                            <option value="${ms.ma}">${ms.ten}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>idDongSP</label>
                    <select name="idDongSP" class="form-select">
                        <c:forEach items="${ dsdsp }" var="dsp">
                            <option value="${dsp.ma}">${dsp.ten}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-6">
                    <label>namBH</label>
                    <input type="text" name="namBH" class="form-control" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>moTa</label>
                    <input type="text" name="moTa" class="form-control" />
                </div>
                <div class="col-6">
                    <label>soLuongTon</label>
                    <input type="password" name="soLuongTon" class="form-control" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>giaNhap</label>
                    <input type="number" name="giaNhap" class="form-control" />
                </div>
                <div class="col-6">
                    <label>giaBan</label>
                    <input type="number" name="giaBan" class="form-control" />
                </div>
            </div>
            <br>
            <button type="submit" class="btn btn-primary">Thêm</button>
        </form>
    </div>
    <script src="/DuAnMauJava4_war_exploded/js/bootstrap.min.js"></script>
    <div class="col-md-2"></div>
</div>
