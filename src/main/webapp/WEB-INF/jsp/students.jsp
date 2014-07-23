<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:actionURL var="addStudentURL">
<portlet:param name="action" value="add"></portlet:param>
</portlet:actionURL>
<portlet:actionURL var="deleteStudentURL">
<portlet:param name="action" value="delete"></portlet:param>
</portlet:actionURL>

<h2><spring:message code="label.header"/></h2>
<!--  Add Contact Form -->
<form:form name="student" commandName="student" method="post" action="${addStudentURL}" >
	<table style="width : 100%;">
		<tr>
			<td><form:label path="firstname"><spring:message code="label.firstname"/></form:label></td>
			<td><form:input path="firstname" /></td> 
		</tr>
		<tr>
			<td><form:label path="lastname"><spring:message code="label.lastname"/></form:label></td>
			<td><form:input path="lastname" /></td>
		</tr>
		<tr>
			<td><form:label path="email"><spring:message code="label.email"/></form:label></td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td><form:label path="telephone"><spring:message code="label.telephone"/></form:label></td>
			<td><form:input path="telephone" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="<spring:message code="label.addcontact"/>"/>
			</td>
		</tr>
	</table>	
</form:form>

<!-- Display list of contacts	 -->
<c:if  test="${!empty contactList}">
	<h3><spring:message code="label.Contacts"/></h3>
	<table style="width : 100%;">
		<tr>
			<th><spring:message code="label.name"/></th>
			<th><spring:message code="label.email"/></th>
			<th><spring:message code="label.telephone"/></th>
			<th>#</th>
		</tr>
		<c:forEach items="${contactList}" var="contact">
			<tr>
				<td align="center">${contact.lastname} ${contact.firstname} </td>
				<td align="center">${contact.email}</td>
				<td align="center">${contact.telephone}</td>
				<td align="center"><a href="${deleteContactURL}&contactId=${contact.id}">delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>