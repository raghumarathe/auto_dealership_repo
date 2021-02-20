package com.rm.auto.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rm.auto.entity.Model;
import com.rm.auto.repository.AutoModelRepository;
import com.rm.auto.vo.ModelVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AutoModelService {

	@Autowired
	private AutoModelRepository autoModelRepository;
	
	public List<ModelVO> getAllModels(){
		log.info("in AutoModelService.getAllModels method..");
		List<ModelVO> modelVos = new ArrayList<ModelVO>();
		try {
			List<Model> models = (List<Model>)autoModelRepository.findAll();
			
			log.info("model entity list="+models.size());
			
			BeanUtilsBean beanUtil = BeanUtilsBean.getInstance();
			for(Model model : models) {
				ModelVO modelVO = new ModelVO();
				beanUtil.copyProperties(modelVO, model);
				modelVos.add(modelVO);
			}
			
			log.info("model vo list="+modelVos.size());
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return modelVos;
	}
}
