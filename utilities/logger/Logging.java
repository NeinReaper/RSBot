package logger;

public class Logging {
	private int count;
	public Logging(){
		count = 0;
	}
	public void logg(String action, String message) {
		System.out.println(action + ": " + message + ", " + count++);
	}
}
