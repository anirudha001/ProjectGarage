package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.corba.se.spi.orbutil.fsm.State;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

/**
 * Servlet implementation class Bill
 */
public class Bill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection con = null;
	Statement stat = null;
	ResultSet rs = null;
	
	int count = 0;
	
	
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	

	public void setConn() throws ClassNotFoundException, SQLException
	{
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@Anirudha-PC:1521:xe","Garage","garage");			
		
		
	}
	
	public void closeConn()
	{
		try{
			if(con != null)
			{
				rs.close();
				con.close();
				System.out.println("Connection Closed Successfully...");
			}
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
   
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		String a=request.getParameter("details");
		

		try {
			setConn();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		PrintWriter out=response.getWriter();
		
		//int id2=Integer.parseInt(request.getParameter("servicing_id"));
		
		String name=request.getParameter("customer_name");
		
		String bikename=request.getParameter("bike_name");
		String bikeno=request.getParameter("bike_no");
		
		
		String name1=request.getParameter("worker_name");
		String cell=request.getParameter("cell");
		
		String servicing=request.getParameter("servicing");
		String other=request.getParameter("other_problem");
		
	
		if(a.equals("Add"))
		{
			//int id=request.getParameter("bill_id");
			int id=Integer.parseInt(request.getParameter("bill_id"));
			int id2=Integer.parseInt(request.getParameter("servicing_id"));
			//int id1=Integer.parseInt(request.getParameter("bill_id"));
			//int id4=Integer.parseInt(request.getParameter("worker_id"));
			int bill=Integer.parseInt(request.getParameter("bill"));
			//int id=0;
			
			try{
				
				String s="select bill_id from billing";
				Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet rs=st.executeQuery(s);
				
				//if(rs.last()){
				//id=rs.getInt("bill_id")+1;
			//	}
					
					PreparedStatement ps=con.prepareStatement("insert into billing values (?,?,?)");
			
					
					ps.setInt(1,id);
					ps.setInt(2,id2);
					ps.setInt(3,bill);
					smssending.sendsms.sendMessage(request.getParameter("msg"),cell);
								
					ps.executeUpdate();
		
					con.commit();
					con.close();
					
					//out.print("Name:: "+name);
			
				
			}
			catch(Exception e)
			{
	              out.println(e);
			}		
			
			//out.print("<br><br>Information Added Sucessfully...");
			int flag=1;
			String z=""+flag;
			String n=""+id;
			HttpSession session=request.getSession();
			session.setAttribute("bid",id);
			session.setAttribute("iid",n);
			session.setAttribute("flag",z);
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/bill_show.jsp");
			rd.include(request, response);
			out.close();
			
			//Closes the Connection
			closeConn();
			
			
			
			
			}  //if stmt
		
		
		
		String aa=null,bb=null,cc=null,dd=null,ee=null,ff=null,gg=null,hh=null,ii=null;
		int flag1=0;
		
			String aaa=request.getParameter("bill_id");

			String ser=request.getParameter("servicing_id");
	                Pattern p2=Pattern.compile("[0-9]*[0-9]");
			Matcher m2=p2.matcher(ser);
			boolean b2=m2.matches();
	                if(b2==false)
	                    {
	                        gg="1";
	                    }
	                else
	                { 
	                	flag1++;    
	                }

	              
	                
	                if(flag1!=1)
	                {
	                	HttpSession session=request.getSession();
	                	
	                	session.setAttribute("gg",gg);
	                	
	                	
	                	
	                	RequestDispatcher rd=getServletContext().getRequestDispatcher("/Billing.jsp");
	                	rd.include(request, response);
	                	
	                	
	                	
	                }

	                
		
		if(flag1==1)
		{
		
		
		
		 if(a.equals("Show"))
		{
			
			int id2=Integer.parseInt(request.getParameter("servicing_id"));
			
			String id5=request.getParameter("servicing_id");
			
			String s="select * from servicing_info";
			String s1="select * from customer_info";
			String s2="select * from worker_info";
			int id8=0,id9=0;
			
			Statement stmt = null;
			Statement stmt1=null;
			Statement stmt2=null;
			
			try {
				stmt= con.createStatement();
				stmt1=con.createStatement();
				stmt2=con.createStatement();
				
			} catch (SQLException e) {
				out.print("In con.createstatement....");
				e.printStackTrace();
			}
			ResultSet rs = null;
			ResultSet rs1=null;
			ResultSet rs2=null;
			
			try {
				rs = stmt.executeQuery(s);
				rs1=stmt1.executeQuery(s1);
				rs2=stmt2.executeQuery(s2);
				
			} catch (SQLException e) {
				out.print("In execute query....");
				e.printStackTrace();
			}
			
			try {
				while(rs.next())
				{
					if(id2==rs.getInt(1))
					{
						id8=rs.getInt(2);
						
						id9=rs.getInt(3);
					
						
						
						
						
					}
				}
				
				    while(rs1.next())
				    {
				    	if(id8==rs1.getInt(1))
				    	{
				    		name=rs1.getString(2);
				    		cell=rs1.getString(4);
							bikename=rs1.getString(6);
							bikeno=rs1.getString(7);
							servicing=rs1.getString(8);
							other=rs1.getString(9);
				    	}
				    }
				    
				    while(rs2.next())
				    {
				    	if(id9==rs2.getInt(1))
				    	{
				    		name1=rs2.getString(2);
				    	}
				    }
				
				
				
				
				
			} catch (SQLException e) {
				out.print("In rs.next......");
				e.printStackTrace();
			}
			
			String x=""+id8;
			String y=""+id9;
			String fff="1";
			
			HttpSession session=request.getSession();
			//session.setAttribute("id4",id4);
			session.setAttribute("id5",id5);
			session.setAttribute("id3",x);
			session.setAttribute("id4",y);
			session.setAttribute("name",name);						
			session.setAttribute("name1",name1);
			session.setAttribute("cell",cell);
			session.setAttribute("bikename",bikename);
			session.setAttribute("bikeno",bikeno);
			session.setAttribute("servicing",servicing);
			session.setAttribute("other",other);
			session.setAttribute("flag3",fff);
			session.setAttribute("bid",aaa);
			
			String SEARCH_JSP = "/bill_show.jsp";
			String forward=SEARCH_JSP;
			RequestDispatcher rd=getServletContext().getRequestDispatcher(forward);
			rd.include(request, response);
			
			
		}
		
		 
		}  //flag if
		
		if(a.equals("Print"))
		{
			String bill=request.getParameter("bill");
			
			String bill_id=request.getParameter("bill_id");
			//String bikeno1=request.getParameter("bike_no");
			
			
			//String name1=request.getParameter("worker_name");
			//String cell=request.getParameter("cell");
			
			String ser_id=request.getParameter("servicing_id");
			String cust_id=request.getParameter("customer_id");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>report</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<form>");
			out.println("<center>BILL REPORT");
			out.println("<br>");
			out.println("<br>");
			out.println("<br>");
			out.println("<table cellspacing=\"4\" cellpadding=\"4\">");
            out.println( "<tr>");
            out.println("<td>Bill ID:</td>" );
            out.println("<td>"+bill_id);
            out.println(" </td>");
            out.println("</tr>");
			//out.println("Bill id:"+bill_id);
			//out.println("<br>");
			//out.println("<br>");
			//out.println("Customer id:"+cust_id);
			 out.println( "<tr>");
	        out.println("<td>Customer ID:</td>" );
	        out.println("<td>"+cust_id);
	        out.println(" </td>");
	        out.println("</tr>");
			//out.println("<br>");
			//out.println("<br>");
			//out.println("Customer name:"+name);
			 out.println( "<tr>");
	            out.println("<td>Customer Name:</td>" );
	            out.println("<td>"+name);
	            out.println(" </td>");
	            out.println("</tr>");
			//out.println("<br>");
			//out.println("<br>");
			//out.println("Customer mob.no:"+cell);
			 out.println( "<tr>");
	            out.println("<td>Customer Mob.No.:</td>" );
	            out.println("<td>"+cell);
	            out.println(" </td>");
	            out.println("</tr>");
			//out.println("<br>");
			//out.println("<br>");
			//out.println("Servicing:"+servicing);
			 out.println( "<tr>");
	            out.println("<td>Servicing:</td>" );
	            out.println("<td>"+servicing);
	            out.println(" </td>");
	            out.println("</tr>");
			//out.println("<br>");
			//out.println("<br>");
			//out.println("Other problem:"+other);
			 out.println( "<tr>");
	            out.println("<td>Other Problem:</td>" );
	            out.println("<td>"+other);
	            out.println(" </td>");
	            out.println("</tr>");
			//out.println("<br>");
			//out.println("<br>");
			//out.println("total bill:"+bill);
			 out.println( "<tr>");
	            out.println("<td>Total Bill:</td>" );
	            out.println("<td>"+bill);
	            out.println(" </td>");
	            out.println("</tr>");
			//out.println("<br>");
			out.println(" </table>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		}
		 
		if(a.equals("Search"))
		{
			
			//int id5=Integer.parseInt(request.getParameter("servicing_id"));
			int id1=Integer.parseInt(request.getParameter("bill_id"));
			String idid=request.getParameter("bill_id");
			int id=0,id7=0,id6=0,id8=0,id9=0,bil=0,id11=0,id12=0;
			
			String s="select * from billing";
			String s1="select * from servicing_info";
			String s2="select * from customer_info";
			String s3="select * from worker_info";
			
			Statement stmt = null;
			Statement stmt1=null;
			Statement stmt2=null;
			Statement stmt3=null;
			try {
				stmt = con.createStatement();
				stmt1 = con.createStatement();
				stmt2 = con.createStatement();
				stmt3 = con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ResultSet rs = null;
			ResultSet rs1=null;
			ResultSet rs2=null;
			ResultSet rs3=null;
			try {
				rs = stmt.executeQuery(s);
				rs1=stmt1.executeQuery(s1);
				rs2=stmt2.executeQuery(s2);
				rs3=stmt3.executeQuery(s3);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				while(rs.next())
				{
					if(rs.getInt(1)==id1)
					{
						id8=rs.getInt(2);
						bil=rs.getInt(3);
					}
				}
				
					while(rs1.next())				//Servicing_info
					{
						if(id8==rs1.getInt(1))
						{
							id11=rs1.getInt(2);
							id12=rs1.getInt(3);
						}
					}
					
					 while(rs2.next())
					 {
						 if(id11==rs2.getInt(1))
						 {
							 	name=rs2.getString(4);						
								bikename=rs2.getString(5);
								bikeno=rs2.getString(6);
								servicing=rs2.getString(8);
								other=rs2.getString(9);
						 }
					 }
					 
					 while(rs3.next())
					 {
						 if(id12==rs3.getInt(1))
						 {
							 name1=rs3.getString(2);
						 }
					 }
				
						String x=""+id8;
						String y=""+id11;
						String z=""+id12;
						String o=""+bil;
					
				
						HttpSession session=request.getSession();
						session.setAttribute("idid",idid);
						session.setAttribute("idx",x);
						session.setAttribute("idy",y);
						session.setAttribute("idz",z);	
						session.setAttribute("name",name);
						session.setAttribute("name1",name1);
						session.setAttribute("bikename",bikename);
						session.setAttribute("bikeno",bikeno);
						session.setAttribute("servicing",servicing);
						session.setAttribute("other",other);
						session.setAttribute("b",o);
						
						
						String SEARCH_JSP = "/bill_search.jsp";
						String forward=SEARCH_JSP;
						RequestDispatcher rd=getServletContext().getRequestDispatcher(forward);
						rd.forward(request, response);
				
					
					
			}	
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			 	}
			
		
		}  //if
		
		if(a.equals("Generate Bill"))
		{
			int f=Integer.parseInt(request.getParameter("general_servicing"));
			int g=Integer.parseInt(request.getParameter("other_servicing"));
			
			int h=f+g;
			String j=""+h;
			int flag=1;
			String n=""+flag;
			/*String k=""+f;
			String l=""+g;*/
			HttpSession session=request.getSession();
			/*session.setAttribute("f",k);
			session.setAttribute("g",l);*/
			session.setAttribute("fl",n);
			session.setAttribute("bill",j);
			String SEARCH_JSP = "/bill_show.jsp";
			String forward=SEARCH_JSP;
			RequestDispatcher rd=getServletContext().getRequestDispatcher(forward);
			rd.include(request, response);
			
		}
		
	}

}
