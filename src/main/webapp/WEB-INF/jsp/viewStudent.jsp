<%@include file="init.jsp"%>
<portlet:renderURL var="backToList" />
<p>
<liferay-ui:header title="Back to Student List" backURL="${backToList}" backLabel="Back"></liferay-ui:header>
</p>
<c:choose>
	<c:when test="${empty student}">
		<spring:message code="student.not.found" />
	</c:when>
	<c:otherwise>
		<div class="form-horizontal">
			<!--Basic Information -->
			<fieldset>
				<legend><spring:message code="label.tab1.title"/></legend>
				<div class="span12">
					<span class="span2"><strong><spring:message code="label.firstname"/></strong></span>
					<span class="span10">${student.firstName}</span>
				</div>
				<div class="span12">
					<span class="span2"><strong><spring:message code="label.lastname"/></strong></span>
					<span class="span10">${student.lastName}</span>
				</div>
				<div class="span12">
					<span class="span2"><strong><spring:message code="label.email"/></strong></span>
					<span class="span10">${student.email}</span>
				</div>	
				<div class="span12">
					<span class="span2"><strong><spring:message code="label.address"/></strong></span>
					<span class="span10">${student.address}</span>
				</div>
				<div class="span12">
					<span class="span2"><strong><spring:message code="label.street"/></strong></span>
					<span class="span10">${student.street}</span>
				</div>
				<div class="span12">
					<span class="span2"><strong><spring:message code="label.city"/></strong></span>
					<span class="span10">${student.city}</span>
				</div>
				<div class="span12">
					<span class="span2"><strong><spring:message code="label.state"/></strong></span>
					<span class="span10">${student.state}</span>
				</div>
				<div class="span12">
					<span class="span2"><strong><spring:message code="label.postCode"/></strong></span>
					<span class="span10">${student.postCode}</span>
				</div>
				<div class="span12">
					<span class="span2"><strong><spring:message code="label.telephone"/></strong></span>
					<span class="span10">${student.telephone}</span>
				</div>
			</fieldset>
			<!-- Course Detail -->
			<fieldset>
				<legend><spring:message code="label.tab2.title"/></legend>
				<div class="span12">
					<span class="span2"><strong><spring:message code="label.category"/></strong></span>
					<span class="span10">${student.course.courseCategory.category}</span>
				</div>
				<div class="span12">
					<span class="span2"><strong><spring:message code="label.course"/></strong></span>
					<span class="span10">${student.course.courseName}</span>
				</div>
			</fieldset>
		</div>
	</c:otherwise>
</c:choose>