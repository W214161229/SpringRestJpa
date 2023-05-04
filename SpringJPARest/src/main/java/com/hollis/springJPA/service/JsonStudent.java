package com.hollis.springJPA.service;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.hollis.springJPA.entity.Course;
import com.hollis.springJPA.entity.Student;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JsonStudent
{
    private ArrayList<Student> students;
    public void populateStudents(String url) throws ParseException
    {
        students = new ArrayList<Student>();
        Client client = Client.create();
        WebResource webResource = client.resource(url);
        
        ClientResponse clientResponse = webResource.accept("application/json").get(ClientResponse.class);
        if(clientResponse.getStatus() != 200)
        {
            throw new RuntimeException("Parse failed: " + clientResponse.toString());
        }
        
        JSONArray jsonArray = (JSONArray) new JSONParser().parse(clientResponse.getEntity(String.class));
        
        Iterator<Object> it = jsonArray.iterator();
        
        while(it.hasNext())
        {
            JSONObject jsonObject = (JSONObject)it.next();
            JSONArray courses = (JSONArray)jsonObject.get("course");
            ArrayList<Course> courseList = new ArrayList<Course>();
            if(courses != null)
            {
            	for(int x = 0; x < courses.size(); x++)
                {
                	JSONObject course = (JSONObject)courses.get(x);
                	courseList.add(new Course((String)course.get("courseNo"), (String)course.get("grade"), (long)course.get("creditHours")));
                }
            }
            System.out.println(courses);
            students.add(new Student((long)jsonObject.get("id"), (String)jsonObject.get("first_name"), (String)jsonObject.get("email"), (String)jsonObject.get("gender"), 
            		courseList));
        }
    }
    public ArrayList<Student> getStudents()
    {
    	return students;
    }
}
