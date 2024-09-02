package bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Admin;

@Stateless
@LocalBean
public class AdminBean {
	@PersistenceContext(unitName = "Cov")
	private EntityManager manager;
	
	public Admin query(String username){
		System.out.println("Admin.find"+username);
		return manager.find(Admin.class,username);
	}
    public AdminBean() {}

}
