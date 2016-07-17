<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:url var="url" value="/viewDevEvents"></c:url>

<div class=row>

	<div class="col-md-8 col-md-offset-2">

		<div class="pagination">

			<c:forEach var="pageNumber" begin="1" end="${page.totalPages}">

				<c:choose>
					<c:when test="${page.number != pageNumber -1}">
						<a href="${url}?p=${pageNumber}"><c:out value="${pageNumber}" /></a>
					</c:when>
					<c:otherwise>
						<strong><c:out value="${pageNumber}" /></strong>
					</c:otherwise>

				</c:choose>

				<c:if test="${pageNumber != page.totalPages }">
					|
				</c:if>

			</c:forEach>

		</div>



		<c:forEach var="devEventUpdate" items="${page.content }">
		
			<c:url var="editLink" value="/editevent?id=${devEventUpdate.id}"></c:url>
			<c:url var="deleteLink" value="/deleteevent?id=${devEventUpdate.id}"></c:url>
		
			<div class="panel panel-default">


				<div>
					<fmt:formatDate pattern="EEEE MMMM d y 'at ' H mm"
						value="${devEventUpdate.added}"></fmt:formatDate>
					${devEventUpdate.text}
				</div>
				
				<div class="edit-links pull-right">
				
					<a href="${editLink}">edit</a> | <a onclick="return confirm('really delete it?')"; href="${deleteLink}">delete</a>
				
				</div>
				
			</div>

		</c:forEach>

	</div>
</div>