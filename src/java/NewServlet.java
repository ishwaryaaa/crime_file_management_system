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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author KHSCI5MCA16060
 */
public class NewServlet extends HttpServlet {

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
            
            
            
            String type = request.getParameter("utype");
            String name = request.getParameter("username");
            String pass = request.getParameter("password");
            int count1 =0;
            
           
                
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
             try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/crime", "root", "");
                
                if("o1".equals(type))
                {
                 
                    out.println(type);
                     if((name == "admin") && (pass == "value"))
                        {
                              out.println("Connected...");
                              RequestDispatcher rs = request.getRequestDispatcher("/admin.html");
                            rs.forward(request, response);
                        }
                   
                        else
                        {   
                            out.println("<html><body><script>window.alert('PLEASE CHECK YOUR PASSWORD AND USERNAME');window.location.assign('index.html');</script></body></html>");
                            RequestDispatcher rs = request.getRequestDispatcher("/admin.html");
                            rs.include(request, response);
                    
                        }
                }
                else if("o2".equals(type))
                {
                    
                    PreparedStatement stmt3=con.prepareStatement("select * from register2");
                    ResultSet rst3=stmt3.executeQuery(); 
                
                    while(rst3.next())
                    {
                        count1 =0;
                        String cname = rst3.getString(6);
                        String cpass = rst3.getString(7);
                    
                    
                        if(name.equals(cname) && pass.equals(cpass))
                        {
                            count1++;
                            RequestDispatcher rs3 = request.getRequestDispatcher("/user.html");
                            rs3.forward(request, response);
                            
                        }
                    }
                    if(count1 == 0)
                    {
                            
                            out.println("<html><head><script>window.alert('ERROR IN USERNAME AND PASSWORD');window.location.assign('login.html');</script></head></html>");
                     
                            RequestDispatcher rd3=request.getRequestDispatcher("/index.html");
                            rd3.include(request, response);
                    }
                        
                
                }
            }
            catch(Exception e1)
            {
                out.println(e1);
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
