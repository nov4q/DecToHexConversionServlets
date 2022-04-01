package pl.polsl.dectohexconversion_nowacki.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pl.polsl.dectohexconversion_nowacki.model.Model;
import pl.polsl.dectohexconversion_nowacki.exception.CustomException;

/**
 * Servlet responsible for calculation.
 *
 * @version 1.2
 * @author kuban
 */
public class CalculationServlet extends HttpServlet {

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

        HttpSession session = request.getSession(true);

        try ( PrintWriter out = response.getWriter()) {

            int inputNumber = 0;
            String inputString = request.getParameter("inputNumber");
            try {
                inputNumber = Integer.parseInt(inputString);
            } catch (NumberFormatException e) {
                out.print("Bad Input");
                out.close();
            }
            List<Integer> list = (List<Integer>) session.getAttribute("list");

            if (list == null) {
                list = new ArrayList<>();
                session.setAttribute("list", list);
            }
            list.add(inputNumber);
            Model model = new Model();
            model.setDecFromInput(inputNumber);
            try {
                model.convertToHex();
            } catch (CustomException except) {
                out.println(except);
                out.close();
            }

            out.println("<HTML><HEAD><TITLE>Result");
            out.println("</TITLE></HEAD><BODY>");

            out.println("Your number: " + inputNumber + " in decimal equals " + model.getHex() + " in Hex.");
            out.println("</BODY></HTML>");

            out.print("<form action='CookieServlet'>");
            out.print("<input type='submit' value='check for prev inputs'>");
            out.print("</form>");
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
