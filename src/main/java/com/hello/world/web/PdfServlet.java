package com.hello.world.web;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/pdf/*")
public class PdfServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/pdf");

        ServletOutputStream out = resp.getOutputStream();
        InputStream is = getServletContext().getResourceAsStream("/WEB-INF/pdf/Lombok.pdf");

        byte[] buff = new byte[1024];
        int f = 0;
        while ((f = is.read(buff)) != -1){
            out.write(buff, 0, f);
        }
        out.flush();
        is.close();
        out.close();
    }
}
