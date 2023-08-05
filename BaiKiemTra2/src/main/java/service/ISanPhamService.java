package service;

import model.DanhMuc;
import model.SanPham;

import java.util.List;

public interface ISanPhamService {
    void update(SanPham sanPham);
    List<SanPham> getAllSanPham();
    SanPham findById(int id);
    void insert(SanPham sanPham);
    void delete(int id);
    List<DanhMuc> getAllDanhMuc();
    DanhMuc getDanhMuc(int idDanhMuc);
    List<SanPham> findByName(String tenSanPham);
    List<SanPham> sortSanPham();
}
