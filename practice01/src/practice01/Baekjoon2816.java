package practice01;

import java.util.ArrayList;
import java.util.Scanner;

// 시간 초과로 통과 못함....
public class Baekjoon2816 {
	public static void main(String[] args) {
		// 1. 첫째 줄에 채널의 수가 입력됨(2~100)
		// 2. 채널 이름이 한 줄에 하나씩 입력됨(최대 10글자씩)
		// 이미 KBS1이 첫 번째에, KBS2가 두 번째에 있는 입력은 주어지지 않음
		// 3. 출력: 상근이가 눌러야 하는 버튼을 순서대로 출력(공백X)
		// 방법의 길이는 500보다 작아야
		
		Scanner sc = new Scanner(System.in);
		
		int channelLen = sc.nextInt();
		sc.nextLine();
		ArrayList<String> channels = new ArrayList<String>();
		
		for (int i = 0; i < channelLen; i++) {
			String str = sc.nextLine();
			channels.add(str);
		}
		
		int currentIdx = 0;
		String target = channels.get(currentIdx);
		
		while (true) {
			if (!"KBS2".equals(target)) {
				// KBS2를 찾을 때까지 탐색하며 resu-lt += "3" 수행,
				// KBS2를 찾으면 target과 KBS2의 위치를 서로 바꿈, currentIdx를 기억
				for (int i = currentIdx; i < channels.size(); i++) {
					if ("KBS2".equals(channels.get(i))) {
						channels.add(i+1, target);
						channels.remove(currentIdx);
						currentIdx = i;
						break;
					}
					System.out.print(3);
				}
			}
			
			if ("KBS1".equals(channels.get(0)) && "KBS2".equals(channels.get(1))) return;
			
			// KBS1 만날 때까지 아래로 이동
			for (int i = currentIdx; i < channels.size(); i++) {
				if ("KBS1".equals(channels.get(i))) {
					currentIdx = i;
					target = channels.get(i);
					break;
				}
				System.out.print(1);
			}
			
			// KBS1를 만나면 맨 위로 옮김
			channels.remove(currentIdx);
			channels.add(0, target);
			for (int i = 0; i < currentIdx; i++) {
				System.out.print(4);
			}
			currentIdx = 0;

			if ("KBS1".equals(channels.get(0)) && "KBS2".equals(channels.get(1))) return;
			
			// KBS1/KBS2외의 채널을 만날 때까지 아래로 이동
			for (int i = currentIdx; i < channels.size(); i++) {
				if (!"KBS1".equals(channels.get(i)) && !"KBS2".equals(channels.get(i))) {
					currentIdx = i;
					target = channels.get(i);
					break;
				}
				System.out.print(1);
			}
		}
	}
}
