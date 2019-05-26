package com.assignment.userresource;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.exception.UserExistException;
import com.assignment.exception.UserNotFoundException;

@RestController
@RequestMapping("/api")
public class UserResource {

	private final UserService userService;

	@Autowired
	public UserResource(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/add-user")
	public Map<String, String> addUser(@Validated @RequestBody User user) throws UserExistException {
		return userService.addUser(user);
	}

	@PutMapping("/update-user/{id}")
	public User updateUser(@PathVariable String id, @Validated @RequestBody User user) throws UserNotFoundException {
		return userService.updateUser(id, user);
	}

	@DeleteMapping("/delete-user/{id}")
	public Map<String, String> deleteUser(@PathVariable String id) throws UserNotFoundException {
		return userService.deleteUser(id);
	}

	@GetMapping("/count/{month}")
	public Map<String, Integer> findByMonth(@PathVariable String month) {
		return userService.findCountOfMonth(month);

	}
	@GetMapping("/current-month/birthdays")
	public List<User> currentMonthBirthDays(){
		return userService.getListOfCurrentMonthBithDays();
	}
}
