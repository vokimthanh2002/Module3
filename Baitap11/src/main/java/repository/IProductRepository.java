package repository;

import models.Product;

import java.beans.Customizer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IProductRepository  implements ProductRepository{

    public static final String SELECT_FROM_PRODUCT = "select * from product";
    List<Product> productList;

    @Override
    public List<Product> findAll() {
        // tạo connection
        Connection connection = DBConnection.getConnection();

        //khai bao
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        productList = new ArrayList<>();

        if(connection!=null){
            try{

                preparedStatement = connection.prepareStatement(SELECT_FROM_PRODUCT);
                resultSet= preparedStatement.executeQuery();
                Product product = null;
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String ten =resultSet.getString("ten");
                    Double gia =resultSet.getDouble("gia");
                    String image = resultSet.getString("image");

                    product = new Product(id,ten,gia,image);
                    productList.add(product);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    resultSet.close();
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }



        return productList;
    }

    @Override
    public void save(Product product) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if(connection!= null){
            try {
                preparedStatement= connection.prepareStatement("INSERT INTO product(id,ten,gia,image) VALUES (?,?,?,?)");

                preparedStatement.setInt(1, product.getIdProduct());
                preparedStatement.setString(2, product.getNameProduct());
                preparedStatement.setDouble(3, product.getPrice());
                preparedStatement.setString(4, product.getImage());

                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Product finById(int id) {
        Product p = new Product();
        for(Product product: productList){
            if(product.getIdProduct()==id){
                p=product;
            }
        }
       return p;
    }

    @Override
    public void update(int id,Product product) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if(connection!= null){
            try {
                preparedStatement= connection.prepareStatement("UPDATE product set ten=?, gia=?, image=? where id=?");
                preparedStatement.setString(1, product.getNameProduct());
                preparedStatement.setDouble(2, product.getPrice());
                preparedStatement.setString(3, product.getImage());
                preparedStatement.setInt(4, product.getIdProduct());
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }
}
