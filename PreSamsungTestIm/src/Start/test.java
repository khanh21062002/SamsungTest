package Start;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        while (true) {
			int num = sc.nextInt();
			if(num == 42) {
				break;
			}
			System.out.println(num);
		}
        sc.close();
	}
}
