package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/gugudan")
public class GugudanServlet extends HttpServlet { //서블릿은 HttpServlet라는 클래스를 상속받는다, 서블릿은 자바 언어를 사용해 웹 프로그램을 제작하는 것
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Rq rq = new Rq(req,resp);
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        int dan = Integer.parseInt(req.getParameter("dan"));
        int limit = Integer.parseInt(req.getParameter("limit"));

        resp.getWriter().append("<h1>%d단</h1>\n".formatted(dan));

        for (int i = 1; i <= limit; i++) {
            resp.getWriter().append("<div>%d * %d = %d</div>\n".formatted(dan, i, dan * i));
        }
    }
    }

//http://localhost:8080/gugudan?dan=3&limit=5
