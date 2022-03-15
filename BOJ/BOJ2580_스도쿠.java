import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

/* 스도쿠 문제 풀기
 * 백트래킹을 활용해서 0이 나올때를 기준으로
 * dfs를 돌려준다.
 * 시간복잡도를 줄이기 위해 0이 나온 좌표를 list에 넣어서
 * 그 부분들만 확인해주려고 한다.
 */

public class Baek2580_스도쿠 {

	static int[][] arr;
	static LinkedList<int[]> list = new LinkedList<>();
	static	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static	StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		arr = new int[9][9];
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0) {
					list.add(new int[] { i, j });
				}
			}
		}
		dfs(0);
	}

	public static void dfs(int count) throws IOException{
		if(count==list.size()) { // 리스트의 사이즈만큼(0의 개수만큼) 돌렸다면 스도쿠 완성이니까 끝
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.setLength(sb.length()-1);
				sb.append("\n");
			}
			bw.write(sb.toString());
			bw.flush();
			bw.close();
			System.exit(0);
		}
		int row = list.get(count)[0];
		int col = list.get(count)[1];
		for (int i = 1; i <= 9; i++) {
			if(check(row,col,i)) {
				arr[row][col] = i;
				dfs(count+1);
				arr[row][col] = 0; //0으로 초기화
			}
		}
	}

	public static boolean check(int row, int col, int num) { // 가로,세로,같은 블롥에 같은 숫자가 있나 체크
		int row_b = row / 3;
		int col_b = col / 3;
		for (int i = 0; i < 9; i++) { // 가로세로 중복체크
			if (arr[row][i] == num)
				return false;
			if (arr[i][col] == num)
				return false;
		}
		for (int i = 0; i < 3; i++) { // 같은 블록내에 있는지 중복 체크
			for (int j = 0; j < 3; j++) {
				if (arr[row_b * 3 + i][col_b * 3 + j] == num)
					return false;
			}
		}
		return true;
	}

}
