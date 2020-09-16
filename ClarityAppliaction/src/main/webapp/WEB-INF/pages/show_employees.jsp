<%@include file="commons/header.jspf" %>
<%@include file="commons/navigation.jspf" %>

	<div class="container" align="center">
		<table   border="1" class="table table-striped">
			<caption align="top">Clarity Details</caption>
			<thead>
				<tr>
					<th>EMPLOYEE ID</th>
					<th>EMPLOYEE NAME</th>
					<th>CLARITY HOURS</th>
					<th>LEAVE COUNT</th>
					<th>HOLIDAY COUNT</th>
					<th>COMMENTS</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listDTO}" var="dto">
					<tr>
						<td>${dto.empid}</td>
						<td>${dto.empName}</td>
						<td>${dto.clarityHours}</td>
						<td>${dto.leaveCount}</td>
						<td>${dto.holidayCount}</td>
						<td>${dto.comments}</td>
						<td><a type="button" class="btn btn-success" href="update_employee?id=${dto.empid}">Update</a></td>
						<td><a type="button" class="btn btn-warning" href="delete_employee?id=${dto.empid}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div align="center"> <a class="button" href="add_employee">Add Employee</a></div>
		</div>
		<br>
 	<c:if test="${!empty resMsg}">
     	<p style="background:pepper;text-align:center;color:red;font-size:20px">${resMsg } </p>
  	</c:if> 
		<br>
		
		<%@include file="commons/footer.jspf" %>
		