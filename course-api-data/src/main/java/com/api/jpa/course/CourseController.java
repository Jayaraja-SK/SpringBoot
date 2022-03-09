package com.api.jpa.course;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.jpa.topic.Topic;

@RestController

public class CourseController {
	
	@Autowired
	private CourseService courseservice;
	
	@RequestMapping("/topics/{id}/courses") // BY DEAFULT, THE METHOD IS GET
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseservice.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseservice.getCourse(id);
	}
	
	@RequestMapping(value="/topics/{topicId}/courses",method=RequestMethod.POST)
	public void addCourse(@RequestBody Course course, @PathVariable String topicId){
		course.setTopic(new Topic(topicId,"",""));
		courseservice.addCourse(course);
	}
	
	@RequestMapping(value="/topics/{topicId}/courses/{id}",method=RequestMethod.PUT)
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id){
		course.setTopic(new Topic(topicId,"",""));
		courseservice.updateCourse(course);
	}
	
	@RequestMapping(value="/topics/{topicId}/courses/{id}",method=RequestMethod.DELETE)
	public void deleteCourse(@PathVariable String id){
		courseservice.deleteCourse(id);
	}
}