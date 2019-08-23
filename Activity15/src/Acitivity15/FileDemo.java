package Acitivity15;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileDemo {
	
	public void demo()
	{
		try
		{
			String pathname = "E:\\TranDuyQuang\\eclipse-workspace\\Activity15\\src\\resources";
			File file = new File(pathname);
			
			// get file/folder information
			System.out.println("Name: " + file.getName());
			System.out.println("Parent: " + file.getParent());
			
			// list all child in folder
			for(File s : file.listFiles())
			{
				String id = s.isFile() ? "File" : "Folder";
				System.out.println(id + " => " + s.getName());
				
				// create new file
				String newFileName = "file.txt";
				File ff = new File(s.getAbsoluteFile() + "\\" + newFileName);
				boolean flag = ff.createNewFile();
				
				// write content to file
				if(flag)
				{
					FileWriter fw = new FileWriter(ff);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write("Virus...^^!");
					bw.newLine();
					bw.close();
					fw.close();
				}
				
				// delete file
				//ff.delete();
			}
		}
		catch(Exception e)
		{
			
		}
	}
	
	public ArrayList<String> AccessFolder()
	{
		ArrayList<String> arr = new ArrayList<String>();
		try
		{
			String pathname = "E:\\TranDuyQuang\\eclipse-workspace\\Activity15\\src\\resources";
			File file = new File(pathname);
			
			// get file/folder information
			System.out.println("Name: " + file.getName());
			System.out.println("Parent: " + file.getParent());
			
			// list all child in folder
			for(File s : file.listFiles())
			{
				String id = s.isFile() ? "File" : "Folder";
				System.out.println(id + " => " + s.getName());
				
				arr.add(s.getName());
			}
		}
		catch(Exception e)
		{
			
		}
		return arr;
	}

	public static void main(String[] args) {
		
		FileDemo fd = new FileDemo();
		fd.demo();

	}

}
