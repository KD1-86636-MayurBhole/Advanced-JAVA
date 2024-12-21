package com.test.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@NoArgsConstructor
public class Player extends BaseEntity
{
	@Column(length = 20, name = "first_name")
	private String firstName;
	
	@Column(length = 20, name = "last_name")
	private String lastName;
	
	private LocalDate dob;
	
	@Column(name = "batting_avg")
	private double battingAvg;
	
	@Column(name = "wicket_taken")
	private int wicketTaken;
	
	@ManyToOne
	@JoinColumn(name="team_id", nullable = false)
	private Team teamId;

	public Player(String firstName, String lastName, LocalDate dob, double battingAvg, int wicketTaken) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.battingAvg = battingAvg;
		this.wicketTaken = wicketTaken;
	}

	
	
	
	

}
