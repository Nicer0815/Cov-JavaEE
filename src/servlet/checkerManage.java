package servlet;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Tube;
import jms.JMSProducer;


@WebServlet("/checkerManage")
public class checkerManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    bean.TubeBean tubeBean;
	public checkerManage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String temp=request.getParameter("tubeID");
		String tubeIDList[] = temp.split(",");
		String state=request.getParameter("state");
		for(int i=0;i<tubeIDList.length;i++){
			String tubeID = tubeIDList[i];
			Tube tube = new Tube();
			tube.setResultTime(new Date().toString());
			tube.setTubeID(tubeID);
			tube.setState(state);
			try {
				System.out.println("JMS==>sending"+tube);
				JMSProducer.send(tube);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//end for
		request.getRequestDispatcher("/check.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
