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
        <title>Registration</title>
        
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
                <h6 class="navbar-dark nav-cl ">MANIT</h6>
                <button type="button" class="navbar-toggler " data-toggle="collapse" data-target="#mymenu">
                    <span class="navbar-toggler-icon "></span>
                    
                </button>
                <div class="collapse navbar-collapse " id="mymenu">
                <ul class=" navbar-nav ml-auto" >
                    <li class="nav-item  ">
                        <a class="nav-link " href="index.jsp">Home</a>
                    </li>
                    <li class="nav-item active ">
                        <a class="nav-link " href="login.jsp">ID Card</a>
                    </li>
                    <li class="nav-item ">
                        <a class="nav-link  " href="contactus.jsp">Contact Us</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="admin.jsp">Admin</a>
                    </li>
                </ul>
                </div>
            </div>    
        </nav>
        
        
        
        <div class="container py-5">
  <div class="row justify-content-center align-items-center ">

    <div class="col-md-7 contact-form ">
             
        <div class="col-md-12">
            <div class="contact-des" >
                <h4>Student Registration </h4>
                
            </div>
                <hr>
                
             
                 
                 <div class=" contact-area2">
                
                    
                     
                     <form  action="RegS" method="POST" enctype="multipart/form-data">
      
                       <div class="form-group">
                            <label >Roll No./ Scholar No.</label>
                            <input type="text" class="form-control" name="txtscholar" placeholder="Roll Number">
                        </div>

                        <div class="form-group">
                            <label >Name</label>
                            <input type="text" class="form-control" name="txtname" placeholder="Enter the Full Name">
                        </div>
                        
                        <div class="form-group">
                            <label >Father's Name</label>
                            <input type="text" class="form-control" name="txtfname" placeholder="Enter the Father's Name">
                        </div>

                        <div class="form-group">
                            <label for="sel1">Course</label>
                            <select class="form-control" id="sel1" name="course" >
                              <option>None</option>
                              <option>BTECH</option>
                              <option>MCA</option>
                              <option>MBA</option>
                            </select>
                          </div>
                          <div class="form-group">
                            <label >Session</label>
                            <input type="" class="form-control" name="txtsession" placeholder="Example : 2018-2021">
                        </div>
                        
                        <div class="form-group">
                            <label for="example-date-input">Date of Birth</label>
                            <input class="form-control" type="date" name="txtdob" id="example-date-input">
                        </div>
                        
                        <div class="form-group">
                            <label >Mobile No.</label>
                            <input type="" class="form-control" name="txtmobile" placeholder="Example : 7979819668">
                        </div>

                        <div class="mb-3">
                            <label for="formFile" class="form-label">Profile picture</label>
                            <input class="form-control" type="file" name="pic" id="formFile">
                          </div>
                        <div class="form-group">
                            <label >Address</label>
                            <input type="addres" class="form-control" name="txtaddress" placeholder="Enter your Address ">
                        </div>

                        <div class="form-group">
                            <label >Email address</label>
                            <input type="email" class="form-control" name="txtemail" placeholder="name@example.com">
                        </div>

                        <div class="form-group">
                            <label >New Password</label>
                            <input type="password" class="form-control" name="txtpass" placeholder="new password">
                        </div>
                        <div class="form-group">
                            <label >confirm Password</label>
                            <input type="password" class="form-control" name="txtcpass" placeholder="confirm password">
                        </div>
                        <div class="form-group">
                                <label for="remember-me" class="text-info"><span>Remember me</span> <span><input id="remember-me" name="remember-me" type="checkbox"></span></label><br>
                                
                                <button type="register" class="btn btn-success">Register</button>
                                <a href="login.jsp" class="btn btn-primary">Log in</a>
                         </div>
                        
                    </form>
                    <div>
                       
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
                            <div class="input-group-append ml-auto">
                             <button class="btn btn-success" type="submit">send</button>
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
