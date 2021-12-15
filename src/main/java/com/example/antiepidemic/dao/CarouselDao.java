package com.example.antiepidemic.dao;

import com.example.antiepidemic.domain.Carousel;

import java.util.List;

public interface CarouselDao {

    // 添加轮播图
    int saveCarousels(String name, Long image , Long inputer);
    // 删除轮播图
    int logicDeleteCarousels(Long id);
    // 修改轮播图
    int updateCarousels(Long id ,String name , Long image);
    // 查询所有轮播图
    List<Carousel> listAllCarousels();
    // 查询某张轮播图
    Carousel getCarousel(Long id);
    // 查询轮播图名是否存在
    boolean getCarouselName(String name);
}
