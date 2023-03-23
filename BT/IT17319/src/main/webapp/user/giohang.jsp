<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sktfk
  Date: 21/03/2023
  Time: 8:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="carda">
    <div class="card">
        <div class="row">
            <div class="col-md-8 cart">
                <div class="title">
                    <div class="row">
                        <div class="col">
                            <h4><b>Shopping Cart</b></h4>
                        </div>
                        <div class="col align-self-center text-right text-muted">
                            3 items
                        </div>
                    </div>
                </div>
                <!--  -->
                <c:forEach items="${listcard}" var="x">
                    <div
                            class="row border-top border-bottom"
                    >
                        <div class="row main align-items-center">
                            <div class="col-1 cb">
                                <input
                                        class="form-check-input mt-4"
                                        type="checkbox"
                                        aria-label="Checkbox for following text input"
                                />
                            </div>
                            <div class="col-2">
                                <img class="img-fluid" ng-src="${x.anhSanPham}" />
                            </div>
                            <div class="col">
<%--                                <div class="row text-muted">{x.dongSanPham}</div>--%>
                                <div class="row">${x.tenSanPham}</div>
                            </div>
                            <div class="col">
                                <a href="/giohang/giamsl?ten=${x.tenSanPham}">-</a><a href="#" class="border">${x.soLuong}</a><a href="/giohang/tangsl?ten=${x.tenSanPham}">+</a>
                            </div>
                            <div class="col">
                                ${x.donGia}
                                    <a class="bi bi-eye" href="/giohang/detail?ma=${x.maGH}""></a>
                                <a class="close" href="/giohang/delete?ma=${x.maGH}">&#10005;</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <!--  -->

                <div class="back-to-shop">
                    <a href="#">&leftarrow;</a
                    ><span class="text-muted">Back to shop</span>
                </div>
            </div>
            <div class="col-md-4 summary">
                <div>
                    <h5><b>Tổng tiền</b></h5>
                </div>
                <hr />
                <c:forEach items="${listcard}" var="x">
                    <div class="row">
                        <div class="col" style="padding-left: 0">${x.tenSanPham}</div>
                        <div class="col text-right">${x.donGia}</div>
                    </div>
                </c:forEach>

                <div
                        class="row"
                        style="border-top: 1px solid rgba(0, 0, 0, 0.1); padding: 2vh 0"
                >
                    <div class="col">Tổng giá tiền</div>
                    <div class="col text-right">${tongTien}</div>
                </div>
                <button class="btn">CHECKOUT</button>
            </div>
        </div>
    </div>
</div>
