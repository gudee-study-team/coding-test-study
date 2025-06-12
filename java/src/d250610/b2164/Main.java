package d250610.b2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 카드 갯수 입력
		int cardNum = Integer.parseInt(br.readLine());
		br.close();
		
		// Stack 클래스 사용
//		long start = System.nanoTime();
//		// 카드 갯수 ~ 1 까지 한 장씩 위로 쌓는다.
//		Stack<Integer> cards = new Stack<Integer>();
//		for (int i = cardNum; i >= 1; i--) {
//			cards.push(i);
//		}
//		
//		while (true) {
//			// 맨 위의 카드를 버린다.
//			cards.pop();
//			// 맨 위의 카드를 맨 아래로 옮긴다.
//			cards.add(0, cards.pop());
//			// 카드가 한 장 남으면 반복을 멈추고 카드 번호를 출력한다.
//			if (cards.size() == 1) {
//				System.out.print(cards.pop());
//				break;
//			}
//		}
//		long end = System.nanoTime();
//		System.out.println(end-start);
		
		if (cardNum == 1) {
			System.out.println(cardNum);
			return;
		}
		
		
		// 2로 나눈 나머지가 0이면서 몫이 짝수인 수 중 가장 큰 수가 남음
		for (int i = cardNum; i >= 1; i--) {
			// 2의 제곱수인지 검증
			// 어떻게?
			// 2로 나눈 몫
			// 그 몫을 가지고 또 2로 나누고
			// 몫이 7 이하가 됐을 때, 2/4/8이면 2의 제곱수
			int target = i;
			while (target > 7) {
				target /= 2;
			}
			
			
			if (target == 2 || target == 4 || target == 8) {
				System.out.println(i);
				return;
			}
		}
	}
}
