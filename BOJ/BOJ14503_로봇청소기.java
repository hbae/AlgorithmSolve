package day0402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503_로봇청소기 {

	static int[][] arr;
	static int N, M, r, c, d;
	static int[] dx = { -1, 0, 1, 0 }; // 북동남서 순
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int res = 0;
		System.out.println(solve(r, c, d, res));

	}

	public static int solve(int x, int y, int d, int res) {
		OUT: while (true) {
			if (arr[x][y] == 0) {
				arr[x][y] = -1;
				res++;
			}
			for (int i = 0; i < 4; i++) {
				int idx = (d + 3) % 4;
				int nx = x + dx[idx];
				int ny = y + dy[idx];
				if (arr[nx][ny] != 0) {
					d = idx;
					continue;
				}
				x = nx;
				y = ny;
				d = idx;
				continue OUT;
			}
			int nx = x - dx[d];
			int ny = y - dy[d];
			if (arr[nx][ny] == 1)
				break;
			else {
				x = nx;
				y = ny;
			}
		}
		return res;
	}

}
