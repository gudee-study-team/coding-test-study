package d250604.b1427;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * 어떻게 한담........
 * 쉽게 간다고 치면
 * n을 문자열로 받아서 char 배열로 만든 다음에 그걸 내림차순으로 Arrays.sort 하면 되긴 하는데...
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		String n = sc.nextLine();
		String n = sc.nextLine();
		
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
