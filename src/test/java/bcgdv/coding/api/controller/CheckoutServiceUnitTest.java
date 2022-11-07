package bcgdv.coding.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.Map.entry;    

import org.junit.jupiter.api.Test;

import bcgdv.coding.api.service.CheckoutService;

public class CheckoutServiceUnitTest {

	@Test
	 void testCountInputWatchIds() { 	
		CheckoutService checkoutService = new CheckoutService();
		List<String> watchIds = Arrays.asList("001", "001");
		HashMap<String, Integer> actual =checkoutService.countInputWatchIds(watchIds);
		Map<String, Integer> expected = Map.ofEntries(entry("001", 2)); 
		assertEquals(expected.toString(), actual.toString()); 
	}
}
