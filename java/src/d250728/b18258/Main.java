package d250728.b18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class Main {
	void pop(Deque<Integer> d, StringBuilder sb) {
		try {
			sb.append(d.pop());
		} catch (NoSuchElementException e) {
			sb.append(-1);
		}
		sb.append("\n");
	}
	
	void empty(Deque<Integer> d, StringBuilder sb) {
		sb.append(d.isEmpty()? 1 : 0).append("\n");
	}
	
	void front(Deque<Integer> d, StringBuilder sb) {
		try {
			sb.append(d.getFirst());
		} catch (NoSuchElementException e) {
			sb.append(-1);
		}
		sb.append("\n");
	}
	
	void back(Deque<Integer> d, StringBuilder sb) {
		try {
			sb.append(d.getLast());
		} catch (NoSuchElementException e) {
			sb.append(-1);
		}
		sb.append("\n");
	}
	
	void size(Deque<Integer> d, StringBuilder sb) {
		sb.append(d.size()).append("\n");
	}
	
	void handle(String order, Deque<Integer> d, Integer x, StringBuilder sb) {
		switch (order) {
			case "push"-> d.add(x);
			case "pop" -> pop(d, sb);
			case "size" -> size(d, sb);
			case "empty" -> empty(d, sb);
			case "front" -> front(d, sb);
			case "back" -> back(d, sb);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Deque<Integer> d = new ArrayDeque<Integer>();
		Main main = new Main();
		StringBuilder sb = new StringBuilder(); // 시간 초과를 해결하기 위해 sb에 출력할 내용을 모아놨다가 한번에 출력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String sentence = br.readLine();
			
			if(sentence.contains(" ")) {
				// push
				String words[] = sentence.split(" ");
				main.handle(words[0], d, Integer.parseInt(words[1]), sb);
			} else {
				// 나머지 모두
				main.handle(sentence, d, null, sb);
			}
		}
		
		System.out.print(sb);
		
		/* test
		d.add(1);	
		d.add(2);
		System.out.println(d.pop()); // 1;
		System.out.println(d.pop()); // 2;
//		d.pop(); // NoSuchElementException
		
		d.add(3);	
		d.add(4);
		System.out.println(d.size()); // 2
		System.out.println(d.isEmpty()); // false
		System.out.println(d.getFirst()); // 3
		System.out.println(d.getLast()); // 4
		d.pop();
		d.pop();
//		d.getFirst(); //NoSuchElementException
		System.out.println(d.size());
		*/
	}
}
