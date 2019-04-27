<%-- 
    Document   : fir
    Created on : Apr 27, 2019, 3:00:52 PM
    Author     : KHSCI5MCA16060
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="../main.css">


        <style>

            .contactBody{
                background-color:black;
                background-size: cover;
                background-attachment: fixed;
                height:1200px;

            }
            .title{
                margin: 0 auto;
                width: 50%;
                text-align: center;
                padding-bottom: 10px;
                font-size: 42px;
                color: rgb(252, 252, 252);
            }

            #title-Tag-Line{
                font-size: 20px;
            }
            /* This will center the form */
            .wrapper {
                width: 80%;
                height: 50%;
                margin: 5% auto 0 auto; 
            }

            /* form animation starts */
            .form {
                background: #EBEBEB;
                text-align: center; 
                box-shadow: 0px 0px 20px 5px #AAA; 
                border-radius: 10px;  
                width: 45%; 
                height: 1220px;
                margin: 30px auto 0 auto;
                padding: 10px 10px;  
                animation: bounce 1.5s infinite;
            }

            .name { 
                background-color:#2BB09A ;
                border-bottom: 5px solid #B2175F;
                color: grey;
                width:300px;
            }

            ::-webkit-input-placeholder{
                color: white;
                font-size: 20px;
            }
            .name:hover{
                background-color: white;
                border-bottom: 5px solid #B2175F;
                height:30px;
                width:400px;
            }

            .email {
                background-color: #2BB09A;  
                border-bottom: 5px solid #502789;
                height:50px;
                width:300px;

            }
            .email:hover{
                background-color: white;  
                border-bottom: 5px solid #502789;
                height:30px;
                width:380px;

            }
            .message {   
                background-color: #2BB09A;
                border-bottom: 5px solid rgb(195, 35, 17);
                overflow: hidden;
                height: 100px;  
                width:300px;
            }

            .message:hover{
                background-color: white;
                border-bottom: 5px solid #2BB09A;
                height: 100px;
                width:370px;
            }

            .submit{
                border-radius:5px;
                padding:10px;
                background-color: #2DD7BB;  
                border: none;
                border-bottom: 5px solid #CB64B2; 
                transform: translateY(-120px); 

            }

            .submit:hover{
                border-bottom: 5px solid #CB64B2;  
                box-shadow: 15px 15px 15px 5px rgba(78, 72, 77, 0.219);
            }

            .entry{
                display: block;
                margin: 30px auto;
                padding: 10px;
                border-radius: 5px;
                border: none;
                transition: all 0.5s ease 0s;
                box-shadow: 0px 0px 25px 2px #AAA;  
            }

            /* Shadow to make it look like form is floating  */
            .shadow{
                box-shadow: 0px 0px 60px 5px #AAA;
                opacity: 0.5;
                border-radius: 100px;
                width: 50%; 
                margin: 50px auto 0 auto;
                padding: 0 20px;  
                animation: shadow 1.5s infinite;
            }
            .submit{
                border-radius:5px;
                padding:10px;
                width:150px;
                color: white;
                background-color: #EE78D1;  
                border: none;
                border-bottom: 5px solid #CB64B2; 
                margin-top: 150px; 

            }



            @keyframes bounce{
                0%{

                }
                50%{
                    transform: translate(0, 8px);
                }

            }
            @keyframes shadow{
                0%{

                }
                50%{
                    opacity: 0.8;
                    width: 50%;
                }
            }

        </style>
        <!-- import statements of bootstrap4 -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
    </head>
    <body class="contactBody">   
    <center>
        <div class="wrapper">
            <div class="title">


            </div>
            <form action="fir" method="POST" class="form">

                <div class="input-group mb-3  entry ">
                  <div class="input-group-prepend">
                      <span class="input-group-text">Complaint id</span>
                  </div>
                  <select class="form-control"  name="cid">

                      <%
                          try{
                              Class.forName("com.mysql.jdbc.Driver");
                              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crime", "root", "");
                              PreparedStatement s1 = con.prepareStatement("SELECT * FROM complaint WHERE cid NOT IN (SELECT cid FROM fir) ");
                             
                              ResultSet r = s1.executeQuery();
                              int flag = 0;
                              while (r.next()) {
                                flag=1;
                                 out.println("<option>"+r.getString("cid")+"</option>" );

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
                <input type="text" class="email entry" placeholder="FIR ID" name="fid"/>
                <input type="text" class="email entry" placeholder="NAME" name="fname"/>
                <input type="text" class="email entry" placeholder="GENDER" name="gender"/>
                <input type="date" class="email entry" placeholder="DATE OF BIRTH" name="dob"/>
                <input type="text" class="email entry" placeholder="ADDRESS" name="faddress"/>
                <input type="text" class="email entry" placeholder="PHONE NUMBER" maxlength="10" name="phonenumber"/>
                <input type="text" class="email entry" placeholder="CRIME" name="crime"/>

                <textarea class="message entry" placeholder="DESCRIPTION" name="crimedescription"></textarea> 
                <input type="text" class="email entry" placeholder="FATHER'S NAME" name="fathersname"/>
                <input type="date" class="email entry" placeholder="DATE OF CRIME" name="dateofcrime"/>
                <input type="date" class="email entry" placeholder="DATE" name="date"/>
                <input type="text" class="email entry" placeholder="LOCATION" name="location"/>

                <button class="submit entry"  formaction="fir">Submit</button>
            </form>  

            <div class="shadow"></div>
        </div>

        <script src="app.js"></script>
    </body>
</html>
