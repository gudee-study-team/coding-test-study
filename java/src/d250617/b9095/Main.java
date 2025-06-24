package d250617.b9095;

/*
규칙을 못 찾아서 검색해서 참고함
n	갯수
1	1
2	2
3	4
4	7
5	13
n>=4 인 경우부터는 앞의 세 개 경우의 갯수를 합친 것이 답
 */
/*
 * 그러면
 * n=1일 때의 갯수
 * n=2일 때의 갯수
 * n=3일 때의 갯수
 * n=4일 때부터는 n-1, n-2, n-3을 더함
 */
/*
 * n = t-1일 때까지 갯수를 구하고, t-2, t-3을 더함
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int cal(int n) {
		int num = 0;
		if (n == 1) {
			num = 1;
		} else if (n == 2) {
			num = 2;
		} else if (n == 3) {
			num = 4;
		} else {
			num = cal(n-1) + cal(n-2) + cal(n-3);
		}
		return num;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(cal(n));
		}
	}
}
