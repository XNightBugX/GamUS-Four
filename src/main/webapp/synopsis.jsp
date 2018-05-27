<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Synopsis</title>
<link rel="stylesheet" type="text/css" href="./css/main.css">
<link rel="icon" href="./images/favicon.png" type="image/png">
	<style>
@media only screen and (max-width: 800px) {
    .column {
	float: left;
	width: 100%;
		}
	}
</style>
</head>
<body>
<div class="column" id="left">
	<div id="image">
	<img src="https:<c:out value="${sessionScope.img}" ></c:out>">
	</div>
	<br>
	<div id="stats">
	<ul id="table_stats">
		<li id="li_s"><b>Title</b>: <c:out value="${sessionScope.name}"/></li>
		<li id="li_s"><b>Genre</b>: <c:out value="${sessionScope.genres}"/></li>
		<li id="li_s"><b>Pegi</b>: <c:out value="${sessionScope.pegi}"/></li>
		<li id="li_s"><b>Platform</b>: <c:out value="${sessionScope.platform}"/></li>
		<li id="li_s"><b>Valoration</b>: <c:out value="${sessionScope.rating}"/></li>
	</ul>
	</div>
	<br>
	<div id="logo">
		<a href="index.html"><img src="./images/logogamus.png" width=250px></a>
	</div> 
</div>
<div class="column" id="center">
	<p id="title_synopsis">Synopsis from <c:out value="${sessionScope.name}"/></p>
	<p id="synopsis"><c:out value ="${sessionScope.synopsis}"/></p><br><br>
	<img src="./images/daraen.png" />
	</div>
	<div class="column" id="right">
<div id="links">  
	<table id="table_links">
		<tr>
			<td id="link_line"><a id="link_n" href="/main?id=${sessionScope.id}&name=${sessionScope.name}">Shop &nbsp;<span id="link_s">l</span></a></td>
		</tr>
		<tr>
			<td id="link_line"><a id="link_n" href="/trailer?id=${sessionScope.id}&name=${sessionScope.name}">Trailer &nbsp;<span id="link_s">n</span></a></td>
		</tr>
		<tr>
			<td id="link_line"><a id="link_n" href="/synopsis?id=${sessionScope.id}&name=${sessionScope.name}">Synopsis &nbsp;<span id="link_s">m</span></a></td>
		</tr>
		<tr>
			<td id="link_line"><a id="link_n"href="/recommendations?name=${sessionScope.name}&recomm=${sessionScope.recomm}">Recommendations</a></td>
		</tr>
	</table>
	<br>
</div>
	<br>
	<div id="post">
	<img src="./images/moogle.png"><br><br>
	<a href="/BloggerController"> <img src="./images/blogger.png"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="/SigninServlet"> <img src="./images/twitter.png"></a>
	</div>
	<br>
</div>
</body>
</html>