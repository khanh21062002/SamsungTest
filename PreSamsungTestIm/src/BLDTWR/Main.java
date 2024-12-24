package BLDTWR;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Số lượng test case
        
        for (int t = 1; t <= T; t++) {
            // Đọc dữ liệu đầu vào cho mỗi test case
            int N = sc.nextInt(); // Tổng số viên gạch
            int M1 = sc.nextInt(); // Số tầng của tháp 1
            int M2 = sc.nextInt(); // Số tầng của tháp 2

            int[] bricks = new int[N];
            for (int i = 0; i < N; i++) {
                bricks[i] = sc.nextInt();
            }

            // Sắp xếp các viên gạch theo thứ tự giảm dần cân nặng
            Arrays.sort(bricks);
            reverseArray(bricks); // Đảo ngược để có thứ tự giảm dần

            // Phân bổ gạch và tính chi phí cho hai tháp
            int costTower1 = calculateCost(bricks, 0, M1); // Tính chi phí cho M1 viên đầu
            int costTower2 = calculateCost(bricks, M1, M1 + M2); // Tính chi phí cho M2 viên tiếp theo

            // Tổng chi phí
            int totalCost = costTower1 + costTower2;

            // In ra kết quả cho test case này
            System.out.println("#" + t + " " + totalCost);
        }
        sc.close();
    }

    // Hàm tính chi phí xây dựng tháp
    private static int calculateCost(int[] bricks, int start, int end) {
        int cost = 0;
        int layer = 1; // Bắt đầu từ tầng 1
        for (int i = start; i < end; i++) {
            cost += bricks[i] * layer; // Tính chi phí
            layer++;
        }
        return cost;
    }

    // Hàm đảo ngược mảng
    private static void reverseArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = array[i];
            array[i] = array[n - 1 - i];
            array[n - 1 - i] = temp;
        }
    }
}