<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recommendations</title>
<link rel="stylesheet" type="text/css" href="./css/search.css">
<link rel="icon" href="./images/favicon.png" type="image/png">
</head>
<body>
<fieldset>
		<legend id="titulo">
	Recommendation from: <c:out value="${requestScope.name}"/>
	</legend>
	<c:forEach items="${requestScope.game}" var="games">
	<div id="juego">
	<p id="name"><a id="name" href="/main?id=${games.id}"><c:out value="${games.name}"></c:out></a></p>		
	<img id="imagen" src="https:<c:out value="${games.cover.url}"></c:out>">
	<p id="sum"><c:out value="${games.summary}" ></c:out></p><br>
	</div><br>
	</c:forEach>	
</fieldset>
	<div>
		<a href="index.html"><img src="./images/logogamus.png" width=200px></a>
	</div>
	<br>
</body>
</html>