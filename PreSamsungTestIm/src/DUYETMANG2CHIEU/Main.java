package DUYETMANG2CHIEU;

public class Main {

	//Duyệt ngang
	public static void horizontalTraversal(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) { // Duyệt qua từng hàng
			for (int j = 0; j < matrix[i].length; j++) { // Duyệt qua từng cột trong hàng
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	// Duyệt ngang xen kẽ
	public static void horizontalAlternateTraversal(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) { // Duyệt qua từng hàng
			if (i % 2 == 0) { // Hàng chẵn: Duyệt từ trái sang phải
				for (int j = 0; j < matrix[i].length; j++) {
					System.out.print(matrix[i][j] + " ");
				}
			} else { // Hàng lẻ: Duyệt từ phải sang trái
				for (int j = matrix[i].length - 1; j >= 0; j--) {
					System.out.print(matrix[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	//Duyệt dọc
	public static void verticalTraversal(int[][] matrix) {
		for (int j = 0; j < matrix[0].length; j++) { // Duyệt qua từng cột
			for (int i = 0; i < matrix.length; i++) { // Duyệt qua từng hàng trong cột
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	//Duyệt dọc xen kẽ
	public static void verticalAlternateTraversal(int[][] matrix) {
		for (int j = 0; j < matrix[0].length; j++) { // Duyệt qua từng cột
			if (j % 2 == 0) { // Cột chẵn: Duyệt từ trên xuống dưới
				for (int i = 0; i < matrix.length; i++) {
					System.out.print(matrix[i][j] + " ");
				}
			} else { // Cột lẻ: Duyệt từ dưới lên trên
				for (int i = matrix.length - 1; i >= 0; i--) {
					System.out.print(matrix[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		System.out.println("Duyệt ngang:");
		horizontalTraversal(matrix);

		System.out.println("\nDuyệt ngang xen kẽ:");
		horizontalAlternateTraversal(matrix);

		System.out.println("\nDuyệt dọc:");
		verticalTraversal(matrix);

		System.out.println("\nDuyệt dọc xen kẽ:");
		verticalAlternateTraversal(matrix);
	}
}
