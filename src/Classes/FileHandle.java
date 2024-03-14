package Classes;

import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors

public class FileHandle {
	
	public FileHandle() {
		// TODO Auto-generated constructor stub
	}
	
    public static void createStorageFile() {
        String currentDirectory = System.getProperty("user.dir");
        File file = new File(currentDirectory, "register.txt");

        try {
            boolean created = file.createNewFile();
            if (created) {
                System.out.println("Arquivo register.txt criado com sucesso.");
            } else {
                System.out.println("O arquivo register.txt já existe no diretório.");
            }
        } catch (IOException e) {
            System.err.println("Erro ao criar o arquivo: " + e.getMessage());
        }
    }


	public static void main(String[] args) {
		createStorageFile();
	}

}
