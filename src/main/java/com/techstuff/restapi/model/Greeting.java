package com.techstuff.restapi.model;

public class Greeting {
private int id;
private String message;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getMessage() {
	System.out.println(message);
	return message;
}
public void setMessage(String message) {
	this.message = message;
	System.out.println(message);
}

}
