package d250610.b2164;

import java.io.*;
import java.util.*;

/* 카드2
 * 첫째 줄에 정수 N(1 ≤ N ≤ 500,000)이 주어진다.
 */
public class Main {

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 데이터를 큐에 저장
        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            que.offer(i);
        }

        int count = 0;
        while (que.size() > 1) {
            if (count % 2 == 0) {// 큐를 순회하면서 순서가 짝수라면 꺼내고
                que.poll();
            } else { // 순서가 홀수면 꺼내서 제일 뒤에 저장
                que.offer(que.poll());
            }
            count++;
        }

        // 마지막 남은 데이터를 출력
        System.out.println(que.peek());
    }
}
