package servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Tube;
import entity.TubeStudent;

@WebServlet("/whiteManage")
public class whiteManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    bean.TubeList listBean;
    @EJB
    bean.TubeBean tubeBean;
    public whiteManage() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		String option = request.getParameter("option");
		System.out.println(option);
		if(option.equals("submit")){
			String tubeID = (String) request.getSession().getAttribute("tubeid");
			Tube tube = new Tube();
			tube.setTubeID(tubeID);
			tube.setOperateTime(new Date().toString());
			System.out.println("listServlet : opt = submit & tube=>"+tube);
			tube.setState("µÈ´ý");
			tubeBean.addTube(tube);
			listBean.submitRecord();
		}else if(option.equals("add")){
			String tubeID=request.getParameter("tubeId");
			String sid=request.getParameter("studentID");
			String sname=request.getParameter("studentName");
			System.out.println(tubeID+sid+sname);
			TubeStudent st = new TubeStudent();
			st.setTubeID(tubeID);
			st.setStudentId(sid);
			st.setStudentName(sname);
			listBean.addRecord(st);
			List<TubeStudent> list = listBean.getList();
			for(int i = 0;i<list.size();i++){
				list.get(i).setlist_id(i+1);
			}
			System.out.println(list);
			request.setAttribute("list", list);
			request.getSession().setAttribute("tubeid", tubeID);
		}else if(option.equals("del")){
			String sid=request.getParameter("studentID");
			listBean.removeRecord(Integer.parseInt(sid));
			List<TubeStudent> list = listBean.getList();
			for(int i = 0;i<list.size();i++){
				list.get(i).setlist_id(i+1);
			}
			
			System.out.println(list);
			request.setAttribute("list", list);
		}else if(option.equals("cancel")){
			List<TubeStudent> list = listBean.getList();
			for(int i = 0;i<list.size();i++){
				list.get(i).setlist_id(i+1);
			}
			
			System.out.println(list);
			request.setAttribute("list", list);
		}
		request.getRequestDispatcher("/white_menu.jsp").forward(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
