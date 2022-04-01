package day0401;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ4485_녹색옷입은애가젤다지 {

	static class node implements Comparable<node> {
		int x, y, val;

		public node(int x, int y, int val) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
		}

		@Override
		public int compareTo(node node) {
			return this.val - node.val;
		}
	}

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<node> queue = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = 0;
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}
			tc++;
			int[][] arr = new int[N][N];
			int[][] dp = new int[N][N];
			boolean[][] isVisited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dp[0][0] = arr[0][0];
			isVisited[0][0] = true;
			queue.add(new node(0, 0, arr[0][0]));

			while (!queue.isEmpty()) {
				node temp = queue.poll();
				int x = temp.x;
				int y = temp.y;
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
						continue;
					}

					if (isVisited[nx][ny] == false) {
						isVisited[nx][ny] = true;
						dp[nx][ny] = dp[x][y]+arr[nx][ny];
						queue.offer(new node(nx, ny, dp[nx][ny]));
					}
				}
			}
			sb.append("Problem ").append(tc).append(": ").append(dp[N-1][N-1]).append("\n");
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
