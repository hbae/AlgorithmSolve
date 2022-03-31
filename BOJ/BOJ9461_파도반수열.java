package day0331;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ9461_파도반수열 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		long[] dp = new long[101];
		dp[1]=1;
		dp[2]=1;
		dp[3]=1;
		dp[4]=2;
		for (int i = 5; i <=100; i++) {
			dp[i] = dp[i-1] + dp[i-5];
		}
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N]).append("\n");
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
