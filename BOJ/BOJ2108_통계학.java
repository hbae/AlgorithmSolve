import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

/*	통계학
 *  산술평균, 중앙값, 최빈값(여러개면 두번째로 작은 값), 범위를 구하는 문제
 *  다른 값들은 금방 구할 수 있는데,
 *  최빈값이 여러개면 그 중 두번째로 작은 값을 구해야 하는 부분을 신경써야 함.
 */

public class Baek2108_통계학 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> list = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		int[] count = new int[8001]; // 들어오는 수가 절댓값이 4000 넘지 않으므로 4000씩 더해서 저장해줄것.
		int sum = 0;
		for (int tc = 0; tc < N; tc++) {
			int num = Integer.parseInt(br.readLine());
			sum += num;
			list.add(num);
			count[num + 4000] += 1;
		}
		Collections.sort(list); // 리스트 정렬
		int range = list.get(list.size()-1) - list.get(0); //범위
		int middle = list.get(N/2); // 중앙값
		int most_freq = Integer.MIN_VALUE;
		for (int i = 0; i < count.length; i++) {
			if (count[i] > most_freq) {
				most_freq = count[i];
			}
		}
		int freq_count = 0;
		int freq_ans = 0;
		for (int i = 0; i < count.length; i++) { //최빈값 찾기
			if (count[i]==most_freq && freq_count ==0) {
				freq_ans = i - 4000;
				freq_count++;
			} else if (count[i]==most_freq && freq_count==1) { // 최빈값이 여러개면 그 중 두번째
				freq_ans = i - 4000;
				break;
			}
		}
		sb.append((int) Math.round((double) sum / N)).append("\n");
		sb.append(middle).append("\n");
		sb.append(freq_ans).append("\n");
		sb.append(range);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
