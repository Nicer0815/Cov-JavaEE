package servlet.login;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Checker;

@WebServlet("/checkerLogin")
public class checkerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private bean.CheckerBean checkerBean;
	
    public checkerLogin() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(username+password);
		Checker checker = checkerBean.query(username);
	    if(checker == null){
	    	System.out.println("用户不存在");
	    	request.setAttribute("status", "上传用户");
			request.setAttribute("action", "/Cov/checkerLogin");
	    	request.getRequestDispatcher("/login.jsp").forward(request,response);
	    }else{
	    	System.out.println("not null");
	    	System.out.println(checker);
	    	if(checker.getPassword().equals(password)){
	    		System.out.println("密码正确");
	    		request.getRequestDispatcher("/check.jsp").forward(request,response);
	    	}else{
	    		System.out.println("密码错误");
	    		request.setAttribute("status", "上传用户");
				request.setAttribute("action", "/Cov/checkerLogin");
	    		request.getRequestDispatcher("/login.jsp").forward(request,response);
	    	}
	    }
	}

}
