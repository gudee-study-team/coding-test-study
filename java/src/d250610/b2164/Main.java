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
		
		// StringBuilder 사용
		long start = System.nanoTime();
		// 카드 갯수 ~ 1 까지 한 장씩 위로 쌓는다.
		StringBuilder sb = new StringBuilder();
		for (int i = cardNum; i >= 1; i--) {
			sb.append(i);
		}
		
		while (true) {
			// 맨 위의 카드를 버린다.
//			System.out.println(sb.deleteCharAt(sb.length()-1));	
			sb.deleteCharAt(sb.length()-1);
			System.err.println(sb);
//			System.out.println(sb);
			// 맨 위의 카드를 맨 아래로 옮긴다.
			char topCard = sb.charAt(sb.length()-1);
			sb = String.valueOf(topCard) + sb.deleteCharAt(sb.length()-1);
			System.out.println(sb);
			// 카드가 한 장 남으면 반복을 멈추고 카드 번호를 출력한다.
			if (sb.length() == 1) {
				System.out.print(sb);
				break;
			}
		}
		long end = System.nanoTime();
//		System.out.println(end-start);
	}
}
