package Interfaces;

import java.util.List;

public interface ArmazenamentoInterface {
	public void savePoints(String userName, int points, String pointType);
	public int getPointsFromUserByType(String userName, String pointType);
	public List<String> getAllPointTypeByUser(String userName);
	public List<String> getUsersWithPoints();
}
