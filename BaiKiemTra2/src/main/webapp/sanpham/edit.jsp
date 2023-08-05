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
<a href="/sanpham">Tro ve danh sach san pham</a>
<form method="post">
  <div class="form-row">
    <div class="form-group col-md-6">
      <label>Ten San Pham</label>
      <input name="tenSP" type="text" class="form-control"  placeholder="Nhap ten san pham" value="${requestScope["sanpham"].getTenSanPham()}">
    </div>
    <div class="form-group col-md-4">
      <label >Danh Muc</label>
      <select name="maDM" class="form-control">
        <option value="${requestScope["sanpham"].getIdDanhMuc()}">${requestScope["sanpham"].getTenDanhMuc()}</option>
        <c:forEach items="${listDM}" var ="danhmuc">
          <option value="${danhmuc.getIdDanhMuc()}">${danhmuc.getTenDanhMuc()}</option>
        </c:forEach>
      </select>
    </div>
    <div class="form-group col-md-6">
      <label>Gia</label>
      <input name="gia" type="text" class="form-control"  placeholder="Nhap gia san pham" value="${requestScope["sanpham"].getGia()}">
    </div>
    <div class="form-group col-md-6">
      <label>So luong san pham</label>
      <input name="soluong" type="text" class="form-control" placeholder="Nhap so luong san pham" value="${requestScope["sanpham"].getSoLuong()}"  >
    </div>
    <div class="form-group col-md-6">
      <label>Mau sac san pham</label>
      <input name="mausac" type="text" class="form-control" placeholder="Nhap mau sac san pham"  value="${requestScope["sanpham"].getMauSac()}"  >
    </div>
    <div class="form-group col-md-6">
      <label>Mo ta</label>
      <input name="moTa" type="text" class="form-control"  placeholder="Nhap mo ta" value="${requestScope["sanpham"].getMoTa()}">
    </div>

  </div>

  <button type="submit" class="btn btn-primary">Chinh sua</button>
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