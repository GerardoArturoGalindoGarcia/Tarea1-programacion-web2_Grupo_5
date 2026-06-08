package hn.uth.pw2tarea1;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "convertidor", value = "/convertidor")
public class ServletBDWB extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String operation = request.getParameter("operation");


        try {
            if ("DecimalaBinario".equals(operation)) {
            int decimal = Integer.parseInt(request.getParameter("number"));
            String binary = Integer.toBinaryString(decimal);

                out.println("<h2 style='color:#2c3e50;'>Conversión Exitosa</h2>");
                out.println("<p>Decimal: <strong style='color:#3498db;'>" + decimal + "</strong></p>");
                out.println("<p>Binario: <strong style='color:#3498db;'>" + binary + "</strong></p>");

            }
            else if ("BinarioaDecimal".equals(operation)) {
                String binary = request.getParameter("number");
                int decimal = Integer.parseInt(binary, 2);

                out.println("<h2 style='color:#2c3e50;'>Conversión Exitosa</h2>");
                out.println("<p>Binario: <strong style='color:#3498db;'>" + binary + "</strong></p>");
                out.println("<p>Decimal: <strong style='color:#3498db;'>" + decimal + "</strong></p>");
            } else {
                out.println("<h3>Operación no válida</h3>");
            }

        } catch (Exception e) {
            out.println("<h3>Error en la conversión</h3>");
        }

        out.println("<br><a href='binarios.html'>Volver</a>");

    }

    @Override
    public void init() {
    }

    @Override
    public void destroy() {
    }
}