package Interfaces;

import java.util.List;

public interface ArmazenamentoMockInterface extends ArmazenamentoInterface{
	public List<String> getLinesFromStorageFile();
}
