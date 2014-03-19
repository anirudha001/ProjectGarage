package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Modify
 */
public class Modify extends HttpServlet {
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
		PrintWriter out=response.getWriter();
		String a=request.getParameter("details");
		
		
		if(a.equals("modify"))
		{
		
		try {
			setConn();
		} catch (ClassNotFoundException | SQLException e1) {
	
			e1.printStackTrace();
		}

		
		int id=Integer.parseInt(request.getParameter("customer_id"));
		String name=request.getParameter("customer_name");
		String addr=request.getParameter("customer_add");
		String cell=request.getParameter("customer_cell");
		String bikecmp=request.getParameter("bike_company");
		String bikename=request.getParameter("bike_name");
		String bikeno=request.getParameter("bike_no");
		String servicing=request.getParameter("servicing");
		String other=request.getParameter("other_problem");
		
		try {
			PreparedStatement ps=con.prepareStatement("update customer_info set customer_name=?,customer_add=?,customer_cell=?,bike_company=?,bike_name=?,bike_no=?,servicing=?,other_problem=? where customer_id=?");
			
			
			ps.setString(1,name);
			ps.setString(2,addr);
			
			ps.setString(3,cell);
			ps.setString(4,bikecmp);
			ps.setString(5,bikename);
			ps.setString(6,bikeno);
			ps.setString(7,servicing);
			ps.setString(8,other);
			ps.setInt(9,id);
			

			ps.executeUpdate();

			con.commit();
			con.close();
			
	
			out.print("<h1>Information Updated Sucessfully...</h1>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}    //if stmt
		
		if(a.equals("delete"))
		{
			out.print("Information Deleted Successfully...");
		}
	}

}
