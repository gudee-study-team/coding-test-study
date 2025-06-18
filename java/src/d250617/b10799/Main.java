package d250617.b10799;

import java.io.*;
import java.util.*;

/* 쇠막대기
 * 한 줄에 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 공백없이 주어진다. 
 * 괄호 문자의 개수는 최대 100,000이다.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String buff = br.readLine();
        char[] arr = buff.toCharArray();

        Deque<Integer> stack = new ArrayDeque<>();
        int count = 0, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                // 스택에 넣을 때 마다 카운트를 세고
                stack.push(count);
                count++;
            } else {
                // 괄호를 닫을 때 카운트를 반영
                int output = stack.pop();
                count--;
                // 연속으로 닫으면 그냥 + 1
                if (arr[i - 1] == ')') sum++;
                else sum += output;
            }
        }

        System.out.println(sum);
    }
}
