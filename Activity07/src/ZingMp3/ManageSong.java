package ZingMp3;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageSong {

	private ArrayList<Song> arr;

	public ManageSong() {
		arr = new ArrayList<Song>();
	}

	public void addSong(int code) {
		
		Song song = new Song();
		song.setCode("S000" + code);
		
		Scanner sc = new Scanner(System.in);		
		System.out.print("Enter song name:");
		song.setName(sc.nextLine());
		
		sc = new Scanner(System.in);		
		System.out.print("Enter song link:");
		song.setLink(sc.nextLine());

		arr.add(song);

		System.out.println("==============================");		
	}

	public void removeSong(String code) {
		arr.removeIf(x -> x.getCode() == code);
	}

	public ArrayList<Song> searchSong(Song song) {
		ArrayList<Song> result = new ArrayList<Song>();
		for (int i = 0; i < arr.size(); i++) {
			Song temp = arr.get(i);
			if (song.getCode().contains(song.getCode()) || song.getName().contains(song.getName())) {
				result.add(song);
			}
		}
		return result;
	}

	public void selectSong() {
		for(int i = 0; i < arr.size(); i++) {
			Song s = arr.get(i);
			System.out.println("==============================");
			System.out.println("Song Information: ");
			System.out.printf("Name: [%s] %s \n", s.getCode(), s.getName());
			System.out.printf("Link: %s \n", s.getLink());
			System.out.println("==============================");
		}
	}
}
