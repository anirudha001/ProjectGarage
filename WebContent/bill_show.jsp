<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% 


String id5=(String)session.getAttribute("id5");
String id3=(String)session.getAttribute("id3");
String id4=(String)session.getAttribute("id4");
String name=(String)session.getAttribute("name");
String name1=(String)session.getAttribute("name1");
String bikename=(String)session.getAttribute("bikename");
String bikeno=(String)session.getAttribute("bikeno");
String servicing=(String)session.getAttribute("servicing");
String other=(String)session.getAttribute("other");
String cell=(String)session.getAttribute("cell");

%>

 <%-- <%
	String x="";
	x=(String)session.getAttribute("bid");
	if(x==null)
	{
		x="";
	}
	session.removeAttribute("bid");
%>  --%>

                    <%
                    	String j="";
                   		j=(String)session.getAttribute("bill");
                   		if(j==null)
                   		{
                   			j="";
                   		}
                    	session.removeAttribute("bill");
                   
        			
                    %>
                    



<html>
<head>
<%
Connection con = null;
Statement st = null;
ResultSet rs = null;
int id=0;
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
con = DriverManager.getConnection("jdbc:oracle:thin:@Anirudha-PC:1521:xe","Garage","garage");
}
catch(Exception e)
{}
try
{
String s="select bill_id from billing";
st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
rs=st.executeQuery(s);

if(rs.last())
{
id=rs.getInt("bill_id")+1;
}
}
catch(Exception e)
{
}
try
{
	if(con != null)
	{
		rs.close();
		con.close();
		System.out.println("Connection Closed Successfully...");
	}
}
catch(Exception e)
{
}
 %>

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
<link rel="stylesheet" href="html5.css">




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
                    <td>Bill ID:</td><td><input type="text" name="bill_id" value="<%=id %>"></td>
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
                    <td>General Servicing:</td><td><input type="text" name="general_servicing" ></td>
                    <td>   +   </td>
                    <td>Other:</td><td><input type="text" name="other_servicing"></td>
                   
                    <td>Total:</td><td><input type="text" name="bill" value="<%=j %>"><input type="submit" name="details" value="Generate Bill"></td>
                </tr>
                <tr>
                <td>mobile no:</td><td><input type="text" name="cell" value="<%=cell%>"></td>
                <td>Enter msg to send:</td><td><input type="text" name="msg" value=""></td>
                </tr>
            </table>
            <br>
            <br>
            <table>
                <tr>
                    <td><input type="submit" name="details" value="Add"></td>
                    <td><input type="submit" name="details" value="Show"></td>
                    <td><input type="submit" name="details" value="Search"></td>
                    <td><input type="submit" name="details" value="Print"></td>
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