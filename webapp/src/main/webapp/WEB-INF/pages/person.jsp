<html>
<body bgcolor="white">
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<table>
		<tr>
			<td>Name</td>
			<td>${person.name}</td>
		</tr>
		<tr>
			<td>Acting</td>
			<td>${person.acting}/10</td>
		</tr>
		<tr>
			<td>Been to</td>
			<td>
				<ul>
					<c:forEach items="${locations}" var="location">
						<li>${location.name}</li>
					</c:forEach>
				</ul>
			</td>
		</tr>
	</table>
</body>
</html>
