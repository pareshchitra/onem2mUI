<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*,javax.swing.JOptionPane,java.util.concurrent.TimeUnit" %>
<%@ page import="swm.Test"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<sql:setDataSource var="snapshot" driver="org.sqlite.JDBC"
     url="jdbc:sqlite:C:/Users/cdot/Desktop/newdb2.db"/>

<sql:query dataSource="${snapshot}" var="result">
SELECT ci FROM newt2  
ORDER BY id DESC  
LIMIT 1;
</sql:query>


<c:forEach var="row" items="${result.rows}">
     <c:out value="${row.ci}"/>
     <c:set var="height" value="${row.ci}"/> 
     <br>
</c:forEach>
 
 
<%
String str =(String)pageContext.getAttribute("height");
float a  = Float.parseFloat(str);

if( a >= 30.0)
{
	TimeUnit.SECONDS.sleep(5);
	request.setAttribute("motor", "N");
}
else if(a <= 5.0)
{
	TimeUnit.SECONDS.sleep(5);
	request.setAttribute("motor", "Y");
}
%>

<script>
var explode = function(){
	  alert("Turn Motor OFF!");
	};


</script>




<c:if test = "${motor == 'Y'}">
         <script> setTimeout(explode, 2000);</script> 
</c:if> 

<c:if test = "${motor == 'N'}">
         <script> setTimeout(explode, 2000);</script>
</c:if> 


     


</body>
</html>