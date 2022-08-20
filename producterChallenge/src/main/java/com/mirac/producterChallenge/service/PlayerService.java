package com.mirac.producterChallenge.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirac.producterChallenge.dto.PlayerDto;
import com.mirac.producterChallenge.entity.Player;
import com.mirac.producterChallenge.repos.PlayerRepository;


import javax.transaction.Transactional;

@Service
@Transactional
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;
	
	
	public Player savePlayer(Player player) {
		return playerRepository.save(player);
	}
	
	public Long deleteById(Long id) {
		playerRepository.deleteById(id);
		return id;
	}
	
	public List<Player> getAllPlayers() {
		return playerRepository.findAll();
	}


	public Player createPlayerFromDto(PlayerDto playerDto){

		Player newPlayer = new Player();
		newPlayer.setName(playerDto.getName());
		newPlayer.setSurname(playerDto.getSurname());
		newPlayer.setPosition(playerDto.getPosition());
		newPlayer.setCreatedAt(new Date());
		return newPlayer;

	}
	
	

}