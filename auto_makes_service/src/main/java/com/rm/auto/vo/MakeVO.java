package com.rm.auto.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MakeVO {
	private long makeId;
	private String makeName;
	private String makeCountry;
	private String makeClass;
	private List<ModelVO> models;
}
