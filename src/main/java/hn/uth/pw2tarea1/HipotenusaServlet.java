package hn.uth.pw2tarea1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/HipotenusaServlet")
public class HipotenusaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        double a = Double.parseDouble(request.getParameter("a"));
        double b = Double.parseDouble(request.getParameter("b"));

        double c = Math.sqrt(Math.pow(a, 2) - Math.pow(b, 2));

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='es'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Resultado Hipotenusa</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Resultado</h2>");
        out.println("<p>El valor de la hipotenusa es: " + c + "</p>");
        out.println("<a href='hipotenusa.html'>Volver</a><br>");
        out.println("<a href='index.html'>Volver al menú</a>");
        out.println("</body>");
        out.println("</html>");
    }
}