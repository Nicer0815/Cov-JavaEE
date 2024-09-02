package servlet.admin.add;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Checker;


@WebServlet("/adminAddChecker")
public class adminAddChecker extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	bean.CheckerBean checkerBean;
    public adminAddChecker() {
        super();
      
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Checker checker = new Checker();
		checker.setUsername(username);
		checker.setPassword(password);
		checkerBean.insert(checker);
		request.getRequestDispatcher("/admin_menu.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
