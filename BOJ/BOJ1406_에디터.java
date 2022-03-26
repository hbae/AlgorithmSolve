import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

/*
 * 링크드리스트는 add, remove할때 앞에서부터 그 인덱스까지 검색해주기 때문에
 * 시간복잡도가 O(N)이 나오므로 시간초과가 나온다.
 * listIterator를 공부할 수 있었던 계기
 */
public class Baek1406_에디터 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		LinkedList<Character> list = new LinkedList<>();
		StringTokenizer st;
		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i));
		}
		ListIterator<Character> iter = list.listIterator();
		int N = Integer.parseInt(br.readLine());
		while(iter.hasNext()) {
			iter.next();
		}

		for (int tc = 0; tc < N; tc++) {
			st = new StringTokenizer(br.readLine());
			char command = st.nextToken().toCharArray()[0];
			switch (command) {
			case 'L':
				if (iter.hasPrevious())
					iter.previous();

				break;
			case 'D':
				if (iter.hasNext())
					iter.next();

				break;
			case 'B':
				if (iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
				break;
			case 'P':
				iter.add(st.nextToken().toCharArray()[0]);

				break;
			default:
				break;
			}
		}
		while (!list.isEmpty()) {
			sb.append(list.poll());
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
