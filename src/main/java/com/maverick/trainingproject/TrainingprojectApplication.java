package com.maverick.trainingproject;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrainingprojectApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(TrainingprojectApplication.class, args);
		Runtime.getRuntime().exec("cmd /C start npm_run_watch.bat");
	}

}
