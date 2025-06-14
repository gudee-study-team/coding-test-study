package d250610.b9012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;


// (이면 +1, )이면 -1을 더해서 0이면 YES 출력
// ㄴ 실패. 왜?
// ())(() 인 경우 YES가 출력됨
// VPS + ) 혹은 ( + VPS 인 경우에는 VPS가 될 수 없음

/*
 * 마지막값부터 pop()
 * 2 )면 right++
 * 3 right가 0이 아니면서 (를 만나면 left++
 *   right (를 만나면 no 리턴
 * 4 right == left 면 둘 다 0으로 만들고 2번부터 다시 시작
 */
public class Main {
	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		Stack<Character> parentheses = new Stack<>();
		Deque<Character> parentheses = new LinkedList<Character>();
		int t = Integer.parseInt(br.readLine());
		
		// t번 입력받고, 입력받을 때마다 출력
		for (int i = 0; i < t; i++) {
			// 문자열 한 줄을 입력받아 Stack에 한 문자씩 넣음
			for (char c : br.readLine().toCharArray()) {
//				parentheses.push(c);
				parentheses.addLast(c);
			}
			
			String result = "YES";
			int right = 0;
			int left = 0;
			
			switch(parentheses.pollLast()) {
			case '(' -> result = "NO";
			case ')' -> right++;
			}
			
			loop: while (!parentheses.isEmpty()) {
				switch(parentheses.pollLast()) {
					case '(' -> {
						if (right == 0) {
							result = "NO";
							break loop;
						} else left++;
					}
					case ')' -> right++;
				}
				
				if (right == left) {
					right = 0;
					left = 0;
				}
			}
			
			if (right != left) result = "NO";
			
			System.out.println(result);
			parentheses.clear();
			right = 0;
			left = 0;
		}
	}
}
