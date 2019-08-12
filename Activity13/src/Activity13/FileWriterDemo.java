package Activity13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileWriterDemo {
	

	public String ReadLine(String filePath) {
		try
		{			
			 FileReader fr = new FileReader(filePath);
			 BufferedReader br = new BufferedReader(fr);
			 
			 String content = "";
			 String temp = "";
			 
			 while((temp = br.readLine()) != null) {
				 content += " " + temp;
			 }
			 
			 br.close();
			 fr.close();
			 
			 return content;
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
			return ex.getMessage();
		}
	}

	public void Write(String content) {
		try
		{			
			FileWriter fs = new FileWriter("file-writer.txt", true);
			fs.write(content);
			fs.close();
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}

	public void Write(String filePath, String content) {
		try
		{			
			FileWriter fs = new FileWriter(filePath, true);
			fs.write(content);
			fs.close();
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}

	public void WriteLine(String content) {
		try
		{			
			FileWriter fs = new FileWriter("file-writer.txt", true);			
			BufferedWriter bw = new BufferedWriter(fs);
			
			bw.write(content);
			bw.newLine();
			
			bw.close();
			fs.close();
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}

	public void WriteLine(String filePath, String content) {
		try
		{			
			FileWriter fs = new FileWriter(filePath, true);			
			BufferedWriter bw = new BufferedWriter(fs);
			
			bw.write(content);
			bw.newLine();
			
			bw.close();
			fs.close();
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {		
		FileWriterDemo fwd = new FileWriterDemo();
		fwd.WriteLine("Hi Steven Tran!");
		fwd.WriteLine("How are you to day?");
	}

}
