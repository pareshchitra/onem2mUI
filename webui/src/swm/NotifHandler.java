package swm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import RequestResponseFunctions.HTTPToOneM2MConverter;
import m2mConstants.M2MRESOURCETYPE;
import m2mConstants.M2MRESPONSESTATUSCODEHTTP;
import swm.Database;
import tojo.ContentInstance;
import tojo.RequestPrimitive;
import tojo.Resource;
import tojo.ResponsePrimitive;

/**
 * Servlet implementation class NotifHandler
 */
@WebServlet("/NotifHandler")

public class NotifHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at 192.168.108.164:8080").append(request.getContextPath());
		System.out.println("Notification Received");
		String[] responseCI = new String[2];
		RequestPrimitive requestPrimitive = null;
		HTTPToOneM2MConverter converter = new HTTPToOneM2MConverter();
		
		try {
			requestPrimitive = converter.httpTooneM2MRequest(request);
		} catch (Exception var9) {
			var9.printStackTrace();
			
		}

		Resource resource = (Resource) requestPrimitive.getPrimitiveContent().getAny();
		if (resource.getResourceType().intValue() == M2MRESOURCETYPE.CONTENTINSTANCE.getvalue().intValue()) {
			ContentInstance contentInstance = (ContentInstance) resource;
			System.out.println("content in ContentInstance Resource = " + contentInstance.getContent());
			Connection con = Database.getConnection();
			/*
			String sql = "CREATE TABLE IF NOT EXISTS newt1 (ci text)";
			try{
			Statement st = con.createStatement();
			st.execute(sql);
			
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}*/
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date date = new Date();  
		    String str = formatter.format(date).toString();
			
			String s = "INSERT INTO newt1(ci,time) VALUES(?,?)";
			try(
				PreparedStatement ps = con.prepareStatement(s)){
				ps.setString(1,(String)contentInstance.getContent());
				ps.setString(2,str);
				ps.executeUpdate();
				
			}catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		

		ResponsePrimitive responsePrimitive = new ResponsePrimitive();
		responsePrimitive.setResponseStatusCode(M2MRESPONSESTATUSCODEHTTP.OK.getvalue());
		responsePrimitive.setRequestIdentifier(requestPrimitive.getRequestIdentifier());
		converter.oneM2MTohttpResponse(response, responsePrimitive);
		String parentResourceID = "";
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	
}
