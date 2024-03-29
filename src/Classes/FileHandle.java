package Classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileHandle {
	private static Path mainDirectory = Paths.get(System.getProperty("user.dir"));
	
    public static void createStorageFile(String filename) {
        Path filepath = mainDirectory.resolve(filename);
        File file = new File(filepath.toString());

        try {
            boolean created = file.createNewFile();
            if (created) {
                System.out.println("Arquivo " + filename + " criado com sucesso.");
            } else {
            	FileHandle.deleteStorageFile(filename);
            	file.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("When creating the file, an exception ocurred: "
            		+ e.getMessage());
        }
    }
    
	public static void createStorageFile() {
		createStorageFile("StorageFile.txt");
	}
    
    public static void deleteStorageFile(String filename) {
    	Path filePath = mainDirectory.resolve(filename);
    	File fileObject = new File(filePath.toString());
    	try {
			fileObject.delete();
		} catch (Exception e) {
			System.out.println("An exception ocurred while deleting the file: "
					+ e.getMessage());
		}
    }
    
    public static List<String> getFilesInDirectory() {
        Path directory = mainDirectory;
        List<String> fileNames = new ArrayList<>();

        try {
            fileNames = Files.list(directory)
                             .filter(Files::isRegularFile)
                             .map(Path::getFileName)
                             .map(Path::toString)
                             .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("An exception ocurred: " + e.getMessage());
        }

        return fileNames;
    }

	public static void writeInformation(String filenameString, String informationString) {
		Path filepath = mainDirectory.resolve(filenameString);
		
		try {
			Files.write(filepath, (informationString + "\n").getBytes(StandardCharsets.UTF_8)
					, StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.err.println("An exception ocurred: " + e.getMessage());
		}
	}
	
	public static void writeInformation(String informationString) {
		writeInformation("StorageFile.txt", informationString);
	}

	public static List<String> readFileLines(String filenameString) {
        List<String> linhas = new ArrayList<>();
        Path filePath = mainDirectory.resolve(filenameString);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath.toString()))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                linhas.add(linha);
            }
        }catch (IOException e) {
			e.printStackTrace();
		}
        return linhas;
	}
	
	public static List<String> readFileLines() {
		return readFileLines("StorageFile.txt");
	}

}
