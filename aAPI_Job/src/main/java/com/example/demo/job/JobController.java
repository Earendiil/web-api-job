package com.example.demo.job;

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

@RestController
@RequestMapping("/jobs")
public class JobController {
	
	@Autowired
	private JobService jobService;
	
	
	
	
	@GetMapping
	public ResponseEntity<List<Job>>  findAll(){
	//	return new ResponseEntity<List<Job>>(jobService.findAll(), HttpStatus.OK);
		return  ResponseEntity.ok(jobService.findAll());
	}
	@PostMapping
	public ResponseEntity<String> createJob(@RequestBody Job job) {
		jobService.createJob(job);
		return new ResponseEntity<>("Job added successfully",HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Job> getJobById(@PathVariable Long id) {
		
		Job job = jobService.getJobById(id);
		if(job !=null)
			return  ResponseEntity.ok(job);
		return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		boolean deleted = jobService.deleteJobById(id);
		
		if(!deleted) 
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	return new ResponseEntity<>("Deleted successfully!", HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateJob(@PathVariable Long id,
											@RequestBody Job updatedJob){
		boolean updated = jobService.updateJob(id, updatedJob);
		if (updated) 
			return new ResponseEntity<>("Job updated", HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	

