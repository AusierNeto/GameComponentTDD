package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Classes.Armazenamento;
import Classes.User;

class ArmazenamentoTests {
	Armazenamento storage;
	String testUserNameString;
	
	@BeforeEach
	void testSetup() {
		storage = new Armazenamento();
		testUserNameString = "Player1";
	}

	@Test
	void storagePointsOfSingleTypeOnJustOneUser() {
		int points = 10;
		String pointType = "Star";
		storage.savePoints(testUserNameString, points, pointType);
		assertEquals(10, storage.getPointsFromUserByType(testUserNameString, pointType));
	}
	
	@Test
	void storagePointsOfMultipleTypesOnSameUser() {
		int points = 10;
		String pointTypeFirst = "Star";
		String pointTypeSecond = "Hearts";
		storage.savePoints(testUserNameString, points, pointTypeFirst);
		assertEquals(10, storage.getPointsFromUserByType(testUserNameString, pointTypeFirst));
		storage.savePoints(testUserNameString, points, pointTypeSecond);
		assertEquals(10, storage.getPointsFromUserByType(testUserNameString, pointTypeSecond));
	} 
	
	
	@Test
	void storeMultiplePointsOfSameTypeOnSameUser() {
		int points = 10;
		String pointType = "Star";
		
		storage.savePoints(testUserNameString, points, pointType);
		assertEquals(10, storage.getPointsFromUserByType(testUserNameString, pointType));
		storage.savePoints(testUserNameString, points, pointType);
		assertEquals(20, storage.getPointsFromUserByType(testUserNameString, pointType));
		
	}
	
	@Test
	void getAllPointTypeForSpecificUser() {
		storage.savePoints(testUserNameString, 1, "Star");
		storage.savePoints(testUserNameString, 1, "Coin");
		storage.savePoints(testUserNameString, 1, "Hearts");
		assertEquals(true, storage.getAllPointTypeByUser(testUserNameString).contains("Star"));
		assertEquals(true, storage.getAllPointTypeByUser(testUserNameString).contains("Coin"));
		assertEquals(true, storage.getAllPointTypeByUser(testUserNameString).contains("Hearts"));
	}
	
	@Test
	void getAllUsersWithPoints() {
		storage.savePoints(testUserNameString, 0, "Hearts");
		String genericUserName = "NoPointsPlayer";
		storage.savePoints(genericUserName, 1, "Star");
		assertEquals(false, storage.getUsersWithPoints().contains(testUserNameString));
		assertEquals(true, storage.getUsersWithPoints().contains(genericUserName));
	}
	
	@Test
	void everyUserHaveZeroPoints() {
		storage.savePoints(testUserNameString, 0, "Hearts");
		String genericUserName = "NoPointsPlayer";
		storage.savePoints(genericUserName, 0, "Star");
		assertEquals(false, storage.getUsersWithPoints().contains(testUserNameString));
		assertEquals(false, storage.getUsersWithPoints().contains(genericUserName));
	}
	
	@Test
	void everyUserHaveAtLeastOnePoint() {
		storage.savePoints(testUserNameString, 1, "Hearts");
		String genericUserName = "NoPointsPlayer";
		storage.savePoints(genericUserName, 1, "Star");
		assertEquals(true, storage.getUsersWithPoints().contains(testUserNameString));
		assertEquals(true, storage.getUsersWithPoints().contains(genericUserName));
	}

}
