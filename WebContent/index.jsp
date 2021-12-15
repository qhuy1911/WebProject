<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<c:if test="${account.isAdmin == 1 }">
<c:redirect url="HomeAdmin"></c:redirect>
</c:if>

<c:redirect url="HomeServlet"></c:redirect>