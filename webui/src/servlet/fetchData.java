package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import swm.Data;
import swm.Database;

/**
 * Servlet implementation class fetchData
 */
@WebServlet("/fetchData")
public class fetchData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fetchData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			/*
			 * json array of time, value
			 */
			JSONObject json = new JSONObject();
			String query = "Select ci,time from newt1 ORDER BY id DESC LIMIT 1";
			
			Connection conn = Database.getConnection();
			Statement stm = conn.createStatement();
			ResultSet rst = stm.executeQuery(query);
			
			while(rst.next()){
				Data d = new Data();
				json.accumulate("time",rst.getString("time"));
				json.accumulate("value",rst.getString("ci"));
			}
			
			response.getWriter().write(json.toString());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}


