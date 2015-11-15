package domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class PersonDomainModel {

	private UUID PersonID;
    private  String FirstName;
    private  String LastName;
    private  String Street;
    private  Integer PostalCode;
    private  String City;
    private  Date Birthday;
    
    

    /**
     * Default constructor.
     */
    
    public PersonDomainModel(){
    	this.PersonID = UUID.randomUUID();
    	this.PostalCode = 0;
    	
    }

	public UUID getPersonID() {
		return PersonID;
	}
	
	public void setPersonID(UUID personID) {
		PersonID = personID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public Integer getPostalCode() {
		return PostalCode;
	}

	public void setPostalCode(Integer postalCode) {
		PostalCode = postalCode;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public Date getBirthday() {
		return Birthday;
	}

	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}
    
    
}