package com.assignment.SpringbootAssignment;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.assignment.exception.UserExistException;
import com.assignment.exception.UserNotFoundException;
import com.assignment.userresource.User;
import com.assignment.userresource.UserRepository;
import com.assignment.userresource.UserService;

@SpringBootTest
public class UserServiceTest {

	@Mock
	UserRepository userRepository;

	@InjectMocks
	UserService userService;

	@Mock
	User user;
	@Mock
	Map<String,String> response;
	

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	response=new HashMap<>();
		user = new User();
		user.setBirthDate(new Date("22-May-2007"));
		user.setEmail("test@er.com");
		user.setfName("test");
		user.setlName("ddd");
		user.setPinCode(85555);
	}

	@Test(expected = NullPointerException.class)
	public void addUserTest() throws UserExistException {
		
		userService.addUser(user);
		
		verify(userRepository).findByEmail(user.getEmail());
		assertEquals(response, userService.addUser(user));
	}
	
	@Test(expected=UserNotFoundException.class)
	public void updateUser() throws UserNotFoundException {
		Mockito.when(userRepository.findById("2111118878")).thenReturn(Optional.of(user));
		assertEquals(user, userService.updateUser("21321312313", user));
	}
}
