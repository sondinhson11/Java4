<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<div class="col-8 offset-2">
    <form method="POST"
          action="/DuAnMauJava4_war_exploded/ctsanpham/update?ma=${kh.id}">
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="id" class="form-control" value="${ kh.id }" disabled/>
            </div>
            <div class="col-6">
                <label>idSP</label>
                <select name="idSP" class="form-select">
                    <c:forEach items="${ dssp }" var="sp2">
                        <option value="${sp2.id}" ${sp2.id == kh.sp.id ? "selected" :"" }>${sp2.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>idNsx</label>
                <select name="idNsx" class="form-select">
                    <c:forEach items="${ dsnxs }" var="nxs2">
                        <option value="${nxs2.id}" ${nxs2.id == kh.nsx.id ? "selected" :"" }>${nxs2.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>idMauSac</label>
                <select name="idMauSac" class="form-select">
                    <c:forEach items="${ dsms }" var="ms2">
                        <option value="${ms2.id}" ${ms2.id == kh.ms.id ? "selected" :"" }>${ms2.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>idDongSP</label>
                <select name="idDongSP" class="form-select">
                    <c:forEach items="${ dsdsp }" var="dsp2">
                        <option value="${dsp2.id}" ${dsp2.id == kh.dsp.id ? "selected" :"" }>${dsp2.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>namBH</label>
                <input type="text" name="namBH" value="${ kh.namBH }" class="form-control" />
                <div class="error mt-2"><p>${errorNamBH}</p></div>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>moTa</label>
                <input type="text" name="moTa" value="${ kh.moTa }" class="form-control" />
                <div class="error mt-2"><p>${errorMoTa}</p></div>
            </div>
            <div class="col-6">
                <label>soLuongTon</label>
                <input type="text" name="soLuongTon" value="${ kh.soLuongTon }" class="form-control" />
                <div class="error mt-2"><p>${errorSoLuongTon}</p></div>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>giaNhap</label>
                <input type="number" name="giaNhap" value="${ kh.giaNhap }" class="form-control" />
                <div class="error mt-2"><p>${errorGiaNhap}</p></div>
            </div>
            <div class="col-6">
                <label>giaBan</label>
                <input type="number" name="giaBan" value="${ kh.giaBan }" class="form-control" />
                <div class="error mt-2"><p>${errorGiaBan}</p></div>
            </div>
        </div>
        <br>
        <button type="submit" class="btn btn-primary">Sửa</button>

    </form>
</div>
<script src="/DuAnMauJava4_war_exploded/js/bootstrap.min.js"></script>
