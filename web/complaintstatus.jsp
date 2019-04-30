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
   <style>
        body {
    margin: 0;
    padding: 0;
    background: url(cover4.jpg) no-repeat 0px 0px;
    min-height: 100vh;
    background-size: cover;
    font-family: 'Raleway', sans-serif;
}
</style>
</head>
<body>
    <label style="float:right;color:greenyellow">
    <a style='text-decoration:none;' href='user.html'> 
<button>
<img src="next.png" alt="FIR"  width="30" height="30">
</button> 
  </a>
        </label>
    <div style="margin-top:50px;border-radius:5px;text-align:center;" class="container bg-light">
      <div class="display-4">
        Complaint Status
      </div>
      <div class="container" style="overflow-x:auto">
        <table class="table table-striped bg-light" style="margin-top: 50px;border-radius:5px !important;">
          <tr>
            <th>Complaint Id</th>
            <th>Status</th>
            <th>Complaint handling officer </th>
            <th> Contact number</th>
            <th>Description</th>
          </tr>

          <%
              String uid = session.getAttribute("user_id").toString();
              try
              {
                  String cid;
                  Class.forName("com.mysql.jdbc.Driver");
                Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/crime","root", "");
                PreparedStatement s1 = con.prepareStatement("select * from complaint where user_id=?");
                PreparedStatement s2 = con.prepareStatement("select * from status where id=?");
                s1.setString(1,uid);
                ResultSet r = s1.executeQuery();
                ResultSet r1;
                int flag=0;
                while(r.next())
                {
                    cid=r.getString("cid");
                    s2.setString(1,cid);
                    r1=s2.executeQuery();
                    while(r1.next())
                    {
                      flag=1;
                      %>
                      <tr>
                          <td> <%=cid%> </td>
                          <td> <%=r1.getString("status")%> </td>
                          <td> <%=r1.getString("complaint_handler_name")%> </td>
                          <td> <%=r1.getString("police_contact_number")%> </td>
                          <td> <%=r1.getString("description")%> </td>
                      <tr>
                      <%
                    }
                }
                if(flag==0)
                {
                        %>
                      <tr>
                          <td colspan="5">
                            <div class="alert alert-danger">
                              No Data Found
                            </div>
                          </td>
                      </tr>
                        <%
                }
              }catch(Exception ex)
              {
                  out.println(ex);
              }
          %>
        </table>
      </div>
    </div>

</body>

</html>