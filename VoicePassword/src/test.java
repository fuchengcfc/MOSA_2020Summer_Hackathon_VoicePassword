import java.util.Scanner;

public class test {
	
	public static void main(String[] args) {
		
		System.out.println("password record begin");
		Recorder.record("password.wav");
		System.out.println("password record finish, press 1 to continue");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		if (num == 1) {
			System.out.println("voice to solve begin");
			Recorder.record("try.wav");
			System.out.println("voice to solve finish");
		}
		
		boolean checkTwoFiles = Comparer.compareTwoFile("password.wav", "try.wav");
		
		System.out.println(checkTwoFiles);
		
		
		
	}

}
