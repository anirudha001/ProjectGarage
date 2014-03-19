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

/**
 * Servlet implementation class ServicingInfo
 */
public class ServicingInfo extends HttpServlet {
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
		
		//String id4=request.getParameter("customer_id");
		
		String id1=request.getParameter("customer_id");
		String name=request.getParameter("customer_name");
		String addr=request.getParameter("customer_add");
		String bikecmp=request.getParameter("bike_company");
		String bikename=request.getParameter("bike_name");
		String bikeno=request.getParameter("bike_no");
		
		String id3=request.getParameter("worker_id");
		String name1=request.getParameter("worker_name");
		String servicing=request.getParameter("servicing");
		String other=request.getParameter("other_problem");
		
		
		String aa=null,bb=null,cc=null,dd=null,ee=null,ff=null,gg=null,hh=null,ii=null;
		int flag1=0;
		
		if(a.equals("show"))
		{

	    

	                String idd=request.getParameter("customer_id");
	                Pattern p2=Pattern.compile("[0-9]*[0-9]");
			Matcher m2=p2.matcher(idd);
			boolean b2=m2.matches();
	                if(b2==false)
	                    {
	                        bb="1";
	                    }
	                else
	                { 
	                	flag1++;    
	                }

	                String idd1=request.getParameter("worker_id");
	                Pattern p3=Pattern.compile("[0-9]*[0-9]");
			Matcher m3=p3.matcher(idd1);
			boolean b3=m3.matches();
	                if(b3==false)
	                    {
	                        cc="1";
	                    }
	                else
	                { 
	                	flag1++;    
	                }
	                
	                
	                
	                if(flag1!=2)
	                {
	                	HttpSession session=request.getSession();
	                	
	                	session.setAttribute("bb",bb);
	                	session.setAttribute("cc",cc);
	                	
	                	
	                	RequestDispatcher rd=getServletContext().getRequestDispatcher("/Servicing_info.jsp");
	                	rd.include(request, response);
	                	
	                	
	                	
	                }

	                
		
		if(flag1==2)
		{
		
		
		
	
	if(a.equals("show"))
	{
		int id=Integer.parseInt(request.getParameter("customer_id"));
		int id2=Integer.parseInt(request.getParameter("worker_id"));
		
		String s="select * from customer_info";
		String s1="select * from worker_info";
		Statement stmt = null;
		Statement stmt1=null;
		try {
			stmt = con.createStatement();
			stmt1=con.createStatement();
		} catch (SQLException e) {
			out.print("In con.createstatement....");
			e.printStackTrace();
		}
		ResultSet rs = null;
		ResultSet rs1=null;
		try {
			rs = stmt.executeQuery(s);
			rs1=stmt1.executeQuery(s1);
		} catch (SQLException e) {
			out.print("In execute query....");
			e.printStackTrace();
		}
		
		try {
			while(rs.next())
			{
				if(id==rs.getInt(1))
				{
					id=rs.getInt(1);
					name=rs.getString(2);
					addr=rs.getString(3);
					bikecmp=rs.getString(5);
					bikename=rs.getString(6);
					bikeno=rs.getString(7);
					servicing=rs.getString(8);
					other=rs.getString(9);
				}
			}
			
			while(rs1.next())
			{
				if(id2==rs1.getInt(1))
				{
					//id2=rs1.getInt(1);
					name1=rs1.getString(2);
					
				}
			}
			
			
		} catch (SQLException e) {
			out.print("In rs.next......");
			e.printStackTrace();
		}
		
		HttpSession session=request.getSession();
		
		session.setAttribute("id1",id1);
		session.setAttribute("name",name);
		session.setAttribute("addr",addr);
		session.setAttribute("id3",id3);
		session.setAttribute("name1",name1);
		
		session.setAttribute("bikecmp",bikecmp);
		session.setAttribute("bikename",bikename);
		session.setAttribute("bikeno",bikeno);
		session.setAttribute("servicing",servicing);
		session.setAttribute("other",other);
		String SEARCH_JSP = "/show.jsp";
		String forward=SEARCH_JSP;
		RequestDispatcher rd=getServletContext().getRequestDispatcher(forward);
		rd.include(request, response);
		
		
		
	}
	
		}   // flag
		
		
		}  //if show 1st
		
	/*if(a.equals("add"))
	{
		
	
		try{
			
		
				
				PreparedStatement ps=con.prepareStatement("insert into worker_info values (?,?,?)");
		
				
				ps.setInt(1,id);
				ps.setString(2,name);
				ps.setString(3,addr);
				
				ps.executeUpdate();
	
				con.commit();
				con.close();
				
				//out.print("Name:: "+name);
			
		
				out.print("<h1>Information Added Sucessfully...</h1>");
				
		
			
		}
		catch(Exception e)
		{
             //  out.println(e);
		}		
		
		//out.close();
		
		//Closes the Connection
		closeConn();
		
		
	}	
		//out.print("Button"+a);
		//RequestDispatcher r=getServletContext().getRequestDispatcher("/Demo");
	      //r.include(request, response);
	*/
	
	if(a.equals("search"))
	{
		int id5=Integer.parseInt(request.getParameter("servicing_id"));
		int id9=0,id10=0;
		 
		
		String s="select * from servicing_info";
		String s1="select * from customer_info";
		String s2="select *from worker_info";
		Statement stmt = null;
		Statement stmt3=null;
		Statement stmt4=null;
		try {
			stmt = con.createStatement();
			stmt3=con.createStatement();
			stmt4=con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		try {
			rs = stmt.executeQuery(s);
			rs1 = stmt3.executeQuery(s1);
			rs2 = stmt4.executeQuery(s2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			while(rs.next())
			{
				if(rs.getInt(1)==id5)
				{
					id9=rs.getInt(2);
					id10=rs.getInt(3);
				}
				
			}
			
			while(rs1.next())
			{
				if(rs1.getInt(1)==id9)
				{
					id9=rs1.getInt(1);
					name=rs1.getString(2);
					addr=rs1.getString(3);
					bikecmp=rs1.getString(5);
					bikename=rs1.getString(6);
					bikeno=rs1.getString(7);
					servicing=rs1.getString(8);
					other=rs1.getString(9);
					
				}
			}
			
			while(rs2.next())
			{
				if(id10==rs2.getInt(1))
				{
					//id2=rs1.getInt(1);
					name1=rs2.getString(2);
					
				}
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		String x=""+id9;
		String y=""+id10;
		String z=""+id5;
		
		HttpSession session=request.getSession();
		session.setAttribute("id4",z);
		session.setAttribute("id1",x);
		session.setAttribute("name",name);
		session.setAttribute("addr",addr);
		session.setAttribute("id3",y);
		session.setAttribute("name1",name1);
		
		session.setAttribute("bikecmp",bikecmp);
		session.setAttribute("bikename",bikename);
		session.setAttribute("bikeno",bikeno);
		session.setAttribute("servicing",servicing);
		session.setAttribute("other",other);
		
		
		String SEARCH_JSP = "/search_service.jsp";
		String forward=SEARCH_JSP;
		RequestDispatcher rd=getServletContext().getRequestDispatcher(forward);
		rd.include(request, response);
		
		
			
	}	//if stmt
		
		
	}

}
