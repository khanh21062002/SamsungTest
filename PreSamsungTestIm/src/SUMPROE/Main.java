package SUMPROE;

import java.util.Scanner;

public class Main {
	private static final int MOD = 1000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        int T = scanner.nextInt();

        StringBuilder output = new StringBuilder();

        
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            long sum = 0;

            for (int x = 1; x <= N; x++) {
                int y = N / x; // y = N / x
                sum = (sum + (long) x * y) % MOD;
            }

            
            output.append(sum).append("\n");
        }

        
        System.out.print(output);

        scanner.close();
    }
}
