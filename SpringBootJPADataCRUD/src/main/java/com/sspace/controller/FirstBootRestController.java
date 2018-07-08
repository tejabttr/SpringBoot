package com.sspace.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sspace.beans.Topic;
import com.sspace.service.TopicsRestService;

@RestController
@RequestMapping(value = "/rest")
public class FirstBootRestController {

	@Autowired
	private TopicsRestService topicsService;

	@RequestMapping(value = "/hello")
	public String viewName() {
		return "Macha this is simple rest application";
	}

	@RequestMapping(value = "/topics")
	public List<Topic> getTopics() {
		return topicsService.getTopics();
	}
	
	@RequestMapping(value="/topics/add", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public String addTopic(@RequestBody Topic topic) {
		return topicsService.addTopic(topic);
	}

	@RequestMapping(value="/topics/remove/{id}",method=RequestMethod.DELETE)
	public String removeTopic(@PathVariable("id") String Id) {
		return topicsService.removeTopic(Id);
	}
	
	@RequestMapping(value="/topics/update",method=RequestMethod.PUT)
	public String updateTopic(@RequestBody Topic topic) {
		return topicsService.updateTopic(topic);
	}
	
	@RequestMapping(value="/topics/{id}")
	public Topic getTopic(@PathVariable("id") String id){
		return topicsService.getTopic(id);
	}
}
