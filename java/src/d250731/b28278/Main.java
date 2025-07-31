package d250731.b28278;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] buff = br.readLine().split(" ");

            switch (buff[0]) {
                case "1":
                    stack.push(buff[1]);
                    break;
                    
                case "2":
                    if (stack.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(stack.pop()).append('\n');
                    break;
                    
                case "3":
                    sb.append(stack.size()).append('\n');
                    break;
                    
                case "4":
                    if (stack.isEmpty()) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                    
                case "5":
                    if (stack.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(stack.peek()).append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }
}

