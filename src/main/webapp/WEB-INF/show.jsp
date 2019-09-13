<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${language.name}</title>
</head>
<body>
	<h1>${language.name}</h1>
	<h2>${language.creator}</h2>
	<h2>${language.currentVersion}</h2>
	<form action="/languages/${language.id}" method="post">
	    <input type="hidden" name="_method" value="delete">
		<input type="submit" value="Delete">
	</form>
	<a href="/languages/${language.id}/edit">edit</a>
</body>
</html>