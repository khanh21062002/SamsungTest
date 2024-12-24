package SMPDIV;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 1 ; i <= t ; i++) {
        	int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            List<Integer> results = new ArrayList<>();
            
            for (int ai = 1; ai < n; ai++) {
                if (ai % x == 0 && ai % y != 0) {
                    results.add(ai);
                }
            }
            for (int j = 0; j < results.size(); j++) {
                if (j > 0) System.out.print(" ");
                System.out.print(results.get(j));
            }
            System.out.println();
        }
        sc.close();
	}
}
