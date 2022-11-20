package bcgdv.coding.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bcgdv.coding.api.service.CheckoutService;
import bcgdv.coding.api.service.WatchCatalogue;
import bcgdv.coding.dto.Request;
import bcgdv.coding.dto.Response;
import bcgdv.coding.models.Watch;

@RestController
@ComponentScan("bcgdv.coding.api")
public class CheckoutController {
	
	@Autowired
	CheckoutService checkoutService;
	
	@Autowired
	WatchCatalogue watchCatalogue;
	
	@PostMapping("/checkout")
	public Response calculateTotalPrice(@RequestBody Request watchIds) {
		 return checkoutService.calculateTotalPrice(watchIds);
	}
	
	@GetMapping("/watches")
	public List<Watch> getWatches() {
		 return watchCatalogue.getWatchCatalogue();
	}
	
	@PostMapping("/add")
	public List<Watch> addWatch(@RequestBody Watch watch) {
		 return watchCatalogue.addWatch(watch);
	}
	
}
