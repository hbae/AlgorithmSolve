import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1600_말이되고픈원숭이 {

	// 나이트처럼 움직일 수 있는 경우들
	static int[] dr = { 2, 2, -2, -2, 1, 1, -1, -1 };
	static int[] dc = { 1, -1, 1, -1, 2, -2, 2, -2 };
	// 사방으로 움직이는 경우들
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] arr;
	static boolean[][][] isVisited;
	static Queue<Integer[]> queue;
	static int row, col, T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		arr = new int[row][col];
		isVisited = new boolean[row][col][T + 1];
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int res = bfs();
		System.out.println(res);
	}

	public static int bfs() {
		queue = new LinkedList<Integer[]>();
		queue.add(new Integer[] { 0, 0, 0, 0 });
		isVisited[0][0][0] = true;
		int result = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			Integer[] temp = queue.poll();
			int x = temp[0];
			int y = temp[1];
			int knight_count = temp[2];
			int res = temp[3];
			if (x == row - 1 && y == col - 1) {
				result = Math.min(result, res);
			}
			if (knight_count < T) {
				for (int i = 0; i < 8; i++) {
					int nr = x + dr[i];
					int nc = y + dc[i];
					if (isValid(nr, nc) == false || isVisited[nr][nc][knight_count + 1] == true)
						continue;
					queue.add(new Integer[] { nr, nc, knight_count + 1, res + 1 });
					isVisited[nr][nc][knight_count + 1] = true;
				}
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (isValid(nx, ny) == false || isVisited[nx][ny][knight_count] == true)
					continue;
				queue.add(new Integer[] { nx, ny, knight_count, res + 1 });
				isVisited[nx][ny][knight_count] = true;
			}
		}
		if (result == Integer.MAX_VALUE)
			return -1;
		else
			return result;
	}

	public static boolean isValid(int x, int y) {
		if (x < 0 || y < 0 || x >= row || y >= col || arr[x][y] == 1)
			return false;
		return true;
	}
}
