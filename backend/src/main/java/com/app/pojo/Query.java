package com.app.pojo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "queries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Query {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer queryId;

	@Column 
	private String question;

	@Column(nullable = true)
	private String answer;

	
}
