/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.annotation.MultipartConfig;


/**
 *
 * @author Navin Ranjan
 */

@MultipartConfig(maxFileSize = 16177216)//1.5mb
public class RegS extends HttpServlet {
    
     PrintWriter out;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        out = response.getWriter();
       
        
        
        try  {
            /* TODO output your page here. You may use following sample code. */
            int result=0;
            
            out.print("yaha se strat h");
             String scholar=request.getParameter("txtscholar");
        String name=request.getParameter("txtname");
        String fname=request.getParameter("txtfname");
        String course=request.getParameter("course");
        String session=request.getParameter("txtsession");
        String dob=request.getParameter("txtdob");
        String mobile=request.getParameter("txtmobile");
        
       Part part= request.getPart("pic");          
        
        String address=request.getParameter("txtaddress");
        String email=request.getParameter("txtemail");
        String pass=request.getParameter("txtpass");
        String cpass=request.getParameter("txtcpass");
        if( cpass.equals(pass))
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/idcard","root","");
            out.print("nahi kam karega kya bol");
            PreparedStatement ps = con.prepareStatement("INSERT INTO regstu (scholar,name,fname,course,session,dob,mobile,image,address,email,pass) values(?,?,?,?,?,?,?,?,?,?,?)");
            out.print("nahi kam karega kya bol");
            InputStream is = part.getInputStream();
            
            ps.setString(1,scholar);
            ps.setString(2,name);
            ps.setString(3,fname);
            ps.setString(4,course);
            ps.setString(5,session);
            ps.setString(6,dob);
            ps.setString(7,mobile);
            ps.setBlob(8, is);
            ps.setString(9,address);
            ps.setString(10,email);
            ps.setString(11,pass);
            result = ps.executeUpdate();
            }       
            if(result > 0)
            {
                
                response.sendRedirect("login.jsp");
                out.println("image insert sucessfully");
            }
            else
                out.println("image insert not sucessfully");
            
        }
        catch(IOException | ClassNotFoundException | SQLException | ServletException e)
        {
            out.println(e);
        
        }
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
