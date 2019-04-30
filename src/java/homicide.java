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
public class homicide extends HttpServlet {

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
            out.println("<title>Servlet homicide</title>");            
            out.println("</head>");
            out.println("<body background='17.jpg'>");
               try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crime","root","");
                PreparedStatement ps = con.prepareStatement("select * from criminal_records1 where crime='Homicide'");
                ResultSet rs = ps.executeQuery();
                out.println("<center>");
                out.println("<h1>HOMICIDE CRIME DETAILS <h1>");
               
                out.println("</center>"); 
              
                out.println("<table border=1 width=60% height=80% align=center>"
                        + "<tr>"
                        + "<th>ID </th>"
                        + "<th>NAME</th>"
                        +"<th>ADDRESS</th>"
                        +"<th>GENDER</th>"
                        +"<th>AGE</th>"
                        +"<th>HEIGHT</th>"
                        +"<th>WEIGHT</th>"
                        +"<th>COLOR</th>"
                        +"<th>IDENTIFICATION MARK</th>"
                        +"<th>OCCCUPATION</th>"
                       +"<th>FATHER'S NAME</th>"
                        +"<th>MOTHER'S NAME</th>"
                         +"<th>CRIME</th>"
                        + "</tr>");
              
                while(rs.next())
                {     out.println("<tr align=center>"
                        +"<td>"+rs.getString(1)+"</td>"
                        +"<td>"+rs.getString(2)+"</td>"
                        +"<td>"+rs.getString(3)+"</td>"
                        +"<td>"+rs.getString(4)+"</td>"
                        +"<td>"+rs.getString(5)+"</td>"
                        +"<td>"+rs.getString(6)+"</td>"
                        +"<td>"+rs.getString(7)+"</td>"
                        +"<td>"+rs.getString(8)+"</td>"
                        +"<td>"+rs.getString(9)+"</td>"
                        +"<td>"+rs.getString(10)+"</td>"
                        +"<td>"+rs.getString(11)+"</td>"
                        +"<td>"+rs.getString(12)+"</td>"
                                
                       +"<td>"+rs.getString(13)+"</td>"
                        +"<tr>");
                   
                }
                 out.println("</table>");
                 out.println("<br>");
                   
                 out.println("<br>");
               //  out.println ("<CENTER><a style='text-decoration:none;' href='admin_inner_status.html'> <button   name='Submit'>UPDATE</button></a></CENTER> "); 
                 con.close();
                 
                
            }
            catch(Exception e)
            {
                out.println("Exception : "+e);
            }
                   
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

