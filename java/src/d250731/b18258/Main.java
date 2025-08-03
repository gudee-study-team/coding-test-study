package d250731.b18258;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;


public class Main {
 
   public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int num = Integer.parseInt(br.readLine());
      int i =0;  
      String command=null;
      Deque<String> queue = new LinkedList<>();
      StringBuilder sb = new StringBuilder();
      while (i<num) {
        command = br.readLine();
        if(command.contains("push")){
            int idx =command.indexOf("h");
            String X = command.substring(idx+2);
            queue.offerFirst(X);
            i++;
            continue;
        }
        switch(command){
            //remove는 비어있으면 예외를 발생 시키므로  poll사용
            //queue.pollLast를 if문의 조건식으로 넣을경우 두번 실행되서 다른 결과가 나옴
            case  "pop":  
                String result = queue.pollLast();
                if(result==null){
                    sb.append("-1").append("\n");
                     
                }else{
                     sb.append(result).append("\n");
                }
                     break;
            case  "size":  
               sb.append(queue.size()).append("\n");
                
            break;
            case  "empty":  
                if(queue.isEmpty()){
                    sb.append("1").append("\n");
                }else{
                     sb.append("0").append("\n");
                }
            break;
            // getLast,getFirst는 값이 비어있으면 예외를 발생 시키므로 peek를 사용
            case  "front":  
                if(queue.peekLast()==null){
                     sb.append("-1").append("\n");
                }else{
                     sb.append(queue.peekLast()).append("\n");
                }
                 break;
            case  "back":  
                if(queue.peekFirst()==null){
                     sb.append("-1").append("\n");
                }else{
                     sb.append(queue.peekFirst()).append("\n");
                }
            break;
        }
        i++;
      }
      System.out.println(sb);
   }
    
}
