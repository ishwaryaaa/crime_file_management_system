/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KHSCI5MCA16060
 */
public class status1 extends HttpServlet {

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
            
            
            /* TODO output your page here. You may use following sample code. */
            
             
             
             
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet status1</title>");            
            out.println("</head>");
            out.println("<body>");
           
        try{
              String id1 = request.getParameter("id");
            
             int id = Integer.parseInt(id1); 
            String status = request.getParameter("status");
            String name = request.getParameter("complaint_handler_name");
            String contact = request.getParameter("police_contact_number");
            String desc= request.getParameter("description");   
                Class.forName("com.mysql.jdbc.Driver");
                Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/crime","root", "");   
                 PreparedStatement ps1=con.prepareStatement("insert into status values(?,?,?,?,?)");
                      ps1.setInt(1,id);
                     ps1.setString(2,status);
                     ps1.setString(3,name);
                     ps1.setString(4,contact);
                     ps1.setString(5,desc);
                     ps1.executeUpdate();
                    out.println("<html><body><script>window.alert('Case "+status+"');window.location.assign('admin.html');</script></body></html>");
            
             }
             catch(Exception e)
            {
                out.println(e);
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
