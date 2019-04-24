<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% int cid = 0,count=Integer.parseInt(session.getAttribute("count").toString());
           String c= "ch";
           int flag=0;
           int i=1;
           while(flag==0&&i<=count)
           {
               c+=i;
               if(request.getParameter(c)!=null)
               {
                   flag=1;
                   cid=Integer.parseInt(request.getParameter(c));
                   
               }
               i++;
           }
           

        %>
        <form action="status1" method="POST"> 
            ID:   <input type="text" placeholder="" name="id" value="<%=cid%>" required><BR>
            <BR>
            STATUS:   <select name="status">
     <option value="status">SELECT</option>
     <option value="open">Open</option>
     <option value="ongoing">Ongoing</option>
     <option value="closed">Closed</option>
        </select><br><br><br>
        COMPLAINT HANDLER NAME:    <input type="text" placeholder="" name="complaint_handler_name" required> <BR><br><br>
        POLICE CONTACT NUMBER:     <input type="text" placeholder="" name="police_contact_number" required> <br><br><br>
                   
        <textarea rows="5" cols="50" name="description" placeholder="ENTER DESCRIPTION HERE.."></textarea><br><br>
        <button type="submit" formaction ="status1" class="registerbtn">SUBMIT</button>
        </form>
   </body>
</html>
