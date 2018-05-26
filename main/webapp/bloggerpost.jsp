<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Blogger's post</title>
<link rel="stylesheet" type="text/css" href="./css/post.css">
</head>
<body>
	<h1>Create your own blog's post!</h1>
	<form id="formulario3" method="post" action="BloggerController">
		<p>
			<input type="submit" value="Send" id="botonpublicar">
		</p>
	</form>
	<textarea name="publicacion" form="formulario3" rows="25" cols="100">I'm interested in the game...</textarea>
</body>
</html>