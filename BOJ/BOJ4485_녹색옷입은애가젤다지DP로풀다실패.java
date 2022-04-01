package day0401;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ4485_녹색옷입은애가젤다지DP로풀다실패 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc = 0;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if (N==0)
				break;
			tc++;
			long[][] dp = new long[125][125];
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i==0 && j==0) // 시작점
						dp[i][j] = arr[i][j];
					else if(i==0) //맨 윗줄
						dp[i][j] = dp[i][j-1] + arr[i][j];
					else if(j==0) // 맨 왼쪽줄
						dp[i][j] = dp[i-1][j] + arr[i][j];
					else
						dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + arr[i][j];
				}
			}
			sb.append("Problem ").append(tc).append(": ").append(dp[N-1][N-1]).append("\n");
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
