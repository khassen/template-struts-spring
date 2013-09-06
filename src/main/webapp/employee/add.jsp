<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <%@ include file="/header.jsp" %>
        <h2>Add Employee</h2>
        
        <s:actionerror/>
        
        <s:form action="addAction" >
            <s:textfield name="firstname" label="First Name"  />
            <s:textfield name="lastname" label="Last Name"  />
            <s:textfield name="email" label="Email" />
            <s:textfield name="telephone" label="Telephone"  />
              <s:textfield name="dateEmbauche" label="Date d'embauche" />
            <s:submit />
        </s:form>


	
	<%@ include file="/footer.jsp" %>   
        
    </body>
</html>
