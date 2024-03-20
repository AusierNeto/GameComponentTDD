package Classes;

import java.util.ArrayList;
import java.util.List;

public class Placar {

	//private ArmazenamentoMock mockClass;
	private Armazenamento armazenamentoObject; 
	
	public Placar(ArmazenamentoMock mockArmazenamento) {
		this.armazenamentoObject = mockArmazenamento;
	}
	
	public Placar(Armazenamento armazenamentoObject) {
		this.armazenamentoObject = armazenamentoObject;
	}

	public void registerPoints(String userName, String pointType, int numberOfPoints) {
		if (this.armazenamentoObject != null)
			this.armazenamentoObject.savePoints(userName, numberOfPoints, pointType);
		else {
			
		}
	}
	
	private String formatPointsOutput(List<String> pointTypes, List<Integer> pointsQty) {
		String outputString = "";
		for (int i=0;i<pointTypes.size();i++) {
			outputString += pointsQty.get(i) + " pontos do tipo " + pointTypes.get(i) + "\n";
		}
		return outputString;
	}

	public String getAllPointsOfUser(String userName) {
		List<String> pointTypes = this.armazenamentoObject.getAllPointTypeByUser(userName);
		List<Integer> pointsQty = new ArrayList<>();
		
		for (String type: pointTypes) {
			pointsQty.add(this.armazenamentoObject.getPointsFromUserByType(userName, type));
		}
		
		return formatPointsOutput(pointTypes, pointsQty);
	}

	public String getRanking(String pointType) {
		return armazenamentoObject.getRanking(pointType);
	}

}
