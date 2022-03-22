import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baek1911_흙길보수하기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][2];
		for (int tc = 0; tc < N; tc++) {
			st = new StringTokenizer(br.readLine());
			arr[tc][0] = Integer.parseInt(st.nextToken());
			arr[tc][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0]==o2[0])
					return o1[1]-o2[1];
				return o1[0]-o2[0];
			}
		});
		
		int count = 0;
		int length = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i][0] > length)
				length = arr[i][0];
			if (arr[i][1] >= length) {
				while (arr[i][1]>length) {
					length += L;
					count++;
				}
			}
		}
		System.out.println(count);

	}

}
