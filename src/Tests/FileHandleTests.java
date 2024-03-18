package Tests;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import Classes.FileHandle;


class FileHandleTests {
	
	@Test
	void createFileInMainDirectoryTest() {
		FileHandle.createStorageFile("FileTest.txt");
		assertEquals(true, FileHandle.getFilesInDirectory().contains("FileTest.txt"));
	}
	
	@Test
	void createAndDeleteFileTest() {
		String filename = "CreateAndDelete.txt";
		
		FileHandle.createStorageFile(filename);
		assertEquals(true, FileHandle.getFilesInDirectory().contains(filename));
		
		FileHandle.deleteStorageFile(filename);
		assertEquals(false, FileHandle.getFilesInDirectory().contains(filename));
	}
	
	@Test
	void writeInformationOnFile() {
		String filenameString = "InformationFile.txt";
		
		FileHandle.createStorageFile(filenameString);
		assertEquals(true, FileHandle.getFilesInDirectory().contains(filenameString));
		
		FileHandle.writeInformation(filenameString, "This is a test"); 
		assertEquals("This is a test", FileHandle.readFileLines(filenameString).get(0));
	}

}
