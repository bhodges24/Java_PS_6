package ch.makery.address.model;

import java.time.LocalDate;
import java.util.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import ch.makery.address.util.LocalDateAdapter;
import domain.PersonDomainModel;
import javax.persistence.Entity;

public class Person extends PersonDomainModel {
	
    public Person() {
        super();
    }

    public Person(String firstName, String lastName, String street, int postalCode, String city, Date birthday ) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setStreet(street);
        this.setPostalCode(postalCode);
        this.setCity(city);
        this.setBirthday(birthday);
        
    }
    
    public StringProperty getFirstNameProperty()
    {
    	return new SimpleStringProperty(this.getFirstName());    	
    }
    
    public StringProperty getLastNameProperty()
    {
    	return new SimpleStringProperty(this.getLastName());    	
    }
    
    public StringProperty getStreetProperty()
    {
    	return new SimpleStringProperty(this.getStreet());    	
    }
    
    public StringProperty getCityProperty()
    {
    	return new SimpleStringProperty(this.getCity());    	
    }
    
    public IntegerProperty getPostalCodeProperty()
    {
    	return new SimpleIntegerProperty(this.getPostalCode());    	
    }
}
