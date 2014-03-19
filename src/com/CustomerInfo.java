package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
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
 * Servlet implementation class CustomerInfo
 */
public class CustomerInfo extends HttpServlet {
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
				stat.close();
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
		
		String id1=request.getParameter("customer_id");
		String name=request.getParameter("customer_name");
		String addr=request.getParameter("customer_add");
		String cell=request.getParameter("customer_cell");
		String bikecmp=request.getParameter("bike_company");
		String bikename=request.getParameter("bike_name");
		String bikeno=request.getParameter("bike_no");
		String servicing=request.getParameter("servicing");
		String other=request.getParameter("other_problem");

		
	/*if(a.equals("generate"))
	{
		
		String s="select customer_id from customer_info";
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
					int i=0;
					if(rs.last())
					{
					
					i=rs.getInt("customer_id")+1;
					
					}
					
					String j=""+i;
					HttpSession session=request.getSession();
					
					session.setAttribute("id",j);
					
					String SEARCH_JSP = "/search.jsp";
					String forward=SEARCH_JSP;
					RequestDispatcher rd=getServletContext().getRequestDispatcher(forward);
					rd.forward(request, response);
					
				
				
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
		*/
		
		String aa=null,bb=null,cc=null,dd=null,ee=null,ff=null,gg=null,hh=null,ii=null;
		int flag1=0;
		
	    name=request.getParameter("customer_name");
	                Pattern p1=Pattern.compile("[a-zA-Z]*[a-zA-Z]");
			Matcher m1=p1.matcher(name);
			boolean b1=m1.matches();
	                if(b1==false)
	                    {
	                        bb="1";
	                    }
	                else
	                {
	                flag1++;
	                }

	                cell=request.getParameter("customer_cell");
	                Pattern p2=Pattern.compile("[0-9]*[0-9]");
			Matcher m2=p2.matcher(cell);
			boolean b2=m2.matches();
	                if(b2==false)
	                    {
	                        cc="1";
	                    }
	                else
	                { 
	                	flag1++;    
	                }

	                addr=request.getParameter("customer_add");
	                Pattern p3=Pattern.compile("[a-zA-Z]*[a-zA-Z]");
			Matcher m3=p3.matcher(addr);
			boolean b3=m3.matches();
	                if(b3==false)
	                    {
	                        dd="1";
	                    }
	                else
	                {
	                flag1++;
	                }
	                
	                bikecmp=request.getParameter("bike_company");
	                Pattern p4=Pattern.compile("[a-zA-Z]*[a-zA-Z]");
			Matcher m4=p4.matcher(name);
			boolean b4=m4.matches();
	                if(b4==false)
	                    {
	                        ee="1";
	                    }
	                else
	                {
	                flag1++;
	                }
	                
	                bikename=request.getParameter("bike_name");
	                Pattern p5=Pattern.compile("[a-zA-Z]*[a-zA-Z]");
			Matcher m5=p5.matcher(bikename);
			boolean b5=m5.matches();
	                if(b5==false)
	                    {
	                        ff="1";
	                    }
	                else
	                {
	                flag1++;
	                }
		
	                	
	                servicing=request.getParameter("servicing");
	                Pattern p6=Pattern.compile("[a-zA-Z]*[a-zA-Z]");
			Matcher m6=p6.matcher(name);
			boolean b6=m6.matches();
	                if(b6==false)
	                    {
	                         gg="1";
	                    }
	                else
	                {
	                flag1++;
	                }
		
	                
	                bikeno=request.getParameter("bike_no");
	                Pattern p7=Pattern.compile("[a-zA-Z]*[a-zA-Z]");
			Matcher m7=p7.matcher(name);
			boolean b7=m7.matches();
	                if(b7==false)
	                    {
	                        hh="1";
	                    }
	                else
	                {
	                flag1++;
	                }

	                
	                
	                if(flag1!=7)
	                {
	                	HttpSession session=request.getSession();
	                	session.setAttribute("aa",aa);
	                	session.setAttribute("bb",bb);
	                	session.setAttribute("cc",cc);
	                	session.setAttribute("dd",dd);
	                	session.setAttribute("ee",ee);
	                	session.setAttribute("ff",ff);
	                	session.setAttribute("gg",gg);
	                	session.setAttribute("hh",hh);
	                	session.setAttribute("ii",ii);
	                	
	                	
	                	RequestDispatcher rd=getServletContext().getRequestDispatcher("/customer_info.jsp");
	                	rd.include(request, response);
	                	
	                	
	                	
	                }

	                
		
		if(flag1==7)
		{
		
		
	if(a.equals("add"))
	{
		
		
		try{
			
			String s="select customer_id from customer_info";
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=st.executeQuery(s);
			int id=0;
			if(rs.last()){
			id=rs.getInt("customer_id")+1;
			}
	
			
				PreparedStatement ps=con.prepareStatement("insert into customer_info values (?,?,?,?,?,?,?,?,?)");
		
				
				ps.setInt(1,id);
				ps.setString(2,name);
				ps.setString(3,addr);
				
				ps.setString(4,cell);
				ps.setString(5,bikecmp);
				ps.setString(6,bikename);
				ps.setString(7,bikeno);
				ps.setString(8,servicing);
				ps.setString(9,other);
			
				
			       
			   
				
				ps.executeUpdate();
	
				con.commit();
				con.close();
				
				//out.print("Name:: "+name);
			
		
				//out.print("<h1>Information Added Sucessfully...</h1>");
				int flag=1;
				String z=""+flag;
				HttpSession session=request.getSession();
				session.setAttribute("flag",z);
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/customer_info.jsp");
				rd.include(request, response);		
			
		}
		catch(Exception e)
		{
              out.println(e);
		}		
		
		out.close();
		
		//Closes the Connection
		closeConn();
		
		
	}	
		//out.print("Button"+a);
		//RequestDispatcher r=getServletContext().getRequestDispatcher("/Demo");
	      //r.include(request, response);
	
		} //flag
	
	else if(a.equals("search"))
	{
		int id=Integer.parseInt(request.getParameter("customer_id"));
		
		String s="select * from customer_info";
		//Statement stmt;
		try {
			stat = con.createStatement();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = stat.executeQuery(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while(rs.next())
			{
				if(rs.getInt(1)==id)
				{
					id=rs.getInt(1);
					name=rs.getString(2);
					addr=rs.getString(3);
					cell=rs.getString(4);
					bikecmp=rs.getString(5);
					bikename=rs.getString(6);
					bikeno=rs.getString(7);
					servicing=rs.getString(8);
					other=rs.getString(9);
					HttpSession session=request.getSession();
					session.setAttribute("id",id1);
					session.setAttribute("name",name);
					session.setAttribute("addr",addr);
					session.setAttribute("cell",cell);
					session.setAttribute("bikecmp",bikecmp);
					session.setAttribute("bikename",bikename);
					session.setAttribute("bikeno",bikeno);
					session.setAttribute("servicing",servicing);
					session.setAttribute("other",other);
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
		
		try {
			//stat.close();
			closeConn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}
	
		
	}

}
