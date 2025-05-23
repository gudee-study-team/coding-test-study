package d250522.b2816;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            list.add(tmp);
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (true) {
            // KBS1을 끌어다가 제일 앞에 배치
            if (!"KBS1".equals(list.get(0))) {
                if (!"KBS1".equals(list.get(idx))) {
                    sb.append(1);
                    idx++;
                } else {
                    sb.append(4);
                    list.set(idx, list.get(idx - 1));
                    list.set(idx - 1, "KBS1");
                    idx--;
                }
                // KBS2을 끌어다가 제일 앞에 배치
            } else if (!"KBS2".equals(list.get(1))) {
                if (!"KBS2".equals(list.get(idx))) {
                    sb.append(1);
                    idx++;
                } else {
                    sb.append(4);
                    list.set(idx, list.get(idx - 1));
                    list.set(idx - 1, "KBS2");
                    idx--;
                }
                // 1, 2가 제자리에 있다면 루프를 종료
            } else {
                break;
            }
        }

        System.out.println(sb.toString());
    }

}
