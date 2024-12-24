package OTTGAME;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static int determineWinningMove(Set<Integer> moves) {
        // 1: Kéo, 2: Búa, 3: Bao
        if (moves.contains(1) && moves.contains(2)) return 2; // Búa thắng Kéo
        if (moves.contains(2) && moves.contains(3)) return 3; // Bao thắng Búa
        if (moves.contains(1) && moves.contains(3)) return 1; // Kéo thắng Bao
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine().trim()); // Số test case

        for (int tc = 1; tc <= T; tc++) {
            // Đọc số người chơi và số lượt chơi
            String[] firstLine = sc.nextLine().trim().split(" ");
            int N = Integer.parseInt(firstLine[0]); // Số người chơi
            int Q = Integer.parseInt(firstLine[1]); // Số lượt chơi

            int[][] moves = new int[Q][N]; // Lưu các nước đi
            boolean[] eliminated = new boolean[N]; // Đánh dấu người chơi bị loại

            // Đọc các nước đi cho mỗi lượt
            for (int q = 0; q < Q; q++) {
                String[] line = sc.nextLine().trim().split(" ");
                for (int i = 0; i < N; i++) {
                    moves[q][i] = Integer.parseInt(line[i]);
                }
            }

            // Xử lý từng lượt chơi
            for (int q = 0; q < Q; q++) {
                // Đếm các loại nước đi và kiểm tra người chơi còn lại
                Set<Integer> moveTypes = new HashSet<>();

                for (int i = 0; i < N; i++) {
                    if (!eliminated[i]) {
                        moveTypes.add(moves[q][i]);
                    }
                }

                // Nếu chỉ còn 1 người chơi hoặc nước đi hòa, bỏ qua lượt này
                if (moveTypes.size() <= 1 || moveTypes.size() == 3) {
                    continue;
                }

                // Có người thắng người thua
                int winningMove = determineWinningMove(moveTypes);
                for (int i = 0; i < N; i++) {
                    if (!eliminated[i] && moves[q][i] != winningMove) {
                        eliminated[i] = true;
                    }
                }
            }

            // In kết quả
            StringBuilder result = new StringBuilder("#" + tc);
            for (int i = 0; i < N; i++) {
                if (!eliminated[i]) {
                    result.append(" ").append(i + 1);
                }
            }
            System.out.println(result);
        }
        sc.close();
    }
}
