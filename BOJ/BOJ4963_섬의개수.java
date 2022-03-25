import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 대각선까지 팔방탐색하는 문제
 * 
 */
public class Baek4963_섬의개수 {

	static int[][] arr;
	static boolean[][] checked;
	static int[] dx = { -1, 0, 1, 0, -1, -1, 1, 1 };
	static int[] dy = { 0, 1, 0, -1, -1, 1, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			int col = Integer.parseInt(st.nextToken());
			int row = Integer.parseInt(st.nextToken());
			if (row == 0 && col == 0)
				break;
			arr = new int[row][col];
			checked = new boolean[row][col];
			int count = 0;
			for (int i = 0; i < row; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < col; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					if (arr[i][j] == 1 && checked[i][j] == false) {
						solve(i, j);
						count++;
					}
				}
			}
			sb.append(count).append("\n");

		}
		sb.setLength(sb.length() - 1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static void solve(int row, int col) {
		checked[row][col] = true;
		for (int i = 0; i < 8; i++) {
			int nx = row + dx[i];
			int ny = col + dy[i];
			if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr[0].length)
				continue;
			if (arr[nx][ny] == 1 && checked[nx][ny] == false) {
				solve(nx, ny);
			}
		}
	}

}
