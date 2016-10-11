<html>

<body bgcolor="white">

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<table>
		<c:forEach items="${people}" var="person">
			<tr>
				<td>${person.name}</td>
				<td>${person.acting}/10</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
