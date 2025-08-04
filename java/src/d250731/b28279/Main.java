package d250731.b28279;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb  = new StringBuilder();
        String command = null;
        String spf=null,sps=null;
        String result=null;
        int commandCount= Integer.parseInt(br.readLine());
        Deque<String> deque = new LinkedList<String>();
        while (commandCount>0) {
            command=br.readLine();
            spf=command.split(" ")[0];
            if(spf.equals("1")||spf.equals("2")){
                sps=command.split(" ")[1];
            }    
            switch (spf) {
                case "1":
                    deque.offerFirst(sps);
                    break;
                case "2":
                    deque.offerLast(sps);
                    break;
                case "3":
                    result=deque.pollFirst();
                    if(result!=null){
                        sb.append(result+"\n");
                    }else{
                        sb.append("-1\n");
                    }
                    break;
                case "4":
                      result=deque.pollLast();
                    if(result!=null){
                        sb.append(result+"\n");
                    }else{
                        sb.append("-1\n");
                    }
                    break;
                case "5":
                    sb.append(deque.size()+"\n");
                    break;
                case "6":
                    if(deque.isEmpty()){
                        sb.append("1\n");
                    }else{
                        sb.append("0\n");
                    }
                    break;
                case "7":
                      result=deque.peekFirst();
                    if(result!=null){
                        sb.append(result+"\n");
                    }else{
                        sb.append("-1\n");
                    }
                    break;
                case "8":
                       result=deque.peekLast();
                    if(result!=null){
                        sb.append(result+"\n");
                    }else{
                        sb.append("-1\n");
                    }
                    break;
            }
            commandCount--;
        }
        System.out.println(sb);
    }
}
