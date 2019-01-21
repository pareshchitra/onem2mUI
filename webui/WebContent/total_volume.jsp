<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="swm.Test"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<sql:setDataSource var="snapshot" driver="org.sqlite.JDBC"
     url="jdbc:sqlite:C:/Users/cdot/Desktop/newdb.db"/>
 
<sql:query dataSource="${snapshot}" var="result">
SELECT ci FROM newt12  
ORDER BY id DESC  
LIMIT 1;
</sql:query>

<c:forEach var="row" items="${result.rows}">
     <c:out value="${row.ci}"/> <br>
</c:forEach>

</body>
</html>