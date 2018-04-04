package com.my.model;
import javax.persistence.*;
@Entity
public class Stdentu {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)       //for autonumber 
    private int ID;
	@Column
	private String name;
	@Column
private String College_name;
	@Column
private int age;
	@Column
private String gender;
	
	public Stdentu(int iD, String name, String college_name, int age, String gender) {
		super();
		ID = iD;
		this.name = name;
		College_name = college_name;
		this.age = age;
		this.gender = gender;
	}
	
public Stdentu()
{
	
}

public int getID() {
	return ID;
}

public void setID(int iD) {
	ID = iD;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCollege_name() {
	return College_name;
}

public void setCollege_name(String college_name) {
	College_name = college_name;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}


}
