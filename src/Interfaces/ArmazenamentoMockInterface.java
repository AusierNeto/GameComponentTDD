package Interfaces;

import java.util.List;

public interface ArmazenamentoMockInterface {
	public List<String> getLinesFromStorageFile();
	public void savePoints(String userName, int numberOfPoints, String pointType);
	public String getAllPointsFromGivenUserByType(String userName);
	public String getRanking(String pointType);
}
