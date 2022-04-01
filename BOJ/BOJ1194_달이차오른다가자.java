package day0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1194_달이차오른다가자 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer[]> queue = new LinkedList<Integer[]>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, -1, 0, 1 };
		char[][] arr = new char[N][M];
		boolean[][][] isVisited = new boolean[N][M][64];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = br.readLine().toCharArray();
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == '0') {
					queue.add(new Integer[] { i, j, 0, 0 });
				}
			}
		}
		while (!queue.isEmpty()) {
			Integer[] temp = queue.poll();
			int x = temp[0];
			int y = temp[1];
			int count = temp[2];
			int key = temp[3];
			if (arr[x][y] == '1') {
				System.out.println(count);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || isVisited[nx][ny][key] == true)
					continue;
				if (arr[nx][ny] == '#')
					continue;
				if (arr[nx][ny] >= 'a' && arr[nx][ny] <= 'f') {
					int newKey = (1 << arr[nx][ny] - 'a') | key;
					
					if (!isVisited[nx][ny][newKey]) {
						isVisited[nx][ny][newKey] = true;
						queue.add(new Integer[] { nx, ny, count + 1, newKey });
					}
				} else if (arr[nx][ny] >= 'A' && arr[nx][ny] <= 'F') {
					int check = (1 << arr[nx][ny] - 'A') & key;
					if (check > 0) {
						isVisited[nx][ny][key] = true;
						queue.add(new Integer[] { nx, ny, count + 1, key });
					}
				} else {
					isVisited[nx][ny][key] = true;
					queue.add(new Integer[] { nx, ny, count + 1, key });
				}
			}
		}
		System.out.println("-1");
	}

}
