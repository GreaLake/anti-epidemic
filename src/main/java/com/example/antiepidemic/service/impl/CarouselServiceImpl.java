package com.example.antiepidemic.service.impl;

import com.example.antiepidemic.dao.CarouselDao;
import com.example.antiepidemic.dao.impl.CarouselDaoImpl;
import com.example.antiepidemic.domain.Carousel;
import com.example.antiepidemic.result.Result;
import com.example.antiepidemic.service.CarouselService;

import java.util.List;

public class CarouselServiceImpl implements CarouselService {

    CarouselDao carouselDao = new CarouselDaoImpl();
    /**
     * 添加轮播图
     * 成功：
     * 1. 轮播图添加成功
     * 失败：
     * 2. 轮播图已存在
     * 3. 轮播图插入失败
     * @param name
     * @param image
     * @param inputer
     * @return
     */
    @Override
    public Result saveCarousels(String name, Long image, Long inputer) {
        Result result = null;
        boolean flag = carouselDao.getCarouselName(name);
        if (!flag){// 不存在的话
            int count = carouselDao.saveCarousels(name, image, inputer);
            if(count == 1){
                result = new Result("插入成功",count,null);
            }else {
                result = new Result("插入失败",count,null);
            }
        }else {// 存在的话
            result = new Result("该轮播图名已存在",null,null);
        }
        return result;
    }

    /**
     * 逻辑删除轮播图
     * 成功 ： 删除成功
     * 失败 ： 删除失败
     * @param id
     * @return
     */
    @Override
    public Result logicDeleteCarousels(Long id) {
        Result result = null;
        int count = carouselDao.logicDeleteCarousels(id);
        if (count == 1){
            result = new Result("删除成功",count,null);
        }else {
            result = new Result("删除失败",count,null);
        }
        return result;
    }

    /**
     * 更新轮播图
     * 成功： 更新成功
     * 失败： 更新失败
     * @param id
     * @param name
     * @param image
     * @return
     */
    @Override
    public Result updateCarousels(Long id, String name, Long image) {
        Result result = null;
        int count = carouselDao.updateCarousels(id,name,image);
        if (count == 1){
            result = new Result("修改成功",count,null);
        }else {
            result = new Result("修改失败",count,null);
        }
        return result;
    }

    /**
     * 查找所有轮播图
     * @return
     */
    @Override
    public List<Carousel> listAllCarousels() {
        List<Carousel> carousels = carouselDao.listAllCarousels();
        return carousels;
    }

    /**
     * 查找某张轮播图
     * @param id
     * @return
     */
    @Override
    public Carousel getCarousel(Long id) {
        Carousel carousel = carouselDao.getCarousel(id);
        return carousel;
    }
}
