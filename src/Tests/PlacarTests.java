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
		p.registerPoints("Usuario", 10, "Star");
		assertEquals("Usuário Usuario recebeu 10 pontos do tipo Star", 
				p.getFileLines());
	}

}
