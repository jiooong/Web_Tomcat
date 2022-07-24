package org.example;

import jakarta.servlet.RequestDispatcher;
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

        int dan = rq.getIntParam("dan",9);
        int limit =  rq.getIntParam("limit",9);


       // rq.appendBody("<h1>%d단</h1>\n".formatted(dan));
        // request에 정보를 담는다.
        // 왜냐하면 나중에 gugudan2.jsp에서 해당 내용을 꺼낼 수 있기 때문에
        req.setAttribute("dan", dan);
        req.setAttribute("limit", limit);

       /* for (int i = 1; i <= limit; i++) {
            rq.appendBody("<div>%d * %d = %d</div>\n".formatted(dan, i, dan * i));
        }*/
        // gugudan2.jsp 에게 나머지 작업을 토스
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/gugudan2.jsp");
        requestDispatcher.forward(req, resp);
    }
    }

//http://localhost:8080/gugudan?dan=3&limit=5
