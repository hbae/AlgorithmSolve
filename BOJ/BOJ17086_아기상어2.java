package day0409;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17086_아기상어2 {

	public static class pos {
		int x;
		int y;

		public pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = { -1, 0, 1, 0, -1, -1, 1, 1 };
	static int[] dy = { 0, 1, 0, -1, -1, 1, 1, -1 };
	static Queue<pos> queue = new LinkedList<>();
	static int[][] arr, check;
	static int N, M, res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		check = new int[N][M];
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(check[i], Integer.MAX_VALUE);
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					queue.add(new pos(i, j));
					check[i][j] = 0;
				}
			}
		}
		res = 0;
		solve();
		System.out.println(res);
	}

	public static void solve() {
		while (!queue.isEmpty()) {
			pos temp = queue.poll();
			int x = temp.x;
			int y = temp.y;
			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (check[nx][ny] == Integer.MAX_VALUE) {
					check[nx][ny] = check[x][y] + 1;
					queue.add(new pos(nx, ny));
					res = Math.max(res, check[nx][ny]);
				}
			}

		}
	}

}
