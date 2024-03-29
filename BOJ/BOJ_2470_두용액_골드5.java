import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 : 280ms
// 메모리 : 31288KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] liquid = new int[N];
		
		for (int i = 0; i < N; i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(liquid);
		
		if(liquid[0] > 0) {
			System.out.println(liquid[0] + " " + liquid[1]);
			return;
		} else if(liquid[N - 1] < 0) {
			System.out.println(liquid[N - 2] + " " + liquid[N - 1]);
			return;
		}
		
		int start = 0;
		int end = N - 1;
		int min = Integer.MAX_VALUE;
		
		int ans1 = 0;
		int ans2 = 0;
		
		while(start < end) {
			
			int sum = liquid[start] + liquid[end];
			if(Math.abs(sum) < min) {
				min = Math.abs(sum);
				ans1 = liquid[start];
				ans2 = liquid[end];
			}
			
			if(sum == 0) {
				ans1 = liquid[start];
				ans2 = liquid[end];
				break;
			} else if(sum > 0) {
				end--;
			} else {
				start++;
			}
		}
		
		System.out.println(ans1 + " " + ans2);
	}

}
