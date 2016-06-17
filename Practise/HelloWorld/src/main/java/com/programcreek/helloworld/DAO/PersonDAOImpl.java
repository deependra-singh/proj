package com.programcreek.helloworld.DAO;

import java.util.List;

import com.programcreek.helloworld.Model.Person;

public interface PersonDAOImpl 
{
	
	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listPersons();
	public Person getPersonById(int id);
	public void removePerson(int id);

}
