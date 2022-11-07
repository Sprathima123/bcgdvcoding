package bcgdv.coding.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bcgdv.coding.api.service.CheckoutService;
import bcgdv.coding.models.Request;
import bcgdv.coding.models.Response;
import bcgdv.coding.models.Watch;

@RestController
@ComponentScan("bcgdv.coding.api")
public class CheckoutController {
	
	@Autowired
	CheckoutService checkoutService;
	
	@PostMapping("/checkout")
	public Response calculateTotalPrice(@RequestBody Request watchIds) {
		 return checkoutService.calculateTotalPrice(watchIds);
	}
}
