package pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
	
	private int stud_id;
	private String stud_name;
	private String stud_address;
	private int stud_contact;
	
	public int getStud_id() {
		return stud_id;
	}
	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}
	
	public String getStud_name() {
		return stud_name;
	}
	public void setStud_name(String stud_name) {
		this.stud_name = stud_name;
	}
	
	public String getStud_address() {
		return stud_address;
	}
	public void setStud_address(String stud_address) {
		this.stud_address = stud_address;
	}
	
	public int getStud_contact() {
		return stud_contact;
	}
	public void setStud_contact(int stud_contact) {
		this.stud_contact = stud_contact;
	}
	
}
