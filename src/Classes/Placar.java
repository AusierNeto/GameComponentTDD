package Classes;

public class Placar {

	private ArmazenamentoMock mockClass = new ArmazenamentoMock();
	
	public Placar(ArmazenamentoMock mockArmazenamento) {
		// TODO Auto-generated constructor stub
		this.mockClass = mockArmazenamento;
	}

	public void registerPoints(String string, int i, String string2) {
		// TODO Auto-generated method stub
		
	}

	public Object getFileLines() {
		return mockClass.getLinesFromStorageFile();
	}

}
