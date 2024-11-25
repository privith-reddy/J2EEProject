<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
</head>
<body>

	<br>
     <h1>Admin Login</h1>
     <form action="validate" method="post">
         Email:<input type="email" id="tbEmail" name="tbEmail" required="required"/>
         <br>
         Password:<input type="password" id="tbPass" name="tbPass" required="required"/>
         <br>
         <input type="submit" id="btnLogin" name="btnLogin" value="Login" />
     
     
     </form>
</body>
</html>