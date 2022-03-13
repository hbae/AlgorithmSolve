import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


/*	모을 수 있는 에너지 양의 최댓값을 구하는 프로그램 만들기
 *  각 에너지 구슬들의 무게를 자유롭게 넣었다 뺐다 하기 위해 arrayList로 구현
 *  dfs를 활용해서 풀었다.
 */

public class Baek16918_에너지모으기 {
	
	static int N, res;
	static ArrayList<Integer> numbers = new ArrayList<>(); // 에너지 구슬의 무게를 담아줄 리스트

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers.add(Integer.parseInt(st.nextToken()));
		}
		dfs(0);
		System.out.println(res);
	}
	
	public static void dfs(int sum) {
		if (numbers.size()==2) { //적어도 3개 이상의 구슬이 있어야지 에너지를 구할 수 있기 때문에
			res = Math.max(res, sum);
			return;
		}
		for (int i = 1; i < numbers.size()-1; i++) {
			int x = numbers.get(i);
			int temp = numbers.get(i-1) * numbers.get(i+1);
			numbers.remove(i); //선택된 에너지 구슬 제거
			dfs(sum+temp); //모인 에너지를 이전까지의 에너지 구슬의 합에 더해준 다음에 다시 dfs
			// 제거되었었던 i번째 에너지 구슬을  그 인덱스에 다시 넣어주기 (원상복구 시켜서 다른 케이스 확인해야되니까)
			numbers.add(i, x); 
		}
	}
}
