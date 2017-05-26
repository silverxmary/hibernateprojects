<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.error {
	color: #ff0000;
}

</style>


</head>
<body>


   <script>
     function formSubmit() {
         document.getElementById("logoutForm").submit();
     }
   </script>

    <c:url value="/logout" var="logoutUrl" />

    <form action="${logoutUrl}" method="post" id="logoutForm">
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />
    </form>

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>
            Usuario : ${pageContext.request.userPrincipal.name} | <a
                href="javascript:formSubmit()"> Logout</a>
        </h2>
    </c:if>



   <hr/>

	<form:form method="post"  action="agregarArticulo" commandName="articulo">

		<table>
			<tr>
				<td><form:label path="nombre">nombre</form:label></td>
				<td><form:input path="nombre" /></td>
				<td><form:errors path="nombre" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="presentacion">presentacion</form:label></td>
				<td><form:input path="presentacion" /></td>
				<td><form:errors path="presentacion" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="precio">precio</form:label></td>
				<td><form:input path="precio" /></td>
				<td><form:errors path="precio" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="cantidad">cantidad</form:label></td>
				<td><form:input path="cantidad" /></td>
				<td><form:errors path="cantidad" cssClass="error" /></td>
			</tr>
            <!--
			<sec:authorize access="hasAnyRole('ROLE_ADMIN' , 'ROLE_USER')">
				<tr>
					<td colspan="2"><input type="submit" value="agregar articulos" /></td>
				</tr>
			</sec:authorize>
               -->
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <tr>
                    <td colspan="2"><input type="submit" value="agregar articulos" /></td>
                </tr>
            </sec:authorize>

		</table>

	</form:form>
	    
	    <table border="1">
	    	<tr>
	           <td>nombre</td>
	           <td>presentacion</td>
	           <td>precio</td> 	
	           <td>cantidad</td> 
	    	</tr>
		   <c:forEach items="${articulos}" var="articulo">
		         <tr>
			        <td><c:out value="${articulo.nombre}"/></td>
			        <td><c:out value="${articulo.presentacion}"/></td>
			        <td><c:out value="${articulo.precio}"/></td>
			        <td><c:out value="${articulo.cantidad}"/></td>
			     </tr>    
			</c:forEach>
        </table>
</body>
</html>