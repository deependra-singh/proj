package com.programcreek.helloworld.Model;

import javax.persistence.*;

@Entity
@Table(name="person")
public class Person
{
		@Id
		@Column(name="person_id")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		
		@Column(name="person_name")
		private String name;
		
		@Column(name="person_country")
		private String country;

		public int getId()
		{
			return id;
		}

		public void setId(int id) 
		{
			this.id = id;
		}

		public String getName() 
		{
			return name;
		}

		public void setName(String name)
		{
			this.name = name;
		}

		public String getCountry() 
		{
			return country;
		}

		public void setCountry(String country) 
		{
			this.country = country;
		}
		
		@Override
		public String toString()
		{
			return "id="+id+", name="+name+", country="+country;
		}
	}
	


