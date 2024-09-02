package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginDispatcher")
public class LoginDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginDispatcher() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("option");
		System.out.println(option);
		if(option.equals("admin")){
			request.setAttribute("status", "管理员");
			request.setAttribute("action", "/Cov/adminLogin");
		}else if(option.equals("white")){
			request.setAttribute("status", "大白");
			request.setAttribute("action", "/Cov/whiteLogin");
		}else if(option.equals("checker")){
			request.setAttribute("status", "上传用户");
			request.setAttribute("action", "/Cov/checkerLogin");
		}else if(option.equals("student")){
			request.setAttribute("status", "学生");
			request.setAttribute("action", "/Cov/studentLogin");
		}
		request.getRequestDispatcher("/login.jsp").forward(request,response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
