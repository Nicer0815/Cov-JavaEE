package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Student;

/**
 * Servlet implementation class studentRegister
 */
@WebServlet("/studentRegister")
public class studentRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB
    bean.StudentsBean studentBean;
    public studentRegister() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentID=request.getParameter("username");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		System.out.println(studentID+name+password);
		Student student = new Student();
		student.setPassword(password);
		student.setStudentId(studentID);
		student.setStudentName(name);
		studentBean.insert(student);
		request.getRequestDispatcher("/student_result.jsp").forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
