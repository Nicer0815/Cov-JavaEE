package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddDispatcher")
public class AddDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddDispatcher() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("option");
		System.out.println(option);
		if(option.equals("white")){
			request.setAttribute("status", "大白");
			request.setAttribute("action", "/Cov/adminAddWhite");
		}else if(option.equals("check")){
			request.setAttribute("status", "上传用户");
			request.setAttribute("action", "/Cov/adminAddChecker");
		}
		request.getRequestDispatcher("/admin_add.jsp").forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
