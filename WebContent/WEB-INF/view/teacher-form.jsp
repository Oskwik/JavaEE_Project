<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>Add Teacher</title>
	
	<link 	type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css" />
	
	<link 	type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/add-teacher-style.css" />		

</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Jensen Education: Spring MVC - Hibernate +++ Spring AOP - Spring Security</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Teacher</h3>
		
		<form:form action="saveTeacher" modelAttribute="teacher" method="POST">
		
		<form:hidden path="id"/>
		
			<table>
				<tbody>
					<tr>
						<td><label>Teacher Nr:</label></td>
						<td><form:input path="nr" /></td>
					</tr>
					
					<tr>
						<td><label>First Name:</label></td>
						<td><form:input path="firstName" /></td>
					</tr>
						
					<tr>
						<td><label>Last Name:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>
					
					<tr>
						<td><label>Comment:</label></td>
						<td><form:input path="comment" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				
				</tbody>
			</table>
		</form:form>
		
		<div style="clear; both"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/teacher/list">Back to List</a>
		</p>
	
	</div>


</body>

</html>