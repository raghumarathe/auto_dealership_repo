package com.rm.auto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rm.auto.service.AutoModelService;
import com.rm.auto.vo.ModelVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path="/model")
@Slf4j
public class AutoModelController {
	
	@Autowired
	private AutoModelService autoModelService; 
	
	@GetMapping(path="/all")
	public List<ModelVO> getModels(){
		log.info("in AutoModelController.getModels method..");
		return autoModelService.getAllModels();
	}
}
