<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
	<form action="/modifyAccount" method="post">

	<h3>User Information</h3>

	<table>
		<tr>
			<td>User ID:</td>
			<td>${sessionScope.username}</td>
		</tr>
		<tr>
			<td>New password:</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td>Repeat password:</td>
			<td><input type="password" name="rePassword"></td>
		</tr>
	</table>
	<%@ include file="IncludeAccountFields.jsp"%>

		<input type="submit" value="confirm">
</form>
	<a href="/viewOrder">My Orders</a></div>

<%@ include file="../common/IncludeBottom.jsp"%>
