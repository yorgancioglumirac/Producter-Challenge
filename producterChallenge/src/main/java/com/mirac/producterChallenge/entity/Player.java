package com.mirac.producterChallenge.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Table;


@Entity
@Table(name = "player")
@Getter
@Setter
@RequiredArgsConstructor
public class Player implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 100, name = "name")
	private String name;
	
	@Column(length = 100, name = "surname")
	private String surname;
	
	@Column(length = 100, name = "position")
	private Position position;

	@Column(length = 100, name = "createdAt")
	private Date createdAt;

}
