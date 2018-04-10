<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Flash Fox</title>
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
		<p>商品列表</p>
		<form action="${pageContext.request.contextPath }/" method="POST">
			<table width="100%" border="1">
				<tr>
					<td>商品名称：<input name="productsCustom.name" value="${productsCustom.name}"></td>
					<td>
						<input type="submit" value="查询">
					</td>
				</tr>
			</table>
		</form>
		<table  width="100%" border="1">
			<tr>
				<td>商品id</td>
				<td>商品名称</td>
				<td>商品价格</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${products }" var="product">
				<tr>
					<td>${product.id }</td>
					<td>${product.name }</td>
					<td>${product.price }</td>
					<td>	
						<%-- <a href="${pageContext.request.contextPath }/editProduct/${product.id}">修改</a> --%>
						<a href="${pageContext.request.contextPath }/product/${product.id}">查看</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
</body>
</html>