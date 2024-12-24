package PROB02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt(); // Number of test cases
        for (int t = 1; t <= T; t++) {
            int M = scanner.nextInt(); // Rows of windows
            int N = scanner.nextInt(); // Columns of windows

            char[][] grid = new char[5 * M + 1][5 * N + 1];

            // Read the entire grid input
            for (int i = 0; i < 5 * M + 1; i++) {
                String line = scanner.next();
                grid[i] = line.toCharArray();
            }

            // Array to store the counts for each curtain state (0 to 4)
            int[] states = new int[5];

            // Analyze each window (4x4) by checking the grid
            for (int row = 0; row < M; row++) {
                for (int col = 0; col < N; col++) {
                    int starCount = 0;

                    // Start of the 4x4 grid (top-left corner)
                    int startRow = 1 + row * 5;
                    int startCol = 1 + col * 5;

                    // Count the '*' in the 4x4 grid
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            if (grid[startRow + i][startCol + j] == '*') {
                                starCount++;
                            }
                        }
                    }

                    // Determine the curtain state based on starCount
                    if (starCount == 0) {
                        states[0]++;
                    } else if (starCount <= 4) {
                        states[1]++;
                    } else if (starCount <= 8) {
                        states[2]++;
                    } else if (starCount <= 12) {
                        states[3]++;
                    } else {
                        states[4]++;
                    }
                }
            }

            // Output the results for this test case
            System.out.print("#" + t);
            for (int state : states) {
                System.out.print(" " + state);
            }
            System.out.println();
        }

        scanner.close();
	}
}
