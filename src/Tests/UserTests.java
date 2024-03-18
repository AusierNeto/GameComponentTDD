package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Classes.User;


class UserTests {

	User user;
	
	@BeforeEach
	void setup() {
		user = new User("Player");
	}
	
	@Test
	void getUserRecevedPoints() {
		user.receivePoints(10, "Star");
		assertEquals(10, user.getPointsByType("Star"));
	}
	
	@Test 
	void addPointsOfTwoDifferentTypes() {
		user.receivePoints(10, "Star");
		assertEquals(10, user.getPointsByType("Star"));
		user.receivePoints(20, "Hearts");
		assertEquals(20, user.getPointsByType("Hearts"));
	}
	
	@Test
	void receiveMultiplePointsOfTheSameType() {
		user.receivePoints(10, "Star");
		assertEquals(10, user.getPointsByType("Star"));
		user.receivePoints(10, "Star");
		assertEquals(20, user.getPointsByType("Star"));
	}

}
