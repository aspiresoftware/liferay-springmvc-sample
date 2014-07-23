<%@include file="init.jsp"%>
<%@include file="modal.jsp"%>
<portlet:renderURL var="addStudentUrl">
	<portlet:param name="render" value="studentForm"/>
</portlet:renderURL>
<portlet:renderURL var="viewStudentUrl">
	<portlet:param name="render" value="viewStudent"/>
</portlet:renderURL>

<div class="alert alert-success fade in"
	<c:if test="${empty success }">
		style="display: none;"
	</c:if>	
>
	<i class="icon-remove close" data-dismiss="alert"></i>
	<strong>Success!</strong> <span class="message">${success}</span>
</div>
<div class="alert alert-danger fade in" 
	<c:if test="${empty error }">
		style="display: none;"
	</c:if>
>
	<i class="icon-remove close" data-dismiss="alert"></i>
	<strong>Error!</strong><span class="message">${error}</span>
</div>
<p>
<a href="${addStudentUrl }" class="btn btn-primary">
	<spring:message code="label.newStudent" />
</a>
</p>
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
				 	"mData" : "firstName",
				 	"mRender" : function(data, type, full) {
						return "<a href='${viewStudentUrl}&studentId="+full.id+"'>" +data+ " </a>";
					}
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
						+"&nbsp;<a href='#' id='rowId_"+data+"' onclick='deleteStudent(this)' class='bs-tooltip' data-placement='top' data-original-title='Delete' title='Delete'><i class='icon-trash'></i></a>";
					}
				}]
	 });
});

// delete Student From database and also datatable
function deleteStudent(element) {
	var studentId = $(element).attr('id').substring($(element).attr('id').indexOf('_') + 1);
	console.log("StudentId = "+studentId);
	var tr = $(element).parents('tr')[0];
	var dataTable = $('#student-datatable').dataTable();
	var confirmDelete = confirm("Are you sure?");
	if(confirmDelete){
		$.ajax({
			type : "POST",
			url : "<portlet:resourceURL id='deleteStudent'/>",
			data : "studentId="+studentId,
			dataType : "json",
			success : function(response) {
				
				$(".alert").find(".message").text(response.actionMessage);
				if (response.status == "success") {
					dataTable.fnDeleteRow(tr);
					$(".alert-success").show();
				}
				if (response.status == "error") {
					$(".alert-danger").show();
					return false;
				}
			},
			error : function(e) {
				alert('Unexpected error while deletion student :: ' + e);
			}
		});
		
	}
}
</script>