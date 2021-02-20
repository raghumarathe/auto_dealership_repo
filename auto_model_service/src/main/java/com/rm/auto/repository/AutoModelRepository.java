package com.rm.auto.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rm.auto.entity.Model;

@Repository
public class AutoModelRepository implements CrudRepository<Model, Long>{

	private static List<Model> models = new ArrayList<Model>();
	
	static {
		models.addAll(Arrays.asList(
				new Model(1, "Camry", "Toyota"),
				new Model(2, "RAV4", "Toyota"),
				new Model(3, "Accord", "Toyota"),
				new Model(4, "CRV", "Toyota"),
				new Model(5, "T1", "Tesla"),
				new Model(6, "CX5", "BMW")));
	}
	
	@Override
	public <S extends Model> S save(S entity) {
		// TODO Auto-generated method stub
		models.add(entity);
		return entity;
	}

	@Override
	public <S extends Model> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Model> findById(Long id) {
		return models.parallelStream().filter(m -> m.getModelId() == id).findFirst();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Model> findAll() {
		return models;
	}

	@Override
	public Iterable<Model> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Model entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Model> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
