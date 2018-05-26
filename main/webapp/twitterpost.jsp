<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Twitter's post</title>
<link rel="stylesheet" type="text/css" href="./css/post.css">
</head>
<body>
	<h1>Create your own tweet!</h1>
	<form id="formulario4" method="post" action="/post">
		<p>
			<input type="submit" value="Send" id="botonpublicartw">
		</p>
	</form>
	<textarea name="publicaciontw" form="formulario4" rows="25" cols="100">I'm interested in the game...</textarea>
</body>
</html>