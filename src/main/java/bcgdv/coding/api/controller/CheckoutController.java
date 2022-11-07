package bcgdv.coding.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import bcgdv.coding.api.service.CheckoutService;
import bcgdv.coding.models.Watch;

@RestController
@ComponentScan("bcgdv.coding.api")
public class CheckoutController {
	
	@Autowired
	CheckoutService checkoutService;
	
	@GetMapping("/watches")
	 public List<Watch> getAllWatches() {
		 return checkoutService.getAllWatches();
	 }
}
