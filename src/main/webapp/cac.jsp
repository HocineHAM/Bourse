<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.List, java.util.Date, java.util.ArrayList, java.util.Iterator,  java.util.ListIterator "%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:forEach items="${nom}" var="jk">
		Item <c:out value="${jk}" />
		<br>
	</c:forEach>

	<%-- <%! ArrayList<String> maliste;  %>

<% 
maliste = (ArrayList<String>)request.getAttribute("nom");
%>


<!-- comment mettre le tableau aller a la ligne; pck dans lexemple dvanat ca imprime la to string de la super super class -->
<% 
Iterator<String> it = maliste.iterator();
while (it.hasNext()){ %>
	<br>
<%=it.next()%>
<%
}

%> --%>
</body>
</html>