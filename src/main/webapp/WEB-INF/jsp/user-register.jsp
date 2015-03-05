<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<form:form commandName="user" cssClass="form-horizontal">

	
	<c:if test="${param.success eq true }">
		<div class="alert alert-success">Congratulations! You are successfully registered. Now you can sign in.</div>
	</c:if>

		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Name:</label>
			<div class="col-sm-10">
				<form:input path="name" cssClass="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<label for="firstName" class="col-sm-2 control-label">First name:</label>
			<div class="col-sm-10">
				<form:input path="firstName" cssClass="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<label for="lastName" class="col-sm-2 control-label">Last name:</label>
			<div class="col-sm-10">
				<form:input path="lastName" cssClass="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<label for="email" class="col-sm-2 control-label">Email:</label>
			<div class="col-sm-10">
				<form:input path="email" cssClass="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<label for="phone" class="col-sm-2 control-label">Phone:</label>
			<div class="col-sm-10">
				<form:input path="phone" cssClass="form-control"/>
			</div>
		</div>
			<div class="form-group">
			<label for="address" class="col-sm-2 control-label">Address:</label>
			<div class="col-sm-10">
				<form:input path="address" cssClass="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<label for="password" class="col-sm-2 control-label">Password:</label>
			<div class="col-sm-10">
				<form:password path="password" cssClass="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-10">
				<input type="submit" value="Register" class="btn btn-lg btn-primary" />
			</div>
		</div>

</form:form> 