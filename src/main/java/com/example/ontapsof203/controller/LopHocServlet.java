package com.example.ontapsof203.controller;

import java.io.*;

import com.example.ontapsof203.service.LopHocService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "LopHocServletServlet", value = {"/lop-hoc/hien-thi",
        "/lop-hoc/xoa",
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
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}