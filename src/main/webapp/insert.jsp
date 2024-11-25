<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Page</title>
</head>
<body>
     <h1>Insert Student Details</h1>
     <form action="addstud" method="post">
     Sname: <input type="text" id="tbName" name="tbName" required="required" />
     <br>
     Sub: <input type="text" id="tbSub" name="tbSub" required="required" />
     <br>
     Gender: <input type="radio" id="rdMale" name="rdGender" value="Male" />Male
             <input type="radio" id="rdFemale" name="rdGender" value="Female" />Female
     <br>
     Email: <input type="email" id="tbEmail" name="tbEmail" required="required" />
     <br>
     Education: <input type="text" id="tbEdu" name="tbEdu" required="required" />
     <br>
     <input type="submit" id="btnSave" name="btnSave" value="Save" />
     
     </form>
     <form action="home" method="post">
     <input type="submit" id="btnHome" name="btnHome" value="Go Home" />
     </form>
</body>
</html>