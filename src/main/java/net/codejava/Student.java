package net.codejava;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
private String name;
private String hobby;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getHobby() {
	return hobby;
}
public void setHobby(String hobby) {
	this.hobby = hobby;
}
}
