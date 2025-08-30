package d250825.b2606;

import java.io.*;
import java.util.*;

/*
 * 컴퓨터의 수는 100이하... 시간초과 신경쓰지 않고 구현만 하면 될 듯
 * https://coding-business.tistory.com/118
 * 이중 배열을 사용해서 구현
 * 1 2가 들어왔다 치면
 * arr[1][2] += 1, arr[2][1] += 1을 하는 거임 (양방향으로 연결)
 * 
 * 첫째줄은 컴퓨터의 수 n
 * 배열은 arr[n][n]으로 생성
 */
public class Main {
	public static void main(String[] args) throws Exception {
//		int n = 7;
//		int m = 6;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine()); // 안씀

		int arr[][] = new int[n][n];
		
		for (int i = 0; i < m; i++) {
			String input[] = br.readLine().trim().split(" ");
			int left = Integer.parseInt(input[0]);
			int right = Integer.parseInt(input[1]);
			
			arr[left - 1][right - 1] += 1;
			arr[right - 1][left - 1] += 1;
		}
		
		// arr[1]에서 값이 1 이상인 인덱스는 바이러스 감염
		// 감염 목록을 set에 담음
		// arr[2]로 이동
		// 2가 만약 감염 목록에 있다면 arr[2]를 확인하며 set에 담고, 없다면 패스
		
		Set<Integer> set = new HashSet<>();
		set.add(1);
		
		// set에 더이상 추가되지 않을 때까지 순회 -> 시간 초과...
		/*
		boolean isChanged = true;
		while(isChanged) {
			isChanged = false; // set에 추가했는지 여부의 기본값을 false로 설정
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!set.contains(i)) continue;
					else if (arr[i][j] > 0) {
						set.add(j);
						isChanged = true; // 추가되면 true로 변경
					}
				}
			}			
		}
		*/
		
		// 문제는 1을 통해 감염된 pc의 수를 요구하고 있기 때문에
		// set에서 1을 제외한 size를 출력
		System.out.println(set.size() - 1);
	}
}
