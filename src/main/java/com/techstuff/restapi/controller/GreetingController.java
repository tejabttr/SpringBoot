package com.techstuff.restapi.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techstuff.restapi.model.Greeting;

@RestController(value = "/greetings")
public class GreetingController {
	private List<Greeting> list = new ArrayList<Greeting>();

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Object> creatGreeting(@RequestBody Greeting greeting) {
		list.add(greeting);
		return new ResponseEntity<Object>("Greeting added successfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/greetings/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getGreetingById(@PathVariable("id") int id) {
		for (Greeting greeting : list) {
			if (greeting.getId() == id) {
				return new ResponseEntity<Object>(greeting, HttpStatus.OK);
			}
		}
		return new ResponseEntity<Object>("Greeting not found", HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<Object> getGreetings() {
		System.out.println("Called...........");
		if (!list.isEmpty()) {
			return new ResponseEntity<Object>(list, HttpStatus.OK);
		}
		System.out.println("getAllllllllllllll");
		return new ResponseEntity<Object>("No Greetings found", HttpStatus.OK);
	}

	@RequestMapping(value = "/update/{id}/{message}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateGreeting(@PathVariable("id") int id, @PathVariable("message") String message) {
		for (Greeting greeting : list) {
			if (greeting.getId() == id) {
				greeting.setMessage(message);
				return new ResponseEntity<Object>("Greeting Upadated Succesfully", HttpStatus.OK);
			}
		}
		return new ResponseEntity<Object>("No Greeting found with the Id", HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteGreeting(@PathVariable("id") int id) {
		for (Iterator<Greeting> iterator = list.iterator(); iterator.hasNext();) {
			Greeting greeting = (Greeting) iterator.next();
			if (greeting.getId() == id) {
				iterator.remove();
				return new ResponseEntity<Object>("Greeting Deleted Succefully...", HttpStatus.OK);
			}
		}
		return new ResponseEntity<Object>("Greeting not found...!", HttpStatus.NOT_FOUND);
	}
}
