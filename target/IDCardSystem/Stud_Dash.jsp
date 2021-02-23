<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="javax.servlet.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet"  href="style.css">
        <link rel="stylesheet"  href="profile.css">
         <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        
    </head>
    <body>
        <div class="container top p-3 ">
            <div class="row ">
            <img src="image/manit logo.png"class="img-thumbnail" alt="Cinque Terre" width="110px" height="110px" >
            <div class="col-sm-8 manit-cl">
                <h3 >Maulana Azad National Institute Technology </h3>
                <h5>Bhopal, Madhaya Pradesh</h5>
            </div>
            </div>
        </div>
        
        <!-- Grey with black text -->
        <nav class="navbar navbar-expand-sm p-1 sticky-top navbar-dark ">
            <div class="container">
                <h6 class=" navbar navbar-dark nav-cl "> MANIT</h6>
                <button type="button" class="navbar-toggler " data-toggle="collapse" data-target="#mymenu">
                    <span class="navbar-toggler-icon "></span>
                    
                </button>
                <div class="collapse navbar-collapse " id="mymenu">
                <ul class=" navbar-nav ml-auto" >
                    <li class="nav-item ">
                        <a class="nav-link " href="index.jsp">Home</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link " href="login.jsp">ID Card</a>
                    </li>
                    <li class="nav-item ">
                        <a class="nav-link  " href="contactus.jsp">Contact Us</a>
                    </li>
                    <li>
                        <a class="nav-link " href="admin.jsp">Admin</a>
                    </li>
                </ul>
                </div>
            </div>    
        </nav>
        
        <div class="container contact-form ">
            
            <div class="contact-des row " >
                <div >
                  <h4>Student Dashboard </h4>
                </div>
                <div class="ml-auto" style="float: right">
                  <a href="login.jsp" class="btn btn-danger" type="submit">Log out</a>
                </div> 
            </div>
                <hr>
                <div class="container">
<div class="py-5">
      <div class="col-sm-7">
        
        <!-- User profile -->
        <div class="panel panel-default">
          
          <div class="panel-body">
            <div class="profile__avatar">
              <img src="image/2.jpg" alt="...">
            </div>
            <div class="profile__header">
                
                <%
    
                    
                   Connection con;
                   PreparedStatement ps;
                   ResultSet x;
                   Class.forName("com.mysql.jdbc.Driver");
                   con= DriverManager.getConnection("jdbc:mysql://localhost:3306/idcard","root","");
                   
                   String scholar=request.getParameter("scholar");
                   ps=con.prepareStatement("select * from regstu where scholar = ?");
                   ps.setString(1, scholar);
                   x=ps.executeQuery();
                   
                   while(x.next())
                   {
                        
%>
              
              <h6 class="text-success">Sch. No./Roll No.: <%=x.getString("scholar")%></h6>
              <hr>
              <h6>Name : <%=x.getString("name")%> </h6>
              <hr>
              <h6>Father's Name : <%=x.getString("fname")%> </h6>
              <hr>
              <h6>Course: <%=x.getString("course")%> </h6>
              <hr>
              <h6>Session : <%=x.getString("Session")%> </h6>
              <hr>
              <h6>DOB : <%=x.getString("dob")%> </h6>
              <hr>
              <h6>Mobile No. : <%=x.getString("mobile")%></h6>
              <hr>
              <h6>Address: <%=x.getString("address")%> </h6>
              <hr>
              <h6>Email : <%=x.getString("email")%> </h6>
              <hr>
              
              
              <% 
                  }
              %>
              
                  
              <button class="btn bg-info">ID Card Download</button>
            </div>
          </div>
        </div>
      </div>
</div>
</div>
             </div>
            </div>
            
        
        
        
        
        
        
       
        
       
        <div class="idea">
            <div class="container">
                <div class="idea-right" ">
                    <hr>
                    <h4>ideas share </h4>
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" placeholder="text">
                            <div class="input-group-append">
                                <button class="btn btn-danger" type="submit">send</button>
                            </div>
                    </div>
                </div>
                
            </div>
            
        </div>
        
        <footer  class="py-3 footer-end ">
            <div class="container text-center">
                <p>Copyright &copy;2020 | Design by Navin Ranjan |</p>
             </div>
        </footer>
         
        
     <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>