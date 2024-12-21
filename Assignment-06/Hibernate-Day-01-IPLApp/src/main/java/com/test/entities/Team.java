package com.test.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString(callSuper = true ,exclude={"players"})
@NoArgsConstructor
public class Team extends BaseEntity {

	@Column(name = "team_name", length = 100, unique = true)
	private String teamName;

	@Column(name = "team_abbreviation", length = 15, unique = true)
	private String abbreviation;

	@Column(name = "max_player_age ")
	private int maxPlayerAge;

	@Column(name = "batting_avg")
	private double battingAvg;

	@Column(name = "wickets_taken")
	private int wicketTaken;

	@OneToMany(mappedBy = "teamId", cascade = CascadeType.ALL, orphanRemoval = true) 
	// orphanRemoval true because if we remove player from team it only break the link player records is still exists in db.
	private List<Player> players = new ArrayList<Player>();

//	public Team(String name, String abr) {
//		this.owner.setOwnerName(name);
//		abbreviation = abr;
//	}

	public Team(String teamName, String abbreviation, int maxPlayerAge, double battingAvg,
			int wicketTaken) {
		super();
		this.teamName = teamName;
		this.abbreviation = abbreviation;
		this.maxPlayerAge = maxPlayerAge;
		this.battingAvg = battingAvg;
		this.wicketTaken = wicketTaken;
	}

	// add a helper method , to add a child ref in bi dir association
//	public void addPlayer(Player p) {
//		this.players.add(p);
//		p.setTeamId(this);
//	}

	// add a helper method , to remove a child ref in bi dir association
//	public void removePlayer(Player p) {
//		this.players.remove(p);
//		p.setTeamId(null);
//	}
//	
	

}
