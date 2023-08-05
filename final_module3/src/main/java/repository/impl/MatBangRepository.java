package repository.impl;

import model.LoaiMatBang;
import model.MatBang;
import model.TrangThai;
import repository.IMatBangRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatBangRepository implements IMatBangRepository {

    public static final String DELETE_MATBANG = "delete  from MatBang where maMatBang=?";

    @Override
    public void update(MatBang matBang) {

    }

    @Override
    public List<MatBang> getAllMatBang() {
        List<MatBang> matBangList = new ArrayList<>();

        Connection connection = DBConnection.getConnection();
        PreparedStatement statement =null;
        ResultSet resultSet = null;
        if(connection!=null){
            try {
                statement = connection.prepareStatement("SELECT * from MatBang");
                resultSet= statement.executeQuery();
                MatBang matBang = null;
                while (resultSet.next()){
                    String maMatBang = resultSet.getString("maMatBang");
                    String trangThai = resultSet.getString("trangThai");
                    float dienTich = resultSet.getFloat("dienTich");
                    int tang = resultSet.getInt("tang");
                    String loaiMatBang = resultSet.getString("loaiMatBang");
                    float  giaTien = resultSet.getFloat("giaTien");
                    String ngayBatDau= resultSet.getString("ngayBatDau");
                    String ngayKetThuc= resultSet.getString("ngayKetThuc");
                    matBang = new MatBang(maMatBang,trangThai,dienTich,tang,loaiMatBang,giaTien,ngayBatDau,ngayKetThuc);
                    matBangList.add(matBang);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            finally {
                try {
                    resultSet.close();
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }
        }
        return matBangList;
    }

    @Override
    public MatBang findByLoaiMatBang(String loaiMatBang) {
        return null;
    }

    @Override
    public MatBang findByTang(int tang) {
        return null;
    }

    @Override
    public MatBang findByGia(float gia) {
        return null;
    }

    @Override
    public void insert(MatBang matBang) {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO MatBang VALUES (?,?,?,?,?,?,?,?)");
            statement.setString(1,matBang.getMaMatBang());
            statement.setString(2,matBang.getTrangThai());
            statement.setFloat(3,matBang.getDienTich());
            statement.setInt(4,matBang.getTang());
            statement.setString(5,matBang.getLoaiMatBang());
            statement.setFloat(6,matBang.getGiaTien());
            statement.setString(7,matBang.getNgayBatDau());
            statement.setString(8,matBang.getNgayKetthuc());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(String maMatBang) {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement  statement = connection.prepareStatement(DELETE_MATBANG);
            statement.setString(1,maMatBang);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        };

    }

    @Override
    public List<LoaiMatBang> getAllLoaiMatBang() {
        List<LoaiMatBang> loaiMatBangList= new ArrayList<>();
        loaiMatBangList.add(new LoaiMatBang("Van Phong Chia Se"));
        loaiMatBangList.add(new LoaiMatBang("Van Phong Tron Goi"));
        return loaiMatBangList;
    }

    @Override
    public List<TrangThai> getAllTrangThai() {
        List<TrangThai> trangThaiList= new ArrayList<>();
        trangThaiList.add(new TrangThai("Trong"));
        trangThaiList.add(new TrangThai("Ha Tang"));
        trangThaiList.add(new TrangThai("Day Du"));
        return trangThaiList;
    }

    @Override
    public List<MatBang> listSort() {
        List<MatBang> listSort = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        MatBang matBang =null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from MatBang order by dienTich");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String maMatBang = resultSet.getString("maMatBang");
                String trangThai = resultSet.getString("trangThai");
                float dienTich = resultSet.getFloat("dienTich");
                int tang = resultSet.getInt("tang");
                String loaiMatBang = resultSet.getString("loaiMatBang");
                float  giaTien = resultSet.getFloat("giaTien");
                String ngayBatDau= resultSet.getString("ngayBatDau");
                String ngayKetThuc= resultSet.getString("ngayKetThuc");
                matBang = new MatBang(maMatBang,trangThai,dienTich,tang,loaiMatBang,giaTien,ngayBatDau,ngayKetThuc);
                listSort.add(matBang);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listSort;
    }

    public static List<MatBang> findByName(String loaiMatBang) {
        List<MatBang> matBangList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        try (
                PreparedStatement statement = connection.prepareStatement("select * from MatBang where loaiMatBang like ?")) {
            statement.setString(1, "%" + loaiMatBang + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String maMatBang = resultSet.getString("maMatBang");
                String trangThai = resultSet.getString("trangThai");
                String loaiMatBang1= resultSet.getString("loaiMatBang");
                float dienTich = resultSet.getFloat("dienTich");
                int tang = resultSet.getInt("tang");
                float  giaTien = resultSet.getFloat("giaTien");
                String ngayBatDau= resultSet.getString("ngayBatDau");
                String ngayKetThuc= resultSet.getString("ngayKetThuc");
                MatBang matBang = new MatBang(maMatBang,trangThai,dienTich,tang,loaiMatBang1,giaTien,ngayBatDau,ngayKetThuc);
                matBangList.add(matBang);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return matBangList;
    }
    }
