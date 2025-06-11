package d250610.b9012;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/*
 * VPS 안에 VPS가 들어가있으면 -> VPS
 * VPS + VPS 면 -> VPS
 * 반대로,
 * !VPS 면 -> VPS 안에 VPS가 들어가있지 않음
 * !VPS 면 -> VPS + VPS 가 아님
 */

/*
 * 입력
 * 첫째줄: T (입력 데이터 수)
 * 한 줄씩 괄호 문자열 (길이: 2~50)
 * 출력
 * VPS이면 YES, 아니면 NO
 */

// (이면 +1, )이면 -1을 더해서 0이면 YES 출력
// ㄴ 실패. 왜?
// ())(() 인 경우 YES가 출력됨
// VPS + ) 혹은 ( + VPS 인 경우에는 VPS가 될 수 없음

// LinkedList에 넣어서 ()면 빼고 빼고....남는게 있으면 NO, 없으면 YES 
// ㄴ근데 이러면 로직이 복잡해지기도 하고, 스택큐를 활용하는 게 아님

/*
 * 마지막값부터 pop()
 * 2 )면 right++
 * 3 right가 0이 아니면서 (를 만나면 left++
 *   right (를 만나면 no 리턴
 * 4 right == left 면 둘 다 0으로 만들고 2번부터 다시 시작
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> parentheses = new Stack<>();
		int t = sc.nextInt();
		sc.nextLine();
		
		// t번 입력받고, 입력받을 때마다 출력
		
		for (int i = 0; i < t; i++) {
			// 문자열 한 줄을 입력받아 Queue에 한 문자씩 넣음
			for (Character c : sc.nextLine().toCharArray()) {
				parentheses.push(c);
			}
			
			String result = "YES";
			int right = 0;
			int left = 0;
			
			switch(parentheses.pop()) {
				case '(' -> result = "NO";
				case ')' -> left++;
			}
			
			loop: while (!parentheses.isEmpty()) {
				switch(parentheses.pop()) {
					case '(' -> {
						if (right == 0) {
							result = "NO";
							break loop;
						} else right++;
					}
					case ')' -> left++;
				}
				
				if (right == left) {
					right = 0;
					left = 0;
				}
			}
			
			System.out.println(result);
		}
	}
}
