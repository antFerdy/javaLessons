

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.omg.CORBA.SystemException;


import model.Colleague;


public class JPATest {
	static EntityManagerFactory factory;
	static EntityManager em;
	

	
	
	public static void main(String[] args) {
		EntityTransaction userTransaction;
		Colleague coll;
		
		factory = Persistence.createEntityManagerFactory("Lesson33");
		em = factory.createEntityManager();
		userTransaction = em.getTransaction();
		
		
		
		/*List listOfColleague = em.createQuery("select t from Colleagues t").getResultList();
		 * for(Colleague colleg:listOfColleague) {
		 * 		System.out.println("The employee name is " + colleg.getName());
		 *	} 
		 *	System.out.println("The size of the list " + listOfColleague.size());
		 */
			
		
		
		
		coll = new Colleague();
		coll.setId(5);
		coll.setName("Jim");
		coll.setSurName("Rogers");
		
		try {
			userTransaction.begin();
			em.persist(coll);
			userTransaction.commit();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		try { 
			if(userTransaction.isActive()) {
				userTransaction.rollback();
			}
			
		} catch (SystemException e1){
			e1.printStackTrace();
		}
		
	    em.close();
		
		
	}

}
