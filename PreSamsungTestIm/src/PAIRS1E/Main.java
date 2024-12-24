package PAIRS1E;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for (int testcase = 1; testcase <= t; testcase++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			HashSet<Integer> arr = new HashSet<>();
			for(int i = 0 ; i < N ; i++) {
				arr.add(sc.nextInt());
			}
			int count = 0;
			for(int num: arr) {
				if(arr.contains(num + K)) {
					count++;
				}
			}
			// Output the result for the current test case
            System.out.println(count);
		}
		sc.close();
	}
}
