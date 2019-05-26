package com.assignment.userresource;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.exception.UserExistException;
import com.assignment.exception.UserNotFoundException;

@Service
public class UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Map<String,String> addUser(User user) throws UserExistException {
		Map<String,String> response=new HashMap<>();
		boolean checkUserExist=userRepository.findByEmail(user.getEmail()).stream().anyMatch(u -> u.isActive()==true);
		if(!checkUserExist) {
			user.setMonth(getMonth(user.getBirthDate()));
			response.put("id", userRepository.save(user).getId());
		}else {
			throw new UserExistException();
		}
		return response;
	}

	public User updateUser(String userId, User user) throws UserNotFoundException {
		User existUser = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException());
		existUser.setPinCode(user.getPinCode());
		existUser.setBirthDate(user.getBirthDate());
		return userRepository.save(existUser);

	}

	public Map<String, String> deleteUser(String id) throws UserNotFoundException {
		User existUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
		existUser.setActive(false);
		Map<String, String> response = new HashMap<String, String>();
		response.put("id", existUser.getId());
		return response;
	}

	public Map<String, Integer> findCountOfMonth(String month) {
		Map<String, Integer> response = new HashMap<String, Integer>();
		response.put("count", userRepository.findByMonth(month).size());
		return response;
	}

	public List<User> getListOfCurrentMonthBithDays(){
		Date date=new Date();
		return userRepository.findByMonth(getMonth(date));
	}
	private String getMonth(Date date) {
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		return localDate.getMonth().name();

	}
}
