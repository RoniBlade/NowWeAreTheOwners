package com.nowweareowner.nowweareowner;

import com.nowweareowner.nowweareowner.impl.UserInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class NowweareownerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NowweareownerApplication.class, args);

		UserInterface userInterface = new UserInterface();
		userInterface.UserInput();


	}
}
