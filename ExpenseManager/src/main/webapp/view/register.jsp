<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
</head>

<body bgcolor="gold" font-color="blue">
 <f:form action="addUser" modelAttribute="user">
<table border='0' width='480px' cellpadding='0' cellspacing='0' align='center'>
<center><tr>
   <td><h1>Registration Form For Student</h1></td>
</tr><center>
 
<table border='0' width='480px' cellpadding='0' cellspacing='0' align='center'>

<tr>
    <td align='center'>User Name:</td>
    <td><f:input path="userName"></f:input> <f:errors path="userName"></f:errors>
     </td>
          
</tr>

<tr> <td>&nbsp;</td> </tr>

<tr>
    <td align='center'>User Address:</td>
    <td><f:input path="UserAddress"></f:input> <f:errors path="userAddress"></f:errors>
</td>
    
</tr>

<tr> <td>&nbsp;</td> </tr>
<tr>
    <td align='center'>User Email:</td>
    <td><f:input path="userEmail"></f:input> <f:errors path="userEmail"></f:errors></td>

    
</tr>

<tr> <td>&nbsp;</td> </tr>
<tr>
    <td align='center'>user Password:</td>
    <td><f:input path="userPassword"></f:input> <f:errors path="userPassword"></f:errors>
</td>
</tr>

<tr> <td>&nbsp;</td> </tr>

<table border='0' cellpadding='0' cellspacing='0' width='480px' align='center'>
<tr>
    <td align='center'><input type='submit' name='REGISTER' value="Register"></td>
</tr>
</table>

</table>
</table>
</f:form>
</body>
</html>