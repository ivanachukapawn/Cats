<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	
	
	
	
	
	

<div class=row>

	<div class="col-md-8 col-md-offset-2">

		<div class="panel panel-default">

			<div class="panel-heading">

				<div class="panel-title">
					add development event description
				</div>
				
			</div>

			<div class="panel-body">
			
				<form:form modelAttribute="devEventUpdate">
					<div class="form-group">
						<form:textarea path="text" name="text" rows="10" cols="50"></form:textarea>
					</div>
				
					<input type="submit" name="submit" value="add dev event" />
				
				</form:form>	
			</div>

		</div>
		
		<div class="panel panel-default">

			<div class="panel-body">
			
				
				<fmt:formatDate pattern="EEEE MMMM d y 'at ' H mm" value="${latestAdded}"></fmt:formatDate>
				<c:out value="${latestText}"></c:out>
				
			</div>

		</div>

	</div>
</div>