package com.hello.world.web;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/pdf")
public class PdfServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String action = req.getParameter("action");
            switch (action){
                case "pdf":  sendFile("application/pdf", "/WEB-INF/pdf/Lombok.pdf", resp); break;
                case "img":  sendFile("image/jpg", "/WEB-INF/img/sfericheskiy_kon_v_vakume.jpg", resp); break;
                default: req.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(req,resp);
            }
        } catch (Exception e){
//           resp.sendRedirect("https://metanit.com/java/javaee/4.4.php");
           resp.sendRedirect("javacours/pdf?action=0");
        }

    }

    public void sendFile(String ct, String filePath, HttpServletResponse resp) throws IOException {
        resp.setContentType(ct);
        ServletOutputStream out = resp.getOutputStream();
        InputStream is = getServletContext().getResourceAsStream(filePath);
        byte[] buff = new byte[1024];
        int f = 0;
        while ((f = is.read(buff)) != -1) {
            out.write(buff, 0, f);
        }
        out.flush();
        is.close();
        out.close();
    }
}
