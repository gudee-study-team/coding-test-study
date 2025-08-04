package d250728.b28279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/*
 * 1. offerFirst()
 * 2. offerLast()
 * 3. pollFirst() : -1 / 혹은 poll() : -1
 * 4. pollLast() : -1 / pop()과 다름!!
 * 5. size()
 * 6. isEmpty() ? 1 : 0
 * 7. getFirst() : -1
 * 8. getLast() : -1
 */
public class Main {
	void handle(String order, Integer x, Deque<Integer> d, StringBuilder sb) {
		switch (order) {
			case "1" -> d.offerFirst(x);
			case "2" -> d.offerLast(x);
			case "3" -> sb.append(d.size() > 0 ? d.pollFirst() : -1);
			case "4" -> sb.append(d.size() > 0 ? d.pollLast() : -1);
			case "5" -> sb.append(d.size());
			case "6" -> sb.append(d.isEmpty() ? 1 : 0);
			case "7" -> sb.append(d.size() > 0 ? d.getFirst() : -1);
			case "8" -> sb.append(d.size() > 0 ? d.getLast() : -1);
		}
		
		if(!("1".equals(order) || "2".equals(order))) sb.append("\n");
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Deque<Integer> d = new ArrayDeque<Integer>();
		Main main = new Main();
		
		for (int i = 0; i < num; i++) {
			String sentence = br.readLine();
			
			if(sentence.contains(" ")) {
				String words[] = sentence.split(" ");
				main.handle(words[0], Integer.parseInt(words[1]), d, sb);
			} else {
				main.handle(sentence, null, d, sb);
			}
		}
		
		System.out.print(sb);
	}
}
