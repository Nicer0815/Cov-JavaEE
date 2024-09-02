package webService;




import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;




import javax.ws.rs.QueryParam;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Produces;




@Path("/restful")
public class NameRESTWS {

	
@GET
@Produces("text/html") 
public String sayHello(@QueryParam("studentID") String studentID,
						@QueryParam("tubeid")String tubeID) {
	
	System.out.println("----/restful----"+studentID+tubeID);
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("Cov",null);
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	transaction.begin();
	
	Query q = manager.createQuery("select t.studentName from Student t where t.studentId=?1");
     q.setParameter(1, studentID);
     String studentName = (String) q.getSingleResult();
     transaction.commit();
	manager.close();
    factory.close();
    
    String page = "<!DOCTYPE html>\n" +
			"<html>\n" +
			"\t<head>\n" +
			"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gbk\">" +
			"\t\t<title>确认被测者</title>\n" +
			"\t</head>\n" +
			"\t<body>\n" +
			"\t\t<div class=\"row\">\n" +
			"\t\t\t<form action=\"/Cov/whiteManage\" method=\"POST\">\n" +
			"\t\t\t\t<div class=\"row\" style=\"text-align: center;\">\n" +
			"\t\t\t\t\t<h4 style=\"color: green;\">请确认被测者：</h4>\n" +
			"\t\t\t\t</div>\n" +
			"\t\t\t\t<input type=\"hidden\" name=\"tubeId\" value=\""+tubeID+"\">\n" +
			"\t\t\t\t<input type=\"hidden\" name=\"option\" id=\"option\" value=\"add\">\n" +
			"\t\t\t\t<div class=\"row\" style=\"text-align: center;\">\n" +
			"\t\t\t\t\t学号:<input style=\"margin-top: 50px;\" type=\"text\" name=\"studentID\" id=\"inputStudentID\" value=\""+studentID+"\" readonly>\n" +
			"\t\t\t\t</div>\n" +
			"\t\t\t\t<div class=\"row\" style=\"text-align: center;\">\n" +
			"\t\t\t\t\t姓名:<input style=\"margin-top: 15px; margin-bottom: 30px;\"  name=\"studentName\" value=\""+studentName+"\" readonly>\n" +
			"\t\t\t\t</div>\n" +
			"\t\t\t\t<div class=\"row\" style=\"text-align: center;\">\n" +
			"\t\t\t\t\t<button onclick=\"window.location.href = 'index.jsp'\">取消添加</button>\n" +
			"\t\t\t\t\t<button type=\"submit\">确认添加</button>\n" +
			"\t\t\t\t</div>\n" +
			"\t\t\t</form>\n" +
			"\t\t</div>\n" +
			"\t</body>\n" +
			"</html>";
	return page;
	

	}

}
