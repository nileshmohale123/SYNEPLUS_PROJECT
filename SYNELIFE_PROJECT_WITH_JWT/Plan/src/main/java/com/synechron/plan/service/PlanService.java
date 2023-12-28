package com.synechron.plan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synechron.plan.exception.ResourceNotFoundException;
import com.synechron.plan.model.Plan;
import com.synechron.plan.repository.PlanRepository;

@Service
public class PlanService {

	@Autowired
	private PlanRepository repo;

	public Plan save(Plan plan) {
		return repo.save(plan);
	}

	public List<Plan> getAll() {
		return repo.findAll();
	}

	public Plan getById(Integer id) {
		return repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
	}

	public Plan update(Plan plan) {
		return repo.save(plan);
	}

	public void deleteById(Integer id) {
		repo.deleteById(id);
	}
}
