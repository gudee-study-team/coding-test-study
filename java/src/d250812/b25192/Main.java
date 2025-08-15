package d250812.b25192;

import java.io.*;
import java.util.*;

/*
 * enter 후 이름이 입력된 사람들 = 곰곰티콘을 1회 사용한 사람들
 * enter 후 또 enter 가 입력되고 이름이 입력되면
 * 이 사람들은 또 입력된 사람수만큼 곰곰티콘을 1회씩 사용함
 * 
 * enter 입력 후 사람들이 입력되면 set에 넣음
 * 또 enter가 입력되면 set의 크기를 총합에 더하고, set을 초기화
 * ...반복
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// enter가 한 번 입력된 후 곰곰티콘을 쓴 사람들의 이름을 담아둠
		// 중복을 제거하기 위해 Set 사용
		Set<String> set = new HashSet<>();
		int sum = 0; // 곰곰티콘 총 사용 횟수
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String target = br.readLine();
			
			if ("ENTER".equals(target)) {
				// ENTER가 입력되면 이전까지의 곰곰티콘 사용 횟수를 sum에 더하고 Set을 비움
				sum += set.size();
				set.clear();
			} else {
				// ENTER가 입력되지 않았으면 입력값을 Set에 담음
				set.add(target);
			}
		}
		sum += set.size(); // 입력이 끝나면 마지막으로 enter가 입력된 후 곰곰티콘을 쓴 횟수를 sum에 더함
		
		System.out.println(sum);
	}
}
