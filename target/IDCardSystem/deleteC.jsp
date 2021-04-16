<%@page import="java.sql.*" %>
<%@page import="javax.servlet.*" %>


<%
    
                    String sn=request.getParameter("sn");
                   Connection con;
                   PreparedStatement ps;
                   ResultSet x;
                   Class.forName("com.mysql.jdbc.Driver");
                   con= DriverManager.getConnection("jdbc:mysql://localhost:3306/idcard","root","");
                    
                   ps=con.prepareStatement("delete from contact where sn = ?");
                  ps.setString(1, sn);
                  ps.executeUpdate();
      

                  response.sendRedirect("contactDash.jsp");%>
                        
%>


