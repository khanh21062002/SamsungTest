package CALEXP;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for ( int i = 1 ; i <= t ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			long result = 1;
            for (int j = 0; j < b; j++) {
                result *= a;
            }
            System.out.println("#" + i + " " + result);
		}
		sc.close();
	}
}
