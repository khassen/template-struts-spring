<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

 <%@ include file="/header.jsp" %>
        <h2>Add Department</h2>
        
        <s:actionerror/>
        
        <s:form action="addAction" >
            <s:textfield name="name" label="Name" />
          
            <s:submit />
        </s:form>

  	<%@ include file="/footer.jsp" %> 
</body>
</html>