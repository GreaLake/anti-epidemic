package com.example.antiepidemic.dao.impl;

import com.example.antiepidemic.dao.CarouselDao;
import com.example.antiepidemic.domain.Carousel;
import com.example.antiepidemic.utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarouselDaoImpl implements CarouselDao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    /**
     * 添加轮播图
     * @param name
     * @param image
     * @param inputer
     * @return
     */
    @Override
    public int saveCarousels(String name, Long image, Long inputer) {
        int count = 0;
        try {
            // 获取连接，定义SQL语句
            conn = DruidUtils.getConnection();
            // 定义Sql语句
            String sql = "insert tb_carousel(name,image,inputer,is_delete,gmt_create,gmt_modified) values(?,?,?,0,now(),now())";
            // 获取sql语句得执行对象
            ps = conn.prepareStatement(sql);
            // 设置name,image,inputer字段
            ps.setString(1,name);
            ps.setLong(2,image);
            ps.setLong(3,inputer);
            // 执行SQL语句
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DruidUtils.close(ps,conn);
        }
        return count;
    }

    /**
     * 逻辑删除轮播图
     * @param id
     * @return
     */
    @Override
    public int logicDeleteCarousels(Long id) {
        int count = 0;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "update tb_carousel set is_delete = 1 where id =?";
            // 获取sql语句的执行对象
            ps = conn.prepareStatement(sql);
            // 设置字段
            ps.setLong(1,id);
            // 执行sql语句的对象
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DruidUtils.close(ps,conn);
        }
        return count;
    }

    /**
     * 更新轮播图
     * @param id
     * @param name
     * @param image
     * @return
     */
    @Override
    public int updateCarousels(Long id, String name, Long image) {
        int count = 0;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "update tb_carousel set name= ? , image= ? where id = ?";
            // 获取sql语句的执行对象
            ps = conn.prepareStatement(sql);
            // 设置字段
            ps.setString(1,name);
            ps.setLong(2,image);
            ps.setLong(3,id);
            // 执行sql语句
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DruidUtils.close(ps,conn);
        }
        return count;
    }

    /**
     * 查询所有轮播图
     * @return
     */
    @Override
    public List<Carousel> listAllCarousels() {
        List<Carousel> carousels = new ArrayList<>() ;

        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义SQL
            String sql = "select id,name,image,inputer,is_delete,gmt_create,gmt_modified from tb_carousel where is_delete=0";
            // 获取sql对象的preparastatement
            ps = conn.prepareStatement(sql);
            // 执行sql语句
            rs = ps.executeQuery();
            // 封装对象，装载集合
            while (rs.next()){
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                Long image = rs.getLong("image");
                Long inputer = rs.getLong("inputer");
                Boolean is_delete = rs.getBoolean("is_delete");
                Date gmt_create = rs.getDate("gmt_create");
                Date gmt_modified = rs.getDate("gmt_modified");
                // 封装为对象
                Carousel carousel = new Carousel(id,name,image,inputer,is_delete,gmt_create,gmt_modified);
                // 装载集合
                carousels.add(carousel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DruidUtils.close(rs,ps,conn);
        }
        return carousels;
    }

    /**
     * 查询某张轮播图
     * @param id
     * @return
     */
    @Override
    public Carousel getCarousel(Long id) {
        Carousel carousel = null;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义SQL
            String sql = "select id,name,image,inputer,is_delete,gmt_create,gmt_modified from tb_carousel where is_delete=0";
            // 获取sql对象的preparastatement
            ps = conn.prepareStatement(sql);
            // 执行sql语句
            rs = ps.executeQuery();
            // 封装对象，装载集合
            while (rs.next()){
                String name = rs.getString("name");
                Long image = rs.getLong("image");
                Long inputer = rs.getLong("inputer");
                Boolean is_delete = rs.getBoolean("is_delete");
                Date gmt_create = rs.getDate("gmt_create");
                Date gmt_modified = rs.getDate("gmt_modified");
                // 封装为对象
                carousel = new Carousel(id,name,image,inputer,is_delete,gmt_create,gmt_modified);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DruidUtils.close(rs,ps,conn);
        }
        return carousel;
    }

    /**
     * 判断name 轮播图名是否存在,flag为flase不存在，true存在
     * @param name
     * @return
     */
    @Override
    public boolean getCarouselName(String name) {
        boolean flag = false;//不存在
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义SQL
            String sql = "select name from tb_carousel where name = ? and is_delete=0";
            // 获取sql对象的preparastatement
            ps = conn.prepareStatement(sql);
            // 设置字段
            ps.setString(1,name);
            // 执行sql语句
            rs = ps.executeQuery();
            flag = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(rs,ps,conn);
        }
        return flag;
    }
}
