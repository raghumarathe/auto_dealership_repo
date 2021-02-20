package com.rm.auto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rm.auto.entity.Make;
import com.rm.auto.service.AutoMakeService;
import com.rm.auto.vo.MakeVO;
import com.rm.auto.vo.ModelVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/make")
@Slf4j
public class AutoMakesController {
	
	@Autowired
	private AutoMakeService autoMakeService;
	
	@GetMapping(path = "/all")
	public List<Make> getMakes(){
		log.info("in AutoMakesController.getMakes()..");
		return autoMakeService.getAllMakes();
	}
	
	@GetMapping(path = "/{id}")
	public MakeVO getMake(@PathVariable long id){
		log.info("in AutoMakesController.getMake().."+ id);
		MakeVO makeVO = autoMakeService.getMake(id);
		RestTemplate restTemplate = new RestTemplate();
		String GET_MAKES_URL = "http://localhost:8091/model/all";
		ModelVO[] modelList =  restTemplate.getForEntity(GET_MAKES_URL, ModelVO[].class).getBody();
		
		//get models corresponding to make of the searched make id
		List<ModelVO> makeModels = Arrays.asList(modelList).stream()
				.filter(m -> m.getMakeName().equalsIgnoreCase(makeVO.getMakeName()))
				.collect(Collectors.toCollection(ArrayList<ModelVO>::new));
		
		log.info("## modelList ="+makeModels.size());
		makeVO.setModels(makeModels);
		return makeVO;
	}
	
	@PostMapping(path="/add")
	public Make addMake(@RequestBody Make make) {
		log.info("in AutoMakesController.addMake()..");
		return autoMakeService.save(make);
	}
}
