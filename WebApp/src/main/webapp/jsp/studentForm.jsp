<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Student Form</title>
<link rel="stylesheet" href="css/formstyles.css">
</head>
<body>
<div class="form-container">
        <h2>Edit Form</h2>
        <form action="Student_Update" method="post">
            <div class="form-group">
                <label for="id">ID:</label>
                <input type="text" id="id" name="id" required value="<c:out value='${student.id}'/>"/> 
            </div>
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required value="<c:out value='${student.name}'/>"/>
            </div>
            <div class="form-group">
                <label for="age">Age:</label>
                <input type="number" id="age" name="age" required value="<c:out value='${student.age}'/>"/>
            </div>
            <div class="form-group">
                <label for="course">Course:</label>
                <input type="text" id="course" name="course" required value="<c:out value='${student.course}'/>"/>
            </div>
            <input type="submit" value="Update Student">
        </form>
    </div>
</body>
</html>