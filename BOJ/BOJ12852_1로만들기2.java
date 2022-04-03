package day0403;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ12852_1로만들기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		int[] link = new int[N + 1];
		dp[0] = 0;
		dp[1] = 0;
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + 1;
			link[i] = i - 1;
			if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
				dp[i] = dp[i / 3] + 1;
				link[i] = i / 3;
			}
			if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
				dp[i] = dp[i / 2] + 1;
				link[i] = i / 2;
			}
		}
		sb.append(dp[N]).append("\n");
		while(N>0) {
			sb.append(N).append(" ");
			N = link[N];
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
