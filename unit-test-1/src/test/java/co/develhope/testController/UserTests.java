package co.develhope.testController;

import co.develhope.testController.controller.HomeController;
import co.develhope.testController.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class UserTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

	@Test
	public void getAll() throws Exception {
		this.mockMvc.perform(get("/users")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void getSingle() throws Exception {
		this.mockMvc.perform(get("/users/1")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void create() throws Exception {
		this.mockMvc.perform(post("/users")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void update() throws Exception {
		this.mockMvc.perform(put("/users/1")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void delete() throws Exception {
		this.mockMvc.perform(delete("/users")).andDo(print()).andExpect(status().isOk());
	}

}
