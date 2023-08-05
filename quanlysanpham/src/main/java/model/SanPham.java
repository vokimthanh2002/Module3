package model;

public class SanPham {
    private int id;
    private String ten;
    private double gia;
    private String moTaSanPham;
    private String nhaSanXuat;

    public SanPham(int id, String ten, double gia, String moTaSanPham, String nhaSanXuat) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.moTaSanPham = moTaSanPham;
        this.nhaSanXuat = nhaSanXuat;
    }

    public SanPham() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getMoTaSanPham() {
        return moTaSanPham;
    }

    public void setMoTaSanPham(String moTaSanPham) {
        this.moTaSanPham = moTaSanPham;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }
}
