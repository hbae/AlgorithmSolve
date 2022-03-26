import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek17136_색종이붙이기 {

	static int[][] arr;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		arr = new int[10][10];
		int[] paperCount = { 0, 5, 5, 5, 5, 5 };
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		res = Integer.MAX_VALUE;
		solve(0, 0, 0, paperCount);
		if (res == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(res);
	}

	public static void solve(int x, int y, int depth, int[] paperCount) {
		if (y == 10) {
			solve(x + 1, 0, depth, paperCount);
			return;
		}
		if (x == 10) {
			res = Math.min(res, depth);
			return;
		}
		if (arr[x][y] == 0) {
			solve(x, y + 1, depth, paperCount);
			return;
		}

		if (arr[x][y] == 1) {
			for (int size = 5; size > 0; size--) {
				if (paperCount[size] == 0 || x + size > 10 || y + size > 10)
					continue;
				// 색종이 개수 남아있고, 유효할때
				if (isValid(x, y, size) == false)
					continue;
				paperCount[size] -= 1;
				cover(x, y, size, 0);
				solve(x, y + size, depth + 1, paperCount);
				paperCount[size] += 1;
				cover(x, y, size, 1);

			}
		}

	}

	public static void cover(int x, int y, int size, int flag) {
		if (flag == 0) { // 색종이 칠할때
			for (int i = x; i < x + size; i++) {
				for (int j = y; j < y + size; j++) {
					arr[i][j] = 0;
				}
			}
		} else if (flag == 1) { // 색종이 칠했던거 벗겨낼때
			for (int i = x; i < x + size; i++) {
				for (int j = y; j < y + size; j++) {
					arr[i][j] = 1;
				}
			}
		}

	}

	public static boolean isValid(int x, int y, int size) {

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (arr[i][j] == 0)
					return false;
			}
		}
		return true;
	}

}
