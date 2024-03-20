package Classes;

import java.util.List;

public class Placar {

	private ArmazenamentoMock mockClass = new ArmazenamentoMock();
	
	public Placar(ArmazenamentoMock mockArmazenamento) {
		this.mockClass = mockArmazenamento;
	}

	public void registerPoints(String userName, String pointType, int numberOfPoints) {
		this.mockClass.savePoints(userName, numberOfPoints, pointType);
	}

	public List<String> getFileLines() {
		return mockClass.getLinesFromStorageFile();
	}

	public String getAllPointsOfUser(String userName) {
		return mockClass.getAllPointsFromGivenUserByType(userName);
	}

}
