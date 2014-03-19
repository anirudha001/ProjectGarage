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



<form method="post" name="f1" action="/ProjectGarage/Bill">
            <br>
            <br>
            <table cellspacing="4" cellpadding="4">
                <tr>
                    <td>Bill ID:</td><td><input type="text" name="bill_id"></td>
                    <td>Servicing ID:</td><td><input type="text" name="servicing_id">
                    <%
	String gg=(String)session.getAttribute("gg");
                    if(gg!=null)
	{
	if(gg.equals("1"))
	{
		session.removeAttribute("gg");
	%>
	<font color="red">Invalid ID !</font>
<%	}
	 }
%> 	
                    </td>
                </tr>
                <tr>
                    <td>Customer Id:</td><td><input type="text" name="customer_id"></td>
                    <td>Worker ID:</td><td><input type="text" name="worker_id"></td>
                </tr>
                <tr>
                    <td>Customer Name:</td><td><input type="text" name="customer_name"></td>
                    <td>Worker Name:</td><td><input type="text" name="worker_name"></td>
                </tr>
                <tr>
                <td>Bike Name:</td><td><input type="text" name="bike_name"></td>
                <td>Bike No:</td><td><input type="text" name="bike_no"></td>
                </tr>
                <tr><td>Servicing:</td><td><input type="text" name="servicing"></td>
                	<td>Other Problems:</td><td><input type="text" name="other_problem"></td>
                </tr>
            </table>
            <br>
            <br>
           <table>    
                <tr>
                    <td>Bill =</td>
                    <td>General Servicing:</td><td><input type="text" name="general_servicing"></td>
                    <td>   +   </td>
                    <td>Other Servicing:</td><td><input type="text" name="other_servicing"></td>
                    <td></td>
                    <td>Total:</td><td><input type="text" name="bill"><input type="submit" name="details" value="Generate Bill"></td>
                </tr>
            </table>
            <br>
            <br>
            <table>
                <tr>
                    <td><input type="submit" name="details" value="Show"></td>
                    <td><input type="submit" name="details" value="Search"></td>
                    <td><input type="reset" value="reset"></td>
                    
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