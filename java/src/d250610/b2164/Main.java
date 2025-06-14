// https://www.acmicpc.net/problem/2164
package d250610.b2164;

// 뭐가 틀린건지 감도 안오네
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		// 카드 갯수 입력
		int cardNum = Integer.parseInt(br.readLine());
		
		long s = System.nanoTime();
		
		// Queue 사용
		// 카드 갯수 ~ 1 까지 한 장씩 위로 쌓는다.
		Queue<Integer> cards = new LinkedList<Integer>();
		for (int i = 1; i <= cardNum; i++) {
			cards.offer(i);
		}
		
		while (true) {
			// 카드가 한 장 남으면 반복을 멈추고 카드 번호를 출력한다.
			if (cards.size() <= 1) break;
			
			// 맨 위의 카드를 버린다.
			cards.poll();
			// 맨 위의 카드를 맨 아래로 옮긴다.
			cards.offer(cards.poll());
		}
		System.out.println(cards.poll());
		
		long e = System.nanoTime();
		System.out.println(e-s);
		
		// Stack 사용
		/*
		// 카드 갯수 ~ 1 까지 한 장씩 위로 쌓는다.
		Stack<Integer> cards = new Stack<Integer>();
		for (int i = cardNum; i >= 1; i--) {
			cards.push(i);
		}
		
		while (true) {
			// 카드가 한 장 남으면 반복을 멈추고 카드 번호를 출력한다.
			if (cards.size() == 1) break;

			// 맨 위의 카드를 버린다.
			cards.pop();
			// 맨 위의 카드를 맨 아래로 옮긴다.
			cards.add(0, cards.pop());
		}
		System.out.println(cards.pop());
		
		long e = System.nanoTime();
		System.out.println(e-s);
		*/
	}
}
