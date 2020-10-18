package com.shayanmalinda.springboot.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shayanmalinda.springboot.entity.User;
import com.shayanmalinda.springboot.exception.ResourceNotFoundException;
import com.shayanmalinda.springboot.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	// get all users' details
	@GetMapping
	public List<User> getAllUsers() {
		return this.userRepository.findAll();
				
	}
	
	// get user details by user id
	@GetMapping("/{id}")
	public User getUserById(@PathVariable (value="id") long userId) {
		return this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with user id :"+userId));
	}
		
	// create a new user
	@PostMapping
	public User createUser(@RequestBody User user) {
		return this.userRepository.save(user);
	} 
	
	// update user details
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user, @PathVariable ("id") long userId) {
		User existingUser =  this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with user id :"+userId));
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		existingUser.setNic(user.getNic());
		existingUser.setPhoneNo(user.getPhoneNo());
		return this.userRepository.save(existingUser);
	}
	
	// delete user by user id
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable ("id") long userId) {
		User existingUser =  this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with user id :"+userId));
		this.userRepository.delete(existingUser);
		return ResponseEntity.ok().build();
	}
}
