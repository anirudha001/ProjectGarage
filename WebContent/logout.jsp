<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>

<%

     String username=(String)session.getAttribute("username");
    if(username!=null)
        {
    	session.removeAttribute("username");
           //out.println(username+" loged out, <a href=\"login.jsp\">Back</a>");
           response.sendRedirect("login.jsp");
            
            
        }
     else 
         {
         out.println("You are already not login <a href=\"login.jsp\">Back</a>");
     }



%>  

</body>
</html>