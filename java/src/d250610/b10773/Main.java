package d250610.b10773;

import java.io.*;
import java.util.*;

/* 제로
 * 첫 번째 줄에 정수 K가 주어진다. (1 ≤ K ≤ 100,000)
 * 이후 K개의 줄에 정수가 1개씩 주어진다. 정수는 0에서 1,000,000 사이의 값을 가지며, 
 * 정수가 "0" 일 경우에는 가장 최근에 쓴 수를 지우고, 아닐 경우 해당 수를 쓴다.
 * 정수가 "0"일 경우에 지울 수 있는 수가 있음을 보장할 수 있다.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        // 스택으로 입력 받고, 입력이 0이면 팝
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp == 0) stack.pop();
            else stack.push(tmp);
        }

        // 스택에 남은 수를 모두 합산
        int sum = 0;
        for (int num : stack) {
            sum += num;
        }

        System.out.println(sum);
    }
}
