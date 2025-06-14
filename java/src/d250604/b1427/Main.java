package d250604.b1427;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String n = sc.nextLine();
		
		// List 사용
//		long start = System.nanoTime();
//		List<Character> list = new ArrayList<Character>();
//		for (int i = 0; i < n.length(); i++) {
//			list.add(n.charAt(i));
//		}
//		
//		Collections.sort(list, Collections.reverseOrder());
//		
//		list.forEach(e -> System.out.print(e));
//		System.out.println();
//		long end = System.nanoTime();
//		System.out.println(end - start);
		
		// 배열 사용
//		long start = System.nanoTime();
		Character[] nums = new Character[n.length()];
		for (int i = 0; i < n.length(); i++) {
			nums[i] = n.charAt(i);
		}
		
		Arrays.sort(nums, Collections.reverseOrder());
		
		for (Character c : nums) {
			System.out.print(c);
		}
		System.out.println();
//		long end = System.nanoTime();
//		System.out.println(end - start);
	}
}
