package Classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Placar {

	private Armazenamento armazenamentoObject; 
	
	public Placar(ArmazenamentoMock mockArmazenamento) {
		this.armazenamentoObject = mockArmazenamento;
	}
	
	public Placar(Armazenamento armazenamentoObject) {
		this.armazenamentoObject = armazenamentoObject;
	}

	public void registerPoints(String userName, String pointType, int numberOfPoints) {
		this.armazenamentoObject.savePoints(userName, numberOfPoints, pointType);
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

	private List<Map.Entry<String, Integer>> sortListBasedOnPoints(Map<String, Integer> mapa) {
	    List<Map.Entry<String, Integer>> lista = new ArrayList<>(mapa.entrySet());
	
	    Comparator<Map.Entry<String, Integer>> comparator = Comparator.comparing(
	    		Map.Entry::getValue, Comparator.reverseOrder());
	
	    Collections.sort(lista, comparator);
	    return lista;
	}
	
	private String formatRankingOutput(List<Map.Entry<String, Integer>> rankingList) {
		String outputString = "";
		int counter = 0;
		for (Map.Entry<String, Integer> entry : rankingList) {
            if (counter != 0)
            	outputString += ", ";
        	outputString += entry.getKey() + " com " + entry.getValue();
            counter++;
        }
		
		return outputString;
	}

	public String getRanking(String pointType) {
		Map<String, Integer> usersWithPoints = this.armazenamentoObject.
				getUsersWithPoints(pointType);
		
		List<Map.Entry<String, Integer>> outputList = sortListBasedOnPoints(usersWithPoints);
		
		return formatRankingOutput(outputList);
	}

}
