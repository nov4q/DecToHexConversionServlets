package pl.polsl.dectohexconversion_nowacki.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet responsible for cookies.
 *
 * @version 1.2
 * @author kuban
 */
public class CookieServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Cookie[] cookies = request.getCookies();
        int visitCounter = 0;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("visitCounter")) {
                    visitCounter = Integer.parseInt(cookie.getValue());
                    break;
                }
            }
        }
        visitCounter++;
        Cookie cookieVisitCounter = new Cookie("visitCounter", Integer.toString(visitCounter));
        response.addCookie(cookieVisitCounter);

        try ( PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CookieServlet</title>");
            out.println("</head>");
            out.println("<body>");
            HttpSession session = request.getSession(true);
            List<Integer> list = (List<Integer>) session.getAttribute("list");

            if (list != null) {
                out.print("Previous input: " + list + "\n");
            }
            out.println("<hr>You visited us " + visitCounter + " times.</hr>");

            out.print("<form action='index.html'>");
            out.print("<input type='submit' value='Calculate again'>");
            out.print("</form>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
