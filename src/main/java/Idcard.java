/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Navin Ranjan
 */
public class Idcard extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
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
        try {
            
            String lar=request.getParameter("txtscholar");
            String name=request.getParameter("txtname");
            String fname=request.getParameter("txtfname");
            String course=request.getParameter("course");
            String session=request.getParameter("txtsession");
            String dob=request.getParameter("txtdob");
            String mobile=request.getParameter("txtmobile");
            String gender=request.getParameter("gender");
            String address=request.getParameter("txtaddress");
            String email=request.getParameter("txtemail");
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://aws-idcard.caecyauotwqb.us-east-2.rds.amazonaws.com:3306/idcard?useSSL=false&allowPublicKeyRetrieval=true","admin","Navin15498");
            Statement st =con.createStatement();
            int x=st.executeUpdate("INSERT INTO `regstu` (`scholar`, `name`, `fname`, `course`, `session`, `dob`, `mobile`, `gender`, `address`, `email`) VALUES ('"+lar+"', '"+name+"', '"+fname+"', '"+course+"', '"+session+"', '"+dob+"', '"+mobile+"', '"+gender+"', '"+address+"', '"+email+"')");
           if(x!=0)
           {
               response.sendRedirect("register.jsp");
               
           }
           else
           {
               response.sendRedirect("index.jsp");
           }
        }
        catch(IOException | ClassNotFoundException | SQLException e){
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
