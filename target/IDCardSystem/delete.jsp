<%@page import="java.sql.*" %>
<%@page import="javax.servlet.*" %>


<%
    
                    String scholar=request.getParameter("scholar");
                   Connection con;
                   PreparedStatement ps;
                   ResultSet x;
                   Class.forName("com.mysql.jdbc.Driver");
                   con= DriverManager.getConnection("jdbc:mysql://localhost:3306/idcard","root","");
                    
                   ps=con.prepareStatement("delete from regstu where scholar = ?");
                  ps.setString(1, scholar);
                  ps.executeUpdate();
      

                  response.sendRedirect("Admin_Dash.jsp");%>
                        
%>


