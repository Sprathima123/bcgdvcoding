package bcgdv.coding.models;

import java.util.ArrayList;
import java.util.List;

public class Request {

	private List<String> watchIds= new ArrayList<String>();

	public List<String> getWatchIds() {
		return watchIds;
	}

	public void setWatchIds(List<String> watchIds) {
		this.watchIds = watchIds;
	}
	
}
