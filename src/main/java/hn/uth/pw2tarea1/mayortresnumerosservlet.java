package hn.uth.pw2tarea1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MayorTresNumerosServlet")
public class MayorTresNumerosServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        int numero1 = Integer.parseInt(request.getParameter("numero1"));
        int numero2 = Integer.parseInt(request.getParameter("numero2"));
        int numero3 = Integer.parseInt(request.getParameter("numero3"));

        int mayor = numero1;

        if (numero2 > mayor) {
            mayor = numero2;
        }

        if (numero3 > mayor) {
            mayor = numero3;
        }

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='es'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Resultado Mayor</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Resultado</h2>");
        out.println("<p>El número mayor es: " + mayor + "</p>");
        out.println("<a href='mayor_tres_numeros.html'>Volver</a><br>");
        out.println("<a href='index.html'>Volver al menú</a>");
        out.println("</body>");
        out.println("</html>");
    }
}