package com.rm.auto.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Model {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long modelId;
	private String modelName;
	private String makeName;
}
