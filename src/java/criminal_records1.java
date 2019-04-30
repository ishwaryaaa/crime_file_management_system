/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KHSCI5MCA16060
 */
public class criminal_records1 extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) { out.println("fffg");
            /* TODO output your page here. You may use following sample code. */
          // int id=Integer.parseInt(request.getParameter("cid"));
           out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet criminal_records1</title>");            
            out.println("</head>");
            out.println("<body>");
               
            
            String name = request.getParameter("cname");
            String address = request.getParameter("caddress");
           
            String gender = request.getParameter("cgender"); 
            int age = Integer.parseInt(request.getParameter("cage"));  
            int hgt = Integer.parseInt(request.getParameter("height"));  
            int wgt = Integer.parseInt(request.getParameter("weight")); 
            String ccolor = request.getParameter("color"); 
            String cidentification_mark=request.getParameter("identification_mark"); 
            String coccupation=request.getParameter("occupation"); 
            String cfather_name= request.getParameter("father_name");
            String cmother_name= request.getParameter("mother_name");
            String ccrime= request.getParameter("crime"); 
             PreparedStatement ps1=null;
            try{
                Class.forName("com.mysql.jdbc.Driver"); //out.println("fffg");
                Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/crime","root","");
                //out.println("fffg");
                 PreparedStatement s1 = con.prepareStatement("select * from criminal_records1");
                 ResultSet r = s1.executeQuery();
                 int cid=1;
                 if(r.next())
                 {  r.last();
                     cid = r.getInt("cid")+1;
                 }
                  ps1=con.prepareStatement("insert into criminal_records1 values(?,?,?,?,?,?,?,?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
                     ps1.setInt(1,cid);
                     ps1.setString(2,name);
                     ps1.setString(3,address);
                     ps1.setString(4,gender);
                     ps1.setInt(5,age);
                     ps1.setInt(6,hgt);
                     ps1.setInt(7,wgt);
                     ps1.setString(8,ccolor);
                     ps1.setString(9,cidentification_mark);
                     ps1.setString(10,coccupation);
                     ps1.setString(11,cfather_name);
                     ps1.setString(12,cmother_name);
                     ps1.setString(13,ccrime);
                     cid++;

                int row = ps1.executeUpdate();

                
            if (row > 0) {

               out.println("<script>window.alert('Criminal Record Added successfully. Record id :- "+cid+" '); window.location.assign('admin.html');</script>");

               out.println(row);

            }
             }
             catch(Exception e)
            {
                out.println(e);
            }
           
            
            
            
            out.println("<h1>Servlet criminal_records1 at " + request.getContextPath() + "</h1>");
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
