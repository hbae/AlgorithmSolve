package day0331;

import java.util.Scanner;

public class BOJ14494_다이나믹이뭐예요 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		long[][] dp = new long[n+1][m+1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				dp[i][j] = 1;
			}
		}
		for (int i = 2; i <=n; i++) {
			for (int j = 2; j <= m ; j++) {
				long temp = (dp[i-1][j] + dp[i][j-1] + dp[i-1][j-1])%1000000007;
				dp[i][j] = temp;
			}
		}
		System.out.println(dp[n][m]);
	}

}
