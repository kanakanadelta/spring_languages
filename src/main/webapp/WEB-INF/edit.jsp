<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit ${language.name}</title>
</head>
<body>
	<div id="form_div">
		<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
		<input type="hidden" name="_method" value="put">
			<!-- Name -->
			<p>
				<form:label path="name">name</form:label>
				<form:errors path="name"/>
				<form:input path="name"/>
			</p>
			<p>
				<form:label path="creator">creator</form:label>
				<form:errors path="creator"/>
				<form:input path="creator"/>
			</p>
			<p>
				<form:label path="currentVersion">currentVersion</form:label>
				<form:errors path="currentVersion"/>
				<form:input path="currentVersion"/>
			</p>
			<input type="submit" value="Submit"/>
		</form:form>
	</div>
</body>
</html>