package d250731.b18258;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        Deque que = new ArrayDeque();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] buff = br.readLine().split(" ");

            switch (buff[0]) {
                case "push":
                    que.offer(Integer.parseInt(buff[1]));
                    break;
                case "pop":
                    if(que.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(que.poll()).append('\n');
                    break;
                case "size":
                    sb.append(que.size()).append('\n');
                    break;
                case "empty":
                    if (que.isEmpty()) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                case "front":
                    if(que.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(que.peek()).append('\n');
                    break;
                case "back":
                    if(que.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(que.peekLast()).append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }
}

