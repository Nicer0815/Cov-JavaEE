package servlet.login;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Admin;

@WebServlet("/adminLogin")
public class adminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private bean.AdminBean adminUserBean;
	
    public adminLogin() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(username+password);
		Admin admin = adminUserBean.query(username);
	    if(admin == null){
	    	System.out.println("�û�������");
	    	request.setAttribute("status", "����Ա");
			request.setAttribute("action", "/Cov/adminLogin");
	    	request.getRequestDispatcher("/login.jsp").forward(request,response);
	    }else{
	    	System.out.println("not null");
	    	System.out.println(admin);
	    	if(admin.getPassword().equals(password)){
	    		System.out.println("������ȷ");
	    		request.getRequestDispatcher("/admin_menu.jsp").forward(request,response);
	    	}else{
	    		System.out.println("�������");
	    		request.setAttribute("status", "����Ա");
				request.setAttribute("action", "/Cov/adminLogin");
	    		request.getRequestDispatcher("/login.jsp").forward(request,response);
	    	}
	    }
	}

}
