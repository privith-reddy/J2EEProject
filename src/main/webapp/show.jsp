<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.ArrayList" %>
    <%@ page import = "com.domain.model.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Page</title>
</head>
<body>
     <h1>Student Details:</h1>
     
     <table border = "1">
            <tr>
               <th>Sno</th>
               <th>Sname</th>
               <th>Sub</th>
               <th>Gender</th>
               <th>Email</th>
               <th>Education</th>
            </tr>
            <% ArrayList<Student> al = (ArrayList<Student>) request.getAttribute("stud"); %>
            
            <% for(Student s : al)
               {
            %>
            
            	<tr>
            	   <td><%=s.getSno() %></td>
            	   <td><%=s.getSname() %></td>
            	   <td><%=s.getSub() %></td>
            	   <td><%=s.getGender() %></td>
            	   <td><%=s.getEmail() %></td>
            	   <td><%=s.getEducation() %></td>
                
            	</tr>
            <%
               }
            %>	   

             
     </table>

</body>
</html>