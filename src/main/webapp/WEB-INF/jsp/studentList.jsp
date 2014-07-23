<%@include file="init.jsp"%>
<%@include file="modal.jsp"%>
<portlet:renderURL var="addStudentUrl">
	<portlet:param name="render" value="studentForm"/>
</portlet:renderURL>

<c:if test="${not empty success }">
	<div class="alert alert-success fade in">
		<i class="icon-remove close" data-dismiss="alert"></i>
		<strong>Success!</strong>${success}
	</div>
</c:if>
<c:if test="${not empty error }">
	<div class="alert alert-danger fade in">
		<i class="icon-remove close" data-dismiss="alert"></i>
		<strong>Error!</strong>${error}
	</div>
</c:if>

<a href="${addStudentUrl }" class="btn btn-primary">
	<spring:message code="label.newStudent" />
</a>
<div class="next-row">
<table id="student-datatable" class="table table-striped table-bordered">
	<thead>
		<tr>
			<th><spring:message code="label.firstname" /></th>
			<th><spring:message code="label.lastname" /></th>
			<th><spring:message code="label.email" /></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>
</div>
<script>
$(document).ready(function() {
	 $('#student-datatable').dataTable({
		 	bJQueryUI: true,
		 	bAutoWidth : true,
			bProcessing : true,
			sAjaxSource : "<portlet:resourceURL id='getAllStudents'/>",
			"aoColumns" : [
				{
				 	"mData" : "firstName"
				},
				{
					"mData" : "lastName"
				},
				{
					"mData" : "email"
				},
				{
					"mData" : "id",
					"bSortable" : false,
					"bSearchable" : false,
					"mRender" : function(data, type, full) {
						return "<a href='${addStudentUrl}&studentId="+data+"' class='bs-tooltip' data-placement='top' data-original-title='Edit' title='Edit'><i class='icon-pencil'></i></a>"
						+"&nbsp;<a href='#' onclick='deleteStudent("+data+")' class='bs-tooltip' data-placement='top' data-original-title='Delete' title='Delete'><i class='icon-trash'></i></a>";
					}
				}]
	 });
});
function deleteStudent(value) {
	console.log("Deletion of student");
	$('.modal').modal("show");
}
</script>