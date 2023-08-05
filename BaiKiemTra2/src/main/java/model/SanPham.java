package model;

public class SanPham {
    int idSanPham;
    String tenSanPham;
    Double gia;
    int soLuong;
    String mauSac;
    String moTa;
    int idDanhMuc;
    String tenDanhMuc;

    public SanPham() {
    }

    public SanPham(String tenSanPham, Double gia, int soLuong, String mauSac, String moTa, int idDanhMuc) {
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.soLuong = soLuong;
        this.mauSac = mauSac;
        this.moTa = moTa;
        this.idDanhMuc = idDanhMuc;
    }

    public SanPham(int idSanPham, String tenSanPham, Double gia, int soLuong, String mauSac, String moTa, String tenDanhMuc) {
        this.idSanPham = idSanPham;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.soLuong = soLuong;
        this.mauSac = mauSac;
        this.moTa = moTa;
        this.tenDanhMuc = tenDanhMuc;
    }

    public SanPham(int idSanPham, String tenSanPham, Double gia, int soLuong, String mauSac, String moTa, int idDanhMuc) {
        this.idSanPham = idSanPham;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.soLuong = soLuong;
        this.mauSac = mauSac;
        this.moTa = moTa;
        this.idDanhMuc = idDanhMuc;
    }

    public SanPham(int idSanPham, String tenSanPham, Double gia, int soLuong, String mauSac, String moTa, int idDanhMuc, String tenDanhMuc) {
        this.idSanPham = idSanPham;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.soLuong = soLuong;
        this.mauSac = mauSac;
        this.moTa = moTa;
        this.idDanhMuc = idDanhMuc;
        this.tenDanhMuc = tenDanhMuc;
    }


    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setIdDanhMuc(int idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "idSanPham=" + idSanPham +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", gia=" + gia +
                ", soLuong=" + soLuong +
                ", mauSac='" + mauSac + '\'' +
                ", moTa='" + moTa + '\'' +
                ", idDanhMuc=" + idDanhMuc +
                ", tenDanhMuc='" + tenDanhMuc + '\'' +
                '}';
    }
}
