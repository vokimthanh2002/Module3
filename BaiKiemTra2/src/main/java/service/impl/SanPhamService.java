package service.impl;

import model.DanhMuc;
import model.SanPham;
import repository.ISanPhamRepository;
import repository.impl.DBConnection;
import repository.impl.SanPhamRepository;
import service.ISanPhamService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SanPhamService implements ISanPhamService {
    private ISanPhamRepository repository = new SanPhamRepository();


    @Override
    public void update(SanPham sanPham) {
        repository.update(sanPham);
    }

    @Override
    public List<SanPham> getAllSanPham() {
        return repository.getAllSanPham();
    }

    @Override
    public SanPham findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void insert(SanPham sanPham) {
        repository.insert(sanPham);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public List<DanhMuc> getAllDanhMuc() {
        return repository.getAllDanhMuc();
    }

    @Override
    public DanhMuc getDanhMuc(int idDanhMuc) {
        return repository.getDanhMuc(idDanhMuc);
    }

    @Override
    public List<SanPham> findByName(String tenSanPham) {
        return repository.findByName(tenSanPham);
    }

    @Override
    public List<SanPham> sortSanPham() {
        return repository.sortSanPham();
    }
}
