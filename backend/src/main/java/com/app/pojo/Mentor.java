package com.app.pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "mentors")
public class Mentor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mentorId;

	@Column(name="mentor_fname")
	private String mentorFirstName;

	@Column(name="mentor_lname")
	private String mentorLastName;

	@Column(name="mentor_email")
	private String mentorEmail;

	@Column(name="mentor_password")
	private String mentorPassword;

	@Column(name="mentor_mono")
	private String mentorMoNo;

	@Column(name="batch_size")
	private int batchSize;

	@Column(name = "current_batch_size", columnDefinition = "integer default 00")
	private int currentBatchSize;

	@Column(name="mentor_dob")
	private LocalDate mentorDob;

	@Column(name="mentor_gender")
	private Gender mentorGender;

	@Column(name="mentor_join_year")
	private LocalDate mentorJoinYear;

	@Column(name="avg_rating")
	private float avgRating;

	@OneToOne(cascade = CascadeType.ALL , orphanRemoval = true)
	@JoinColumn(name = "mentor_address_id", referencedColumnName = "address_id", insertable = true, updatable = true)
	@JsonIgnore 
	private Address mentorAddress;

	@ManyToOne
	@JoinColumn(name="mentor_course_id")
	private Course assignedMentorCourseId;

	@OneToMany(mappedBy = "assignedMentor",cascade = CascadeType.ALL , orphanRemoval = true)
	@JsonIgnoreProperties("assignedMentor")
	@JsonIgnore
	private List<Student> studentsList = new ArrayList<>();

	
	//to add Student in mentor table
	public void addStudent(Student student) {
		studentsList.add(student);
		student.setAssignedMentor(null);
	}

	//to remove student from mentor table
	public void removeStudent(Student student) {
		studentsList.remove(student);
		student.setAssignedMentor(null);
	}
}
