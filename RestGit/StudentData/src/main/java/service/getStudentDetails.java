package service;

import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pojo.Student;

@Path("/student")
public class getStudentDetails {
	
	HashMap<Integer, Student> students = new HashMap<>();
	Student student;
	
	/*@Produces(MediaType.APPLICATION_XML)
	@GET
	public Student getDetails()
	{
		Student student=new Student();
		student.setId(1);
		student.setName("kp");
		return student;
	}*/
	
	@POST
	//@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String registerStudent(@FormParam("id") int id, @FormParam("name") String name )
	{
		student = new Student(id, name);
		students.put(id, student);
		return "Student details added successfully";
	}
	
}
