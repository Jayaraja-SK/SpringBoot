package io.javabrains.springbootstarter.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TopicController {
	
	@Autowired
	private TopicService topicservice;
	
	@RequestMapping("/topics") // BY DEAFULT, THE METHOD IS GET
	public List<Topic> getAllTopics() {
		return topicservice.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicservice.getTopic(id);
	}
	
	@RequestMapping(value="/topics",method=RequestMethod.POST)
	public void addTopic(@RequestBody Topic topic){
		topicservice.addTopic(topic);
	}
	
	@RequestMapping(value="/topics/{id}",method=RequestMethod.PUT)
	public void addTopic(@RequestBody Topic topic, @PathVariable String id){
		topicservice.updateTopic(id,topic);
	}
	
	@RequestMapping(value="/topics/{id}",method=RequestMethod.DELETE)
	public void deleteTopic(@PathVariable String id){
		topicservice.deleteTopic(id);
	}
}
