package com.test.dao;

import com.test.entities.Player;

public interface PlayerDao {
	//add new player to existing Team
	String addNewPlayer(Long teamId,Player Player);
	
	String deletePlayer(Long playerId, Long TeamId);
}
