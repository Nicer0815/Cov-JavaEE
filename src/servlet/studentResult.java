package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Student;
import entity.Tube;
import entity.TubeStudent;

@WebServlet("/studentResult")
public class studentResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	bean.TubeList listBean;
	@EJB
	bean.TubeBean tubeBean;
	
    public studentResult() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = (Student) request.getSession().getAttribute("student");
		System.out.println("stdQueryServlet:==>student:==>"+student);
		TubeStudent ts = listBean.getTube(student.getStudentId());
		if(ts!=null){
			System.out.println("in studentQueryServlet:TubeStudent==>"+ts);
			Tube tube = tubeBean.query(ts.getTubeID());
			System.out.println("stdQueryServlet:==>tube:==>"+tube+tube.getResultTime());
			request.setAttribute("studentID", ts.getStudentId());
			request.setAttribute("studentName", ts.getStudentName());
			request.setAttribute("operateTime", tube.getOperateTime());
			request.setAttribute("resultTime", tube.getResultTime());
			request.setAttribute("state", tube.getState());
		}else{
			System.out.println("TubeStudent没有记录");
			request.setAttribute("studentID", student.getStudentId());
			request.setAttribute("studentName", student.getStudentName());
			request.setAttribute("operateTime", "没有记录");
			request.setAttribute("resultTime", "没有记录");
			request.setAttribute("state", "无记录");
		}
		request.getRequestDispatcher("/student_result.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
