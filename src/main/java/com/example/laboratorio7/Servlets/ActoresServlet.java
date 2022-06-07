package com.example.laboratorio7.Servlets;

import com.example.laboratorio7.Daos.ActoresDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ActoresServlet", value = "/Actores")
public class ActoresServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ActoresDao actoresDao = new ActoresDao();
        request.setAttribute("listaActores",actoresDao.listarActores());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Actores.jsp");
        requestDispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
