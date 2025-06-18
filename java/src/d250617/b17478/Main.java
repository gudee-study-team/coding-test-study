package d250617.b17478;

import java.util.*;

/* 재귀함수가 뭔가요?
 * 교수님이 출력을 원하는 재귀 횟수 N(1 ≤ N ≤ 50)이 주어진다.
 * 문자열 추가 성능 비교
 * https://velog.io/@ch200203/Java-%EB%AC%B8%EC%9E%90%EC%97%B4-%ED%95%A9%EC%B9%98%EA%B8%B0-%EC%84%B1%EB%8A%A5-%EB%B9%84%EA%B5%90
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        
        sb.append(method(n, n));
    
        System.out.println(sb);
    }

    static StringBuilder method(int num1, int num2) {
        String[] arr = {
            "",
            "",
            "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n", 
            "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n", 
            "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n"
        };
        if (num2 == 0) arr = new String[] {
            "",
            "",
            "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n"
        };
        String str = "\"재귀함수가 뭔가요?\"\n";
        arr[1] = str;

        StringBuilder bar = new StringBuilder();
        for (int i = 0; i < num1 - num2; i++)
            bar.append("____");

        String joined = String.join(bar, arr);

        StringBuilder sb = new StringBuilder();
        sb.append(joined);
        if (num2 != 0)
            sb.append(method(num1, num2 - 1));
        sb.append(bar).append("라고 답변하였지.\n");

        return sb;
    }
}
