<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="content-right fr">
	<c:set value="${catId}" var="item"></c:set>
	<h3>${listCat[item-1].name}</h3>
	<div class="main-content items-new">
		<ul>
			<c:choose>
				<c:when test="${not empty listNew}">
					<c:forEach items="${listNew}" var="news">
						<li class="active">
							<h2>
								<a  href="${pageContext.request.contextPath}/detail/${news.id}" title="">${news.name}</a>
							</h2>
							<div class="item">
								<p>${news.name}</p>
								<div class="clr"></div>
							</div>
						</li>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<li>
						<p>chưa có tin tức</p>
					</li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</div>
<div class="clr"></div>