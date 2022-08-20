package com.mirac.producterChallenge.api;

import java.util.List;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.mirac.producterChallenge.entity.Player;
import com.mirac.producterChallenge.service.PlayerService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PlayerQueryResolver implements GraphQLQueryResolver{

	private final PlayerService playerService;
	
	public List<Player> getAllPlayers() {
		return playerService.getAllPlayers();
	}

}
