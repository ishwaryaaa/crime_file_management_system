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
import javax.servlet.http.HttpSession;

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

            try {
                HttpSession session = request.getSession(false);
                String uid = session.getAttribute("user_id").toString();
                Class.forName("com.mysql.jdbc.Driver");
                Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/crime","root", "");  
                PreparedStatement sl = con.prepareStatement("select * from register");
                ResultSet r1= sl.executeQuery();
                r1.first();
                String address = r1.getString("address");
                String phno = r1.getString("phonenumber");
                String job = r1.getString("occupation");
                String cdob = request.getParameter("dob");
                String date_of_inci = request.getParameter("date_of_incident");

                String location = request.getParameter("clocation");
                String type = request.getParameter("crime_type");
                String description = request.getParameter("cdescription");
                String cwitness = request.getParameter("witness");
                PreparedStatement ps1 = null;

                PreparedStatement s1 = con.prepareStatement("select * from complaint");
                ResultSet r = s1.executeQuery();
                int cid = 1;
                if (r.next()) {
                    r.last();
                    cid = r.getInt("cid") + 1;
                }
                ps1 = con.prepareStatement("insert into complaint  values(?,?,?,?,?,?,?,?,?,?)");
                ps1.setInt(1, cid);
                ps1.setString(2, uid);
                ps1.setString(3, address);
                ps1.setString(4, phno);
                ps1.setString(5, job);
                ps1.setString(6, date_of_inci);
                ps1.setString(7, location);
                ps1.setString(8, type);
                ps1.setString(9, description);
                ps1.setString(10, cwitness);
                int row = ps1.executeUpdate();

                if (row > 0) {

                    out.println("<html><head><script>window.alert('Complaint Registered. Complaint Id :- "+cid+"');window.location.assign('user.html');</script></head></html>");

                    out.println(row);
                }
            } catch (Exception e) {
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
