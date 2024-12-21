package com.test.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString(callSuper = true)
public class Owner extends BaseEntity
{
	@Column(length = 20, nullable = false)
	private String ownerName;
	@Column(length = 50)
	private String ownerEmail;
	@Column(length = 50)
	private String company;
	
	@Column(name = "current_status")
	private int status;
	
	@OneToOne
	private Team teamId;

	public Owner(String ownerName, String ownerEmail, String company, int status) {
		super();
		this.ownerName = ownerName;
		this.ownerEmail = ownerEmail;
		this.company = company;
		this.status = status;
	}
	
	
	
	
}
