package Classes;

import java.util.ArrayList;
import java.util.List;

import Interfaces.ArmazenamentoInterface;

public class Armazenamento implements ArmazenamentoInterface{

	private List<User> userList;
	
	public Armazenamento() {
		FileHandle.createStorageFile();
		this.userList = new ArrayList<User>();
	}

	private User searchForUserInList(String userName) {
		for (User currentUser: this.userList) {
			if (currentUser.userName == userName) {
				return currentUser;
			}
		}
		return null;
	}
	
	private void updateUserReferences(String userName, int points, String pointType) {
		User userReference = searchForUserInList(userName);
		if (userReference != null)
			userReference.receivePoints(points, pointType);
		else {
			User userObject = new User(userName);
			userObject.receivePoints(points, pointType);
			userList.add(userObject);
		}
	}

	@Override
	public void savePoints(String userName, int points, String pointType) {
		String savePointsString = "Usuário " + userName + " recebeu " + 
				points + " ponto(s) do tipo " + pointType;
		FileHandle.writeInformation(savePointsString);
		this.updateUserReferences(userName, points, pointType);
	}

	@Override
	public int getPointsFromUserByType(String userName, String pointType) {
		for (User currentUser: this.userList) {
			if (currentUser.userName == userName) {
				return currentUser.getPointsByType(pointType);
			}
		}
		return 0;
	}

	@Override
	public List<String> getAllPointTypeByUser(String userName) {
		for (User currentUser: this.userList) {
			if (currentUser.userName == userName) {
				return currentUser.getUserPointTypes();
			}
		}
		
		return null;
	}
	
	public List<String> getUsersWithPoints() {
		List<String> usersWithPoints = new ArrayList<String>();
		for (User currentUser: this.userList) {
			int currentUserTotalPoints = 0;
			for (String pointType: getAllPointTypeByUser(currentUser.userName)) {
				currentUserTotalPoints += getPointsFromUserByType(currentUser.userName,
						pointType);
			}
			if (currentUserTotalPoints > 0) {
				usersWithPoints.add(currentUser.userName);
			}
		}
		return usersWithPoints;
	}

	@Override
	public String getAllPointsFromGivenUser(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRanking(String pointType) {
		// TODO Auto-generated method stub
		return null;
	}

}
