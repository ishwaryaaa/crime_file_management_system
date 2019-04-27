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
public class fir extends HttpServlet {

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
            int complaint_id = Integer.parseInt(request.getParameter("cid"));  
           
          int f_id = Integer.parseInt(request.getParameter("fid"));    
           String name = request.getParameter("fname"); 
            String gen = request.getParameter("gender");
            String dt_ob = request.getParameter("dob");  
            String addr = request.getParameter("faddress"); 
            int phno = Integer.parseInt(request.getParameter("phonenumber"));    
            String crim=request.getParameter("crime");
            String crime_description=request.getParameter("crimedescription"); 
            String father_name = request.getParameter("fathersname"); 
            String date_of_crime = request.getParameter("dateofcrime"); 
           String dt= request.getParameter("date");  
            String loc = request.getParameter("location"); 
            
           
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet fir</title>");            
            out.println("</head>");
            out.println("<body>");
        
            
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/crime","root", "");   
                PreparedStatement ps1=con.prepareStatement("insert into fir  values(?,?,?,?,?,?,?,?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
               

                     ps1.setInt(1,complaint_id);
                     ps1.setInt(2,f_id);
                     ps1.setString(3,name);
                     ps1.setString(4,gen);
                     ps1.setString(5,dt_ob);
                     ps1.setString(6,addr);
                     ps1.setInt(7,phno);
                     ps1.setString(8,crim);
                     ps1.setString(9,crime_description);
                     ps1.setString(10,father_name);
                     ps1.setString(11,date_of_crime);
                     ps1.setString(12,dt);
                     ps1.setString(13,loc);
                   
                     ps1.executeUpdate();
                      
                    out.println("<html><body><script>window.alert('ONE ROW INSERTED');window.location.assign('login.html');</script></body></html>");
            
             }
             catch(Exception e)
            {
                out.println(e);
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
