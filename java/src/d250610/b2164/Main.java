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

        // 홀수는 버리고 시작하는데 1이 들어오면 케이스가 다름
        if (n == 1) {
            System.out.println(1);
            return ;
        }

        // 데이터를 짝수만 큐에 저장
        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0)
                que.offer(i);
        }

        // 마지막 들어온 값에 따라 시작점이 다름
        int count = n % 2;
        while (que.size() > 1) {
            if (count % 2 == 0) { // 큐를 순회하면서 카운트가 짝수면 버리고
                que.poll();
            } else { // 카운트가 홀수면 꺼내서 제일 뒤에 저장
                que.offer(que.poll());
            }
            count++;
        }

        // 마지막 남은 데이터를 출력
        System.out.println(que.peek());
    }
}

// public class Main {

//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());
//         int idx = 1;
//         int answer = 0;
//         if (n == 1) {
//             System.out.println(1);
//         } else {
//             for (int i = 1; i < n; i++) {
//                 answer += 2;
//                 if (answer == Math.pow(2, idx) && i < n - 1) {
//                     answer = 0;
//                     idx++;
//                 }
//             }
//             System.out.println(answer);
//         }

//     }
// }
