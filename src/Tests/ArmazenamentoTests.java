package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Classes.Armazenamento;
import Classes.User;

class ArmazenamentoTests {
	Armazenamento storage;
	String testUser;
	
	@BeforeEach
	void testSetup() {
		storage = new Armazenamento();
		testUser = "Player1";
	}

	@Test
	void storagePointsOfSingleTypeOnJustOneUser() {
		int points = 10;
		String pointType = "Star";
		storage.savePoints(testUser, points, pointType);
		assertEquals(10, storage.getPointsFromUserByType(testUser, pointType));
	}
	
	@Test
	void storagePointsOfMultipleTypesOnSameUser() {
		int points = 10;
		String pointTypeFirst = "Star";
		String pointTypeSecond = "Hearts";
		storage.savePoints(testUser, points, pointTypeFirst);
		assertEquals(10, storage.getPointsFromUserByType(testUser, pointTypeFirst));
		storage.savePoints(testUser, points, pointTypeSecond);
		assertEquals(10, storage.getPointsFromUserByType(testUser, pointTypeSecond));
	} 
	
	
	@Test
	void storeMultiplePointsOfSameTypeOnSameUser() {
		int points = 10;
		String pointType = "Star";
		
		storage.savePoints(testUser, points, pointType);
		assertEquals(10, storage.getPointsFromUserByType(testUser, pointType));
		storage.savePoints(testUser, points, pointType);
		assertEquals(20, storage.getPointsFromUserByType(testUser, pointType));
		
	}
	
	@Test
	void getAllPointTypeForSpecificUser() {
		storage.savePoints(testUser, 1, "Star");
		storage.savePoints(testUser, 1, "Coin");
		storage.savePoints(testUser, 1, "Hearts");
		assertEquals(true, storage.getAllPointTypeByUser(testUser).contains("Star"));
		assertEquals(true, storage.getAllPointTypeByUser(testUser).contains("Coin"));
		assertEquals(true, storage.getAllPointTypeByUser(testUser).contains("Hearts"));
	}
	
	@Test
	void getAllUsersWithPoints() {
		storage.savePoints(testUser, 0, "Hearts");
		String genericUserName = "NoPointsPlayer";
		storage.savePoints(genericUserName, 1, "Star");
		assertEquals(false, storage.getUsersWithPoints().contains(testUser));
		assertEquals(true, storage.getUsersWithPoints().contains(genericUserName));
	}
	
	@Test
	void everyUserHaveZeroPoints() {
		storage.savePoints(testUser, 0, "Hearts");
		String genericUserName = "NoPointsPlayer";
		storage.savePoints(genericUserName, 0, "Star");
		assertEquals(false, storage.getUsersWithPoints().contains(testUser));
		assertEquals(false, storage.getUsersWithPoints().contains(genericUserName));
	}
	
	@Test
	void everyUserHaveAtLeastOnePoint() {
		storage.savePoints(testUser, 1, "Hearts");
		String genericUserName = "NoPointsPlayer";
		storage.savePoints(genericUserName, 1, "Star");
		assertEquals(true, storage.getUsersWithPoints().contains(testUser));
		assertEquals(true, storage.getUsersWithPoints().contains(genericUserName));
	}

}
