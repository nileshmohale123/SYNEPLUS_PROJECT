package com.synechron.plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synechron.plan.model.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer>{

}
