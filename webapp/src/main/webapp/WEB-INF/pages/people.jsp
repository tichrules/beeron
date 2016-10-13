<html>

<body bgcolor="white">

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<table>
		<c:forEach items="${people}" var="person">
			<tr>
				<td><a href="person/${person.name}">${person.name}</a></td>
				<td>${person.acting}/10</td>
			</tr>
		</c:forEach>
	</table>
	<a href="create">Create</a>
</body>
</html>
