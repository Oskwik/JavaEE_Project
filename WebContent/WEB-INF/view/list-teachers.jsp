<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Teachers</title>
	
	<link 	type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Jensen Education: Spring MVC - Hibernate +++ Spring AOP - Spring Security</h2>
		</div>
		
		<div id="container">
		
		<br></br>
		<!-- Logout button -->
		<form:form action="${pageContext.request.contextPath}/logout" 
				   method="POST">
		
			<input type="submit" value="Logout" class="add-teacher-button" />
		
		</form:form>
		
		
		
			<div id="content">
			
			<p>
				User: <security:authentication property="principal.username" />, Role(s): <security:authentication property="principal.authorities" />
			</p>
		

			<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
			
				<input type="button" value="Add teacher"
						onclick="window.location.href='showFormForAdd'; return false;" 
						class="add-teacher-button"	/>
			</security:authorize>
						
				<form:form action="search" method="POST">
                Search Teacher: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-teacher-button" />
                
            <br>
                
            </form:form>		
			
				<table>
				
					<tr>
						<th>Teacher Nr:</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Comment</th>
						<th>Action</th>
					</tr>
					
					<c:forEach var="tmp" items="${teachers}">
					
					<c:url var="updateLink" value="/teacher/showFormForUpdate">
						<c:param name="teacherId" value="${tmp.id}" />
					</c:url>
					
					<c:url var="deleteLink" value="/teacher/delete">
						<c:param name="teacherId" value="${tmp.id}" />
					</c:url>	
					
						<tr>
							<td> ${tmp.nr}</td>
							<td> ${tmp.firstName}</td>
							<td> ${tmp.lastName}</td>
							<td> ${tmp.comment}</td>
							<td>
								<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
									<a href="${updateLink}">Update</a>
								</security:authorize>
								
								<security:authorize access="hasAnyRole('ADMIN')">|
									<a href="${deleteLink}"
									onclick="if (!(confirm('Are you want to delete ?'))) return false">Delete</a>
								</security:authorize>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

	

</body>

</html>