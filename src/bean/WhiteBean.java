package bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entity.White;

/**
 * Session Bean implementation class OperatorBean
 */
@Stateless
@LocalBean
public class WhiteBean {
	@PersistenceContext(unitName = "Cov")
	private EntityManager manager;
	
    public WhiteBean() {}

	public White query(String username) {
		System.out.println("WhiteBean.query:"+username);
		return manager.find(White.class, username);
	}

	public void insert(White operator) {
		System.out.println("WhiteBean.insert:"+operator);
		manager.persist(operator);
	}

}
