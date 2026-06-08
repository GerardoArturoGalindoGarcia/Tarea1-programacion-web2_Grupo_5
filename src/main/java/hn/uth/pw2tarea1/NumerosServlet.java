package hn.uth.pw2tarea1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/NumerosServletMMM")
public class NumerosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {

            if ("Mayor3Numeros".equals(request.getParameter("operation"))) {
                int n1 = Integer.parseInt(request.getParameter("num1"));
                int n2 = Integer.parseInt(request.getParameter("num2"));
                int n3 = Integer.parseInt(request.getParameter("num3"));
                int mayor = Math.max(n1, Math.max(n2, n3));
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Resultados</title>");
                out.println("</head>");

                out.println("<body style='font-family:Arial,sans-serif;"
                        + "background:linear-gradient(135deg,#4facfe,#00f2fe);"
                        + "display:flex;"
                        + "justify-content:center;"
                        + "align-items:center;"
                        + "height:100vh;"
                        + "margin:0;'>");

                out.println("<div style='background:white;"
                        + "padding:30px;"
                        + "border-radius:15px;"
                        + "box-shadow:0 6px 20px rgba(0,0,0,0.25);"
                        + "text-align:center;"
                        + "min-width:350px;'>");

                out.println("<h2 style='color:#2c3e50;'>Resultado del Análisis</h2>");

                out.println("<p style='font-size:18px;'>El número mayor de los 3 es:</p>");

                out.println("<p style='font-size:26px;"
                        + "color:#3498db;"
                        + "font-weight:bold;'>" + mayor + "</p>");

                out.println("<br><a href='Mayor de 3 numeros.html' "
                        + "style='background:#3498db;"
                        + "color:white;"
                        + "padding:12px 25px;"
                        + "text-decoration:none;"
                        + "border-radius:8px;"
                        + "font-weight:bold;'>Volver</a>");

                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }

            if ("Menor3Numeros".equals(request.getParameter("operation"))) {
                int n1 = Integer.parseInt(request.getParameter("num1"));
                int n2 = Integer.parseInt(request.getParameter("num2"));
                int n3 = Integer.parseInt(request.getParameter("num3"));
                int menor = Math.min(n1, Math.min(n2, n3));
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Resultados</title>");
                out.println("</head>");

                out.println("<body style='font-family:Arial,sans-serif;"
                        + "background:linear-gradient(135deg,#4facfe,#00f2fe);"
                        + "display:flex;"
                        + "justify-content:center;"
                        + "align-items:center;"
                        + "height:100vh;"
                        + "margin:0;'>");

                out.println("<div style='background:white;"
                        + "padding:30px;"
                        + "border-radius:15px;"
                        + "box-shadow:0 6px 20px rgba(0,0,0,0.25);"
                        + "text-align:center;"
                        + "min-width:350px;'>");

                out.println("<h2 style='color:#2c3e50;'>Resultado del Análisis</h2>");

                out.println("<p style='font-size:18px;'>El número menor de los 3 es:</p>");

                out.println("<p style='font-size:26px;"
                        + "color:#3498db;"
                        + "font-weight:bold;'>" + menor + "</p>");

                out.println("<br><a href='Menor de 3 Numeros.html' "
                        + "style='background:#3498db;"
                        + "color:white;"
                        + "padding:12px 25px;"
                        + "text-decoration:none;"
                        + "border-radius:8px;"
                        + "font-weight:bold;'>Volver</a>");

                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }

            if ("ModaVariosNumeros".equals(request.getParameter("operation"))) {

                String listaStr = request.getParameter("listaNumeros");

                if (listaStr == null || listaStr.trim().isEmpty()) {
                    out.println("<h3>Error: No se enviaron números</h3>");
                    return;
                }

                String[] partes = listaStr.split(",");

                HashMap<Integer, Integer> frecuencias = new HashMap<>();
                int maxRepeticiones = 0;

                for (String parte : partes) {
                    int num = Integer.parseInt(parte.trim());
                    frecuencias.put(num, frecuencias.getOrDefault(num, 0) + 1);

                    maxRepeticiones = Math.max(maxRepeticiones, frecuencias.get(num));
                }

                ArrayList<Integer> modas = new ArrayList<>();
                for (int num : frecuencias.keySet()) {
                    if (frecuencias.get(num) == maxRepeticiones) {
                        modas.add(num);
                    }
                }

                // ===== HTML BASE ÚNICO =====
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Resultado Moda</title>");
                out.println("</head>");

                out.println("<body style='font-family:Arial,sans-serif;"
                        + "background:linear-gradient(135deg,#4facfe,#00f2fe);"
                        + "display:flex;"
                        + "justify-content:center;"
                        + "align-items:center;"
                        + "height:100vh;"
                        + "margin:0;'>");

                out.println("<div style='background:white;"
                        + "padding:30px;"
                        + "border-radius:15px;"
                        + "box-shadow:0 6px 20px rgba(0,0,0,0.25);"
                        + "text-align:center;"
                        + "min-width:350px;'>");

                out.println("<h2 style='color:#2c3e50;'>Resultado de la Moda</h2>");

                // ===== RESULTADO =====
                if (modas.size() == 1) {

                    out.println("<p style='font-size:18px;'>La moda es:</p>");
                    out.println("<p style='font-size:28px;color:#3498db;font-weight:bold;'>"
                            + modas.get(0) + "</p>");
                    out.println("<p>Se repitió " + maxRepeticiones + " veces</p>");

                } else {

                    out.println("<p style='font-size:18px;'>Hay empate en la moda:</p>");
                    out.println("<p style='font-size:28px;color:#3498db;font-weight:bold;'>"
                            + modas + "</p>");
                    out.println("<p>Se repitieron " + maxRepeticiones + " veces cada uno</p>");
                }

                // ===== BOTÓN =====
                out.println("<br><a href='moda.html' "
                        + "style='background:#3498db;"
                        + "color:white;"
                        + "padding:12px 25px;"
                        + "text-decoration:none;"
                        + "border-radius:8px;"
                        + "font-weight:bold;'>Volver</a>");

                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }


            out.println("<br><br>");

            // --- AQUÍ ESTÁ EL NUEVO BOTÓN ESTILIZADO ---
            out.println("<button onclick=\"window.location.href='index.html'\" style='padding: 10px 20px; font-size: 16px; background-color: #007bff; color: white; border: none; border-radius: 4px; cursor: pointer;'>");
            out.println("Volver al Menú Principal");
            out.println("</button>");

            out.println("</body>");
            out.println("</html>");

        } catch (NumberFormatException e) {
            out.println("<h3>Error: Por favor asegúrate de ingresar solo números enteros válidos.</h3>");
            out.println("<p>DEBUG listaNumeros: " + request.getParameter("listaNumeros") + "</p>");
            out.println("<br><button onclick=\"window.location.href='index.html'\" style='padding: 10px 20px; font-size: 16px; cursor: pointer;'>Volver al Menú Principal</button>");
        } finally {
            out.close();
        }
    }
}