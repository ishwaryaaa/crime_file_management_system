<%-- 
    Document   : Signout.jsp
    Created on : Apr 27, 2019, 1:31:02 PM
    Author     : KHSCI5MCA16060
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%
            session = request.getSession(false);
            session.invalidate();
            response.sendRedirect("login.html");
       %>
    </body>
</html>
