package io.javabrains.controller;

import java.util.List;

import javax.validation.Valid;

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

import io.javabrains.entity.User;
import io.javabrains.exception.ResourceNotFoundExcepetion;
import io.javabrains.repositry.UserRepositry;

@RestController
@RequestMapping("api/users")
public class UserController {
	
	@Autowired
	private UserRepositry  userRepositry;

	
	//get All users
	@GetMapping
	public List<User> getAllUsers(){
		return this.userRepositry.findAll();
		
	}
	//get one user
	@GetMapping("/{id}")
	public User getUser(@PathVariable(value="id")  Long userId) {
		ResourceNotFoundExcepetion x=new ResourceNotFoundExcepetion("user not found with id : " + userId);
		return this.userRepositry.findById(userId)
				.orElseThrow(()->x);	
	}
	
	//create an user
	@PostMapping
	public User createUser(@Valid @RequestBody User user) {
		
		return this.userRepositry.save(user);
	}
	//update an user
	@PutMapping("/{id}")
	public User updateUser(@Valid @RequestBody User user, @PathVariable(value="id")  Long userId) {
		ResourceNotFoundExcepetion x=new ResourceNotFoundExcepetion("user not found with id : " + userId);
		User mm= this.userRepositry.findById(userId)
				.orElseThrow(()->x);
		
		mm.setFirstName(user.getFirstName());
		mm.setEmail(user.getEmail());
		mm.setLastName(user.getLastName());
		
	return	this.userRepositry.save(mm);
		
	}
	//delete an user
	@DeleteMapping("/{id}")
	public ResponseEntity<User> DeleteUser( @PathVariable(value="id")  Long userId) {
		ResourceNotFoundExcepetion x=new ResourceNotFoundExcepetion("user not found with id : " + userId);
		User mm= this.userRepositry.findById(userId)
				.orElseThrow(()->x);
		
		this.userRepositry.delete(mm);
		return ResponseEntity.ok().build();
				
	}
}
