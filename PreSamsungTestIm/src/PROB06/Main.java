package PROB06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            char[][] map = new char[M][N];

            // Read the map
            for (int i = 0; i < M; i++) {
                String line = scanner.next();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            // Count the number of unserved households
            int unservedHouseholds = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 'H' && !isServed(map, i, j)) {
                        unservedHouseholds++;
                    }
                }
            }

            System.out.printf("#%d %d\n", t, unservedHouseholds);
        }

        scanner.close();
    }

    // Helper function to check if a household is served by a tower
    private static boolean isServed(char[][] map, int x, int y) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 'A' && Math.abs(i - x) <= 1 && Math.abs(j - y) <= 1) {
                    return true;
                } else if (map[i][j] == 'B' && Math.abs(i - x) <= 2 && Math.abs(j - y) <= 2) {
                    return true;
                } else if (map[i][j] == 'C' && Math.abs(i - x) <= 3 && Math.abs(j - y) <= 3) {
                    return true;
                }
            }
        }
        return false;
    }
}
