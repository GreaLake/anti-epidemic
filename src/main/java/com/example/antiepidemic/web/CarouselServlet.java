package com.example.antiepidemic.web;

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
    private void logicDel(HttpServletRequest request,HttpServletResponse response){

    }
    private void update(HttpServletRequest request,HttpServletResponse response){

    }
    private void listCarousels(HttpServletRequest request,HttpServletResponse response){

    }
    private void getCarousel(HttpServletRequest request,HttpServletResponse response){

    }
}
