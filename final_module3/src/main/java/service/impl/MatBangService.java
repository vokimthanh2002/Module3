package service.impl;

import model.LoaiMatBang;
import model.MatBang;
import model.TrangThai;
import repository.IMatBangRepository;
import repository.impl.MatBangRepository;

import java.util.List;

public class MatBangService implements IMatbangService{
    IMatBangRepository repository = new MatBangRepository();
    @Override
    public void update(MatBang matBang) {
        repository.update(matBang);
    }

    @Override
    public List<MatBang> getAllMatBang() {
        return repository.getAllMatBang();
    }

    @Override
    public MatBang findByLoaiMatBang(String loaiMatBang) {
        return repository.findByLoaiMatBang(loaiMatBang);
    }

    @Override
    public MatBang findByTang(int tang) {
        return repository.findByTang(tang);
    }

    @Override
    public MatBang findByGia(float gia) {
        return repository.findByGia(gia);
    }

    @Override
    public void insert(MatBang matBang) {
        repository.insert(matBang);
    }

    @Override
    public void delete(String maMatBang) {
        repository.delete(maMatBang);
    }

    @Override
    public List<LoaiMatBang> getAllLoaiMatBang() {
        return repository.getAllLoaiMatBang();
    }

    @Override
    public List<TrangThai> getAllTrangThai() {
        return repository.getAllTrangThai();
    }

    @Override
    public List<MatBang> listSort() {
        return repository.listSort();
    }
}
