import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * A->B
 * 연산은 두가지
 * 2를 곱하거나, 1을 수의 가장 오른쪽에 추가
 * 이를 실행해 나가면서 연산의 최소 횟수를 구한다.
 * 
 */
public class Baek16953_A에서B {
	static long a, b; // 입력값이 a,b가 10^9까지 가므로 long형으로 선언해준다.
	static int res = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		solve(0, a);
		if (res == Integer.MAX_VALUE) // a에서 b를 만들 수 없는 경우
			System.out.println("-1");
		else
			System.out.println(res);
	}

	public static void solve(int count, long n) {
		if (n == b) { // b에 도달하면 count세준다
			res = Math.min(res, count + 1);
			return;
		}
		if (n > b) {
			return;
		}
		if (n * 2 <= b)
			solve(count + 1, n * 2);
		if ((n * 10 + 1) <= b)
			solve(count + 1, n * 10 + 1);
	}
}
