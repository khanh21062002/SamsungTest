package PROB01;

import java.util.Scanner;

public class Main {
	
	//Hàm tính số nén
	public static int compressNumber(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for( int i = 1 ; i<=t ; i++ ) {
        	int n = sc.nextInt();
        	
        	int result = compressNumber(n);
        	
        	System.out.println("#" + i + " " + result);
        }
        sc.close();
	}
}
