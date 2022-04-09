package day0409;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14890_경사로 {

	static int[][] arr, arr2;
	static int N, X;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		arr2 = new int[N][N];
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr[i].length; j++) {
				int temp = Integer.parseInt(st.nextToken());
				arr[i][j] = temp;
				arr2[j][i] = temp;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (check(arr[i]))
				res++;
			if (check(arr2[i]))
				res++;
		}
		System.out.println(res);
	}

	public static boolean check(int[] arr) {
		int currentnum = arr[0];
		int numcnt = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == currentnum) { // 이전 숫자랑 같으면 개수세주기
				numcnt++;
				continue;
			}
			if (Math.abs(arr[i] - currentnum) != 1) // 1보다 차이많이나면
				return false;
			if (arr[i] == currentnum + 1) { // 위로 올라가는 경사로
				if (numcnt < X) // 경사로 길이만큼 없으면
					return false;
				else { // 경사로 길이만큼 있으면 갱신해주고 다시 시작
					numcnt = 1;
					currentnum = arr[i];
					continue;
				}
			}
			if (arr[i] == currentnum - 1) { // 아래로 내려가는 경사로
				if (i + X > N) // 경사로를 놓을만큼 길이가 안된다면(indexoutofbound)
					return false;
				for (int j = i; j < i + X; j++) { // 경사로만큼 앞에 텀이 있는지 확인
					if (arr[j] != currentnum - 1) { // 경사로만큼 텀이 없다면
						return false;
					}
				}
				// 아래로 내려가는 경사로를 지어주고 새 위치 갱신
				for (int j = 0; j < X - 1; j++) {
					i++;
				}
				currentnum = arr[i];
				numcnt = 0; // 경사로까지 다쓴상태니까
			}
		}
		return true;
	}

}
