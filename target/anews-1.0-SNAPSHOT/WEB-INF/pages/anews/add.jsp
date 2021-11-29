<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<style>
	.error {
		color: red
	}
</style>
<div class="content-right fr">
	<h3>Thêm tin</h3>
	<div class="main-content">
		<s:form method="POST" modelAttribute="new" action="${pageContext.request.contextPath}/new/add" enctype="multipart/form-data">
<%--			<s:hidden path="id" />--%>
			Tên tin:<s:input path="name"  />
			<br><s:errors path="name" cssClass="error" /><br />
			Mô tả: <s:textarea path="sortdescriptor" />
			<br><s:errors path="sortdescriptor" cssClass="error" /><br />
			Nội dung: <s:textarea path="title"/>
			<br><s:errors path="sortdescriptor" cssClass="error" /><br />
			Hình ảnh: <input type="file" name="file" value="" multiple="multiple" /><br /><br />
			Thể loại:
			<s:select path="cat.id" >
				<c:forEach items="${listCat}" var="cat">
					<s:option value="${cat.id}">${cat.name}</s:option>
				</c:forEach>
			</s:select>
			<br><br>
			<input type="submit" name="submit" value="Thêm tin" /><br /><br />
		</s:form>
	</div>
</div>
<div class="clr"></div>
<script>
	document.getElementById("them-bai-viet").classList.add('active');
</script>