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


<form method="post" action="/ProjectGarage/ServicingInfo">
<table cellspacing="5" cellpadding="5">
<tr>
<td>Servicing ID:</td><td><input type="text" name="servicing_id" ></td>
</tr>
<tr>
                    <td>Customer ID:</td><td><input type="text" name="customer_id">
                   
<%
	String bb=(String)session.getAttribute("bb");
	if(bb!=null)
	{
	if(bb.equals("1"))
	{
		session.removeAttribute("bb");
	%>
	<font color="red">Invalid cell_no !</font>
<%		
	}
	 }
%> 

                    
                    </td>
                    <td>Worker ID:</td><td><input type="text" name="worker_id">
                    
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
<tr>
<td>Customer Name:</td><td><input type="text" name="customer_name"></td>
<td>Worker Name:</td><td><input type="text" name="worker_name"></td>
</tr>
<tr>
<td>Customer Address:</td><td><input type="text" name="customer_address"></td>
<td>Servicing:</td><td><input type="text" name="servicing"></td>
</tr>
<tr>
<td>Bike Company:</td><td><input type="text" name="bike_company"></td>
<td>Other Problems:</td><td><input type="text" name="other_problem"></td>
</tr>
<tr>
<td>Bike Name:</td><td><input type="text" name="bike_name"></td>
<td>Bike No:</td><td><input type="text" name="bike_no"></td>
</tr>

</table>
<br>
<table cellspacing="10" cellpadding="8" >
<tr>
<td height="20" width="20">
<td><input type="submit" name="details" value="show"></td>
<td><input type="submit" name="details" value="search"></td>
<td><input type="reset" value="reset"></td>
</tr>
</table>

</form>



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
