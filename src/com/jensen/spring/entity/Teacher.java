package com.jensen.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Creates a Teacher object with Hibernate-mapping,  get- and set- methods.
 * Use two constructors. One - for Insert, Update and Delete database operation, another for Read.
 * @author Shul, Oskwik
 * @version 2.0
 */

@Entity
@Table(name="teacher")
public class Teacher {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tid")
	private int id;
	
	@Column(name="tnr")
	private int nr;
	
	@Column(name="fname")
	private String firstName;
	
	@Column(name="lname")
	private String lastName;
	
	@Column(name="comment")
	private String comment;
	
	public Teacher() {}
	
	public Teacher(int nr, String firstName, String lastName, String comment) {
		this.nr = nr;
		this.firstName = firstName;
		this.lastName = lastName;
		this.comment = comment;
	}

	public Teacher(int id, int nr, String firstName, String lastName, String comment) {
		this(nr, firstName, lastName, comment);
		this.id = id;
}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", nr=" + nr + ", firstName=" + firstName + ", lastName=" + lastName + ", comment="
				+ comment + "]";
	}
	
	
}
