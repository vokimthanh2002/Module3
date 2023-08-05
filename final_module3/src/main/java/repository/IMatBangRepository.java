package repository;

import model.LoaiMatBang;
import model.MatBang;
import model.TrangThai;

import java.util.List;

public interface IMatBangRepository {
    void update(MatBang matBang);
    List<MatBang> getAllMatBang();
    MatBang findByLoaiMatBang(String loaiMatBang);
    MatBang findByTang(int tang);
    MatBang findByGia(float gia);
    void insert(MatBang matBang);
    void delete(String maMatBang);
    List<LoaiMatBang> getAllLoaiMatBang();
    List<TrangThai> getAllTrangThai();
    List<MatBang> listSort();


}
