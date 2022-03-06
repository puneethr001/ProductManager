package net.codejava;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
class Register {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
    private int id;
	private String name;
	private long phonenumber;
	
    public String getName() {
	return name;
    }
    public void setName(String name) {
	this.name = name;
    }
    public long getNumber() {
	return phonenumber;
    }
    public void setNumber(long number) {
	this.phonenumber = number;
    }
}
