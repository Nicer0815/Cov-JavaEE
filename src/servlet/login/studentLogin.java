package servlet.login;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Student;

@WebServlet("/studentLogin")
public class studentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private bean.StudentsBean studentBean;
	
    public studentLogin() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(username+password);
		Student student = studentBean.query(username);
	    if(student == null){
	    	System.out.println("�û�������");
	    	request.setAttribute("status", "ѧ��");
			request.setAttribute("action", "/Cov/studentLogin");
	    	request.getRequestDispatcher("/login.jsp").forward(request,response);
	    }else{
	    	System.out.println("not null");
	    	System.out.println(student);
	    	if(student.getPassword().equals(password)){
	    		System.out.println("������ȷ");
	    		request.getSession().setAttribute("student", student);
	    		request.getRequestDispatcher("/studentResult").forward(request,response);
	    	}else{
	    		System.out.println("�������");
	    		request.setAttribute("status", "ѧ��");
				request.setAttribute("action", "/Cov/studentLogin");
	    		request.getRequestDispatcher("/login.jsp").forward(request,response);
	    	}
	    }
	}

}
