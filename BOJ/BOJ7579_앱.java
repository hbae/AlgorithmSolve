import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	
	public static void main(String [] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int N= Integer.parseInt(st.nextToken());
		int M= Integer.parseInt(st.nextToken());
        int sum = 0;
		int[] memory= new int[N];
		int[] cost= new int[N];
		
		st= new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			memory[i]= Integer.parseInt(st.nextToken());
		}
		
		st= new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			cost[i]= Integer.parseInt(st.nextToken());
			sum+=cost[i];
		}
		
		int[] dp= new int[sum+1];
		for(int i=0; i<N; i++) {
			for(int j=sum; j>=cost[i]; j--) {
				dp[j]=Math.max(dp[j], dp[j-cost[i]]+memory[i]);
			}
		}
		
		for(int i=0; i<=sum; i++) {
			if(dp[i]>=M) {
				System.out.println(i);
				break;
			}
		}
	}
}
