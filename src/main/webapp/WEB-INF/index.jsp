<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    

<!DOCTYPE html>
<html>
<head>
	<style>
		* {
			
		}
	</style>
<meta charset="UTF-8">
<title>Languages</title>
</head>
<body>

	<!-- INDEX OF BOOKS -->
	<div id="table_div">
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${languages}" var="language">
					<tr>
						<td>
							<a href="/lanugages/${language.id}">
								<c:out value="${language.name}"/>
							</a>
						</td>
						<td>
							<c:out value="${language.name}"/>
						</td>
						<td>
							<c:out value="${language.name}"/>
						</td>
						<td>
							<form action="/languages/${language.id}" method="post">
							    <input type="hidden" name="_method" value="delete">
		    					<input type="submit" value="Delete">
							</form>
							<a href="/languages/${language.id}/edit">edit</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<!-- FORM FOR NEW -->
	<div id="form_div">
		<form:form action="/languages" method="post" modelAttribute="language">
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