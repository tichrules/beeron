<html>
<body bgcolor="white">
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<spring:url value="/users" var="actionUrl" />
	<form:form method="post" modelAttribute="personForm"
		action="${actionUrl}">
		<p>
			Name:
			<form:input type="text" path="name" />
		</p>
		<p>
			Acting:
			<form:input type="number" path="acting" />
		</p>
		<p>
			<input type="submit" value="Submit" /> <input type="reset"
				value="Reset" />
		</p>
	</form:form>
</body>
</html>
