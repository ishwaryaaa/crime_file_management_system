/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KHSCI5MCA16060
 */
public class complaintservlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            
            String citizenname = request.getParameter("citizenname"); 
        String citizenaddress= request.getParameter("citizenaddress");
        String job = request.getParameter("job");
        String age = request.getParameter("age");
        
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet complaintservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            if (citizenname == null)
        {
            out.println("<p>Name: MISSING</p>");
         } else {
            out.println("<p>Name: " + citizenname + "</p>");
         }
        if (citizenaddress == null)
           {
            out.println("<p>Password: MISSING</p>");
         } else {
            out.println("<p>Password: " +citizenaddress+ "</p>");
         }
        
        
         if (job == null) {
            out.println("<p>Gender: MISSING</p>");
         } else if (job.equals("m")) {
            out.println("<p>Gender: male</p>");
         } else {
            out.println("<p>Gender: female</p>");
         }
 
          if (age == null) {
            out.println("<p>Age: MISSING</p>");
         } else if (age.equals("1")) {
            out.println("<p>Age: &lt; 1 year old</p>");
         } else if (age.equals("99")) {
            out.println("<p>Age: 1 to 99 years old</p>");
         } else {
            out.println("<p>Age: &gt; 99 years old</p>");
         }
         
            
            
            
            out.println("</body>");
            out.println("</html>");
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
