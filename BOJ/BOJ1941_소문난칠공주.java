package day0409;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1941_소문난칠공주 {

	static char[][] arr;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[] numbers, input;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new char[5][5];
		numbers = new int[7];
		input = new int[25];
		for (int i = 0; i < 5; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < 25; i++) {
			input[i] = i;
		}
		combination(0, 0);
		System.out.println(res);
	}

	public static void combination(int cnt, int start) {
		if (cnt == 7) {
			if (isValid(numbers) && solve(numbers))
				res++;
			return;
		}
		for (int i = start; i < 25; i++) {
			numbers[cnt] = input[i];
			combination(cnt + 1, i + 1);
		}
	}

	public static boolean isValid(int[] numbers) { // s가 4개이상인지
		int count = 0;
		for (int i = 0; i < numbers.length; i++) {
			int idx = numbers[i];
			int row = idx / 5;
			int col = idx % 5;
			if (arr[row][col] == 'S')
				count++;
		}
		if (count >= 4)
			return true;
		else
			return false;
	}

	public static boolean solve(int[] numbers) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] isSelected = new boolean[5][5];
		boolean[][] isChecked = new boolean[5][5];
		for (int i = 0; i < numbers.length; i++) {
			int idx = numbers[i];
			int row = idx / 5;
			int col = idx % 5;
			if (i == 0) {
				queue.add(new int[] { row, col });
				isChecked[row][col] = true;
			}
			isSelected[row][col] = true;
		}

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int row = temp[0];
			int col = temp[1];
			for (int i = 0; i < 4; i++) {
				int nx = row + dx[i];
				int ny = col + dy[i];
				if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5)
					continue;
				if (!isChecked[nx][ny] && isSelected[nx][ny]) {
					isChecked[nx][ny] = true;
					queue.add(new int[] { nx, ny });
				}
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (isChecked[i][j] != isSelected[i][j])
					return false;
			}
		}
		return true;
	}
}
