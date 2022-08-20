package com.mirac.producterChallenge.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirac.producterChallenge.entity.Player;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{



}
