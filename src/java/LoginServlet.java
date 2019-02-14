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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author KHSCI5MCA16060
 */
public class LoginServlet extends HttpServlet {

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
            
            String type = request.getParameter("s1");
            String name = request.getParameter("txt1");
            String pass = request.getParameter("ps1");
            try
            {
               // Class.forName("com.mysql.jdbc.Driver");  
               // Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/tat","root","");     
                //out.println("Connected...");
                
                //PreparedStatement stmt=con.prepareStatement("select * from teacher_details");
                //ResultSet rst=stmt.executeQuery(); 
                
                //int count =0;
               // while(rst.next())
                //{
                   // String tname = rst.getString(1);
                    //String tpass = rst.getString(3);
                    
                    if("o2".equals(type))
                    {
                        if(name.equals("ad") && pass.equals("ad"))
                        {
                            RequestDispatcher rs = request.getRequestDispatcher("/user.html");
                            rs.forward(request, response);
                           // count++;
                        }
                        
                        //if(count == 0)
                        else
                        {
                            
                            out.println("<html><head><script>window.alert('ERROR IN USERNAME AND PASSWORD');window.location.assign('index.html');</script></head></html>");
                     
                            RequestDispatcher rd=request.getRequestDispatcher("/index.html");
                           rd.include(request, response);
                        }
                     }
                    else if("o1".equals(type))
                    {
                        if(name.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("value"))
                        {
                            RequestDispatcher rs = request.getRequestDispatcher("/admin.html");
                            rs.forward(request, response);
                            
                        }
                        else
                        {   
                            out.println("<html><body><script>window.alert('PLEASE CHECK YOUR PASSWORD AND USERNAME');window.location.assign('index.html');</script></body></html>");
                            RequestDispatcher rs = request.getRequestDispatcher("/index.html");
                            rs.include(request, response);
                    
                        }
                    }
                    
                    
                   
                
                     else
                    {
                        out.println("<html><body><script>alert('PLEASE SELECT USER TYPE');window.location.assign('index.html');</script></body></html>");
                        RequestDispatcher rs = request.getRequestDispatcher("/index.html");
                        rs.include(request, response);
                    }            
                }
            
                 
             
            catch(Exception e)
            {
                out.println(e);
            }
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet test</title>");            
            out.println("</head>");
            out.println("<body>");
           
            
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
