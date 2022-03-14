import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

/* 절댓값 힙을 구현하는 문제 (절대값이 작은순대로, 절댓값이 여러개일 때는 더 작은수)
 * 작은 수들을 빼주려면 priorityQue를 활용하는게 효율적이다.
 * 대신 절댓값을 기준으로 해줘야하기 때문에 메서드 오버라이딩해줘서 
 * 절댓값을 기준으로 정렬한다.
 * 
 */

public class Baek11286_절댓값힙 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1) == Math.abs(o2)) // 절댓값이 같은 경우 더 작은수
					return o1 - o2;
				return Math.abs(o1) - Math.abs(o2); // 그게 아니라면 절댓값 기준으로 정렬
			}
		});

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			if (temp == 0) { // 0일때 절댓값이 가장 작은 값 출력, 제거
				if (pq.isEmpty()) // pq가 비었을때는 0출력
					sb.append("0").append("\n");
				else // pq가 안 비었다면 가장 작은 값 출력
					sb.append(pq.poll()).append("\n");
			} else //0이 아니라면 pq에 입력
				pq.add(temp);
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

}
