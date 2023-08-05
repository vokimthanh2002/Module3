<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/static/datatables/css/dataTables.bootstrap4.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
<%--header--%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <img src="https://cf.shopee.vn/file/574c453dfb1de06280875b72010b338c" style="height: 100px " >
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="/sanpham">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Features</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Pricing</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Dropdown link
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
        </ul>
    </div>
</nav>
<h1 style="text-align: center">Danh sách sản phẩm</h1>
<div class="row flex-column align-items-end mr-5" >
    <nav class="navbar navbar-light bg-light justify-content-end">
         <form method="get">
             <input type="hidden" name="action" value="sort">
             <button class="btn btn-success" type="submit" > Sap xep </button> &emsp;
         </form>
        <button class="btn btn-success" type="submit" onclick="window.location.href='/sanpham?action=create'"> Them moi san pham </button> &emsp;
        <form  class="form-inline" method="get" >
            <input class="form-control mr-sm-2" type="search"  placeholder="Ten san pham" aria-label="Search" name="inputSearch">
            <input type="hidden" name="action" value="search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit" >Search</button>
        </form>
    </nav>
</div>
<table class="table table-sm table-dark" class="table" id="tableStudent">
    <thead>
    <tr>
        <th scope="col">Id San Pham</th>
        <th scope="col">Ten San Pham</th>
        <th scope="col">Gia</th>
        <th scope="col">So Luong</th>
        <th scope="col">Mau Sac</th>
        <th scope="col">Mo Ta</th>
        <th scope="col">Danh Muc</th>
        <th scope="col">Chuc Nang</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${sanPhamList}" var="sanpham">
        <tr>
            <td scope="row"><a href="/sanpham?action=view&id=${sanpham.getIdSanPham()}">${sanpham.getIdSanPham()}</a></td>
            <th scope="row">${sanpham.getTenSanPham()}</th>
            <th scope="row">${sanpham.getGia()}</th>
            <th scope="row">${sanpham.getSoLuong()}</th>
            <th scope="row">${sanpham.getMauSac()}</th>
            <th scope="row">${sanpham.getMoTa()}</th>
            <th scope="row">${sanpham.getTenDanhMuc()}</th>
            <th scope="row">
                <button type="submit" class="btn btn-info" onclick="window.location.href='/sanpham?action=edit&id=${sanpham.getIdSanPham()}'"> Chỉnh Sửa </button>
                <button type="submit" class="btn btn-danger" data-toggle="modal"
                        data-target="#exampleModal" onclick="onDelete(${sanpham.getIdSanPham()})"> Xóa </button>
            </th>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Xóa san pham này!</h5>
            </div>
            <form method="post" action="/sanpham?action=delete">
                <input type="hidden" name="idDelete" id="id">
                <div class="modal-body">
                    <p>Bạn có thật sự muốn xóa</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-danger">Delete</button>
                </div>
            </form>

        </div>
    </div>
</div>

<%--footer--%>
<!-- Footer -->
<footer class="page-footer font-small mdb-color lighten-3 pt-4">

    <!-- Footer Elements -->
    <div class="container">

        <!--Grid row-->
        <div class="row">

            <!--Grid column-->
            <div class="col-lg-2 col-md-12 mb-4">

                <!--Image-->
                <div class="view overlay z-depth-1-half">
                    <img src="https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(73).webp" class="img-fluid"
                         alt="">
                    <a href="">
                        <div class="mask rgba-white-light"></div>
                    </a>
                </div>

            </div>
            <!--Grid column-->

            <!--Grid column-->
            <div class="col-lg-2 col-md-6 mb-4">

                <!--Image-->
                <div class="view overlay z-depth-1-half">
                    <img src="https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(78).webp" class="img-fluid"
                         alt="">
                    <a href="">
                        <div class="mask rgba-white-light"></div>
                    </a>
                </div>

            </div>
            <!--Grid column-->

            <!--Grid column-->
            <div class="col-lg-2 col-md-6 mb-4">

                <!--Image-->
                <div class="view overlay z-depth-1-half">
                    <img src="https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(79).webp" class="img-fluid"
                         alt="">
                    <a href="">
                        <div class="mask rgba-white-light"></div>
                    </a>
                </div>

            </div>
            <!--Grid column-->

            <!--Grid column-->
            <div class="col-lg-2 col-md-12 mb-4">

                <!--Image-->
                <div class="view overlay z-depth-1-half">
                    <img src="https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(81).webp" class="img-fluid"
                         alt="">
                    <a href="">
                        <div class="mask rgba-white-light"></div>
                    </a>
                </div>

            </div>
            <!--Grid column-->

            <!--Grid column-->
            <div class="col-lg-2 col-md-6 mb-4">

                <!--Image-->
                <div class="view overlay z-depth-1-half">
                    <img src="https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(82).webp" class="img-fluid"
                         alt="">
                    <a href="">
                        <div class="mask rgba-white-light"></div>
                    </a>
                </div>

            </div>
            <!--Grid column-->

            <!--Grid column-->
            <div class="col-lg-2 col-md-6 mb-4">

                <!--Image-->
                <div class="view overlay z-depth-1-half">
                    <img src="https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(84).webp" class="img-fluid"
                         alt="">
                    <a href="">
                        <div class="mask rgba-white-light"></div>
                    </a>
                </div>

            </div>
            <!--Grid column-->

        </div>
        <!--Grid row-->

    </div>
    <!-- Footer Elements -->

    <!-- Copyright -->
    <div class="footer-copyright text-center py-3">© 2023 Copyright:
        <a href="/">vokimthanh</a>
    </div>
    <!-- Copyright -->

</footer>
<!-- Footer -->
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
<script src="/static/datatables/js/jquery.dataTables.js"></script>
<script src="/static/datatables/js/dataTables.bootstrap4.js"></script>
<script>
    $(document).ready(function () {
        $('#tableStudent').dataTable({
            'searching': false,
            "order": [],
            'pageLength' : 10
        })
    })
    function onDelete(id) {
        document.getElementById("id").value = id;
    }

</script>

</body>
</html>