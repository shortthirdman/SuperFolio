package com.shortthirdman.superfolio;

import static org.assertj.core.api.Assertions.assertThat;

import com.shortthirdman.superfolio.controller.UserProfileController;
import com.shortthirdman.superfolio.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
class SuperFolioApplicationTests {

	@Autowired
	private UserProfileController controller;

	@Autowired
	private UserService service;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
		assertThat(service).isNotNull();
	}

}
