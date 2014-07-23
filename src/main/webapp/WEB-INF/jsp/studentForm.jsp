<%@include file="init.jsp"%>
<portlet:actionURL var="addStudentURL">
	<portlet:param name="action" value="save"/>
</portlet:actionURL>
<portlet:renderURL var="backToList" />

<a href="${backToList}">
	<spring:message code="label.backToList" />
</a>

<form:form id="studentForm" commandName="student" method="post" action="${addStudentURL}" cssClass="form-horizontal">
	<c:if test="${not empty message }">
		${message}
	</c:if>
	<div id="rootwizard">
		<ul>
			<li><a href="#tab1" data-toggle="tab"><spring:message code="label.tab1.title"/> </a></li>
			<li><a href="#tab2" data-toggle="tab"><spring:message code="label.tab2.title"/></a></li>
		</ul>
		<div class="tab-content">
			<!-- Tab 1 : Basic Information -->
			<div class="tab-pane" id="tab1">
				<div class="control-group">
					<label class="control-label" for="firstname"><spring:message
							code="label.firstname" /><span class="required">*</span>
					</label>
					<div class="controls">
						<form:input path="firstName" cssClass="required"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="name">
						<spring:message code="label.lastname"/><span class="required">*</span>
					</label>
					<div class="controls">
						<form:input path="lastName" cssClass="required"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="email">
						<spring:message code="label.email"/><span class="required">*</span>
					</label>
					<div class="controls">
						<form:input path="email" cssClass="required email"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="address"><spring:message code="label.address"/> </label>
					<div class="controls">
						<form:input path="address"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="street"><spring:message code="label.street"/> </label>
					<div class="controls">
						<form:input path="street"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="city"><spring:message code="label.city"/> </label>
					<div class="controls">
						<form:input path="city"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="state"><spring:message code="label.state"/> </label>
					<div class="controls">
						<form:input path="state"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="postCode"><spring:message code="label.postCode"/> </label>
					<div class="controls">
						<form:input path="postCode"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="telephone"><spring:message code="label.telephone"/> </label>
					<div class="controls">
						<form:input path="telephone"/>
					</div>
				</div>
			</div>
			<!-- Tab 2 : Course Detail -->
			<div class="tab-pane" id="tab2">
				<div class="control-group">
					<label class="control-label"><spring:message code="label.category"/> </label>
					<div class="controls">
						<select id="course-category">
							<option value="">--Select--</option>
							<c:forEach items="${courseCategory}" var="courseCategory" varStatus="status">
								<option value="${courseCategory.category}" 
									<c:if test="${student.course.courseCategory.id == courseCategory.id }">
										selected="selected"
									</c:if>
								>${courseCategory.category}</option>
							</c:forEach>
						</select>
						
					</div>
				</div>
				<div class="control-group">
					<label class="control-label"><spring:message code="label.course"/> </label>
					<div class="controls">
						<form:select path="course.id" id="courses">
							<form:option value="">--Select--</form:option>
							<c:forEach items="${courses}" var="course" varStatus="status">
								<c:choose>
									<c:when test="${not empty student.course and course.courseCategory.id eq student.course.courseCategory.id}">
										<form:option cssClass="${course.courseCategory.category}" value="${course.id}">${course.courseName}</form:option>
									</c:when>
									<c:otherwise>
										<form:option cssClass="${course.courseCategory.category}" value="${course.id}" cssStyle="display:none;">${course.courseName}</form:option>
									</c:otherwise>
								</c:choose>								
							</c:forEach>
						</form:select>
					</div>
				</div>
			</div>
			<ul class="pager wizard">
				<li class="previous">
					<a href="javascript:void(0);" class="button-previous"><spring:message code="label.previous" /> </a>
				</li>
				<li class="next">
					<a href="javascript:void(0);" class="button-next"><spring:message code="label.next"/> </a>
				</li>
				<li class="submit">
					<form:hidden path="id"/>
					<button type="submit" class="btn btn-success button-submit">
						<spring:message code="label.submit" />
						<i class="icon-angle-right"></i>
					</button>
				</li>
			</ul>
		</div>
	</div>
</form:form>
<script>
$(document).ready(function() {
	jQuery("#course-category").change(function() {
		var category = jQuery.trim(jQuery(this).val());
		$("#courses option").not(':first').hide();
		$("#courses option:first-child").attr("selected", "selected");
		if(category != "") {
			$("#courses option[class='"+category+"']").show();	
		}
	});
});
</script>