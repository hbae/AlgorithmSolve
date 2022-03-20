import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek2841_외계인의기타연주 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Integer>[] stacks = new Stack[7];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int count = 0;
		for (int tc = 0; tc <= 6 ; tc++) {// 줄이 여섯개
			stacks[tc] = new Stack<>();
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int line = Integer.parseInt(st.nextToken());
			int flat = Integer.parseInt(st.nextToken());
			// 현재 플랫보다 클 경우 작은값 나올때까지 빼줌
			while(!stacks[line].isEmpty() && stacks[line].peek()>flat) {
				stacks[line].pop();
				count++;
			}
			// 숫자가 더 큰 클랫이라면 추가
			if(stacks[line].isEmpty()||stacks[line].peek()<flat) {
				stacks[line].push(flat);
				count++;
			}
			
		}
		System.out.println(count);

	}

}
