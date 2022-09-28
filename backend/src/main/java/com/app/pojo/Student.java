package com.app.pojo;

import java.time.LocalDate; 

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;

	@Column(name = "student_fname")
	private String studentFirstName;

	@Column(name="student_lname")
	private String studentLastName;

	@Column(name="student_email")
	private String studentEmail;

	@Column(name="student_password")
	private String studentPassword;

	@Column(name="student_mobile_no")
	private String studentMobileNo;

	@Column(name="student_dob")
	private LocalDate studentDob;

	@Column(name="student_gender")
	private Gender studentGender;

	@Column(name="student_marks")
	private float studentMarks;

	@ManyToOne 
	@JoinColumn(name="student_course_id")
	@JsonIgnoreProperties("studentsList")
	@JsonIgnore 
	private Course assignedStudentCourse;

	@OneToOne(cascade = CascadeType.ALL , orphanRemoval = true)
	@JoinColumn(name = "student_address_id", referencedColumnName = "address_id", insertable = true, updatable = true)
	@JsonIgnore
	private Address studentAddress;

	@ManyToOne
	@JoinColumn(name="assigned_mentor_id", nullable = true)
	@JsonIgnoreProperties("studentsList")
	@JsonIgnore
	private Mentor assignedMentor;


}
