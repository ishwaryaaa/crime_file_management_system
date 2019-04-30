<%--
    Document   : suggesstions
    Created on : Apr 27, 2019, 2:38:48 PM
    Author     : KHSCI5MCA16060
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- import statements of bootstrap4 -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
    </head>
    <body background="16.jpg"><label style="float:right;color:greenyellow">
    <a style='text-decoration:none;' href='user.html'> 
<button>
<img src="next.png" alt="FIR"  width="30" height="30">
</button> 
  </a>
        </label>
        <div class="container" style="margin-top:50px;border-radius:5px;text-align:center;">
          <form action="suggestions" method="post">




              <center><b><u><h2>SUGGESTIONS</h2></u></b> </center>

              <div class="input-group mb-3">
                  <div class="input-group-prepend">
                      <span class="input-group-text">Complaint id</span>
                  </div>
                  <select  name="cid">

                      <%
                          try{
                              String cid;
                              String uid = session.getAttribute("user_id").toString();
                              Class.forName("com.mysql.jdbc.Driver");
                              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crime", "root", "");
                              PreparedStatement s1 = con.prepareStatement("select * from complaint where user_id=?");

                              s1.setString(1, uid);
                              ResultSet r = s1.executeQuery();
                              int flag = 0;
                              while (r.next()) {
                                flag=1;
                                 %>
                                 <option value="<%=r.getString("cid")%>"> <%=r.getString("cid")%> </option>
                                 <%

                              }

                              if (flag == 0) {
                              out.println("<option > No Data Found  </option>");
                              }
                          }
                          catch(Exception ex


                              )
                      {
                        out.println(ex);
                          }
                      %>
                  </select>
              </div>
              <table class="radio">
                  <tr>
                      <th>Officer responded in a timely manner.</th>
                      <td width="90"><input name="timely_manner" type="radio" value="Agree" /> Agree</td><td width="100">
                          <input name="timely_manner" type="radio" value="Disagree" /> Disagree</td><td width="120">
                          <input name="timely_manner" type="radio" value="Not Applicable" /> Not Applicable</td>
                  </tr>
                  <tr>
                      <th>Officer's appearance was professional.</th>
                      <td><input name="pro" type="radio" value="Agree" /> Agree</td><td>
                          <input name="pro" type="radio" value="Disagree" /> Disagree</td><td>
                          <input name="pro" type="radio" value="Not Applicable" /> Not Applicable</td>
                  </tr>
                  <tr>
                      <th>Officer was courteous and polite.</th>
                      <td><input name="polite" type="radio" value="Agree" /> Agree</td><td>
                          <input name="polite" type="radio" value="Disagree" /> Disagree</td><td>
                          <input name="polite" type="radio" value="Not Applicable" /> Not Applicable</td>
                  </tr>
                  <tr>
                      <th>Officer took steps to mitigate issue.</th>
                      <td><input name="issue" type="radio" value="Agree" /> Agree</td><td>
                          <input name="issue" type="radio" value="Disagree" /> Disagree</td><td><input name="issue" type="radio" value="Not Applicable" /> Not Applicable</td>
                  </tr>
                  <tr>
                      <th>The issue was resolved to my satisfaction.</th>
                      <td><input name="satif" type="radio" value="Agree" /> Agree</td><td>
                          <input name="satif" type="radio" value="Disagree" /> Disagree</td><td><input name="satif" type="radio" value="Not Applicable" /> Not Applicable</td>
                  </tr>
                  <tr>
                      <th>Officer showed concern while attempting to address my issue.</th>
                      <td><input name="concern" type="radio" value="Agree" /> Agree</td><td><input name="OFFICER-SHOWED-CONCERN" type="radio" value="Disagree" /> Disagree</td><td><input name="OFFICER-SHOWED-CONCERN" type="radio" value="Not Applicable" /> Not Applicable</td>
                  </tr>
                  <tr>
                      <th>Officer handled the incident in a professional manner.</th>
                      <td><input name="manner" type="radio" value="Agree" /> Agree</td><td><input name="manner" type="radio" value="Disagree" /> Disagree</td><td><input name="manner" type="radio" value="Not Applicable" /> Not Applicable</td>
                  </tr>
                  <tr>
                      <th>Officer made appropriate remarks/comments.</th>
                      <td><input name="remarks" type="radio" value="Agree" /> Agree</td><td>
                          <input name="remarks" type="radio" value="Disagree" /> Disagree</td><td><input name="remarks" type="radio" value="Not Applicable" /> Not Applicable</td>
                  </tr>

                  <tr>

                      <th>Please add any comments or suggestions you may have:</th>

                  <tr>
                      <td><textarea name="comments" rows="5" cols="70" /></textarea></td>
                  </tr>

              </table>
              <input type="submit" name="s" value="SUBMIT">
          </form>
        </div>

    </body>
</html>
