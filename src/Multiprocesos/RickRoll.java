package Multiprocesos;

public class RickRoll {

	public static void main(String[] args) {

		ProcessBuilder pb;
		Process proceso = null;
		try {

			// A la hora de decir que es lo que queremos abrir hacemos click derecho y en Run as / Run configuration / Arguments Pegamos lo que queremos reproducir
			pb = new ProcessBuilder("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe", args[0]);
			proceso = pb.start();
			
			proceso.waitFor();
			System.out.println("Te la comiste");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
