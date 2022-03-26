import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek3187_양치기꿍 {

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static char[][] arr;
	static int sheep_minus, wolf_minus;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		arr = new char[row][col];
		visited = new boolean[row][col];
		int sheep = 0;
		int wolf = 0;
		for (int i = 0; i < row; i++) {
			arr[i] = br.readLine().toCharArray();
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 'k')
					sheep++;
				if (arr[i][j] == 'v')
					wolf++;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] != '#' && visited[i][j] == false) {
					sheep_minus = 0;
					wolf_minus = 0;
					solve(i, j);
					if (wolf_minus >= sheep_minus)
						sheep -= sheep_minus;
					else
						wolf -= wolf_minus;
				}
			}
		}
		System.out.print(sheep + " " + wolf);
	}

	public static void solve(int x, int y) {
		visited[x][y] = true;
		if (arr[x][y] == 'k')
			sheep_minus++;
		if (arr[x][y] == 'v')
			wolf_minus++;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr[0].length || visited[nx][ny] == true
						|| arr[nx][ny] == '#')
					continue;
				solve(nx, ny);

			}

	}

}
