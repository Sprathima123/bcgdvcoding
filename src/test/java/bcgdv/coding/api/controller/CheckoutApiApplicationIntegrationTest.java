package bcgdv.coding.api.controller;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import bcgdv.coding.api.CheckoutController;
import bcgdv.coding.dto.Request;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CheckoutController.class)
public class CheckoutApiApplicationIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void TestAPIRestController() throws Exception {
		List<String> watchIds = Arrays.asList("001", "002", "001", "004", "003");
		Request req = new Request();
		req.setWatchIds(watchIds);
		mockMvc.perform(MockMvcRequestBuilders.post("/checkout")
				.contentType("application/json")
				.content(asJsonString(req)))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.price").value(360));
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
