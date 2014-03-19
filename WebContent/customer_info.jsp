<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	

 


<link rel="stylesheet" href="html5.css"></link>
<title>HTML5</title>

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

<form method="post" name ="f1"  action="/ProjectGarage/CustomerInfo" >
<table><tr><td>
<table height ="300" width = "300"cellspacing="4" cellpadding="4" >
<tr>
<td >Customer-id:</td>
<td> <input type="text" name="customer_id"> </td>
</tr>
<tr>
<td align="left">Customer Name:</td>
<td>
<input type="text" name="customer_name" value=""></td>
<td>
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
<td>Customer address:</td>
<td><input type="text" name="customer_add"></td>
<td >
<%
	String dd=(String)session.getAttribute("dd");
	if(dd!=null)
	{
	if(dd.equals("1"))
	{
		session.removeAttribute("dd");
	%>
	<font color="red">Invalid address </font>
<%		
	}
	 }
%> 
</td>

</tr>
<tr>
<td>Customer Cell:
</td><td><input type="text" name="customer_cell"></td>
<td>
<%
	String cc=(String)session.getAttribute("cc");
	if(cc!=null)
	{
	if(cc.equals("1"))
	{
		session.removeAttribute("cc");
	%>
	<font color="red">Invalid cell_no !</font>
<%		
	}
	 }
%> 
</td>

</tr>

<tr><td>
Bike company:</td><td><input type="text" name="bike_company"></td>
<td>
<%
	String ee=(String)session.getAttribute("ee");
	if(ee!=null)
	{
	if(ee.equals("1"))
	{
		session.removeAttribute("ee");
	%>
	<font color="red">Invalid bike company !</font>
<%		
	}
	 }
%> 
</td>

</tr>
<tr><td>
Bike name:</td><td><input type="text" name="bike_name"></td>
<td>
<%
	String ff=(String)session.getAttribute("ff");
	if(ff!=null)
	{
	if(ff.equals("1"))
	{
		session.removeAttribute("ff");
	%>
	<font color="red">Invalid bike name !</font>
<%		
	}
	 }
%> 
</td>

</tr>
<tr><td>Bike no:</td><td><input type="text" name="bike_no"></td>
<td>
<%
	String hh=(String)session.getAttribute("hh");
	if(hh!=null)
	{
	if(hh.equals("1"))
	{
		session.removeAttribute("hh");
	%>
	<font color="red">Invalid bike no !</font>
<%		
	}
	 }
%> 
</td>

</tr>
<tr><td>Servicing:</td><td><input type="text" name="servicing"></td>
<td>
<%
	String gg=(String)session.getAttribute("gg");
	if(gg!=null)
	{
	if(gg.equals("1"))
	{
		session.removeAttribute("gg");
	%>
	<font color="red">Invalid servicing !</font>
<%		
	}
	 }
%> 
</td>

</tr>
<tr><td>Other Problems:</td><td><input type="text" name="other_problem"></td></tr>
</table>
<table cellspacing="4" cellpadding="4" height ="10" width ="10"> <tr>
<td><input type="submit" value="add" name="details"></td>
<td><input type="submit" value="search" name="details"></td>
<td><input type="reset" value="reset"></td>
<!-- <td><input type="submit" value="modify" name="details"></td> -->
<!-- <td><input type="submit" value="delete" name="details"></td> -->
</tr></table>
</table>
</form>


<%
	String flag=(String)session.getAttribute("flag");
	if(flag!=null)
	{
	if(flag.equals("1"))
	{
		session.removeAttribute("flag");
	%>
	Information added sucessfully..
<%		
	}
	 }
%> 




<br>
</div>

<div>
<br>
<br>
</div>

</body>
<br>
</html>