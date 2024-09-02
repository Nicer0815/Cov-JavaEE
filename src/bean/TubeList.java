package bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.TubeStudent;

@Stateful
@LocalBean
public class TubeList {

	private int cnt;
	private List<TubeStudent> list=new ArrayList<TubeStudent>();
	
    public TubeList() { cnt = 0;}
	
	public void addRecord(TubeStudent ts) {
		list.add(ts);
		cnt++;
	}
	
	public void removeRecord(int num) {
		list.remove(num-1);
		cnt--;
	}
	
	public void submitRecord() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Cov",null);
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		int i = 0;
		while(!list.isEmpty()){
			list.get(0).setlist_id(i);
			manager.persist(list.get(0));
			list.remove(0);
			i++;
			cnt--;
		}
		
	     transaction.commit();
		 System.out.println("--------+++");
		manager.close();
	    factory.close();
	    cnt=1;
		
	}
	
	public List<TubeStudent> getList() {
		return list;
	}
	
	public TubeStudent getTube(String studentID) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Cov",null);
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		System.out.println("--------+++studentID:"+studentID);
		Query q = manager.createQuery("SELECT t FROM TubeStudent t where t.studentId=?1");
	     q.setParameter(1, studentID);
	     List<TubeStudent> list = q.getResultList();
	     transaction.commit();
		 System.out.println("--------+++");
		manager.close();
	    factory.close();
	    System.out.println("getlist in TubeListBean:"+list);
		return list.get(list.size()-1);
	}

}
