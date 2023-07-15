package com.nowweareowner.nowweareowner;

import com.nowweareowner.nowweareowner.impl.UserInterface;
import com.nowweareowner.nowweareowner.impl.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

public class NowweareownerApplication {

	public static void main(String[] args) {
		UserService userService = new UserService();
		UserInterface userInterface = new UserInterface(userService);

		userInterface.userInput();
		userInterface.userInput();

		userInterface.closeScan();
	}

}
