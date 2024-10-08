<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student List</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="container">
        <!-- Student List Column -->
        <div class="student-list">
            <h2>Student List</h2>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Age</th>
                        <th>Course</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <!--  student entry -->
                   <c:forEach var="student" items="${requestScope.studentList}">
			<tr>
				<td>${student.id}</td>
				<td>${student.name}</td>
				<td>${student.age}</td>
				<td>${student.course}</td>
				<td>
				
				 <a href="/WebApp/Student_Edit?id=${student.id}" class="edit-btn">Edit</a>
				 <a href="/WebApp/Student_Delete?id=${student.id}" onclick="return confirm('Are you sure you want to delete this student?');" class="delete-btn">Delete</a>
                    
                </td>
			</tr>
		</c:forEach>
                    
                </tbody>
            </table>
        </div>

        <!-- Student Form -->
        <div class="student-form">
            <h2>Student Form</h2>
            <form action="Student_Save" method="post">
                <label for="id">ID</label>
                <input type="text" id="id" name="id">

                <label for="name">Name</label>
                <input type="text" id="name" name="name">

                <label for="age">Age</label>
                <input type="text" id="age" name="age">

                <label for="course">Course</label>
                <input type="text" id="course" name="course">

                <div class="form-buttons">
                    <button type="reset" class="reset-btn">Reset</button>
                    <button type="submit" class="submit-btn">Add Student</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>

