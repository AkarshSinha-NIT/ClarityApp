<%@include file="commons/header.jspf" %>
<%@include file="commons/navigation.jspf" %>
<br>
<br>
<h1 style="color:black;text-align: center">Login</h1>

	
	<div align="center" class="container">
     <font color="red">${errorMessage}</font>
	<form action="login" method="post">
	<table>
		<tr>
		<td>Name :</td><td> <input type="text" name="uname" /></td>
		</tr>
		<tr>
		<td>Password : </td><td><input type="password" name="pwd" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center">	<button type="submit" class="btn btn-success">Login</button></td>
		</tr>
			</table>
	</form>

	</div>
	
<%@include file="commons/footer.jspf" %>
