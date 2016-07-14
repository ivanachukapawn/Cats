<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class=row>

	<div class="col-md-8 col-md-offset-2">

		<c:forEach var="devEventUpdate" items="${page.content }">


			<div class="panel panel-default">

				
				<fmt:formatDate pattern="EEEE MMMM d y 'at ' H mm" value="${devEventUpdate.added}"></fmt:formatDate>
				<strong><c:out value="${devEventUpdate.text}"></c:out></strong>

			</div>






		</c:forEach>

	</div>
</div>