/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
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
public class Registeruser extends HttpServlet {

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
            out.println("<title>Servlet Registeruser</title>");            
            out.println("</head>");
            out.println("<body>");
            
            try{
                String name = request.getParameter("name");
            String address = request.getParameter("address");
            String phonenumber = request.getParameter("phonenumber");        
            String occupation = request.getParameter("occupation");
            
            int age=Integer.parseInt(request.getParameter("age"));
            String password=request.getParameter("password");
            String cpassword=request.getParameter("cpassword");
               
                if(password.equals(cpassword))
                {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/crime","root", "");  
                PreparedStatement s1 = con.prepareStatement("select * from register");
                 ResultSet r = s1.executeQuery();
                 int cid=1;
                 if(r.next())
                 {  r.last();
                     cid = r.getInt("user_id")+1;
                 }
                
                 PreparedStatement ps1=con.prepareStatement("insert into register  values(?,?,?,?,?,?,?)");
                     ps1.setString(1,name);
                     ps1.setInt(2, cid);
                     ps1.setString(3,address);
                     ps1.setString(4,phonenumber);
                     ps1.setString(5,occupation);
                     ps1.setInt(6,age);
                     ps1.setString(7,password);
                     
                     ps1.executeUpdate();
                    out.println("<html><body><script>window.alert('Successfully Registered');window.location.assign('login.html');</script></body></html>");
                }
                else
                {
                     out.println(" Mis match ");
                }
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
