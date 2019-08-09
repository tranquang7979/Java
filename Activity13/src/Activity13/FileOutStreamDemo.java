package Activity13;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileOutStreamDemo {
	
	public void Write() {
		String fileName = "data.txt";
		try
		{
			String text = "Xin chào Steven Trần";
			byte[] content = text.getBytes();
			
			FileOutputStream fs = new FileOutputStream(fileName, true);
			fs.write(content);
			fs.close();
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new FileOutStreamDemo().Write();
	}

}
