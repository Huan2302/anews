<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="content-right fr">
	<c:if test="${not empty news}">
		<h3>${news.name}</h3>
		<div class="main-content">
			<p>Ngày đăng:${news.createDate}</p>
			<h4 style="color: #222">${news.sortdescriptor}</4>
			<p>${news.title}</p>
			<c:forEach items="${listImgByNewId}" var="image">
				<img src="${contextPath}/img/${image.name}" height="200px;" alt="">
			</c:forEach>
		</div>
	</c:if>
</div>
<div class="clr"></div>