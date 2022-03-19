import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 입력값의 개수가 10,000,000이므로 이를 하나씩 처리해주면 메모리 초과가 난다.
 * 출력값이 많으므로 stringbuilder 필수
 * 각 원소의 개수를 저장해줌
 */
public class Baek10989_수정렬하기3{
	
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] count = new int[10001];

        for(int i=0; i<N; i++) {
            count[Integer.parseInt(br.readLine())]++;
        }

        for(int i=1; i<=10000; i++){
            if(count[i]>0) {
                for (int k = 0; k < count[i]; k++) { //개수만큼 처리해주기 위해
                    sb.append(i).append('\n');
                }
            }
        }
        System.out.println(sb.toString());
    }
}
