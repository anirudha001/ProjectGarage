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
 * Servlet implementation class WorkerInfo
 */
public class WorkerInfo extends HttpServlet {
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
		String id1=request.getParameter("worker_id");
		String name=request.getParameter("worker_name");
		String addr=request.getParameter("worker_address");
		String no=request.getParameter("worker_mob");
		
	
		String aa=null,bb=null,cc=null,dd=null,ee=null,ff=null,gg=null,hh=null,ii=null;
		int flag1=0;
		
		if(a.equals("add"))
		{
	    name=request.getParameter("worker_name");
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

	                no=request.getParameter("worker_mob");
	                Pattern p2=Pattern.compile("[0-9]*[0-9]");
			Matcher m2=p2.matcher(no);
			boolean b2=m2.matches();
	                if(b2==false)
	                    {
	                        cc="1";
	                    }
	                else
	                { 
	                	flag1++;    
	                }

	                addr=request.getParameter("worker_address");
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
	                
	               
	                
	                
	                if(flag1!=3)
	                {
	                	HttpSession session=request.getSession();
	                	
	                	session.setAttribute("bb",bb);
	                	session.setAttribute("cc",cc);
	                	session.setAttribute("dd",dd);
	                	
	                	
	                	
	                	RequestDispatcher rd=getServletContext().getRequestDispatcher("/Worker_info.jsp");
	                	rd.include(request, response);
	                	
	                	
	                	
	                }

	                
		
		if(flag1==3)
		{
		
		
		
		
		
		
		
	if(a.equals("add"))
	{
		
	
		try{
			
			String s="select worker_id from worker_info";
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=st.executeQuery(s);
			int id=0;
			if(rs.last()){
			id=rs.getInt("worker_id")+1;
			}
			
		
				
				PreparedStatement ps=con.prepareStatement("insert into worker_info values (?,?,?,?)");
		
				
				ps.setInt(1,id);
				ps.setString(2,name);
				ps.setString(3,addr);
				ps.setString(4,no);
				
				ps.executeUpdate();
	
				con.commit();
				con.close();
				
				//out.print("Name:: "+name);
			
		
				//out.print("<br><br><br><br><br><br><br><br><br><br>Information Added Sucessfully...");
				int flag=1;
				String z=""+flag;
				HttpSession session=request.getSession();
				session.setAttribute("flag",z);
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/Worker_info.jsp");
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
	
	
	
		}// flag
		
		  }   //add if
		

	
			int flag2=0;
		
	    

	                id1=request.getParameter("worker_id");
	                Pattern p4=Pattern.compile("[0-9]*[0-9]");
			Matcher m4=p4.matcher(id1);
			boolean b4=m4.matches();
	                if(b4==false)
	                    {
	                        ii="1";
	                    }
	                else
	                { 
	                	flag2++;    
	                }	
		
	
   
	                
	                if(flag2!=1)
	                {
	                	HttpSession session=request.getSession();
	                	
	                	session.setAttribute("ii",ii);
	                	
	                	
	                	RequestDispatcher rd=getServletContext().getRequestDispatcher("/Worker_info.jsp");
	                	rd.include(request, response);
	                	
	                	
	                	
	                }

	                
		
		if(flag2==1)
		{
		     
	                
	                
	 if(a.equals("search"))
	{
		int id=Integer.parseInt(request.getParameter("worker_id"));
		
		String s="select * from worker_info";
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
				if(rs.getInt(1)==id)
				{
					id=rs.getInt(1);
					name=rs.getString(2);
					addr=rs.getString(3);
					no=rs.getString(4);
				
					
					HttpSession session=request.getSession();
					session.setAttribute("id",id1);
					session.setAttribute("name",name);
					session.setAttribute("addr",addr);
					session.setAttribute("no",no);
					
					String SEARCH_JSP = "/worker_search.jsp";
					String forward=SEARCH_JSP;
					RequestDispatcher rd=getServletContext().getRequestDispatcher(forward);
					rd.forward(request, response);
					
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}  //if
	 
	}   //flag
	
	}

}
