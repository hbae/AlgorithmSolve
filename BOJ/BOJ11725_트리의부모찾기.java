import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*	트리의 부모 찾기
 * 1번이 루트노드
 * 리스트를 생성하여 노드들의 연결관계를 담아준다.
 * dfs를 활용하여 부모노드들을 담아준다.
 * 
 */

public class Baek11725_트리의부모찾기 {

	static int[] parents;
	static List<Integer>[] list;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		parents = new int[N + 1];
		isSelected = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int tc = 0; tc < N - 1; tc++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			list[node1].add(node2); // 각 정점들의 관계를 담아줌
			list[node2].add(node1);
		}
		dfs(1);
		for (int i = 2; i < parents.length; i++) {
			sb.append(parents[i]).append("\n");
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	public static void dfs(int n) {
		isSelected[n] = true;
		for (int i : list[n]) {
			if (isSelected[i] == false) {
				parents[i] = n;
				dfs(i);
			}
		}

	}

}
