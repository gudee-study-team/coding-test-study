package d250812.b25192;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    //list로 할 경우 시간 초과 생각해본 것이 Set을 이용하는것 
    //찾아보니 Set은 탐색시간이 O(1)이고 list는 최악의 경우 O(N)이므로 속도차이가 남
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Gomgomcount = 0; // 곰곰이모티콘 개수
        int lineCount = Integer.parseInt(br.readLine()); //채팇 개수 

        String chat=br.readLine();//첫번쨰는 무조건 ENTER이니 그냥 받음
        Set<String > chatSet = new HashSet<>(); //채팅 기록을 저장할 배열
        
        for(int i = 1 ; i<lineCount ; i++){
            chat = br.readLine();
            if(chat.equals("ENTER")){
                chatSet.clear();
                continue;
            }
            if(!chatSet.contains(chat)){
                chatSet.add(chat);
                Gomgomcount++;
            }


        }
        System.out.println(Gomgomcount);
        
    }
}   
