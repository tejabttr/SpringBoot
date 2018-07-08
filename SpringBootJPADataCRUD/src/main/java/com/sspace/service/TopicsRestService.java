package com.sspace.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.SystemPropertyUtils;

import com.sspace.beans.Topic;
import com.sspace.repository.TopicRepository;

@Service
public class TopicsRestService {
	
	@Autowired
	private TopicRepository topicsRepository;
	
	private static List<Topic> list;
	public TopicsRestService() {
		
	}
public List<Topic> getTopics(){
	list=new ArrayList<>();
	topicsRepository.findAll().forEach(list::add);
	return list;
}
public String updateTopic(Topic topic){
	/*System.out.println(Id+"        "+name);
	for (Topic topic : list) {
		if(topic.getId().equals(Id)){
			System.out.println("called");
			topic.setName(name);
			return topic;
		}
	}
	return null;*/
	topicsRepository.save(topic);
	return "successfully updated";
}
public String addTopic(Topic topic){
	/*if(topic.getId()!=null){
		System.out.println(topic.getName());
	list.add(topic);
	return  " topic successfully added";
	}
	return "topic is empty";*/
	topicsRepository.save(topic);
	return  "topic successfully added";
}
public String removeTopic(String Id){
	/*for (Topic topic : list) {
		if(topic.getId().equals(Id)){
			list.remove(topic);
			return "successfully removed";
		}
	}*/
	// single line code fot the above code
	/*boolean topic=list.removeIf(t -> t.getId().equals(Id));
	if(topic)
		return "successfully removed";
	else
	return "no topic with this id";*/
	topicsRepository.delete(Id);
	return "successfully removed";
}


public Topic getTopic(String id){
	return topicsRepository.findOne(id);
}
}
