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
        <title>ID CARD</title>
        
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet"  href="style.css">
         <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="bootstrap/bootstrap.min.css" >
        <link rel="stylesheet" href="bootstrap/bootstrap.min.js" >
    </head>
    <body>
        <div class="container top p-3 ">
            <div class="row px-1 ">
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
                    <li class="nav-item active ">
                        <a class="nav-link " href="register.jsp">ID Card</a>
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
        
        
        
        <div class="container py-3">
  <div class="row justify-content-center align-items-center ">

    <div class="col-md-7 contact-form ">
             
        <div class="col-md-12">
            <div class="contact-des" >
                <h4>ID Card</h4>
                
            </div>
                <hr>
                
             
                 
                 <div class=" contact-area2">
                
                    
                     
                     <form  action="Idcard" method="POST">
      
                       <div class="form-group">
                            <label >Roll No./ Scholar No.</label>
                            <input type="text" class="form-control" id="scholar" name="txtscholar"  placeholder="Roll Number">
                        </div>

                        <div class="form-group">
                            <label >Name</label>
                            <input type="text" class="form-control" id="name" name="txtname" placeholder="Enter the Full Name">
                        </div>
                        
                        <div class="form-group">
                            <label >Father's Name</label>
                            <input type="text" class="form-control" id="fname" name="txtfname" placeholder="Enter the Father's Name">
                        </div>
                         
                         <div>   
                         <label>Gender : </label>
                         <div class=" form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="gender" id="gender" value="Male">
                                <label class="form-check-label" for="inlineRadio1">Male</label>
                              </div>
                              <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="gender" id="gender" value="Female">
                                <label class="form-check-label" for="inlineRadio2">Female</label>
                              </div>
                         </div>

                        <div class="form-group">
                            <label for="sel1">Department</label>
                            <select class="form-control" id="course" name="course" >
                              <option>None</option>
                              <option>BTECH</option>
                              <option>MCA</option>
                              <option>MBA</option>
                            </select>
                          </div>
                          <div class="form-group">
                            <label >Session</label>
                            <input type="" class="form-control" id="session" name="txtsession" placeholder="Example : 2018-2021">
                        </div>
                        
                        <div class="form-group">
                            <label for="example-date-input">Date of Birth</label>
                            <input class="form-control" type="date" name="txtdob" id="dob">
                        </div>
                        
                        <div class="form-group">
                            <label >Mobile No.</label>
                            <input type="" class="form-control" name="txtmobile" id="mobile" placeholder="Example : 7979819668">
                        </div>

                   
                        <div class="form-group">
                            <label >Address</label>
                            <input type="addres" class="form-control" name="txtaddress" id="address" placeholder="Enter your Address ">
                        </div>

                        <div class="form-group">
                            <label >Email address</label>
                            <input type="email" class="form-control" name="txtemail" id="email" placeholder="name@example.com">
                        </div>
                        <div class="form-group">
                                
                                <button type="register" id="submitBtn" class="btn btn-primary">Get Id Card</button>
                                
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
     <script src="https://unpkg.com/pdf-lib@1.4.0"></script>
    <script src="./FileSaver.js"></script>
    <script src="https://unpkg.com/@pdf-lib/fontkit@0.0.4"></script>
    <script src="./index.js"></script>
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    </body>
</html>
