package com.hollis.springJPA.entity;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Student
{
	@Id
    private long id;
    private String firstName;
    private String email;
    private String gender;
    private ArrayList<Course> courses;
    public Student(long i, String n, String e, String d, ArrayList<Course> c)
    {
        id = i;
        firstName = n;
        email = e;
        gender = d;
        courses = c;
    }
    public long getID()
    {
        return id;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getEmail()
    {
        return email;
    }
    public String getGender()
    {
        return gender;
    }
    public ArrayList<Course> getCourses()
    {
    	return courses;
    }
    public void setID(long i)
    {
    	id = i;
    }
    public void setFirstName(String fn)
    {
    	firstName = fn;
    }
    public void setEmail(String e)
    {
    	email = e;
    }
    public void setGender(String g)
    {
    	gender = g;
    }
    public void setCourses(ArrayList<Course> c)
    {
    	courses = c;
    }
    @Override 
    public String toString()
    {
        return firstName + "- ID#" + id + "- " + gender + "- " + email + "-" + "Courses: " + courses;
    }
}