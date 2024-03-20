package Classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

	private Map<String, Integer> pointsDict = new HashMap<>();
	public String userName;
	
	public User(String userNameString ) {
		this.userName = userNameString;
	}
	
	public void receivePoints(int points, String pointType) {
		if (this.pointsDict.containsKey(pointType))
			this.pointsDict.merge(pointType, points, Integer::sum);
		else
			this.pointsDict.put(pointType, points);
	}
	
	public int getPointsByType(String pointType) {
		return this.pointsDict.get(pointType);
	}
	
	public List<String> getUserPointTypes() {
		List<String> typesList = new ArrayList<>(this.pointsDict.keySet());
		return typesList;
	}

}
