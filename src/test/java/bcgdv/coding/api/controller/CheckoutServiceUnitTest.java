package bcgdv.coding.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.Map.entry;    

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import bcgdv.coding.api.service.CheckoutService;
import bcgdv.coding.models.Watch;

public class CheckoutServiceUnitTest {

	@Test
	 void testCountInputWatchIds() { 	
		CheckoutService checkoutService = new CheckoutService();
		List<String> watchIds = Arrays.asList("001", "001");
		HashMap<String, Integer> actual =checkoutService.countInputWatchIds(watchIds);
		Map<String, Integer> expected = Map.ofEntries(entry("001", 2)); 
		assertEquals(expected.toString(), actual.toString()); 
	}
	
	@Test
	void testGetWatchById() {
		CheckoutService checkoutService = new CheckoutService();
		Watch actual = checkoutService.getWatchById("001");
		Watch expected = new Watch("001", "Rolex", 100, "3 for 200");
		assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
	}
}
