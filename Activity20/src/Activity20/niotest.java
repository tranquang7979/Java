package Activity20;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;

public class niotest {
	
	public void getFolder() {
		String folderPath = "E:\\TranDuyQuang\\niotest\\a.txt";		
		try {
			
			Path path = Paths.get(folderPath);
			System.out.println("Total path: " + path.getNameCount()); // 3 -> ["TranDuyQuang", "niotest", "a.txt"]
			System.out.println("Folder Name: " + path.getName(1)); // niotest
			System.out.println("File System: " + path.getFileSystem());
			System.out.println("Root: " + path.getRoot());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createFolder() {
		String folderPath = "E:\\TranDuyQuang\\niotest\\C";		
		try {
			
			Path path = Paths.get(folderPath);
			Files.createDirectory(path);
			
			FileAttribute<String> attr = new FileAttribute<String>() {
				
				@Override
				public String value() {
					return "this is content";
				}
				
				@Override
				public String name() {
					return "C";
				}
			};
			folderPath += "\\c.txt";
			path = Paths.get(folderPath);
			Files.createFile(path, attr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createFile() {
		String folderPath = "E:\\TranDuyQuang\\niotest\\C\\c.txt";		
		try {
			
			Path dir = Paths.get("E:\\TranDuyQuang\\niotest\\C");
	        Path fileToCreatePath = dir.resolve("c.txt");
	        System.out.println("File to create path: " + fileToCreatePath);
	        Path newFilePath = Files.createFile(fileToCreatePath);
	        System.out.println("New file created: " + newFilePath);
	        System.out.println("New File exits: " + Files.exists(newFilePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		niotest test = new niotest();
		//test.getFolder();
		//test.createFolder();
		test.createFile();
	}
	
}
