package Classes;

import java.util.ArrayList;
import java.util.List;

public class Armazenamento {

	private List<User> userList;
	
	public Armazenamento() {
		FileHandle.createStorageFile();
		this.userList = new ArrayList<User>();
	}

	public void savePoints(User userObject, int points, String pointType) {
		String savePointsString = "O usuário " + userObject.userName + " recebeu " + 
									points + " pontos do tipo " + pointType;
		FileHandle.writeInformation(savePointsString);
		
		// Save user references
		userObject.receivePoints(points, pointType);
		userList.add(userObject);
	}
	
	public int getPointsFromUserByType(User userObject, String pointType) {
		for (User currentUser: this.userList) {
			if (currentUser.userName == userObject.userName) {
				return currentUser.getPointsByType(pointType);
			}
		}
		return -1;
	}

	public List<String> getAllPointTypeByUser(User testUser) {
		return testUser.getUserPointTypes();
	}

	public List<String> getUsersWithPoints() {
		List<String> usersWithPoints = new ArrayList<String>();
		for (User currentUser: this.userList) {
			int currentUserTotalPoints = 0;
			for (String pointType: getAllPointTypeByUser(currentUser)) {
				currentUserTotalPoints += getPointsFromUserByType(currentUser, pointType);
			}
			if (currentUserTotalPoints > 0) {
				usersWithPoints.add(currentUser.userName);
			}
		}
		return usersWithPoints;
	}

}
