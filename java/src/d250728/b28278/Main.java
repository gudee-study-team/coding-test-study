package d250728.b28278;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/*
 * 1: d.push(x)
 * 2: d.pop() or -1
 * 3: d.size()
 * 4: d.isEmpty()? 1 : 0
 * 5: d.getLast() or -1
 */
public class Main {
	void handle(Deque<Integer> d, String order, Integer x, StringBuilder sb) {
		switch (order) {
			case "1" -> d.push(x); // d.add(x) 아님
			case "2" -> sb.append(d.size() > 0 ? d.pop() : -1).append("\n");
			case "3" -> sb.append(d.size()).append("\n");
			case "4" -> sb.append(d.isEmpty() ? 1 : 0).append("\n");
			case "5" -> sb.append(d.size() > 0 ? d.getLast() : -1).append("\n");
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Deque<Integer> d = new ArrayDeque<Integer>();
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Main main = new Main();
		
		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; i++) {
			String sentence = br.readLine();
			
			if(sentence.contains(" ")) {
				String words[] = sentence.split(" ");
				main.handle(d, words[0], Integer.parseInt(words[1]), sb);
			} else {
				main.handle(d, sentence, null, sb);
			}
		}
		
		System.out.print(sb);
	}
}
