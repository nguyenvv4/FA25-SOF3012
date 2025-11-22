package com.example.ontapsof203.controller;

import java.io.*;
import java.util.Date;

import com.example.ontapsof203.model.LopHoc;
import com.example.ontapsof203.service.LopHocService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "LopHocServletServlet", value = {"/lop-hoc/hien-thi",
        "/lop-hoc/xoa",
        "/lop-hoc/them",
        "/lop-hoc/chi-tiet",
        "/lop-hoc/cap-nhat",
})
public class LopHocServlet extends HttpServlet {

    LopHocService lopHocService = new LopHocService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/lop-hoc/hien-thi")) {
            request.setAttribute("list", lopHocService.getAllLopHoc());
            request.getRequestDispatcher("/lop-hoc.jsp").forward(request, response);
        } else if (uri.equals("/lop-hoc/xoa")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            lopHocService.xoa(id);
            response.sendRedirect("/lop-hoc/hien-thi");
        } else if (uri.contains("/lop-hoc/chi-tiet")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            // lay lop hoc theo id
            LopHoc lopHoc = lopHocService.chiTiet(id);
            // set lop hoc thanh attribute
            request.setAttribute("lopHoc", lopHoc);
            request.getRequestDispatcher("/cap-nhat.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/lop-hoc/them")) {
            // lay thong tin tren form thong qua name trong input
            String tenLop = request.getParameter("tenLop");
            String gvcn = request.getParameter("gvcn");
            String trangThai = request.getParameter("trangThai");
            LopHoc lopHoc = new LopHoc();
            lopHoc.setTenLop(tenLop);
            lopHoc.setGvcn(gvcn);
            lopHoc.setTrangThai(trangThai);
            lopHoc.setCreatedAt(new Date());
            lopHocService.them(lopHoc);
            response.sendRedirect("/lop-hoc/hien-thi");
        } else if (uri.contains("/lop-hoc/cap-nhat")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            String tenLop = request.getParameter("tenLop");
            String gvcn = request.getParameter("gvcn");
            String trangThai = request.getParameter("trangThai");
            LopHoc lopHoc = new LopHoc();
            lopHoc.setId(id);
            lopHoc.setTenLop(tenLop);
            lopHoc.setGvcn(gvcn);
            lopHoc.setTrangThai(trangThai);
            lopHocService.capNhat(lopHoc);
            response.sendRedirect("/lop-hoc/hien-thi");

        }
    }
}