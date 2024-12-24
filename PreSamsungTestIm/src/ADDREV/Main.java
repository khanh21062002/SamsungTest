package ADDREV;

import java.util.Scanner;

public class Main {
	
	//Hàm đảo ngược số
	public static int reverse(int num) {
		
		int reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < N; i++) {
			 
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            
            int revNum1 = reverse(num1);
            int revNum2 = reverse(num2);
            
            int sum = revNum1 + revNum2;
            int revSum = reverse(sum);

            System.out.println(revSum);
		}
		sc.close();
	}

}
