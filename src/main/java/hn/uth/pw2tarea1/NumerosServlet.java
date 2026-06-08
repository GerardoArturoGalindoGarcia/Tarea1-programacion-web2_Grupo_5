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

@WebServlet("/NumerosServlet")
public class NumerosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            // --- PARTE A y B: Mayor y Menor de 3 números ---
            int n1 = Integer.parseInt(request.getParameter("num1"));
            int n2 = Integer.parseInt(request.getParameter("num2"));
            int n3 = Integer.parseInt(request.getParameter("num3"));

            // VALIDACIÓN: Si los tres números son iguales
            if (n1 == n2 && n2 == n3) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head><title>Error</title></head>");
                out.println("<body>");
                out.println("<h3>Error: Los tres números superiores no pueden ser idénticos.</h3>");
                // Botón de regreso también en la pantalla de error
                out.println("<br><button onclick=\"window.location.href='index.html'\" style='padding: 10px 20px; font-size: 16px; cursor: pointer;'>Volver al Menú Principal</button>");
                out.println("</body></html>");
                return;
            }

            int mayor = Math.max(n1, Math.max(n2, n3));
            int menor = Math.min(n1, Math.min(n2, n3));

            // --- PARTE C: Valor que más se repite (Soporta Empates) ---
            String listaStr = request.getParameter("listaNumeros");
            String[] partes = listaStr.split(",");

            HashMap<Integer, Integer> frecuencias = new HashMap<>();
            int maxRepeticiones = 0;

            for (String parte : partes) {
                int num = Integer.parseInt(parte.trim());
                frecuencias.put(num, frecuencias.getOrDefault(num, 0) + 1);

                if (frecuencias.get(num) > maxRepeticiones) {
                    maxRepeticiones = frecuencias.get(num);
                }
            }

            ArrayList<Integer> modas = new ArrayList<>();
            for (int num : frecuencias.keySet()) {
                if (frecuencias.get(num) == maxRepeticiones) {
                    modas.add(num);
                }
            }

            // --- PRESENTACIÓN DE RESULTADOS ---
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultados</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Resultados del Análisis Numérico</h2>");
            out.println("<p><b>El número mayor de los 3 es:</b> " + mayor + "</p>");
            out.println("<p><b>El número menor de los 3 es:</b> " + menor + "</p>");

            if (modas.size() == 1) {
                out.println("<p><b>El valor que más se repite de la lista es:</b> " + modas.get(0) + " (se repitió " + maxRepeticiones + " veces)</p>");
            } else {
                out.println("<p><b>Hay un empate en la moda. Los valores que más se repiten son:</b> " + modas + " (se repitieron " + maxRepeticiones + " veces cada uno)</p>");
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
            out.println("<br><button onclick=\"window.location.href='index.html'\" style='padding: 10px 20px; font-size: 16px; cursor: pointer;'>Volver al Menú Principal</button>");
        } finally {
            out.close();
        }
    }
}