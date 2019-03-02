<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
 
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<html>

<meta http-equiv='content-type' content="text/html; charset=ISO-8859-1")>
<center>
<br/></br>
<head>
<title> Portefeuille</title>
</head>
<body bgcolor=#FFEFE5>
<label style=font-size:40px; font-family:arial>

<B><label style=font-size:40px font-family:arial> Portefeuille d'action</label> </B><br><br>
<br/></br>

<label style=font-size:35px font-family:arial>

<c:forEach items="${theportefeuille }" var="v">
    ${v }
</c:forEach>

<%-- <% ArrayList portefeuille = (ArrayList) request.getAttribute("theportefeuille");%>

<%= portefeuille %> --%>
 
          
</label> 
</body>
</center>

</html>
</html>