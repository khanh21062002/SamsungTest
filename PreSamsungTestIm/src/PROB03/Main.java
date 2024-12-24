package PROB03;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int t = scanner.nextInt(); // Số lượng test case
		for (int testcase = 1; testcase <= t; testcase++) {
			int h = scanner.nextInt(); // Chiều cao của hình chữ nhật
			int w = scanner.nextInt(); // Chiều rộng của hình chữ nhật
			int m = scanner.nextInt(); // Số hàng của ma trận
			int n = scanner.nextInt(); // Số cột của ma trận

			// Khởi tạo ma trận
			int[][] array = new int[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					array[i][j] = scanner.nextInt();
				}
			}

			int maxSum = 0;

			// Duyệt qua tất cả các hình chữ nhật kích thước h * w
			for (int startRow = 0; startRow <= m - h; startRow++) {
				for (int startCol = 0; startCol <= n - w; startCol++) {
					int sum = 0;

					// Tính tổng các số chẵn trong hình chữ nhật
					for (int row = startRow; row < startRow + h; row++) {
						for (int col = startCol; col < startCol + w; col++) {
							if (array[row][col] % 2 == 0) {
								sum += array[row][col];
							}
						}
					}

					// Cập nhật tổng lớn nhất
					maxSum = Math.max(maxSum, sum);
				}
			}

			// In kết quả cho mỗi test case
			System.out.println("#" + testcase + " " + maxSum);
		}

		scanner.close();
	}
}
