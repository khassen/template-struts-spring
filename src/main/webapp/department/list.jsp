<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="/header.jsp"%>
	<table border="1px" cellpadding="8px">
		<tr>
			<th>ID</th>
			<th>Name</th>
		</tr>
		<s:iterator value="departments">
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="name" /></td>
			</tr>
		</s:iterator>
	</table>
	<%@ include file="/footer.jsp"%>



</body>
</html>