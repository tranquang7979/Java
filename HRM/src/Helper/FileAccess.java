package Helper;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileAccess {

	public String read(String filePath) {
		try {
			FileReader fr = new FileReader(filePath);
			BufferedReader br = new BufferedReader(fr);

			String content = "";
			String line = "";

			while ((line = br.readLine()) != null) {
				content += line;
			}

			//System.out.print(content);
			
			br.close();
			fr.close();
			return content;
		} catch (Exception ex) {
			ex.printStackTrace();
			return "";
		}
	}

}
