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
public class loginservlet extends HttpServlet {

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

            try {
                String utype = request.getParameter("utype");
                String name = request.getParameter("name");
                String pass = request.getParameter("password");
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/crime", "root", "");
                

                PreparedStatement sl = con.prepareStatement("select * from register where name=? AND password=? ");
                sl.setString(1,name);
                sl.setString(2,pass);
                ResultSet rst = sl.executeQuery();
                
                if(rst.next())
                {
                    if(name.equalsIgnoreCase("Admin"))
                    {
                        request.getRequestDispatcher("admin.html").forward(request, response);
                    }
                    else
                    {
                            String uid = rst.getInt("User_id") + "";
                            HttpSession session = request.getSession();
                            session.setAttribute("user_id", uid);
                            RequestDispatcher rs = request.getRequestDispatcher("user.html");
                            rs.forward(request, response);
                        
                    }
                    
                }
                else
                {
                    out.println("<html><head><script>window.alert('Invalid Username or Password');window.location.assign('login.html');</script></head></html>");
                    RequestDispatcher rd = request.getRequestDispatcher("/index.html");
                    rd.include(request, response);
                }

                
                
            } catch (Exception e) {
                out.println(e);
            }

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet loginservlet</title>");
            out.println("</head>");
            out.println("<body>");
            // out.println("<h1>Servlet loginservlet at " + request.getContextPath() + "</h1>");
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
