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
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet complaintservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            int id=Integer.parseInt(request.getParameter("cid"));
            String name=request.getParameter("cname");
            String address=request.getParameter("caddress");
            int phno=Integer.parseInt(request.getParameter("cphone"));
            String job=request.getParameter("cjob");
            String cdob=request.getParameter("dob");
            String date_of_inci=request.getParameter("date_of_incident");
         
            String location=request.getParameter("clocation");
            String type=request.getParameter("crime_type");
            String description=request.getParameter("cdescription");
            String cwitness=request.getParameter("witness");
            
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registeruser</title>");            
            out.println("</head>");
            out.println("<body>");

            try{
              
                Class.forName("com.mysql.jdbc.Driver");
                Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/crime","root", "");   
                 PreparedStatement ps1=con.prepareStatement("insert into complaint  values(?,?,?,?,?,?,?,?,?,?,?)");
                     ps1.setInt(1,id);
                     ps1.setString(2,name);
                     ps1.setString(3,address);
                     ps1.setInt(4, phno);
                     ps1.setString(5,job);
                     ps1.setString(6,cdob);
                     ps1.setString(7,date_of_inci);
                     ps1.setString(8,location);
                      ps1.setString(9,type);
                     ps1.setString(10,description);
                     ps1.setString(11,cwitness);
                     
                     ps1.executeUpdate();
                    out.println("<html><body><script>window.alert('ONE ROW INSERTED');window.location.assign('index.html');</script></body></html>");
        out.println(id);
             }
            
             catch(Exception e)
            {
                out.println(e);
            }
            out.println("<h1>Servlet Registeruser at " + request.getContextPath() + "</h1>");
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
