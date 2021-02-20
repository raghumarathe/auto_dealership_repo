package com.rm.auto.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Make {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long makeId;
	private String makeName;
	private String makeCountry;
	private String makeClass;
}
