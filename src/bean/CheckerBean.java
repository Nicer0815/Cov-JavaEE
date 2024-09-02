package bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entity.Checker;

/**
 * Session Bean implementation class TesterBean
 */
@Stateless
@LocalBean
public class CheckerBean {
	@PersistenceContext(unitName = "Cov")
	private EntityManager manager;
	
    public CheckerBean() {}

	public Checker query(String username) {
		System.out.println("CheckerBean.query:"+username);
		return manager.find(Checker.class, username);
	}

	public void insert(Checker tester) {
		System.out.println("CheckerBean.insert:"+tester);
		manager.persist(tester);
	}
}
