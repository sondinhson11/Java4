<%--
  Created by IntelliJ IDEA.
  User: sktfk
  Date: 20/03/2023
  Time: 9:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav">
                <li class="nav-item me-4">
                    <a class="nav-link pr" href="/ctsanpham/index">Chi tiết sản phẩm</a>
                </li>
                <li class="nav-item me-4">
                    <a class="nav-link pr" href="/sanpham/index">Sản phẩm</a>
                </li>
                <li class="nav-item me-4">
                    <a class="nav-link pr" href="/dongsp/index">Dòng sản phẩm</a>
                </li>
                <li class="nav-item me-4">
                    <a class="nav-link pr" href="/nsx/index">Nhà sản xuất</a>
                </li>
                <li class="nav-item me-4">
                    <a class="nav-link pr" href="/mausac/index">Màu sắc</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<script>
    // window.addEventListener("load", function () {
    //     // Lấy node thứ hai trong allSideMenu
    //     const node2 = allSideMenu[2];
    //
    //     // Kích hoạt sự kiện click trên node thứ hai
    //     node2.click();
    // });
    // Set active menu from local storage (if exists)
    const activeMenu = localStorage.getItem('activeMenu');
    if (activeMenu) {
        const activeMenuEl = document.getElementById(activeMenu);
        if (activeMenuEl) {
            activeMenuEl.classList.add('active');
        }
    }

</script>