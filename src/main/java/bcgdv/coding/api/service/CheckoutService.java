package bcgdv.coding.api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import bcgdv.coding.dto.Request;
import bcgdv.coding.dto.Response;
import bcgdv.coding.models.Watch;

@Component
public class CheckoutService {
	
	WatchCatalogue watchCatalogue = WatchCatalogue.getInstance();
	
	public HashMap<String, Integer> countInputWatchIds(List<String> Ids) {
		 HashMap<String, Integer> watchIdCount = new HashMap<String, Integer>();
		 for(int i=0;i<Ids.size(); i++) {
			 String id = Ids.get(i);
			 if(watchIdCount.containsKey(id)) {
				 watchIdCount.put(id, watchIdCount.get(id) + 1);
			 }
			 else {
				 watchIdCount.put(id, 1);
			 }			 
		 }
		 return watchIdCount;
	}
	
	public float[] parseDiscountPrice(String discount) {
		 float[] discountPrice = new float[2];
		 Scanner scanner = new Scanner(discount).useDelimiter("\\D+");
		 discountPrice[0] = scanner.nextInt();
		 discountPrice[1] = scanner.nextInt();
		 return discountPrice;
	}
	
	public Response calculateTotalPrice(Request watchIds) {
		 Response response = new Response();
		 CheckoutService checkoutService = new CheckoutService();
		 float totalPrice = 0;
		 String discount;
		 float[] discountPrice;
		 int numOfProducts;
		 float discountPriceOfProdcuts;
		 
		 List<String> Ids= watchIds.getWatchIds();
		 HashMap<String, Integer> watchIdCount = countInputWatchIds(Ids);
		 
		 for (String key : watchIdCount.keySet() ) {
			    Watch watch = watchCatalogue.getWatchById(key);
			    
			    if(watch!=null) {
			    	if(!watch.getDiscount().isEmpty() && watch.getDiscount()!=null) {
			    	discount = watch.getDiscount();
			    	discountPrice = parseDiscountPrice(discount);
			    	numOfProducts = (int)discountPrice[0];
			    	discountPriceOfProdcuts = discountPrice[1];
			    	
			    	if(watchIdCount.get(key) == (Integer)numOfProducts) {
			    		totalPrice += discountPriceOfProdcuts;
			    	}
			    	else if(watchIdCount.get(key) < (Integer)numOfProducts) {
			    		totalPrice+= watchIdCount.get(key) * watch.getUnitPrice();
			    	}
			    	else {
			    		int rem = (int)watchIdCount.get(key)/numOfProducts;
			    		totalPrice+= rem * discountPriceOfProdcuts;
			    		int quot = (int)watchIdCount.get(key)%numOfProducts;
			    		totalPrice+= quot * watch.getUnitPrice();
			    	}
			    }
			    else {
			    	totalPrice = totalPrice + watchIdCount.get(key)* watch.getUnitPrice();
			    }
			   }
			}
		 response.setPrice(totalPrice);
		 return response; 
	} 
	
}
