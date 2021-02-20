package com.rm.auto.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rm.auto.entity.Make;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class AutoMakeRepository implements CrudRepository<Make, Long> {

	private static List<Make> makes = new ArrayList<Make>();
	static {
		makes.addAll(Arrays.asList(
				new Make(1, "Toyota", "Japan", "Economy"),
				new Make(2, "Honda", "Japan", "Economy"),
				new Make(3, "Tesla", "US", "Premium")));
	}
	
	@Override
	public <S extends Make> S save(S entity) {
		makes.add(entity);
		return entity;
	}

	@Override
	public <S extends Make> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Make> findById(Long id) {
		return makes.stream().filter(m -> (m.getMakeId()==id)).findFirst();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Make> findAll() {
		log.info("in AutoMakeRepository.getMakes()..");
		return makes;
	}

	@Override
	public Iterable<Make> findAllById(Iterable<Long> ids) {
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
	public void delete(Make entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Make> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	
}
