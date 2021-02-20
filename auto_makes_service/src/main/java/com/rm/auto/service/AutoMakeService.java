package com.rm.auto.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rm.auto.entity.Make;
import com.rm.auto.repository.AutoMakeRepository;
import com.rm.auto.vo.MakeVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AutoMakeService {
	
	@Autowired
	AutoMakeRepository autoMakeRepository;
	
	public List<Make> getAllMakes(){
		log.info("in AutoMakeService.getMakes()..");
		return (List<Make>)autoMakeRepository.findAll();
	}
	
	public MakeVO getMake(long makeId){
		log.info("in AutoMakeService.getMake()..");
		Make make = autoMakeRepository.findById(makeId).orElse(new Make());
		MakeVO makeVO = new MakeVO();
		try {
			BeanUtilsBean.getInstance().copyProperties(makeVO, make);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return makeVO;
	}
	
	public Make save(Make make){
		log.info("in AutoMakeService.save()..");
		return autoMakeRepository.save(make);
	}
}
