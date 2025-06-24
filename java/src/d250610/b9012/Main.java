// https://www.acmicpc.net/problem/9012
package d250610.b9012;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 마지막값부터 pop()
 * 2 )면 right++
 * 3 right가 0이 아니면서 (를 만나면 left++
 *   right (를 만나면 no 리턴
 * 4 right == left 면 둘 다 0으로 만들고 2번부터 다시 시작
 */
/*
 * 굳이 마지막값부터 할 필요X
 * 카운트로 풀되 (왼쪽 괄호 갯수 - 오른쪽 괄호 갯수 == 0?) 의 조건으로만 판단하게 되면 예외 커버 못 함
 * 첫 번째 값부터 시작해서 ( 면 left++, )면 left--
 * left == 0이면 올바른 괄호 문자열
 * 단, 확인하는 도중 left가 -가 된다면 ( 없이 )가 나왔다는 뜻이므로 바로 올바르지 않은 괄호 문자열로 판단
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine()); // 괄호 문자열의 줄 수
		StringBuilder result = new StringBuilder(); // 여기에 판정 결과 저장
		
		for (int i = 0; i < t; i++) {
			String str = br.readLine();
			int left = 0;
			
			for (char c : str.toCharArray()) {
				switch (c) {
					case '(' -> left++;
					case ')' -> left--;
				}
				
				if (left < 0) break;
			}
			
			if (left == 0) result.append("YES\n");
			else result.append("NO\n");
		}
		
		System.out.println(result);
	}
}
