package d250731.b28279;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Deque<String> deq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] buff = br.readLine().split(" ");

            switch (buff[0]) {
            case "1":
                deq.addFirst(buff[1]);
                break;
                
            case "2":
                deq.addLast(buff[1]);
                break;
                
            case "3":
                if (deq.isEmpty()) sb.append(-1).append('\n');
                else sb.append(deq. pollFirst()).append('\n');
                break;
                
            case "4":
                if (deq.isEmpty()) sb.append(-1).append('\n');
                else sb.append(deq. pollLast()).append('\n');
                break;
                
            case "5":
                sb.append(deq.size()).append('\n');
                break;
                
            case "6":
                if (deq.isEmpty()) sb.append(1).append('\n');
                else sb.append(0).append('\n');
                break;
                
            case "7":
                if (deq.isEmpty()) sb.append(-1).append('\n');
                else sb.append(deq. peekFirst()).append('\n');
                break;
                
            case "8":
                if (deq.isEmpty()) sb.append(-1).append('\n');
                else sb.append(deq. peekLast()).append('\n');
                break;
            }
        }

        System.out.println(sb);
    }
}
