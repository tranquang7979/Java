package Utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class FileHelper {

	public ArrayList<String> read(String fileName) {		
		try {
			ArrayList<String> result = new ArrayList<String>();
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);

			String content = "";
			String line = "";

			while ((line = br.readLine()) != null) {
				result.add(line);
			}

			//System.out.print(content);

			br.close();
			fr.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public void write(String fileName, String content) {
		try
		{			
			FileWriter fs = new FileWriter(fileName, true);			
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

}
