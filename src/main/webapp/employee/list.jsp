<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Employee</title>
</head>
<body>
	<%@ include file="/header.jsp"%>
	<table border="1px" cellpadding="8px">
		<tr>
			<th>ID</th>
			<th>First name</th>
			<th>Last name</th>
			<th>Email</th>
			<th>Telephone</th>
			<th>Date embauche</th>
		</tr>
		<s:iterator value="employees">
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="firstname" /></td>
				<td><s:property value="lastname" /></td>
				<td><s:property value="email" /></td>
				<td><s:property value="telephone" /></td>
				<td><s:property value="dateEmbauche" /></td>
			</tr>
		</s:iterator>
	</table>
	<%@ include file="/footer.jsp"%>
</body>
</html>
