// https://www.acmicpc.net/problem/10773
package d250610.b10773;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	// 입력받은 수의 총합을 구함
	// 조건
	// 0을 입력받으면 바로 전에 입력한 수를 총합에서 뺌
	// 0이 아니면 총합에 더함
	// 0이 연속으로 나온 경우, 전에 입력한 수, 그 전에 입력한 수....를 지워야 함
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		
		Deque<Integer> memory = new LinkedList<Integer>();
		
		int sum = 0;
		// k번 입력받음
		for (int i = 0; i < k; i++) {
			int num = Integer.parseInt(br.readLine());
			
			// 0일 때: 전에 입력한 수를 총합에서 뺌
			if (num == 0) {
				sum -= memory.pollLast();
				
			}
			// 0이 아닐 때: 총합에 더함
			else {
				sum += num;
				memory.addLast(num);
			}
		}
		
		System.out.println(sum);
	}
}
