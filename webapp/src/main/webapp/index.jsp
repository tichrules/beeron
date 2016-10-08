<html>

<body bgcolor="white">

	<%@ page import="beeron.ragnar.common.Person"%>
	<jsp:useBean id="ragnar" class="beeron.ragnar.server.jsp.RagnarBean" />
	<table>
		<%
			for (Person person : ragnar.getPeople()) {
		%>
		<tr>
			<td><%=person.getName()%></td>
			<td><%=person.getActing()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>
