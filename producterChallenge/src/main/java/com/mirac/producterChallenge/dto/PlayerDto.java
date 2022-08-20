package com.mirac.producterChallenge.dto;

import java.io.Serializable;

import com.mirac.producterChallenge.entity.Position;

import lombok.Data;

@Data
public class PlayerDto implements Serializable{

	private String name;
	private String surname;
	private Position position;
	
}