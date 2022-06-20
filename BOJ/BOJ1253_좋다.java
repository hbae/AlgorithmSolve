package day0620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1253_좋다 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int res = 0;

		for (int i = 0; i < arr.length; i++) {
			int left = 0;
			int right = N - 1;
			while (true) { // 이분탐
				if (left == i)
					left++;
				if (right == i)
					right--;
				if (left >= right)
					break;
				int sum = arr[left] + arr[right];
				if (sum == arr[i]) {
					res++;
					break;
				}
				if (sum < arr[i])
					left++;
				if (sum > arr[i])
					right--;

			}
		}
		System.out.println(res);
	}

}
