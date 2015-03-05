<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<div class="form-horizontal">
	<div class="form-group">
		<label class="col-sm-2 control-label"></label>
		<div style="padding-top: 7px;" class="col-sm-10">
			<h2>${product.name}</h2>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">Id:</label>
		<div style="padding-top: 7px;" class="col-sm-10">
			${product.id}
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">Product type:</label>
		<div style="padding-top: 7px;" class="col-sm-10">
			${product.productType.name}
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">Description:</label>
		<div style="padding-top: 7px;" class="col-sm-10">
			${product.description}
		</div>
	</div>
</div>
