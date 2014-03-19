<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<% 
	String id=(String)session.getAttribute("id");
    String name=(String)session.getAttribute("name");
	String addr=(String)session.getAttribute("addr");
	String cell=(String)session.getAttribute("cell");
	String bikecmp=(String)session.getAttribute("bikecmp");
	String bikename=(String)session.getAttribute("bikename");
	String bikeno=(String)session.getAttribute("bikeno");
	String servicing=(String)session.getAttribute("servicing");
	String other=(String)session.getAttribute("other");
	
%>


<html>
<head>

<%
String myname =  (String)session.getAttribute("username");
if(myname==null)
{
	session.removeAttribute("username");
	response.sendRedirect("login.jsp");
%>
<%-- <jsp:forward page="login.jsp">
<jsp:param value="myname" name="myname"></jsp:param>
</jsp:forward> --%>
<%
	// out.println(" You are logged out, <a href=\"login.jsp\">Back</a>");
}
%>
<link rel="stylesheet" href="html5.css"></link>
<title>HTML5</title>
</head>
<body style="filter:progid:DXImageTransform.Microsoft.Gradient(endColorstr='#FF5C33', startColorstr='#333333', gradientType='1');">


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

<form method="post" action="/ProjectGarage/Modify"><table><tr><td>
<table height ="300" width = "300"cellspacing="4" cellpadding="4">
<tr>
<td >Customer-id:</td>
<td> <input type="text" name="customer_id" value="<%=id%>"></td>
</tr>
<tr>
<td align="left">Customer Name:</td>
<td>
<input type="text" name="customer_name" value="<%=name%>"></td>
</tr>
<tr>
<td>Customer address:</td>
<td><input type="text" name="customer_add" value="<%=addr%>"></td>
</tr>
<tr>
<td>Customer Cell:
</td><td><input type="text" name="customer_cell" value="<%=cell %>"></td></tr>
<tr><td>
Bike company:</td><td><input type="text" name="bike_company"  value="<%=bikecmp%>" ></td></tr>
<tr><td>
Bike name:</td><td><input type="text" name="bike_name" value="<%=bikename%>" ></td></tr>
<tr><td>Bike no:</td><td><input type="text" name="bike_no" value="<%=bikeno%>" ></td></tr>
<tr><td>Servicing:</td><td><input type="text" name="servicing" value="<%=servicing%>"></td></tr>
<tr><td>Other Problems:</td><td><input type="text" name="other_problem" value="<%=other%>"></td></tr>
</table>
<table cellspacing="4" cellpadding="4" height ="10" width ="10"> <tr>
<td><input type="submit" value="modify" name="details" ></td>
<!-- <td><input type="submit" value="delete" name="details" ></td> -->
</tr></table></td>
<td><img height="200" width="200" src="C:\Users\Anirudha\Pictures\..jpg"> </td></tr> </table>
</form>

<br>
</div>

<div>
<br>
<br>
</div>

</body>
<br>
</html>