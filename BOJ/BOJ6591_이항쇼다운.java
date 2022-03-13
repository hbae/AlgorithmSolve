import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*	Combination을 어떻게 효율적으로 구할 것인가를 물어보는 문제
 *  nCr = nPr/r! 의 원리를 이용해서 풀것
 *  즉 10C2는 10*9*8*7*6 / 5*4*3*2*1 인데
 *  이를 효율적으로 해결해보자
 */

public class Baek6591_이항쇼다운 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			if (N==0 & K==0)
				break;
			K = Math.min(K, N-K); //10C8 == 10C2이므로 계산을 적게 해주기 위해 K에 8이 아닌 2를 넣고자한다
			long res = 1; // 곱해지는 변수인데 주어진 숫자의 범위가 2^31-1까지이므로
			// 곱해지다 보면 int 범위를 초과할 수 있기 때문에 long형으로
			
			// 왜 큐로 구현했는가?
			// 10C2를 예로 들어보면 10*9*8*7*6을 굳이 다 곱하기 전에도 충분히
			// 5,4,3,2,1로 나눠주면 되기 때문에
			// 나눠지는 것들은 미리 나눠주려고 했다.
			Queue<Integer> queue = new LinkedList<Integer>();
			for (int i = K; i >=1 ; i--) {
				queue.add(i);
			}
			for (int i = N; i > N-K; i--) {
				res *= i;
				int test = queue.size();
				for (int tc = 1; tc <=test; tc++) { // 계속 반복되는 걸 방지하기위해 tc를 큐사이즈만큼만
					if (res%queue.peek()==0) { // 나눠질 수 있는 수면 큐에서 빼버림
						res /= queue.poll();
					} else { // 그게 아니라면 큐에 다시 집어넣어줌
						queue.add(queue.poll());
					}
				}
			}
			sb.append(res).append("\n");
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
