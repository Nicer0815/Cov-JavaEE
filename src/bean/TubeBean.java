package bean;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entity.Tube;

@Stateless
@LocalBean
public class TubeBean {
	@PersistenceContext(unitName = "Cov")
	private EntityManager manager;
    public TubeBean() {}

	
	public void addTube(Tube tube) {
		System.out.println("persist tube before:"+tube);
		manager.persist(tube);
		System.out.println("persist tube:"+tube);
	}


	public void updateTube(Tube tube) {
		Tube target = manager.find(Tube.class, tube.getTubeID());
		target.setResultTime(new Date().toString());
		target.setState(tube.getState());
		System.out.println("//persist tube:"+target);
		//manager.persist(target);
	}

	public Tube query(String id) {
		System.out.println("TubeBean query:"+id);
		return manager.find(Tube.class, id);
		
	}

}
