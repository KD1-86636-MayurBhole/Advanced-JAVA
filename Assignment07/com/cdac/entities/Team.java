package com.cdac.entities;
import javax.persistence.*;
@Entity
@Table(name="teams")
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length = 20, name="team_name", unique=true)
	private String name;
	@Column(length = 10, unique=true)
	private String abbravation;
	@Column(length = 10, nullable=false)
	private String owner;
	@Column(name="max_player_age")
	private int age;
	@Column(name="batting_avg")
	private double battingAverage;
	@Column(name="wickets_taken")
	private int wickets;
	public Team() {
	}
	public Team(String owner,String abbravation)
	{
		this.owner=owner;
		this.abbravation=abbravation;
	}
	public Team(String name, String abbravation, String owner, int age, double battingAverage, int wickets) {
		super();
		this.name = name;
		this.abbravation = abbravation;
		this.owner = owner;
		this.age = age;
		this.battingAverage = battingAverage;
		this.wickets = wickets;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbravation() {
		return abbravation;
	}
	public void setAbbravation(String abbravation) {
		this.abbravation = abbravation;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getBattingAverage() {
		return battingAverage;
	}
	public void setBattingAverage(double battingAverage) {
		this.battingAverage = battingAverage;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	
	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", abbravation=" + abbravation + ", owner=" + owner + ", age="
				+ age + ", battingAverage=" + battingAverage + ", wickets=" + wickets + "]";
	}
}
