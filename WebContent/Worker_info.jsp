<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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



<form method="post" action="/ProjectGarage/WorkerInfo">
<table cellspacing="4" cellpadding="4">
<tr>
<td>Worker id:</td>
<td><input type="text" name ="worker_id">
<%
	String ii=(String)session.getAttribute("ii");
	if(ii!=null)
	{
	if(ii.equals("1"))
	{
		session.removeAttribute("ii");
	%>
	<font color="red">Invalid id !</font>
<%		
	}
	 }
%> 
</td>
</tr>
<tr>
<td>Worker name:</td>
<td><input type="text" name="worker_name">

<%
	String bb=(String)session.getAttribute("bb");
	if(bb!=null)
	{
	if(bb.equals("1"))
	{
		session.removeAttribute("bb");
	%>
	<font color="red">Invalid name !</font>
<%		
	}
	 }
%> 

</td>
</tr>
<tr>
<td>Worker Address:</td>
<td><input type="text" name="worker_address">
<%
	String dd=(String)session.getAttribute("dd");
	if(dd!=null)
	{
	if(dd.equals("1"))
	{
		session.removeAttribute("dd");
	%>
	<font color="red">Invalid address !</font>
<%		
	}
	 }
%> 

</td>
</tr>
<tr>
  <td>Worker Mob. no.</td>
  <td><input type="text" name="worker_mob">
  <%
	String cc=(String)session.getAttribute("cc");
	if(cc!=null)
	{
	if(cc.equals("1"))
	{
		session.removeAttribute("cc");
	%>
	<font color="red">Invalid mobile no !</font>
<%		
	}
	 }
%> 
  
  </td>
</tr>

</table>
<br>
<table>
<tr>
<td><input type="submit" name="details" value="add"></td>
<td><input type="submit" name="details" value="search"></td>
<td><input type="reset" value="reset"></td>
</tr>
</table>
</form>

<%
	String flag=(String)session.getAttribute("flag");
		if(flag!=null)
		{
	if(flag.equals("1"))
	{
	%>
	
	Information Added Successfully....	
		
<%		
	}
		}
%> 
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

</div>

<div>

<br>
</div>

</body>
<br>
</html>