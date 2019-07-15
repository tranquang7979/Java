package ZingMp3;

import java.util.ArrayList;

public class MainApp {

	public static void main(String[] args) {

		ManageSong ms = new ManageSong();
		for(int i = 0; i < 3; i++) {
			ms.addSong(i+1);
		}
		
		ms.selectSong();
		
	}

}
