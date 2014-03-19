<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% 

String id1=(String)session.getAttribute("idid");
String id5=(String)session.getAttribute("idx");
String id3=(String)session.getAttribute("idy");
String id4=(String)session.getAttribute("idz");
String name=(String)session.getAttribute("name");
String name1=(String)session.getAttribute("name1");
String bikename=(String)session.getAttribute("bikename");
String bikeno=(String)session.getAttribute("bikeno");
String servicing=(String)session.getAttribute("servicing");
String other=(String)session.getAttribute("other");
String bill=(String)session.getAttribute("b");



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



<form method="post" action="/ProjectGarage/Bill">
            <br>
            <br>
            <table cellspacing="4" cellpadding="4">
                <tr>
                    <td>Bill ID:</td><td><input type="text" name="bill_id" value"<%=id1 %>"></td>
                    <td>Servicing ID:</td><td><input type="text" name="servicing_id" value="<%=id5 %>"></td>
                </tr>
                <tr>
                    <td>Customer Id:</td><td><input type="text" name="customer_id" value="<%=id3 %>"></td>
                    <td>Worker ID:</td><td><input type="text" name="worker_id" value="<%=id4 %>" ></td>
                </tr>
                <tr>
                    <td>Customer Name:</td><td><input type="text" name="customer_name" value="<%=name %>"></td>
                    <td>Worker Name:</td><td><input type="text" name="worker_name" value="<%=name1 %>"></td>
                </tr>
                <tr>
                <td>Bike Name:</td><td><input type="text" name="bike_name" value="<%=bikename %>"></td>
                <td>Bike No:</td><td><input type="text" name="bike_no" value="<%=bikeno %>"></td>
                </tr>
                <tr><td>Servicing:</td><td><input type="text" name="servicing" value="<%=servicing %>"></td>
                	<td>Other Problems:</td><td><input type="text" name="other_problem" value="<%=other %>"></td>
                </tr>
            </table>
            <br>
            <br>
           <table>    
                <tr>
                    <td>Bill =</td>
                    <td>General Servicing:</td><td><input type="text" name="genral_servicing"></td>
                    <td>   +   </td>
                    <td>Other Servicing:</td><td><input type="text" name="other_servicing"></td>
                    <td></td>
                    <td>Total:</td><td><input type="text" name="bill" value="<%=bill %>"><input type="submit" name="details" value="Generate Bill"></td>
                </tr>
            </table>
            <br>
            <br>
            <table>
                <tr>
                    <td><input type="submit" name="details" value="Add"></td>
                    <td><input type="submit" name="details" value="Show"></td>
                    <td><input type="submit" name="details" value="Search"></td>
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