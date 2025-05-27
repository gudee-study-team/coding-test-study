package d250522.b2816;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            list.addLast(tmp);
        }

        StringBuilder sb = new StringBuilder();
        // KBS1 위치를 찾아서
        int idx = list.indexOf("KBS1");
        for (int i = 0; i < idx; i++)
            sb.append(1);
        // KBS1을 제일 앞에 배치
        list.add(0, list.remove(idx));
        for (int j = 0; j < idx; j++)
            sb.append(4);

        // KBS2 위치를 찾아서
        idx = list.indexOf("KBS2");
        for (int i = 0; i < idx; i++)
            sb.append(1);
        // KBS2를 제일 앞에 배치
        list.add(1, list.remove(idx));
        for (int j = 1; j < idx; j++)
            sb.append(4);

        System.out.println(sb.toString());
    }

}
