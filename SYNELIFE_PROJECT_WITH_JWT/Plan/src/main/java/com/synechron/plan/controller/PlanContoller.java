package com.synechron.plan.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.synechron.plan.model.Covers;
import com.synechron.plan.model.Plan;
import com.synechron.plan.model.PlanBenifits;
import com.synechron.plan.model.Response;
import com.synechron.plan.service.PlanService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/plan")
public class PlanContoller {

	@Autowired
	private PlanService service;

	@Autowired
	RestTemplate temp;

	@GetMapping("/get/{id}")
	public ResponseEntity<Plan> getById(@PathVariable Integer id) {
		Plan plan = service.getById(id);
		return new ResponseEntity<>(plan, HttpStatus.OK);
	}

	@GetMapping("/get")
	public ResponseEntity<List<Plan>> getAll() {
		List<Plan> plan = service.getAll();
		return new ResponseEntity<>(plan, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Plan> add(@RequestBody Plan plan) {
		Plan plans = service.save(plan);
		return new ResponseEntity<>(plans, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Plan> update(@RequestBody Plan plan) {
		Plan plans = service.update(plan);
		return new ResponseEntity<>(plans, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		service.deleteById(id);
		return new ResponseEntity<>("Deleted Sucessfully", HttpStatus.OK);
	}

	@GetMapping("/planBenifits/{id}")
	@CircuitBreaker(name = "Customer", fallbackMethod = "getDefaultMsg")
	public ResponseEntity<PlanBenifits> getPlanBenfits(@PathVariable Integer id) {
		PlanBenifits pb = new PlanBenifits();
		Plan plan = service.getById(id);

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		List<Covers> cover = temp.exchange("http://localhost:8081/cover/get/" + id, HttpMethod.GET, entity, List.class)
				.getBody();

		pb.setPlan(plan);
		pb.setCovers(cover);

		return new ResponseEntity<>(pb, HttpStatus.OK);
	}

	public ResponseEntity<Response> getDefaultMsg(Exception e) {
		Response res = new Response();
		res.setMsg("services is down....");
		return new ResponseEntity<Response>(res, HttpStatus.OK);
	}
}
