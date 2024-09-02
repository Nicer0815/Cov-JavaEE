package bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entity.Student;

/**
 * Session Bean implementation class StudentsBean
 */
@Stateless
@LocalBean
public class StudentsBean {
	@PersistenceContext(unitName = "Cov")
	private EntityManager manager;
	
    public StudentsBean() {}

	public Student query(String studentId) {
		System.out.println("StudentsBean.query:"+studentId);
		return manager.find(Student.class, studentId);
	}

	public void insert(Student student) {
		System.out.println("StudentsBean.insert:"+student);
		manager.persist(student);
	}

}
