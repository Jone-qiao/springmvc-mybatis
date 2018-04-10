<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Flash Fox -- ${product.name }</title>
</head>
<body>
	<div>
		<c:if test="${idUser != null }">
			<p>${name}</p>
			<p>
				<a href="${pageContext.request.contextPath}/logout">退出</a>
			</p>
		</c:if>
		<c:if test="${idUser == null }">
			<p>
				<a href="${pageContext.request.contextPath}/login">登录</a>
			</p>
		</c:if>
	</div>
	<div>
		<p>${product.id }</p>
		<p>${product.name }</p>
		<p>${product.price }</p>
	</div>
</body>
</html>