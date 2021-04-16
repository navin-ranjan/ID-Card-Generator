<%-- 
    Document   : index.jsp
    Created on : Jan 31, 2021, 3:32:38 PM
    Author     : Navin Ranjan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
        
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet"  href="style.css">
         <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="bootstrap/bootstrap.min.css" >
        <link rel="stylesheet" href="bootstrap/bootstrap.min.js" >
    </head>
    <body>
        <div class="container top p-3 ">
            <div class="row px-1">
            <img class="p-2" src="image/manit logo.png"class="img-thumbnail" alt="Cinque Terre" width="110px" height="110px" >
            <div class="col-sm-8 manit-cl">
                <h3 >Maulana Azad National Institute Technology </h3>
                <h5>Bhopal, Madhaya Pradesh</h5>
            </div>
            </div>
        </div>
        
        <!-- Grey with black text -->
        <nav class="navbar navbar-expand-sm p-1 sticky-top navbar-dark ">
            <div class="container">
                <h6 class="navbar navbar-dark nav-cl ">MANIT</h6>
                <button type="button" class="navbar-toggler " data-toggle="collapse" data-target="#mymenu">
                    <span class="navbar-toggler-icon "></span>
                    
                </button>
                <div class="collapse navbar-collapse text-center " id="mymenu">
                <ul class=" navbar-nav ml-auto" >
                    <li class="nav-item  ">
                        <a class="nav-link " href="index.jsp">Home</a>
                    </li>
                    <li class="nav-item ">
                        <a class="nav-link " href="register.jsp">ID Card</a>
                    </li>
                    <li class="nav-item ">
                        <a class="nav-link  " href="contactus.jsp">Contact Us</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link " href="admin.jsp">Admin</a>
                    </li>
                </ul>
                </div>
            </div>    
        </nav>
        
        
         <div class="container py-5">
  <div class="row justify-content-center align-items-center ">

    <div class="col-md-6 contact-form ">
             
        <div class="col-md-12">
            <div class="contact-des" >
                <h4>Admin Log in </h4>
                
            </div>
                <hr>
                
             
                 
                 <div class=" contact-area2">
                
                    
                     
                    <form  action="AdminLog" method="POST">
      
                       
                        <div class="form-group">
                            <label >Username</label>
                            <input type="text" class="form-control" name="txtuser" placeholder="username">
                        </div>

                        <div class="form-group">
                            <label >Password</label>
                            <input type="password" class="form-control" name="txtpass" placeholder="password">
                        </div>
                        <div class="form-group">
                                <button type="login" class="btn btn-success">Log in</button>
                                
                         </div>
                        
                    </form>
                    <div>
                       
                    </div>   
                    
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
    </body>
</html>
