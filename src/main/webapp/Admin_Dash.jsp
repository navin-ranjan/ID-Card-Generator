<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet"  href="style.css">
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
                    <li class="nav-item active ">
                        <a class="nav-link " href="index.jsp">Home</a>
                    </li>
                    <li class="nav-item ">
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
                  <h4>Admin Dashboard </h4>
                </div>
                <div class="ml-auto" style="float: right">
                    <button class="btn btn-primary" type="submit">Ideas View</button>
                    <button class="btn btn-primary" type="submit">Contact View</button>
                    <a  href="admin.jsp" class="btn btn-danger" type="submit">Log out</a>
                </div> 
            </div>
                <hr>
             <div class="row contact-area1">   
             <div class="profile col-md-6" >
                    <div class="card">
                        
                        <div class="card-body">
                            <h4 style="margin-left: 20px">Instractions</h4>
                                 <ul style="margin-right: 20px; color: red">
                                     <li>Fill the correct Information and click on Generate ID Card button.</li>
                                     
                                </ul>
                                 
                        </div>
                    </div>
            </div>
                 
                 <div class="col-md-5 contact-area2">
                
                    
                     
                    <form  class="container " action="RegS" method="get">
      
                        <div class="form-group"> 
                            <label >Name </label>
                             <input type="name" class="form-control" name="txtname" placeholder="Your name">
                        </div>
                        <div class="form-group">
                            <label >Email address</label>
                            <input type="email" class="form-control" name="txtemail" placeholder="name@example.com">
                        </div>

                        <div class="form-group">
                            <label >New Password</label>
                            <input type="password" class="form-control" name="txtpass" placeholder="password">
                        </div>
                        <div class="form-group">
                            <label >Confirm Password</label>
                            <input type="password" class="form-control" name="txtcpass" placeholder="confirm password">
                        </div>
                        <div class="form-group">
                            <label >Mobile Number</label>
                            <input type="phone" class="form-control"  name="txtmobile" placeholder="Your Number">
                        </div>
                        <input type="submit" class="btn btn-success" value="Generate ID Card">
                    </form>
                    <div>
                       
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