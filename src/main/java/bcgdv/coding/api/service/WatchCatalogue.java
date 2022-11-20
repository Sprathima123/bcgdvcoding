package bcgdv.coding.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import bcgdv.coding.models.Watch;

@Component
public class WatchCatalogue {
	
	private static WatchCatalogue instance;
	private List<Watch> watchCatalogue = new ArrayList<Watch>();

	private WatchCatalogue() {
		watchCatalogue.add(new Watch("001", "Rolex", 100, "3 for 200"));
		watchCatalogue.add(new Watch("002", "Michael Kors", 80, "2 for 120"));
		watchCatalogue.add(new Watch("003", "Swatch", 50, ""));
		watchCatalogue.add(new Watch("004", "Casio", 30, ""));
	}
	
	public static WatchCatalogue getInstance(){
		if (instance == null)
			instance = new WatchCatalogue();
	    return instance;
	}
	
	public List<Watch> getWatchCatalogue() {
		return instance.watchCatalogue;
	}

	public List<Watch> addWatch(Watch watch) {	
		instance.watchCatalogue.add(watch);
		return instance.watchCatalogue;	
	}
	
	public Watch getWatchById(String watchId) {
		Predicate<Watch> wid = p -> p.getWatchId().equals(watchId);
		return filterWatches(wid);
	}
	
	private Watch filterWatches(Predicate<Watch> strategy) {
		return instance.watchCatalogue.stream().filter(strategy).findFirst().orElse(null);
	}
}
