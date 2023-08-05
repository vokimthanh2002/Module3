package repository.impl;

import jdk.javadoc.internal.doclets.toolkit.builders.ConstructorBuilder;
import model.DanhMuc;
import model.SanPham;
import repository.ISanPhamRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SanPhamRepository implements ISanPhamRepository {

    public static final String SELECT_FROM_SAN_PHAM = "select idSanPham,tenSanPham,gia,soLuong,mauSac,moTa,tenDanhMuc from SanPham as sp join DanhMuc as dm on sp.idDanhMuc = dm.idDanhMuc";
    public static final String SELECT_FROM_DANH_MUC = "SELECT * FROM DanhMuc";
    public static final String INSERT_SAN_PHAM = "INSERT INTO SanPham(`tenSanPham`, `gia`, `soLuong`, `mauSac`, `moTa`, `idDanhMuc`) VALUES(?,?,?,?,?,?)";
    public static final String FIND_BY_ID = "select idSanPham,tenSanPham,gia,soLuong,mauSac,moTa,tenDanhMuc,dm.idDanhMuc from SanPham as sp join DanhMuc as dm on sp.idDanhMuc = dm.idDanhMuc where idSanPham=?";
    public static final String UPDATE_SAN_PHAM = "UPDATE SanPham set tenSanPham=?, gia=?, mauSac=?,idDanhMuc=?,soLuong=?,moTa=? where idSanPham=?;";
    public static final String DELETE_SAN_PHAM = "delete from SanPham where idSanPham=?";
    public static final String SELECT_SANPHAM_BY_NAME = "select idSanPham,tenSanPham,gia,soLuong,mauSac,moTa,tenDanhMuc from SanPham as sp join DanhMuc as dm on sp.idDanhMuc = dm.idDanhMuc where tenSanPham like ?;";

    @Override
    public void update(SanPham sanPham) {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_SAN_PHAM);
            statement.setString(1,sanPham.getTenSanPham());
            statement.setDouble(2,sanPham.getGia());
            statement.setString(3,sanPham.getMauSac());
            statement.setInt(4,sanPham.getIdDanhMuc());
            statement.setInt(5,sanPham.getSoLuong());
            statement.setString(6,sanPham.getMoTa());
            statement.setInt(7,sanPham.getIdSanPham());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<SanPham> getAllSanPham() {
        List<SanPham> sanPhamList = new ArrayList<>();

        Connection connection = DBConnection.getConnection();
        PreparedStatement statement =null;
        ResultSet resultSet = null;
        if(connection!=null){
            try {
                statement = connection.prepareStatement(SELECT_FROM_SAN_PHAM);
                resultSet= statement.executeQuery();
                SanPham sanPham = null;
                while (resultSet.next()){
                    int idSanPham =resultSet.getInt("idSanPham");
                    String tenSanPham = resultSet.getString("tenSanPham");
                    Double gia = resultSet.getDouble("gia");
                    int soLuong = resultSet.getInt("soLuong");
                    String mauSac = resultSet.getString("mauSac");
                    String moTa = resultSet.getString("moTa");
                    String tenDanhMuc = resultSet.getString("tenDanhMuc");
                    sanPham = new SanPham(idSanPham,tenSanPham,gia,soLuong,mauSac,moTa,tenDanhMuc);
                    sanPhamList.add(sanPham);
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
        return sanPhamList;
    }

    @Override
    public SanPham findById(int id) {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
            statement.setInt(1,id);
            ResultSet resultSet= statement.executeQuery();
            SanPham sanPham;
            while (resultSet.next()){
                String tenSanPham = resultSet.getString("tenSanPham");
                Double gia = resultSet.getDouble("gia");
                int soLuong = resultSet.getInt("soLuong");
                String mauSac = resultSet.getString("mauSac");
                String moTa = resultSet.getString("moTa");
                String tenDanhMuc = resultSet.getString("tenDanhMuc");
                int idDanhMuc = resultSet.getInt("idDanhMuc");
                sanPham = new SanPham(id,tenSanPham,gia,soLuong,mauSac,moTa,idDanhMuc,tenDanhMuc);
                return sanPham;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public void insert(SanPham sanPham) {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_SAN_PHAM);
            statement.setString(1,sanPham.getTenSanPham());
            statement.setDouble(2,sanPham.getGia());
            statement.setInt(3,sanPham.getSoLuong());
            statement.setString(4,sanPham.getMauSac());
            statement.setString(5,sanPham.getMoTa());
            statement.setInt(6,sanPham.getIdDanhMuc());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void delete(int id) {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement  statement = connection.prepareStatement(DELETE_SAN_PHAM);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<DanhMuc> getAllDanhMuc() {
        List<DanhMuc> danhMucList = new ArrayList<>();

        Connection connection = DBConnection.getConnection();
        PreparedStatement statement =null;
        ResultSet resultSet = null;
        if(connection!=null){
            try {
                statement = connection.prepareStatement(SELECT_FROM_DANH_MUC);
                resultSet= statement.executeQuery();
                DanhMuc danhMuc = null;
                while (resultSet.next()){
                    int idDanhMuc = resultSet.getInt("idDanhMuc");
                    String tenDanhMuc = resultSet.getString("tenDanhMuc");
                    danhMuc = new DanhMuc(idDanhMuc,tenDanhMuc);
                    danhMucList.add(danhMuc);

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

        return danhMucList;
    }

    @Override
    public DanhMuc getDanhMuc(int idDanhMuc) {
        return null;
    }

    @Override
    public List<SanPham> findByName(String tenSanPham) {
        List<SanPham> productList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        try (
            PreparedStatement statement = connection.prepareStatement(SELECT_SANPHAM_BY_NAME)) {
            statement.setString(1, "%" + tenSanPham + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idSanPham");
                String tenSP = rs.getString("tenSanPham");
                double gia = rs.getDouble("gia");
                int soLuong = rs.getInt("soLuong");
                String color = rs.getString("mauSac");
                String moTa = rs.getString("moTa");
                String tenDanhMuc= rs.getString("tenDanhMuc");
                productList.add(new SanPham(id, tenSP, gia, soLuong, color, moTa, tenDanhMuc));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<SanPham> sortSanPham() {
        List<SanPham> listSort = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        SanPham sanPham =null;
        try {
            PreparedStatement statement = connection.prepareStatement("select idSanPham,tenSanPham,gia,soLuong,mauSac,moTa,tenDanhMuc from SanPham as sp join DanhMuc as dm on sp.idDanhMuc = dm.idDanhMuc order by gia");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int idSanPham = resultSet.getInt("idSanPham");
                String tenSanPham = resultSet.getString("tenSanPham");
                Double gia = resultSet.getDouble("gia");
                int soLuong = resultSet.getInt("soLuong");
                String mauSac = resultSet.getString("mauSac");
                String moTa =resultSet.getString("moTa");
                String tenDanhMuc= resultSet.getString("tenDanhMuc");
                sanPham= new SanPham(idSanPham,tenSanPham,gia,soLuong,mauSac,moTa,tenDanhMuc);
                listSort.add(sanPham);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listSort;
    }
}
