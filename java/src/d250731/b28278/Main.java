package d250731.b28278;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int commandCount = Integer.parseInt(br.readLine());
        String command = null;
        String result = null;
        Stack<String>stack = new Stack<String>();
        StringBuilder sb= new StringBuilder();
        for(int i=0 ; i<commandCount; i++){
            command=br.readLine();
            if(command.split(" ")[0].equals("1")){
               command= command.split(" ")[1];
               stack.push(command);
               continue;
            }
            switch(command){
                // 뺴라는 의미가 다음 인덱스가 아닌 stack에서 제거하라는 의미
            // case  "2":  
            //     try {
            //         String result = stack.elementAt(1);
            //         sb.append(result+"\n");
            //     } catch (Exception e) {
            //         sb.append("-1\n");
            //     }
            //          break;
            case "2":
                try {
                    result=stack.pop();
                    sb.append(result+"\n");
                } catch (Exception e) {
                  sb.append("-1\n");
                }
                break;
            case  "3":  
               sb.append(stack.size()+"\n");
                
                break;
            case  "4":  
                if(stack.isEmpty()){
                    sb.append("1"+"\n");
                }
                else{
                    sb.append("0"+"\n");
                }
                 break;
            case  "5":  
            try {
                 result=stack.peek();
                sb.append(result+"\n");
            } catch (Exception e) {
                sb.append("-1\n");
            }
                
                break;
        }


        }
        System.out.println(sb);
    }
    
}
