package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Classes.Armazenamento;
import Classes.Placar;


class IntegrationTests {

	Placar placar;
	Armazenamento armazenamento;
	String testUserNameString = "GenericUser";
	
	@BeforeEach
	void testSetup() {
		// Initialize the tests with ArmazenamentoClass
		armazenamento = new Armazenamento();
		placar = new Placar(armazenamento);
	}
	
	@Test
	void savePointsOfSingleTypeOnJustOneUser() {
		int points = 10;
		String pointType = "Star";
		placar.registerPoints(testUserNameString, pointType, points);
		assertEquals("10 pontos do tipo Star\n", placar.getAllPointsOfUser(testUserNameString));
	}
	
	@Test
	void savePointsOfMultipleTypesOnSingleUser() {
		placar.registerPoints(testUserNameString, "Star", 10);
		assertEquals("10 pontos do tipo Star\n", placar.getAllPointsOfUser(testUserNameString));
		placar.registerPoints(testUserNameString, "Flowers", 5);
		assertEquals("10 pontos do tipo Star\n5 pontos do tipo Flowers\n", placar.getAllPointsOfUser(testUserNameString));
	}
	
	@Test
	void getRankingForPointType() {
		placar.registerPoints(testUserNameString, "Star", 10);
		placar.registerPoints("AnotherUser", "Star", 5);
		
		//"guerra" com "25", "fernandes" com "19" e "rodrigo" com "17"
		assertEquals(testUserNameString + " com 10, AnotherUser com 5", placar.getRanking("Star"));
	}

}
