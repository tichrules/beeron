<html>

<body bgcolor="white">

	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<spring:url value="/ragnar/people/delete" var="deleteUrl" />
	<form:form method="post" action="${deleteUrl}">
		<table>
			<c:forEach items="${people}" var="person">
				<tr>
					<td><a href="person/${person.id}">${person.name}</a></td>
					<td>${person.acting}/10</td>
					<td><button type="submit" name="id" value="${person.id}">Delete</button></td>
				</tr>
			</c:forEach>
		</table>
	</form:form>
	<a href="create">Create</a>
</body>
</html>
