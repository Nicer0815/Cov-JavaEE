package servlet.admin.add;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.White;

@WebServlet("/adminAddWhite")
public class adminAddWhite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	bean.WhiteBean whiteBean;
    public adminAddWhite() {
        super();
      
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		White white = new White();
		white.setUsername(username);
		white.setPassword(password);
		whiteBean.insert(white);
		request.getRequestDispatcher("/admin_menu.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
