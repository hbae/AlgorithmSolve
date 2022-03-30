import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2636_치즈 {

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] arr;
	static boolean[][] isVisited;
	static Queue<Integer[]> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		arr = new int[row][col];
		int res = 0;
		int cheese_count = 0;
		int before_count = 0;
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (true) {
			isVisited = new boolean[row][col];
			cheese_count = bfs();
			if (cheese_count == 0)
				break;
			before_count = cheese_count;
			res++;
		}
		System.out.print(res + "\n" + before_count);
	}

	public static int bfs() {
		int count = 0;
		queue = new LinkedList<Integer[]>();
		queue.add(new Integer[] { 0, 0 });
		while (!queue.isEmpty()) {
			Integer[] temp = queue.poll();
			int x = temp[0];
			int y = temp[1];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr[0].length || isVisited[nx][ny] == true)
					continue;
				if(arr[nx][ny]==0) {
					isVisited[nx][ny] = true;
					queue.add(new Integer[] {nx,ny});
				}
				if(arr[nx][ny]==1) {
					count++;
					arr[nx][ny] = 0;
					isVisited[nx][ny] = true;
				}
			}
		}

		return count;
	}
}

