package com.example.antiepidemic.service;

import com.example.antiepidemic.domain.Carousel;
import com.example.antiepidemic.result.Result;

import java.util.List;

public interface CarouselService {
    // 添加轮播图
    Result saveCarousels(String name, Long image , Long inputer);
    // 删除轮播图
    Result logicDeleteCarousels(Long id);
    // 修改轮播图
    Result updateCarousels(Long id ,String name , Long image);
    // 查询所有轮播图
    List<Carousel> listAllCarousels();
    // 查询某张轮播图
    Carousel getCarousel(Long id);
}
