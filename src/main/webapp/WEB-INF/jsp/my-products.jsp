<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>
111111
<br>
${param.message}
${message_3}
<br>
2222222
<br>
${param.message_3}
<c:if test="${message != null}">
	<div class="alert alert-success" >${message}</div>
</c:if>

<table class="table table-bordered table-hover table-stripped">
	<thead>
		<tr>
			<th>Product name</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${myProducts}" var="product">
			<tr>
				<td>
					<a href='<spring:url value="/my-products/${product.id}" />'>${product.name}</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


	