package com.Bach.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

import com.Bach.action.StudentAction;
import com.Bach.entity.Student;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet(name = "ControllerServlet",urlPatterns = {"/Student_List","/Student_Save","/Student_Update","/Student_Edit","/Student_Delete"})
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
		
		try {
			processRequest(request, response);
		} catch (ServletException | IOException e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			processRequest(request, response);
		} catch (ServletException | IOException e) {
			
			e.printStackTrace();
		}
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String action= request.getServletPath();
		
		switch(action) {
		case"/Student_List":
			showStudentList(request,response);
			break;
		case"/Student_Save":
			saveStudent(request,response);
			break;
		case"/Student_Update":
			updateStudent(request,response);
			break;
		case"/Student_Edit":
			editStudent(request,response);
			break;
		case"/Student_Delete":
			deleteStudent(request,response);
			break;
			default:
				showHomePage(request,response);
		}
		
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id= request.getParameter("id");
		StudentAction sAction1= new StudentAction();
		Student student= sAction1.findStudent(Integer.parseInt(id));
		StudentAction sAction2= new StudentAction();
		sAction2.deleteStudent(student);
		response.sendRedirect("Student_List");
	}

	private void editStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id= request.getParameter("id");
		StudentAction sAction= new StudentAction();
		Student student= sAction.findStudent(Integer.parseInt(id));
		request.setAttribute("student",student);
		
		request.getRequestDispatcher("/jsp/studentForm.jsp").forward(request,response);
		
		
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Student student = new Student();
		student.setId(Integer.parseInt(request.getParameter("id")));
		student.setName(request.getParameter("name"));
		student.setAge(Integer.parseInt(request.getParameter("age")));
		student.setCourse(request.getParameter("course"));
		
		StudentAction sAction = new StudentAction();
		sAction.upDateStudent(student);
		
		response.sendRedirect("Student_List");
		
		
	}

	private void saveStudent(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		Student student = new Student();
		student.setId(Integer.parseInt(request.getParameter("id")));
		student.setName(request.getParameter("name"));
		student.setAge(Integer.parseInt(request.getParameter("age")));
		student.setCourse(request.getParameter("course"));
		
		StudentAction sAction = new StudentAction();
		sAction.saveStudent(student);
		request.setAttribute("student", student);
		response.sendRedirect("Student_List");
	//	request.getRequestDispatcher("/jsp/studentList.jsp").forward(request,response);
		
	}

	private void showHomePage(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.getRequestDispatcher("/index.html").forward(request,response);
	}

	private void showStudentList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentAction sAction= new StudentAction();
		List<Student> studentList =  sAction.getStudents();
		request.setAttribute("studentList", studentList);
		request.getRequestDispatcher("/jsp/studentList.jsp").forward(request,response);
		
	}
}
