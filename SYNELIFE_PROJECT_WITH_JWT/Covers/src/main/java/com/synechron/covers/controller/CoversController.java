package com.synechron.covers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synechron.covers.model.Covers;
import com.synechron.covers.service.CoversService;

@RestController
@RequestMapping("/cover")
public class CoversController {

	@Autowired
	private CoversService service;

	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Covers> getById(@PathVariable Integer id) {
		Covers cover = service.getById(id);
		return new ResponseEntity<>(cover, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<List<Covers>> getByPlanId(@PathVariable Integer id) {
		List<Covers> cover = service.getByPlanId(id);
		return new ResponseEntity<>(cover, HttpStatus.OK);
	}

	/*
	 * @GetMapping("/get/{name}") public ResponseEntity<Covers>
	 * getByName(@PathVariable String name) { Covers cover =
	 * service.getByName(name);
	 * 
	 * return new ResponseEntity<>(cover, HttpStatus.OK); }
	 */

	@GetMapping("/get")
	public ResponseEntity<List<Covers>> getAll() {
		List<Covers> cover = service.getAll();
		return new ResponseEntity<>(cover, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Covers> add(@RequestBody Covers cover) {
		Covers covers = service.add(cover);
		return new ResponseEntity<>(covers, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Covers> update(@RequestBody Covers cover) {
		Covers covers = service.update(cover);
		return new ResponseEntity<>(covers, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id){
		service.deleteById(id);
		return new ResponseEntity<>("Cover deleted Successfully", HttpStatus.OK);
	}
}
