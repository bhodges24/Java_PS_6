package base;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {
	
	private static PersonDomainModel my_person;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//Format Dates
		SimpleDateFormat my_format = new SimpleDateFormat("yyyy.MM.dd");
		//Create new Person
		my_person = new PersonDomainModel();
		my_person.setFirstName("Johnny");
		my_person.setLastName("Smith");
		my_person.setCity("Chicago");
		my_person.setPostalCode(50505);
		my_person.setBirthday(my_format.parse("1994.04.04"));
		my_person.setStreet("Orchard Lane");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}
;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		/*PersonDomainModel DB_person;
		
		PersonDAL.deletePerson(my_person.getPersonID());
		DB_person = PersonDAL.getPerson(my_person.getPersonID());
		assertNull(DB_person); */
		
	} 

	@Test
	public void GetPersonsTest() {
		
		//Check to make sure my_person is not in the table
		ArrayList<PersonDomainModel> DB_persons;
		DB_persons = PersonDAL.getPersons();
		assertFalse(DB_persons.isEmpty());	
	}
	
	@Test
	public void GetPersonTest() {
		
		//Check to make sure my_person is not in the table
		PersonDomainModel DB_person;
		DB_person = PersonDAL.getPerson(my_person.getPersonID());
		assertTrue(DB_person == null);
	} 
	
	@Test
	public void AddPersonTest() {
		
		//Check to make sure my_person is not in the table
		PersonDomainModel DB_person;
		DB_person = PersonDAL.getPerson(my_person.getPersonID());
		assertTrue(DB_person == null);
		
		//Add my_person
		PersonDomainModel added_person = PersonDAL.addPerson(my_person);
		assertTrue(added_person.getPersonID() == my_person.getPersonID());
		
		//Check if my_person was added to the Database
		DB_person = PersonDAL.getPerson(my_person.getPersonID());
		assertNull(DB_person);		
	} 
	
	/**@Test
	public void UpdatePersonTest() {
		//Create a new last name
		final String LAST_NAME = "Appleseed";
		
		//Check to make sure my_person is not in the table
		PersonDomainModel DB_person = PersonDAL.getPerson(my_person.getPersonID());
		assertNull(DB_person);
		
		//Add my_person
		PersonDAL.addPerson(my_person);
		
		//Change my_person's last name
		my_person.setLastName(LAST_NAME);
		
		//Update my_person record in Database
		PersonDAL.updatePerson(my_person);
		
		//Check if my_person was updated in the Database
		DB_person = PersonDAL.getPerson(my_person.getPersonID());
		assertTrue(DB_person.getLastName() == LAST_NAME);		
	}**/
	
	/**@Test
	public void DeletePersonTest() {
		//
		assertNotNull(my_person.getPersonID());
		//Check to make sure my_person is not in the table
		PersonDomainModel DB_person;
		DB_person = PersonDAL.getPerson(my_person.getPersonID());
		assertNull(DB_person);
		
		//Add my_person
		PersonDAL.addPerson(my_person);
		
		//Check if my_person was added to the Database
		DB_person = PersonDAL.getPerson(my_person.getPersonID());
		assertTrue(PersonDAL.getPerson(my_person.getPersonID()).getPersonID() == my_person.getPersonID());
		//Delete my_person from Database
		PersonDAL.deletePerson(my_person.getPersonID());
		
		//Check if my_person was deleted from the Database
		DB_person = PersonDAL.getPerson(my_person.getPersonID());
		assertNull(DB_person);		
	} **/

}
