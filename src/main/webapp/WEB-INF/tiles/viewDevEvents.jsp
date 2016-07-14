<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class=row>

	<div class="col-md-8 col-md-offset-2">

		<c:forEach var="devEventUpdate" items="${page.content }">


			<div class="panel panel-default">

				<div class="panel-body">

					<c:out value="${devEventUpdate.text}"></c:out>

				</div>

			</div>






		</c:forEach>

	</div>
</div>