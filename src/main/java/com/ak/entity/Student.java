package com.ak.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String year;
    public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	private String photoUrl;
    private String contact;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Course> courses;
    private String department;
	private String grades;
	private String attendance;

    public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	// Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public String getContact() {
		return contact;
	}
	public void setContactDetails(String contact) {
		this.contact = contact;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	 public Student(Long id, String name, String contact, String photoUrl, List<Course> courses, String grades, String attendance) {
	        this.id = id;
	        this.name = name;
	        this.contact = contact;
	        this.photoUrl = photoUrl;
	        this.courses = courses;
	        this.grades = grades;
	        this.attendance = attendance;
	    }
	public Student(String string, String string2, String string3, String string4, String string5, String string6) {
		// TODO Auto-generated constructor stub
	}
	public String getGrades() {
		return grades;
	}
	public void setGrades(String grades) {
		this.grades = grades;
	}
	public String getAttendance() {
		return attendance;
	}
	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
    
}
