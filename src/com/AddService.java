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
 * Servlet implementation class AddService
 */
public class AddService extends HttpServlet {
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
		//int id1=Integer.parseInt(request.getParameter("servicing_id"));
		
		
		int id=0;
		
		
		if(a.equals("add"))
		{
			int id2=Integer.parseInt(request.getParameter("customer_id"));
			
			int id3=Integer.parseInt(request.getParameter("worker_id"));
		try{
			
			String s="select servicing_id from servicing_info";
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=st.executeQuery(s);
			
			if(rs.last()){
			id=rs.getInt("servicing_id")+1;
			}
				
				PreparedStatement ps=con.prepareStatement("insert into servicing_info values (?,?,?)");
		
				
				ps.setInt(1,id);
				ps.setInt(2,id2);
				ps.setInt(3,id3);
				
							
				ps.executeUpdate();
	
				con.commit();
				con.close();
				
				//out.print("Name:: "+name);
		
			
		}
		catch(Exception e)
		{
              out.println(e);
		}		
		
		//out.print("<br><br><br><br><br><br><br><br>Information Added Sucessfully...");
		int flag=1;
		String z=""+flag;
		String m=""+id;
		HttpSession session=request.getSession();
		session.setAttribute("flag",z);
		session.setAttribute("id",m);
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/show.jsp");
		rd.include(request, response);
		
		out.close();
		
		//Closes the Connection
		closeConn();
		
		
		
		
		}  //if stmt
		
		
		String aa=null,bb=null,cc=null,dd=null,ee=null,ff=null,gg=null,hh=null,ii=null;
		int flag1=0;
		
	    

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
			String id1=request.getParameter("customer_id");
			String name=request.getParameter("customer_name");
			String addr=request.getParameter("customer_add");
			String bikecmp=request.getParameter("bike_company");
			String bikename=request.getParameter("bike_name");
			String bikeno=request.getParameter("bike_no");
			
			String id4=request.getParameter("worker_id");
			String name1=request.getParameter("worker_name");
			String servicing=request.getParameter("servicing");
			String other=request.getParameter("other_problem");
			
			int id14=Integer.parseInt(request.getParameter("customer_id"));
			int id15=Integer.parseInt(request.getParameter("worker_id"));
			
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
					if(id14==rs.getInt(1))
					{
						id14=rs.getInt(1);
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
					if(id15==rs1.getInt(1))
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
			session.setAttribute("id3",id4);
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
		
		
		  }    //flag
		
		
		
		
 		
		
		
		/*else if(a.equals("search"))
		{
			String s="select * from customer_info";
			Statement stmt = null;
			try {
				stmt = con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ResultSet rs = null;
			try {
				rs = stmt.executeQuery(s);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				while(rs.next())
				{
					if(rs.getInt(1)==id1)
					{
						//id1=rs.getInt(1);
						//id2=rs.getInt(2);
						name=rs.getString(3);
						addr=rs.getString(4);
						bikecmp=rs.getString(5);
						bikename=rs.getString(6);
						bikeno=rs.getString(7);
						//id3=rs.setInt(8);
						name1=rs.getString(9);
							
						HttpSession session=request.getSession();
						session.setAttribute("id1",id1);
						session.setAttribute("id2",id2);
						session.setAttribute("name",name);
						session.setAttribute("addr",addr);
						session.setAttribute("bikecmp",bikecmp);
						session.setAttribute("bikename",bikename);
						session.setAttribute("bikeno",bikeno);
						session.setAttribute("i3",id3);
						session.setAttribute("name1",name1);
						String SEARCH_JSP = "/search.jsp";
						String forward=SEARCH_JSP;
						RequestDispatcher rd=getServletContext().getRequestDispatcher(forward);
						rd.forward(request, response);
						
					}
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				
		}
		*/
		
		
	  }			
	}


