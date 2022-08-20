package com.mirac.producterChallenge.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.mirac.producterChallenge.dto.PlayerDto;
import com.mirac.producterChallenge.entity.Player;
import com.mirac.producterChallenge.service.PlayerService;

import lombok.RequiredArgsConstructor;

@Component
public class PlayerMutationResolver implements GraphQLMutationResolver{

	@Autowired
	private PlayerService playerService;
	
	
	public Player addPlayer(PlayerDto player) {
		Player playerToAdd = playerService.createPlayerFromDto(player);
		return playerService.savePlayer(playerToAdd);
	}
	
	public Long deletePlayer(Long id) {
		return playerService.deleteById(id);

	}



}