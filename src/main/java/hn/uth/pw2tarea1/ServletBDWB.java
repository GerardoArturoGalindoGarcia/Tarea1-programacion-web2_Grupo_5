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
            // --- INICIO DEL DISEÑO CSS Y HTML (AGREGADO PARA LA RÚBRICA) ---
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("    <title>Resultado de Conversión</title>");
            out.println("    <style>");
            out.println("        body { font-family: Arial, sans-serif; background: linear-gradient(135deg, #43e97b, #38f9d7); min-height: 100vh; display: flex; justify-content: center; align-items: center; margin: 0; padding: 20px; box-sizing: border-box; }");
            out.println("        .container { background: white; padding: 30px; border-radius: 15px; box-shadow: 0 10px 25px rgba(0,0,0,0.2); width: 450px; text-align: center; }");
            out.println("        h2 { color: #333; font-size: 20px; margin-top: 0; margin-bottom: 5px; }");
            out.println("        h3 { color: #555; font-size: 16px; margin-bottom: 20px; }");
            out.println("        table { width: 100%; border-collapse: collapse; margin: 20px 0; font-size: 15px; }");
            out.println("        th, td { border: 1px solid #ddd; padding: 12px; text-align: center; }");
            out.println("        th { background-color: #28a745; color: white; }");
            out.println("        .btn-back { display: block; width: 100%; padding: 12px; background: #007BFF; color: white; border: none; border-radius: 8px; margin-top: 15px; text-decoration: none; font-size: 14px; font-weight: bold; cursor: pointer; text-align: center; box-sizing: border-box; }");
            out.println("        .btn-back:hover { background: #0056b3; }");
            out.println("    </style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");

            // Requisito Obligatorio: Nombres e identificación del Grupo
            out.println("    <h2>Conversor de Sistemas Numéricos</h2>");
            out.println("    <h3>Grupo 5 - UTH</h3>");
            // --- FIN DEL BLOQUE DE DISEÑO INICIAL ---


            if ("DecimalaBinario".equals(operation)) {
                int decimal = Integer.parseInt(request.getParameter("number"));
                String binary = Integer.toBinaryString(decimal);

                // TABLA REQUERIDA POR EL INGENIERO (Reemplaza los <p> sueltos de tu compañero)
                out.println("    <table>");
                out.println("        <tr><th>Operación Realizada</th><th>Dato Entrada</th><th>Resultado</th></tr>");
                out.println("        <tr><td><b>Decimal a Binario</b></td><td>" + decimal + "</td><td><b>" + binary + "</b></td></tr>");
                out.println("    </table>");

            }
            else if ("BinarioaDecimal".equals(operation)) {
                String binary = request.getParameter("number");
                int decimal = Integer.parseInt(binary, 2);

                // TABLA REQUERIDA POR EL INGENIERO (Reemplaza los <p> sueltos de tu compañero)
                out.println("    <table>");
                out.println("        <tr><th>Operación Realizada</th><th>Dato Entrada</th><th>Resultado</th></tr>");
                out.println("        <tr><td><b>Binario a Decimal</b></td><td>" + binary + "</td><td><b>" + decimal + "</b></td></tr>");
                out.println("    </table>");

            } else {
                out.println("    <h3 style='color: red;'>Operación no válida</h3>");
            }

        } catch (Exception e) {
            out.println("    <h3 style='color: red;'>Error en la conversión</h3>");
        }

        // Cierre del contenedor y botón estilizado de regreso
        out.println("    <button onclick=\"window.location.href='binarios.html'\" class='btn-back'>Volver al Conversor</button>");
        out.println("</div>"); // Cierra .container
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