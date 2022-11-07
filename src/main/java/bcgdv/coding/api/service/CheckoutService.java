package bcgdv.coding.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import bcgdv.coding.models.Watch;

@Component
public class CheckoutService {
	
	private List<Watch> watchCatalogue = new ArrayList<Watch>();
	
	public CheckoutService() {
		watchCatalogue.add(new Watch("001", "Rolex", 100, "3 for 200"));
		watchCatalogue.add(new Watch("002", "Michael Kors", 80, "2 for 120"));
		watchCatalogue.add(new Watch("003", "Swatch", 50, ""));
		watchCatalogue.add(new Watch("004", "Casio", 30, ""));
	}
	
	public List<Watch> getAllWatches() {	
		return watchCatalogue;
	}
	
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
	
}
