package com.hollis.springJPA.entity;

import javax.persistence.Entity;

@Entity
public class Course
{
    private String courseNo;
    private String grade;
    private long creditHours;
    public Course(String cn, String g, long ch)
    {
        courseNo = cn;
        grade = g;
    	creditHours = ch;
    }
    public long getCreditHours()
    {
        return creditHours;
    }
    public String getCourseNo()
    {
        return courseNo;
    }
    public String getGrade()
    {
        return grade;
    }
    @Override 
    public String toString()
    {
        return "CID: " + courseNo + " - Grade: " + grade + " - " + creditHours + " hours.";
    }
}