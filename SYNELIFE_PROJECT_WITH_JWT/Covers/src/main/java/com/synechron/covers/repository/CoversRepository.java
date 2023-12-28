package com.synechron.covers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synechron.covers.model.Covers;

@Repository
public interface CoversRepository extends JpaRepository<Covers, Integer>{

	public Covers findByCoverName(String name);

	public List<Covers> findByPlanId(Integer id);

}
