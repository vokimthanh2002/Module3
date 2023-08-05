<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<a href="/matbang">Tro ve danh sach sach mat bang</a>
<form method="post">
    <div class="form-row">
        <div class="form-group col-md-6">
            <label>Ma Mat Bang</label>
            <input name="maMB" type="text" class="form-control"  placeholder="Nhap ten mat bang">
        </div>
        <div class="form-group col-md-6">
            <label>Dien Tich</label>
            <input name="dienTich" type="text" class="form-control"  placeholder="Nhap dien tich">
        </div>
        <div class="form-group col-md-4">
            <label >Trang Thai</label>
            <select name="trangThai" class="form-control">
                <c:forEach items="${trangThaiList}" var ="trangThai">
                    <option value="${trangThai.getTenTrangThai()}">${trangThai.getTenTrangThai()}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group col-md-6">
            <label>Tang</label>
            <input name="tang" type="number" class="form-control" >
        </div>
        <div class="form-group col-md-4">
            <label >Loai Van Phong</label>
            <select name="loaiVanPhong" class="form-control">
                <c:forEach items="${loaiMatBangList}" var ="loaiMatBang">
                    <option value="${loaiMatBang.getTenLoaiMatBang()}">${loaiMatBang.getTenLoaiMatBang()}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group col-md-6">
            <label>Mo ta chi tiet</label>
            <input name="moTa" type="text" class="form-control" placeholder="Nhap mo ta"  >
        </div>
        <div class="form-group col-md-6">
            <label>Gia Cho Thue</label>
            <input name="gia" type="text" class="form-control" placeholder="Nhap Gia"   >   VND
        </div>
        <div class="form-group col-md-6">
            <label>Ngay Bat Dau</label>
            <input name="ngayBD" type="date" class="form-control" >
        </div>
        <div class="form-group col-md-6">
            <label>Ngay Ket Thuc</label>
            <input name="ngayKT" type="date" class="form-control" >
        </div>

    </div>

    <button type="submit" class="btn btn-primary">Tao moi</button>
</form>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>