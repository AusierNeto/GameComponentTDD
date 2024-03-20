package Classes;

import java.util.List;

import Interfaces.ArmazenamentoMockInterface;

public class ArmazenamentoMock extends Armazenamento implements ArmazenamentoMockInterface {

	public ArmazenamentoMock() {
		FileHandle.createStorageFile("MockStorage.txt");
	}

	@Override
	public void savePoints(String userName, int numberOfPoints, String pointType) {
		FileHandle.writeInformation("MockStorage.txt", "Usuário " + userName + " recebeu "
				+ numberOfPoints + " ponto(s) do tipo " + pointType);
	}

	public String getAllPointsFromGivenUser(String userName) {
		if (userName == "Usuario")
			return "10 - Star\n10 - Hearts\n10-Flowers";
		else 
			return "Usuário sem pontos";
	}

	public String getRanking(String pointType) {
		if (pointType == "Star")
			return "\"OutroUser\" com \"11\", \"Usuario\" com \"10\"";
		return "\"TerceiroUser\" com \"50\", \"Usuario\" com \"10\"";
	}

	@Override
	public List<String> getLinesFromStorageFile() {
		return FileHandle.readFileLines("MockStorage.txt");
	}

}
