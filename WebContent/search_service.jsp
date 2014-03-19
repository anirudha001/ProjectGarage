<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	String id=(String)session.getAttribute("id4");
	String id1=(String)session.getAttribute("id1");
	String name=(String)session.getAttribute("name");
	String addr=(String)session.getAttribute("addr");
	String bikecmp=(String)session.getAttribute("bikecmp");
	String bikename=(String)session.getAttribute("bikename");
	String bikeno=(String)session.getAttribute("bikeno");
	String id3=(String)session.getAttribute("id3");
    String name1=(String)session.getAttribute("name1");
	
	String servicing=(String)session.getAttribute("servicing");
	String other=(String)session.getAttribute("other");
	
	
	
%>


<html>
<head>

<%
String myname =  (String)session.getAttribute("username");
if(myname==null)
{
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

<form>
<table cellspacing="5" cellpadding="5">
<tr>
<td>Servicing ID:</td><td><input type="text" name="<%=id %>"></td>
</tr>
<tr>
                    <td>Customer ID:</td><td><input type="text" value="<%=id1 %>"></td>
                    <td>Worker ID:</td><td><input type="text" value="<%=id3 %>"></td>
                </tr>
<tr>
<td>Customer Name:</td><td><input type="text" value="<%=name %>"></td>
<td>Worker Name:</td><td><input type="text" value="<%=name1 %>"></td>
</tr>
<tr>
<td>Customer Address:</td><td><input type="text" name="customer_add" value="<%=addr %>"></td>
<td>Servicing:</td><td><input type="text" value="<%=servicing %>"></td>
</tr>
<tr>
<td>Bike Company:</td><td><input type="text" value="<%=bikecmp%>"></td>
<td>Other Problems:</td><td><input type="text" value="<%=other%>"></td>
</tr>
<tr>
<td>Bike Name:</td><td><input type="text" value="<%=bikename %>"></td>
<td>Bike No:</td><td><input type="text" value="<%=bikeno %>"></td>
</tr>

</table>
<br>
<table cellspacing="10" cellpadding="8" >
<tr>
<td height="20" width="20">

<a href="Servicing_info.jsp">Back</a>
</td>


</tr>
</table>

</form>



<br>
<br>
<br>
<br>
<br>

</div>

<div>
<br>
<br>
</div>

</body>
<br>
</html>