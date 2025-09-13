package d250527.b2798;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * 입력
 * 첫째줄 - 카드 갯수 N(3~100) -> 100^3 = 10^8 => 3중 반복문 가능, 합의 최댓값 M(10~300000)
 * 둘째줄 - N만큼의 숫자들(0~100000) => int 타입 사용
 * 출력: M과 최대한 가까운 카드 3장의 합
 * 
 * 모든 경우의 수를 구해볼까
 * 3중 반복문 돌려서 합이 M보다 작다면 ArrayList에 넣고
 * ArrayList를 오름차순 정렬한 다음
 * 마지막 인덱스의 값 출력
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// N(cardNum), M(max)을 입력받음
		int cardNum = sc.nextInt();
		int max = sc.nextInt();
		
		// 숫자들을 담을 배열 선언
		Integer[] cardNums = new Integer[cardNum];
		
		// N만큼의 숫자들을 입력받아 배열 초기화
		for (int i = 0; i < cardNums.length; i++) {
			cardNums[i] = sc.nextInt();
		}
		
		// 모든 합의 결과를 담을 ArrayList 선언
		ArrayList<Integer> sumList = new ArrayList<Integer>();
		
		// 배열을 3중 반복문 안에서 돌면서 ArrayList에 추가
		for (int i = 0; i < cardNums.length; i++) {
			for (int j = 0; j < cardNums.length; j++) {
				for (int j2 = 0; j2 < cardNums.length; j2++) {
					if (i == j || i == j2 || j == j2) continue; // 같은 카드를 두 번 이상 뽑을 수는 없으므로, 이 경우 다음 반복으로 넘어감					
					int Cardsum = cardNums[i] + cardNums[j] + cardNums[j2];
					if (Cardsum > max) continue; // 합이 최댓값보다 크면 리스트에 추가하지 않음
					sumList.add(Cardsum);
				}
			}
		}
		
		// ArrayList 오름차순 정렬
		Collections.sort(sumList);
		System.out.println(sumList.get(sumList.size() - 1));
	}
}
