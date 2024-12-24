package PTRNLOCK;

import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Số test cases

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt(); // Số mẫu hình cần kiểm tra
            String[] patterns = new String[N];
            
            // Đọc các mẫu hình
            for (int i = 0; i < N; i++) {
                patterns[i] = sc.next();
            }
            
            // Kiểm tra từng mẫu hình và xây dựng kết quả
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < N; i++) {
                result.append(isValidPattern(patterns[i]) ? "1" : "0");
            }
            
            System.out.println("#" + t + " " + result.toString());
        }
        sc.close();
    }

    private static boolean isValidPattern(String pattern) {
        // Kiểm tra độ dài tối thiểu
        if (pattern.length() < 4) {
            return false;
        }

        // Chuyển pattern thành mảng số
        int[] points = new int[pattern.length()];
        for (int i = 0; i < pattern.length(); i++) {
            points[i] = pattern.charAt(i) - '0';
        }

        // Kiểm tra điểm trùng lặp
        HashSet<Integer> used = new HashSet<>();
        for (int point : points) {
            if (!used.add(point)) {
                return false;
            }
        }

        // Kiểm tra tính hợp lệ của các kết nối
        for (int i = 0; i < points.length - 1; i++) {
            if (!isValidConnection(points[i], points[i + 1], used)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isValidConnection(int start, int end, HashSet<Integer> used) {
        // Chuyển đổi số thành tọa độ (0-based)
        int x1 = (start - 1) / 3;
        int y1 = (start - 1) % 3;
        int x2 = (end - 1) / 3;
        int y2 = (end - 1) % 3;

        // Khoảng cách giữa hai điểm
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        // Kiểm tra điểm giữa cho trường hợp đặc biệt
        if (dx == 2 || dy == 2) {
            int mx = (x1 + x2) / 2;
            int my = (y1 + y2) / 2;
            int middlePoint = mx * 3 + my + 1;
            
            // Nếu không có điểm giữa trong pattern
            if (!used.contains(middlePoint)) {
                return false;
            }
        }

        // Kiểm tra đường chéo đi qua trung tâm
        if (dx == 1 && dy == 1) {
            if (!used.contains(5)) {
                return false;
            }
        }

        return true;
    }
}
