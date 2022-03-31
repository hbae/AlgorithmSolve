package day0331;

import java.util.Scanner;

public class BOJ1463_1로만들기 {

	static int x;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		
		int[] arr = new int[x + 1];
		for (int i = 1; i <= x; ++i)
			arr[i] = Integer.MAX_VALUE;
		arr[1] = 0;
		arr[2] = 1;
		arr[3] = 1;
		for (int i = 4; i <= x; i++) {
			if (i % 3 == 0)
				arr[i] = Math.min(arr[i / 3] + 1, arr[i]);
			if (i % 2 == 0)
				arr[i] = Math.min(arr[i / 2] + 1, arr[i]);
			arr[i] = Math.min(arr[i], arr[i - 1] + 1);
		}
		System.out.println(arr[x]);
		sc.close();
	}

}