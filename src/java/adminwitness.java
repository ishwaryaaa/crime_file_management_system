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
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KHSCI5MCA16060
 */
public class adminwitness extends HttpServlet {

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
            out.println("<title>Servlet adminwitness</title>");            
            out.println("</head>");
            out.println("<body>");
        try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crime","root","");
                PreparedStatement ps = con.prepareStatement("select * from witness");
                ResultSet rs = ps.executeQuery();
                out.println("<center>");
                out.println("<h1>WITNESS DETAILS <h1>");
               
                out.println("</center>"); 
              
                out.println("<table border=1 width=60% height=80% align=center>"
                        + "<tr>"
                        + "<th>INFORMER NAME </th>"
                        + "<th>ADDRESS</th>"
                        +"<th>PHONE NUMBER</th>"
                        +"<th>SUSPECT NAME</th>"
                        +"<th>DESCRIPTION</th>"
                          + "</tr>");
              
                while(rs.next())
                {
                   
                    String name = rs.getString("name");
                    String add = rs.getString("address");
                    
                    int ph = rs.getInt("phonenumber");
                       String suspectname = rs.getString("suspectname");
                   String desc= rs.getString("description");
               
                 
                    out.println("<tr align=center >"+ "<td >" +name+"<td width ='20%' >"+add+"<td > "+ph+"<td > "+ suspectname+" <td> "+desc+"</tr>");
                   
                    out.println("<br>");
                   
                    out.println("<br>");
                    
                    
                   
                }
                 out.println("</table>");
                 out.println("<br>");
                   
                 out.println("<br>");
                out.println ("<CENTER><a style='text-decoration:none;' href='admin_inner_status.html'> <button   name='Submit'>UPDATE</button></a></CENTER> "); 
                 con.close();
                 
                
            }
            catch(Exception e)
            {
                out.println("Exception : "+e);
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
