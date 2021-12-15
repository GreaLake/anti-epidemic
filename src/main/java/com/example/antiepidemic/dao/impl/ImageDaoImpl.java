package com.example.antiepidemic.dao.impl;

import com.example.antiepidemic.dao.ImageDao;
import com.example.antiepidemic.domain.Image;
import com.example.antiepidemic.utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ImageDaoImpl implements ImageDao {

    Connection connection = null;

    PreparedStatement statement = null;

    ResultSet resultSet = null;

    @Override
    public Integer insertImage(String name, String path, Integer inputer) {
        try{
            connection = DruidUtils.getConnection();
            String sql = "insert into `tb_image` values (null,?,?,?,0,now(),now());";
            statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,path);
            statement.setInt(3,inputer);
            Integer result = statement.executeUpdate();
            DruidUtils.close(resultSet,statement,connection);
            return result;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer updateImage(String id, String name, String path) {
        try{
            connection = DruidUtils.getConnection();
            String sql = "update `tb_image` " +
                    "set name = ? ,path = ?,gmt_update = now() where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,path);
            statement.setString(3,id);
            Integer result = statement.executeUpdate();
            DruidUtils.close(resultSet,statement,connection);
            return result;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer deleteImage(String id) {
        try{
            connection = DruidUtils.getConnection();
            String sql = "update `tb_image` " +
                    "set is_delete = 1,gmt_update = now() where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,id);
            Integer result = statement.executeUpdate();
            DruidUtils.close(resultSet,statement,connection);
            return result;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Image queryOneImage(String id) {
        return null;
    }

    @Override
    public List<Image> listAllImage() {
        return null;
    }
}
