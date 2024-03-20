package Classes;

import java.util.List;

import Interfaces.ArmazenamentoMockInterface;

public class ArmazenamentoMock implements ArmazenamentoMockInterface {

	public ArmazenamentoMock() {
		FileHandle.createStorageFile("MockStorage.txt");
	}

	@Override
	public List<String> getLinesFromStorageFile() {
		// TODO Auto-generated method stub
		return FileHandle.readFileLines("MockStorage.txt");
	}

	@Override
	public void savePoints(String userName, int numberOfPoints, String pointType) {
		FileHandle.writeInformation("MockStorage.txt", "Usuário " + userName + " recebeu " + numberOfPoints + " ponto(s) do tipo " + pointType);
	} 

}
