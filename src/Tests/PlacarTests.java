package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Classes.ArmazenamentoMock;
import Classes.Placar;


class PlacarTests {

	private Placar p;
	
	@BeforeEach
	void setup() {
		ArmazenamentoMock mockArmazenamento = new ArmazenamentoMock();
		p = new Placar(mockArmazenamento);
	}
	
	@Test
	void receivePointsByUser() {
		p.registerPoints("Usuario", "Star", 10);
		assertEquals("Usuário Usuario recebeu 10 ponto(s) do tipo Star", 
				p.getFileLines().get(0));
	}
	
	@Test
	void getAllUserPointsByType() {
		p.registerPoints("Usuario", "Star", 10);
		p.registerPoints("Usuario", "Hearts", 10);
		p.registerPoints("Usuario", "Flowers", 10);
		assertEquals("10 - Star\n10 - Hearts\n10-Flowers", 0); p.getAllPointsOfUser("Usuario");
	}

}
