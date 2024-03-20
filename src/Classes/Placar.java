package Classes;

import java.util.List;

public class Placar {

	private ArmazenamentoMock mockClass;
	private Armazenamento armazenamentoObject; 
	
	public Placar(ArmazenamentoMock mockArmazenamento) {
		this.mockClass = mockArmazenamento;
	}
	
	public Placar(Armazenamento armazenamentoObject) {
		this.armazenamentoObject = armazenamentoObject;
	}

	public void registerPoints(String userName, String pointType, int numberOfPoints) {
		if (this.mockClass != null)
			this.mockClass.savePoints(userName, numberOfPoints, pointType);
		else {
			
		}
	}

	public List<String> getFileLines() {
		return mockClass.getLinesFromStorageFile();
	}

	public String getAllPointsOfUser(String userName) {
		return mockClass.getAllPointsFromGivenUserByType(userName);
	}

	public String getRanking(String pointType) {
		return mockClass.getRanking(pointType);
	}

}
