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

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Resultado</title>");
        out.println("</head>");
        out.println("<body style='font-family:Arial,sans-serif;"
                + "background:#f4f4f4;"
                + "display:flex;"
                + "justify-content:center;"
                + "align-items:center;"
                + "height:100vh;'>");

        out.println("<div style='background:white;"
                + "padding:30px;"
                + "border-radius:15px;"
                + "box-shadow:0 4px 12px rgba(0,0,0,0.2);"
                + "text-align:center;"
                + "min-width:300px;'>");
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
        
        out.println("<br><br><a href='binarios.html' "
                + "style='background:#3498db;"
                + "color:white;"
                + "padding:10px 20px;"
                + "text-decoration:none;"
                + "border-radius:5px;'>Volver</a>");

        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    public void init() {
    }

    @Override
    public void destroy() {
    }
}