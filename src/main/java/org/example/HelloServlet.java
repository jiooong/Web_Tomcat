package org.example;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

// 들어오는 파라미터를 UTF-8로 해석 ,들어오는 데이터를 UTF-8 로 해석하겠다.
        req.setCharacterEncoding("UTF-8");
// 서블릿이 HTML 파일을 만들 때 UTF-8 로 쓰기,완성되는 HTML의 인코딩을 UTF-로 하겠다.
        resp.setCharacterEncoding("UTF-8"); // 이 부분 고쳐주세요.

// HTML이 UTF-8 형식이라는 것을 브라우저에게 알린다. 브라우저에게 우리가 만든 결과물이 UTF-8 이다 라고 알리는 의미
        resp.setContentType("text/html; charset=utf-8");

        resp.getWriter().append("지원");
    }
}