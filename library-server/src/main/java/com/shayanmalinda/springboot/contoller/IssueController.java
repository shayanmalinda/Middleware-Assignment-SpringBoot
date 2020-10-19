package com.shayanmalinda.springboot.contoller;

import com.shayanmalinda.springboot.entity.Issue;
import com.shayanmalinda.springboot.exception.ResourceNotFoundException;
import com.shayanmalinda.springboot.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/issues")
public class IssueController {

	@Autowired
	private IssueRepository issueRepository;
	
	// get all issues' details
	@GetMapping
	public List<Issue> getAllIssues() {
		return this.issueRepository.findAll();
				
	}
	
	// get get Issue details by issue id
	@GetMapping("/{id}")
	public Issue getIssueById(@PathVariable (value="id") long issueId) {
		return this.issueRepository.findById(issueId)
				.orElseThrow(() -> new ResourceNotFoundException("Issue not found with issue id :"+issueId));
	}
		
	// create a new issue
	@PostMapping
	public Issue createIssue(@RequestBody Issue issue) {
		return this.issueRepository.save(issue);
	}


	
	// delete issue by issue id
	@DeleteMapping("/{id}")
	public ResponseEntity<Issue> deleteIssue(@PathVariable ("id") long issueId) {
		Issue existingIssue =  this.issueRepository.findById(issueId)
				.orElseThrow(() -> new ResourceNotFoundException("Issue not found with issue id :"+issueId));
		this.issueRepository.delete(existingIssue);
		return ResponseEntity.ok().build();
	}
}
