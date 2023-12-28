package com.synechron.covers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synechron.covers.exception.ResourceNotFoundException;
import com.synechron.covers.model.Covers;
import com.synechron.covers.repository.CoversRepository;

@Service
public class CoversService {

	@Autowired
	private CoversRepository repo;

	public Covers getById(int id) {
		return repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
	}

	public List<Covers> getAll() {
		return repo.findAll();
	}

	public Covers add(Covers cover) {
		return repo.save(cover);
	}

	public Covers update(Covers cover) {
		return repo.save(cover);
	}

	public Covers getByName(String name) {
		return repo.findByCoverName(name);
	}

	public void deleteById(Integer id) {
		repo.deleteById(id);
	}

	public List<Covers> getByPlanId(Integer id) {

		return repo.findByPlanId(id);
	}
}
