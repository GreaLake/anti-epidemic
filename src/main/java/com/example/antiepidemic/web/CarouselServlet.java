package com.example.antiepidemic.web;

import com.example.antiepidemic.domain.Carousel;
import com.example.antiepidemic.result.Result;
import com.example.antiepidemic.service.CarouselService;
import com.example.antiepidemic.service.impl.CarouselServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 1.*快乐每一天
 * 2 * @Author: lake
 * 3 * @Date: 2021/12/15 20:40
 * 4
 */
public class CarouselServlet extends HttpServlet {
    private CarouselService carouselService = new CarouselServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应的输出格式和编码
        response.setContentType("text/html;charset=UTF-8");
        // 获取参数action/method
        String action = request.getParameter("action");
        if ("save".equals(action)){
            // 调用添加功能
            save(request,response);
        }else if("logicDel".equals(action)){
            // 调用逻辑删除功能
            logicDel(request,response);
        }else if("update".equals(action)){
            // 调用更新功能
            update(request,response);
        }else if("listCarousels".equals(action)){
            // 调用查询所有轮播图功能
            listCarousels(request,response);
        }else if("getCarousel".equals(action)){
            // 调用查询某张轮播图功能
            getCarousel(request,response);
        }
    }
    private void save(HttpServletRequest request,HttpServletResponse response) throws IOException {
        // 接收参数
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String inputer = request.getParameter("inputer");
        // 调用业务层来添加数据
        Result save = carouselService.saveCarousels(name, Long.parseLong(image), Long.parseLong(inputer));
        // 按照输出结果序列化
        ObjectMapper mapper = new ObjectMapper();
        // 封装成json对象
        String json = mapper.writeValueAsString(save);
        // 输出结果
        response.getWriter().print(json);
    }
    private void logicDel(HttpServletRequest request,HttpServletResponse response) throws IOException {
        // 接收参数
        String id = request.getParameter("id");
        // 调用业务层逻辑删除数据
        Result del = carouselService.logicDeleteCarousels(Long.parseLong(id));
        // 按照输出结果序列化
        ObjectMapper mapper = new ObjectMapper();
        // 封装json对象
        String json = mapper.writeValueAsString(del);
        // 输出结果
        response.getWriter().print(json);
    }
    private void update(HttpServletRequest request,HttpServletResponse response) throws IOException {
        // 接收参数
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        // 调用业务层逻辑删除数据
        Result del = carouselService.updateCarousels(Long.valueOf(id),name,Long.valueOf(image));
        // 按照输出结果序列化
        ObjectMapper mapper = new ObjectMapper();
        // 封装json对象
        String json = mapper.writeValueAsString(del);
        // 输出结果
        response.getWriter().print(json);
    }
    private void listCarousels(HttpServletRequest request,HttpServletResponse response) throws IOException {
        // 调用业务层逻辑删除数据
        List<Carousel> carousels = carouselService.listAllCarousels();
        // 按照输出结果序列化
        ObjectMapper mapper = new ObjectMapper();
        // 封装json对象
        String json = mapper.writeValueAsString(carousels);
        // 输出结果
        response.getWriter().print(json);
    }
    private void getCarousel(HttpServletRequest request,HttpServletResponse response) throws IOException {
        // 接收参数
        String id = request.getParameter("id");
        // 调用业务层逻辑删除数据
        Carousel carousel = carouselService.getCarousel(Long.valueOf(id));
        // 按照输出结果序列化
        ObjectMapper mapper = new ObjectMapper();
        // 封装json对象
        String json = mapper.writeValueAsString(carousel);
        // 输出结果
        response.getWriter().print(json);
    }
}
