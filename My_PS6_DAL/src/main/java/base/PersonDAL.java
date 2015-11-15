package base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.PersonDomainModel;
import util.HibernateUtil;

public class PersonDAL {
	
	/* addPerson() -- Adds a person to the database
	 * @param per
	 * @return  */
	public static PersonDomainModel addPerson(PersonDomainModel per) {
		//PS6 - please implement
		Session my_session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		//Start a new transaction and try to add the student to the database
		try{
			tx = my_session.beginTransaction();
			my_session.save(per);
			tx.commit();
		}catch(HibernateException ex){ //Catch any Hibernate errors
			if(tx != null){
				//If there was an error with the transaction, rollback the database
				tx.rollback();
				ex.printStackTrace();
			}
		} finally{ //End the session no matter what happens
			my_session.close();
		}
		
		return per;
	}
	/*getPersons() -- Gets all person records from the database
	 * @return   */
	public static ArrayList<PersonDomainModel> getPersons() {
		//PS6 - please implement
		Session my_session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		ArrayList<PersonDomainModel> persons = new ArrayList<PersonDomainModel>();
		
		try{
			tx = my_session.beginTransaction();
			
			List my_persons = my_session.createQuery("FROM PersonDomainModel").list();
			
			for(Iterator my_iterator = my_persons.iterator(); my_iterator.hasNext();){
				PersonDomainModel person = (PersonDomainModel)my_iterator.next();
				persons.add(person);
			}
			
			tx.commit();
		} catch(HibernateException ex){
			if (tx != null)
				tx.rollback();
				ex.printStackTrace();
		} finally {
			my_session.close();
		}
		return persons;

	}
	/*getPerson -- gets a single person record from the Database
	 * @param perID
	 * @return
	 */
	public static PersonDomainModel getPerson(UUID perID) {
		//PS6 - please implement	
		Session my_session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		PersonDomainModel perGet = null;
		
		try{
			tx = my_session.beginTransaction();
			
			/*Query my_query = my_session.createSQLQuery("SELECT * FROM per WHERE PersonID = :ID");
			my_query.setParameter("ID", perID);
			List<?> my_list = my_query.list();

			perGet = (PersonDomainModel)my_list.get(0); */  //Tried this initially, but wouldn't work in JUNIT
			
			ArrayList<PersonDomainModel> DB_persons = getPersons();
			
			for(PersonDomainModel per : DB_persons){
				if(perID == per.getPersonID()){
					 perGet = per;
					 break;
				}
			}
			
			tx.commit();
			
		} catch (IndexOutOfBoundsException ex_1) {
			//Make sure results list is not empty
			perGet = null;
		}catch(HibernateException ex_2){
			if (tx != null)
				tx.rollback();
			ex_2.printStackTrace();
		} finally {
			my_session.close();
		}
		return perGet;
	}

	public static void deletePerson(UUID perID) {
		//PS6 - please implement
		Session my_session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try{
			tx = my_session.beginTransaction();
			
			PersonDomainModel my_person = (PersonDomainModel)my_session.get(PersonDomainModel.class, perID);
			//Make sure queried person in Database
			if(my_person != null){
				my_session.delete(my_person);
			}
			tx.commit();
	} catch(HibernateException ex){
		if (tx != null)
			tx.rollback();
		ex.printStackTrace();
	} finally {
		my_session.close();
	}
	}


	public static PersonDomainModel updatePerson(PersonDomainModel per) {
		//PS6 - please implement
		Session my_session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		PersonDomainModel new_person = new PersonDomainModel();
		new_person.setFirstName(per.getFirstName());
		new_person.setLastName(per.getLastName());
		new_person.setCity(per.getCity());
		new_person.setPersonID(per.getPersonID());
		new_person.setStreet(per.getStreet());
		new_person.setBirthday(per.getBirthday());
		
		try{
			tx = my_session.beginTransaction();
			my_session.update(per);
			tx.commit();
			
		} catch(HibernateException ex){
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			my_session.close();
		}
		
		return new_person;
	}
}
	
	
	
	
	
	
	
	
	
	