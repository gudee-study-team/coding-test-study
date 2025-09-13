package d250812.b26069;

import java.util.*;
import java.io.*;

/*
 * ChongChong을 Set에 넣음
 * 입력된 두 개 중 하나라도 Set에 넣어져 있다면 둘 다 Set에 넣음
 * Set의 크기 출력 
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<String> set = new HashSet<>(); // 춤을 추는 사람을 넣는 Set
		int n = Integer.parseInt(br.readLine());
		
		// ChongChong을 미리 Set에 넣어두고,
		// 이후에 한 줄에 입력되는 두 값 중 하나라도 Set에 들어있다면 둘 다 Set에 넣음
		// 로직이 간단한데 반복문이 많아서 반복문을 줄이기 위해 stream() 을 사용함
		set.add("ChongChong"); 
		for (int i = 0; i < n; i++) {
			// stream()을 이용하기 위해 입력된 값을 Collection에 담음
			List<String> pair = List.of(br.readLine().split(" ")); 
			if (pair.stream().anyMatch(e -> set.contains(e))) { // anyMatch(조건) 조건에 맞으면 true 반환
				set.addAll(pair);
			}
		}
		
		System.out.println(set.size());
	}
}
