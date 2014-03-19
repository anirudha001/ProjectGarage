<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" href="html5.css"></link>
<title>HTML5</title>
</head>
<body>

  <%
        String myname =  (String)session.getAttribute("username");
       
        if(myname!=null)
            {
        	
        
             out.println("Welcome  "+myname+"  , <a href=\"logout.jsp\" >Logout</a>");
             
             %>
             
             
             
           

<div align="center" ><h1>Garage Management System</h1>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;


</div>

<div id="container">
<a href="login.jsp">HOME</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="customer_info.jsp">CUSTOMER INFORMATION</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="Worker_info.jsp">WORKER INFORMATION</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="Servicing_info.jsp">SERVICING</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="Billing.jsp">BILLING</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="AboutUs.jsp">ABOUT US</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<div id="container">
</div>

<br>
<br>
<br>
<table>
<tr>
<td><img align="middle" height="500" width="600" src="c.jpg"></td>
<td valign="top">
<font style="font-family:sans-serif"><b>Garage Management System(GMS)</b><br>
caters to the need of various activities<br> 
 of Garage, which works as a non-profit,<br>
  service providing division to its own <br>
 parent group of Companies.<br></font>
 </td>
 </tr>
</table>

             
      







<br>
<br>
</div>

<div>

<br>
<br>
<br>
<br>

</div>

</body>
  <%
        
        }
     
     else 
         {
     	
     
	%>
       
            
            <form action="checkLogin.jsp">
            	<center>Login For Garage Management System</center>
                <table align="center">
                
                    <tr>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Username  : </td>
                        <td> <input name="username" size=15 type="text" /> </td> 
                    </tr>
                    <tr>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Password  : </td>
                        <td><input name="password" size=15 type="password" /> </td> 
                    </tr>
                    <tr>
                 <td> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="login" /></td>
                  </tr>  
                </table>
                
               
            </form>
        <% 
            }
        
            
            %>
      
</html>
