<%@include file="init.jsp"%>
<portlet:renderURL var="backToList" />
<p>
<liferay-ui:header title="Back to Stundent List" backURL="${backToList}" backLabel="Back"></liferay-ui:header>
</p>
<div class="form-horizontal">
	<!--Basic Information -->
	<fieldset>
		<legend>${student.firstName} ${student.lastName} - <spring:message code="label.tab1.title"/></legend>
		<div class="span12">
			<span class="span2"><spring:message code="label.firstname"/></span>
			<span class="span10">${student.firstName}</span>
		</div>
		<div class="span12">
			<span class="span2"><spring:message code="label.lastname"/></span>
			<span class="span10">${student.lastName}</span>
		</div>
		<div class="span12">
			<span class="span2"><spring:message code="label.email"/></span>
			<span class="span10">${student.email}</span>
		</div>	
		<div class="span12">
			<span class="span2"><spring:message code="label.address"/></span>
			<span class="span10">${student.address}</span>
		</div>
		<div class="span12">
			<span class="span2"><spring:message code="label.street"/></span>
			<span class="span10">${student.street}</span>
		</div>
		<div class="span12">
			<span class="span2"><spring:message code="label.city"/></span>
			<span class="span10">${student.city}</span>
		</div>
		<div class="span12">
			<span class="span2"><spring:message code="label.state"/></span>
			<span class="span10">${student.state}</span>
		</div>
		<div class="span12">
			<span class="span2"><spring:message code="label.postCode"/></span>
			<span class="span10">${student.postCode}</span>
		</div>
		<div class="span12">
			<span class="span2"><spring:message code="label.telephone"/></span>
			<span class="span10">${student.telephone}</span>
		</div>
	</fieldset>
	<!-- Course Detail -->
	<fieldset>
		<legend>${student.firstName} ${student.lastName} - <spring:message code="label.tab2.title"/></legend>
		<div class="span12">
			<span class="span2"><spring:message code="label.category"/></span>
			<span class="span10">${student.course.courseCategory.category}</span>
		</div>
		<div class="span12">
			<span class="span2"><spring:message code="label.course"/></span>
			<span class="span10">${student.course.courseName}</span>
		</div>
	</fieldset>
</div>