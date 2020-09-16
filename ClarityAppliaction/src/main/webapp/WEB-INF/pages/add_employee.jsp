<%@include file="commons/header.jspf" %>
<%@include file="commons/navigation.jspf" %>
<br>
<br>
<h1 style="color:black;text-align: center">Enter Clarity Details</h1>
	
	<div align="center" class="container">
	<table >
		<form:form action="add_employee" method="post" modelAttribute="empCmd">
		
		<tr >
			<td><form:label path="empid">Employee ID :</form:label></td>
			<td><form:input type="text" path="empid" /></td><td><form:errors path="empid" /></td>
		</tr>	
			
		<tr>	
			<td><form:label path="empName">Employee Name :</form:label></td>
			<td><form:input type="text" path="empName" /></td><td><form:errors path="empName" /></td>
		</tr>	
			
		<tr>
			<td><form:label path="clarityHours">Clarity Hours :</form:label></td>
			<td><form:input type="text" path="clarityHours" /></td> <td><form:errors path="clarityHours" /></td>
		</tr>
			
		<tr>
			<td><form:label path="leaveCount">Leave Count :</form:label></td>
			<td><form:input type="text" path="leaveCount" /></td><td><form:errors path="leaveCount"/></td>
		</tr>	
			
		<tr>	
			<td><form:label path="holidayCount">Holiday Count :</form:label></td>
			<td><form:input type="text" path="holidayCount" /></td><td><form:errors path="holidayCount" /></td>
		</tr>	
			
		<tr>
			<td><form:label path="comments">Comments :</form:label></td>
			<td><form:input type="text" path="comments" /></td><td><form:errors path="comments" /></td>
		</tr>
		
			
			<tr>
			<td colspan="3" align="center">	<button type="submit" class="btn btn-success" >Submit</button></td>
			</tr>
		</form:form>
		
		</table>
	</div>
	<br>
 	<c:if test="${!empty resMsg}">
     	<p style="background:pepper;text-align:center;color:red;font-size:20px">${resMsg } </p>
  	</c:if> 
		<br>
	<%@include file="commons/footer.jspf" %>