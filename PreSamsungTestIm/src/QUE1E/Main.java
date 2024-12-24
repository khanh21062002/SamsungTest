package QUE1E;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			int N = sc.nextInt();

			int[] persons = new int[N];
			int[] pos = new int[N];
			boolean[] isFill = new boolean[N];

			int[] ans = new int[N];
			for (int i = 0; i < N; i++) {
				persons[i] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				pos[i] = sc.nextInt();
			}
			HashMap<Integer, Integer> hm = new HashMap<>();
			for (int i = 0; i < N; i++) {
				hm.put(persons[i], pos[i]);
			}
			Arrays.sort(persons);

			for (int i = 0; i < N; i++) {
				int current = hm.get(persons[i]);
				for (int j = 0; j < N; j++) {
					if (!isFill[j]) {
						current--;
					}
					if (current == -1) {
						ans[j] = persons[i];
						isFill[j] = true;
						break;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				System.out.print(ans[i] + " ");
			}
			System.out.println();
		}
	}
}
