package Classes;

import java.util.List;

import Interfaces.ArmazenamentoMockInterface;

public class ArmazenamentoMock implements ArmazenamentoMockInterface {

	public ArmazenamentoMock() {
		FileHandle.createStorageFile("MockStorage.txt");
	}

	@Override
	public List<String> getLinesFromStorageFile() {
		return FileHandle.readFileLines("MockStorage.txt");
	}

	@Override
	public void savePoints(String userName, int numberOfPoints, String pointType) {
		FileHandle.writeInformation("MockStorage.txt", "Usuário " + userName + " recebeu "
				+ numberOfPoints + " ponto(s) do tipo " + pointType);
	}

	@Override
	public String getAllPointsFromGivenUserByType(String userName) {
		if (userName == "Usuario")
			return "10 - Star\n10 - Hearts\n10-Flowers";
		else 
			return "Usuário sem pontos";
	}

}
