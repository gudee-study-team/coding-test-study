package d250610.b9012;

import java.io.*;
import java.util.*;

/* 괄호
 * 입력 데이터는 표준 입력을 사용한다. 입력은 T개의 테스트 데이터로 주어진다. 
 * 입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다. 
 * 각 테스트 데이터의 첫째 줄에는 괄호 문자열이 한 줄에 주어진다. 
 * 하나의 괄호 문자열의 길이는 2 이상 50 이하이다. 
 */
public class Main {

    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        boolean[] result = new boolean[t];
        for (int i = 0; i < t; i++) {
            // 입력을 순회하면서
            String buff = br.readLine();
            Deque<Boolean> stk = new ArrayDeque<>();
            boolean flag = true;
            for (int j = 0; j < buff.length(); j++) {
                //  (를 만나면 스택에 저장
                if (buff.charAt(j) == '(') stk.push(true);
                else {
                    // )를 만나면 스택에 데이터가 남아 있다면 팝
                    if (!stk.isEmpty()) stk.pop();
                    // 없다면 flag에 표시해주고 루프 탈출
                    else {
                        flag = false;
                        break;
                    }
                }
            }
            // 순회가 끝났는데 스택에 데이터가 남아있으면 flag에 표시
            if (!stk.isEmpty()) flag = false;
            result[i] = flag;
        }

        StringBuilder sb = new StringBuilder();
        for (boolean flag : result) {
            // flag 값에 따라 구분해서 출력
            if (flag == true) sb.append("YES").append('\n');
            else sb.append("NO").append('\n');
        }

        System.out.println(sb);
    }
}
